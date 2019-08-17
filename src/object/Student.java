package object;

import java.util.*;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {

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


	public Student(String MSSV, String name, String gender, String cmnd) {
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + MSSV + ", lastName=" + name + ", email=" + cmnd + "]";

	}
}