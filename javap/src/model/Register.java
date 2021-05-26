package model;

public class Register
{

	private String email;
	private String pass;
	private String date;
	private String name ;
	private String que;
	public Register(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}
	private String ans;
	public Register(String name, String email,String date ) {
		super();
		this.email = email;
		this.name = name;
		this.date = date ;
		
	}
	
	@Override
	public String toString() {
		return "Register [email=" + email + ", pass=" + pass + ", date=" + date + ", name=" + name + ", que=" + que
				+ ", ans=" + ans + "]";
	}
	public Register(String email, String pass, String date, String name, String que, String ans) {
		super();
		this.email = email;
		this.pass = pass;
		this.date = date;
		this.name = name;
		this.que = que;
		this.ans = ans;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
