package object;

import java.util.*;
import java.io.Serializable;


public class Student implements Serializable {
//	int MSSV;
	public String MSSV, name, sex, passport_id;
	
	public Student(String MSSV, String name, String sex, String passport_id) {
		this.MSSV = MSSV;
		this.name = name;
		this.sex = sex;
		this.passport_id = passport_id;
	}
	
	public void setData(String MSSV, String name, String sex, String passport_id) {
		this.MSSV = MSSV;
		this.name = name;
		this.sex = sex;
		this.passport_id = passport_id;
	}
}