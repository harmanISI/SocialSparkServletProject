package model;

public class AddFrndjava
{
private String userid;

public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getFrndid() {
	return Frndid;
}
public void setFrndid(String frndid) {
	Frndid = frndid;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
private String Frndid;
private int  status;
public AddFrndjava(String userid, String frndid, int status) {
	super();
	this.userid = userid;
	Frndid = frndid;
	this.status = status;
}
@Override
public String toString() {
	return "AddFrndjava [userid=" + userid + ", Frndid=" + Frndid + ", status=" + status + "]";
}

}
