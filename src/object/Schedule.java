package object;

import java.util.*;
import java.io.Serializable;


public class Schedule implements Serializable {
//	int ID;
	public String ID, name, classRoom;
	
	public Schedule(String ID, String name, String classRoom) {
		this.ID = ID;
		this.name = name;
		this.classRoom = classRoom;
	}
	
	public void setData(String ID, String name, String classRoom) {
		this.ID = ID;
		this.name = name;
		this.classRoom = classRoom;
	}
}