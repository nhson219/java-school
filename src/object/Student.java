package object;

import java.util.*;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Iterator;

@Entity
@Table(name = "student")
public class Student {
	private static SessionFactory factory;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "MSSV")
	private String MSSV;

	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "cmnd")
	private String cmnd;

	public Student() {

	}

	public void insertStudent(String MSSV, String name, String gender, String cmnd) {
		this.MSSV = MSSV;
		this.name = name;
		this.gender = gender;
		this.cmnd = cmnd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMSSV() {
		return MSSV;
	}

	public void setMSSV(String MSSV) {
		this.MSSV = MSSV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCMND() {
		return cmnd;
	}

	public void setCMND(String cmnd) {
		this.cmnd = cmnd;
	}

	public List listStudent() {
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
			Criteria cr = session.createCriteria(Student.class);

			List employees = cr.list();

			tx.commit();
			return employees;

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