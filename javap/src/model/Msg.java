package model;

import java.util.Date;

public class Msg
{
	private String msg;
	private String frindd;
	private Date date;
	

@Override
	public String toString() {
		return "Msg [msg=" + msg + ", frindd=" + frindd + ", date=" + date + ", userid=" + userid + "]";
	}
public Msg(String msg, String frindd, Date date, String userid) {
		super();
		this.msg = msg;
		this.frindd = frindd;
		this.date = date;
		this.userid = userid;
	}
public Date getDate() {
	return this.date;
}
public void setDate(Date date) {
	this.date = date;
}
private String userid;
public Msg(String userid, String msg, String frind) {
	super();
	this.userid = userid;
	this.msg = msg;
	this.frindd = frind;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getFrindd() {
	return frindd;
}
public void setFrindd(String frindd) {
	this.frindd = frindd;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}

	
	
}
