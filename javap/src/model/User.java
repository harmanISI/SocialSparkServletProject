package model;

public class User {
	
	private String fname;
	private String lname;
	private String email;
	private String pass;
	
	
	
	public User(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public User(String fname, String lname, String email, String pass) {	
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.fname + " " + this.lname;
	}
}
