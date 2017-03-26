package zq.rmiserver;

import java.io.Serializable;

public class Student implements Serializable {

	private int sid;
	private String sname;
	private float score;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}


}
