package object;

import java.util.*;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Iterator;

public class Score {
	private static SessionFactory factory;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "student_id")
	private String student_id;

	@Column(name = "score_gk")
	private float score_gk;
	
	@Column(name = "score_ck")
	private float score_ck;
	
	@Column(name = "score_different")
	private float score_different;
	
	@Column(name = "score")
	private float score;
	
	
	
	public void insertScore(String student_id, String name, float score_gk, float score_ck, float score_different, float score) {
		this.student_id = student_id;
		this.name = name;
		this.score_gk = score_gk;
		this.score_ck = score_ck;
		this.score_different = score_different;
		this.score = score;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScore_gk() {
		return score_gk;
	}

	public void setScore_gk(float score_gk) {
		this.score_gk = score_gk;
	}
	
	public float getScore_ck() {
		return score_ck;
	}

	public void setScore_ck(float score_ck) {
		this.score_ck = score_ck;
	}
	
	public float getScore_different() {
		return score_different;
	}

	public void setScore_different(float score_different) {
		this.score_different = score_different;
	}
	
	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	public List listScore() {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Score.class);

			List score = cr.list();

			tx.commit();
			return score;

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

}