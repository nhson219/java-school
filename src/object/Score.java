package object;

import java.util.*;
import java.io.Serializable;


public class Score implements Serializable {
//	int MSSV;
	public String MSSV, name, score_gk, score_ck, another_score, total_score;
	
	public Score(String MSSV, String name, String score_gk, String score_ck, String another_score, String total_score) {
		this.MSSV = MSSV;
		this.name = name;
		this.score_gk = score_gk;
		this.score_ck = score_ck;
		this.another_score = another_score;
		this.total_score = total_score;
	}
	
	public void setData(String MSSV, String name, String score_gk, String score_ck, String another_score, String total_score) {
		this.MSSV = MSSV;
		this.name = name;
		this.score_gk = score_gk;
		this.score_ck = score_ck;
		this.another_score = another_score;
		this.total_score = total_score;
	}
}