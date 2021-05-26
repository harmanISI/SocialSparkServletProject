package db;

import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import model.AddFrndjava;

import model.Msg;
import model.Register;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.ResultSet;

public class usersdb {
	private DataSource ds;
	private Register R;

	public usersdb(DataSource ds) {
		this.ds = ds;
	}

	public void getAll(Register R) throws Exception {
		ArrayList<Register> temp = new ArrayList<>();

		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;

		try {
			conn = this.ds.getConnection();
			System.out.print(conn);
			
			//String sql = "SELECT * FROM circle.user";
			PreparedStatement ps=conn.prepareStatement(  
                    "insert into user(email,pass,date,que,ans,name) values (?,?,?,?,?,?)");  
			
			
			 ps.setString(1,R.getEmail());  
	            ps.setString(2,R.getPass());  
	            ps.setString(3,R.getDate());  
	            ps.setString(4,R.getQue());  
	            ps.setString(5,R.getAns());  
	            ps.setString(6,R.getName());  
	            System.out.print(R.getEmail());
			ps.executeUpdate();
		

			//smt = conn.createStatement();
			//res = smt.executeQuery(sql);

			/*
			 * while (res.next()) { String name = res.getString("email").toString(); String
			 * pass = res.getString("pass").toString(); System.out.println(name + pass );
			 * temp.add(new Register(name, pass, " ", " ", " ")); }
			 */

		} finally {
			close(conn, smt, psmt, res);
		}

		
	}
	// login
	public boolean authenitication(Register R) throws Exception {
		 String userEmail = R.getEmail(); //Assign user entered values to temporary variables.
	     String userpassword = R.getPass();

		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;

		 try {      	
				conn = this.ds.getConnection();
				
				String sql = "select email,pass from user ";
				
				smt = conn.createStatement();
				res = smt.executeQuery(sql);
				System.out.print(conn);
				while(res.next()) {
					String  userEmailDB = res.getString("email").toString();
					String passwordDB = res.getString("pass").toString(); 
	               if(userEmailDB.equals(R.getEmail()) && passwordDB.equals(R.getPass()))
	               {
	                  return true; //If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
	               }
			}
	        }catch(Exception e) {
	        	 e.printStackTrace();
	        }
	        
	        return false;

		
	}
	
	// forgot pass
	
	public String fpass(String email, String que, String ans) throws Exception {
		

		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;

		 try {      	
				conn = this.ds.getConnection();
				
				String sql = "select email,que,ans,name  from user ";
				
				smt = conn.createStatement();
				res = smt.executeQuery(sql);
				System.out.print(conn);
				while(res.next()) {
					String  userEmailDB = res.getString("email").toString();
					String passwordDB = res.getString("que").toString(); 
					String ansg = res.getString("ans").toString(); 
					String nameu = res.getString("name").toString(); 
					
					   System.out.println(userEmailDB +" "+passwordDB+" "+ansg);
	               if(userEmailDB.equalsIgnoreCase(email) && passwordDB.equals(que) && ans.equalsIgnoreCase(ansg) )
	               {
	                  return nameu; //If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
	               }
			}
	        }catch(Exception e) {
	        	 e.printStackTrace();
	        }
	        
	        return null;

		
	}
	
	// updating passsword
	
	
	public int passupdation(String fEmail,String pass) throws Exception {
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			conn = this.ds.getConnection();
			
			String sql = "UPDATE user SET pass =? WHERE email =? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2,fEmail );
		
			
			int done = pstmt.executeUpdate();
			
			/*
			 * if(done != 0) { String sql1 =
			 * String.format("INSERT INTO friends VALUES('%s','%s','%s')",uEmail,
			 * fEmail,'1'); smt = conn.createStatement(); smt.executeUpdate(sql1); }
			 */
			
			
			return done;
		}finally {
			close(conn,smt,pstmt,res);	
		}	

	}
	
	// adding frnd
	public void addingfrnd(AddFrndjava R) throws Exception {
		

		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;

		try {
			conn = this.ds.getConnection();
			System.out.print(conn);
			
			PreparedStatement ps=conn.prepareStatement(  
                    "insert into frnd(userid,frndid,status) values (?,?,?)");  
			
			
			 ps.setString(1,R.getUserid());  
	         ps.setString(2,R.getFrndid());  
	         ps.setInt(3,R.getStatus());  
	         
	          
			ps.executeUpdate();
		

			

		} finally {
			close(conn, smt, psmt, res);
		}

		
	}
	
	//removing friend
	
	
	
	public boolean removeFriend(String fEmail, String uEmail) throws Exception {
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		try {
			conn = this.ds.getConnection();
			
			String sql = "DELETE FROM frnd WHERE frndid =? && userid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fEmail);
			pstmt.setString(2, uEmail);	
			int done = pstmt.executeUpdate();
			
			if(done != 0) {
				sql = "DELETE FROM frnd WHERE userid =? && frndid=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uEmail);
				pstmt.setString(2, fEmail);	
				pstmt.executeUpdate();
			}
			
			
			return true;
		}finally {
			close(conn,smt,pstmt,res);	
		}	
	}
	//getRegisterdUSer
	
	 public ArrayList<Register> getSuugestion(String Username ) throws Exception{ 
		 ArrayList<Register>
	  tempusers = new ArrayList<>();
	  
	  Connection conn = null; Statement smt = null; 
	 PreparedStatement psmt = null;
	  ResultSet res = null;
	  
	  
	  try { 
		  conn = this.ds.getConnection(); 
		  System.out.print(conn); 
		  
		  
		PreparedStatement ps=conn.prepareStatement(  
                    "SELECT * FROM user where  email  not in (select frndid from frnd where userid = ? ) AND email != ? ");  
			 ps.setString(1,Username);  
			 ps.setString(2,Username);  
	res=		ps.executeQuery();
	  while(res.next())
	  { 
		 
		 String email  = res.getString("email").toString(); 
		 String pass  = res.getString("pass").toString(); 
		 String name   = res.getString("name").toString(); 
		  System.out.print(name );
	
		 tempusers.add(new Register(email,pass,"",name ,"","")); 
	  }
	  
	  }finally
	  { 
		  close(conn,smt,psmt,res); 
		  }
	  
	  return tempusers; 
	  }
	
	 
	 
	// FIND USER
		public  ArrayList<Register> findUser(String email) throws Exception {
			
			 ArrayList<Register>
			  tempusers = new ArrayList<>();
			Connection conn = null;
			Statement smt = null;
			PreparedStatement pstmt = null;
			ResultSet res = null;
			Register foundUser = null;
			
			try {
				
				conn = this.ds.getConnection();
				
				String sql = "SELECT * from user WHERE email = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, email);
				
				res = pstmt.executeQuery();
				
				if(res.next()) {
					String tempFname = res.getString("name").toString();
					String tempLname = res.getString("email").toString();
					String tempdATE = res.getString("date").toString();
					
					
					
						
						 tempusers.add(new Register(tempFname,tempLname,tempdATE)); 	
						
				}
			}finally {
				
				close(conn,smt,pstmt,res);
				
			}
		
			return tempusers;	
		}
		
		
	 
	 
	 
	 
	 
	 //Get my send MSgs
	 public ArrayList<Msg> getMyMessages(String user,String frndid) throws Exception{
			Connection conn = null;
			Statement smt = null;
			PreparedStatement pstmt = null;
			ResultSet res = null;
			
			ArrayList<Msg> tempMessages = new ArrayList<>();
			
			try {
				
				conn = this.ds.getConnection();
				String sql = "SELECT m.*, u.name "
						+ "FROM msg m "
						+ "JOIN user u ON u.email = m.frm "
						+ "WHERE  m.frm = ?  and m.rcpt= ? "
						+ "ORDER BY m.D";
				
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, user);
				pstmt.setString(2,frndid );
			
				
				res = pstmt.executeQuery();
				
				while(res.next()) {

					 String fromEmail = res.getString("frm");
					String toEmail =  res.getString("rcpt");
					Date date = res.getDate("D");
					String message =res.getString("msgs");
					
					tempMessages.add(new Msg(message, toEmail, date, fromEmail));	
				}
				
				
			}
			finally {
				close(conn,smt,pstmt,res);
			}
			return tempMessages;
		
		}

	 
	//GET Fiends MSgs 
	 public ArrayList<Msg> getFriendMessages(String friend, String myname) throws Exception{
			Connection conn = null;
			Statement smt = null;
			PreparedStatement pstmt = null;
			ResultSet res = null;
			
			ArrayList<Msg> tempMessages = new ArrayList<>();
			
			try {
				conn = this.ds.getConnection();
				String sql = "SELECT m.*"
						+ "FROM msg m "
						+ "JOIN user u ON u.email = m.frm "
						+ "WHERE m.frm = ? and m.rcpt =? "
						+ "ORDER BY m.D";
				
				pstmt = conn.prepareStatement(sql);
				
				System.out.println(friend);
				
				pstmt.setString(1, friend);
				pstmt.setString(2,myname );
			
				
				res = pstmt.executeQuery();
				
				while(res.next()) {

					 String fromEmail = res.getString("frm");
					String toEmail =  res.getString("rcpt");
					Date date = res.getDate("D");
					String message =res.getString("msgs");
					
					tempMessages.add(new Msg(message, toEmail, date, fromEmail));	
					System.out.println("in USERDB  FROM EMAIL "+fromEmail+"TO EMAIL "+toEmail+"  msg    "+message);
				}
				
				return tempMessages;
			}
			finally {
				close(conn,smt,pstmt,res);
			}
		
		}
		 
	 
	 
	 
	 
	 
	 
	 
	 
	// FriendsListFrom Db
	 public ArrayList<AddFrndjava> listfrnd(String Username ) 
			 throws Exception{ 
		 ArrayList<AddFrndjava>
	  frnds = new ArrayList<>();
	  
	  Connection conn = null; Statement smt = null; 
	  PreparedStatement psmt = null;
	  ResultSet res = null;
	  
	  
	  try { 
		  conn = this.ds.getConnection(); 
		  System.out.print(conn); 
		  
		  
			PreparedStatement ps=conn.prepareStatement(  
                    "SELECT f.frndid,u.email, u.name,f.status  FROM frnd f , user u  where f. userid = ? and f.frndid=u.email");  
			
			
			 ps.setString(1,Username);  
	res=		ps.executeQuery();
		  
		  
			/*
			 * String sql ="SELECT * FROM user where email = ?";
			 * 
			 * 
			 * smt = conn.createStatement(); res = smt.executeQuery(sql);
			 */
	  
	  while(res.next())
	  { 
		 
		 String userid  = res.getString("email").toString(); 
		 String frndid  = res.getString("frndid").toString(); 
		 String name   = res.getString("name").toString(); 
		 int st   = res.getInt("status"); 
		  System.out.print(userid );
	
		  frnds.add(new AddFrndjava(name,frndid,st)); 
	  }
	  
	  }finally
	  { 
		  close(conn,smt,psmt,res); 
		  }
	  
	  return frnds; 
	  }
	 
	 //SendingMSgto Db
	 public void send(Msg send) throws Exception {
			ArrayList<Register> temp = new ArrayList<>();

			Connection conn = null;
			Statement smt = null;
			PreparedStatement psmt = null;
			ResultSet res = null;

			try {
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	            LocalDateTime now = LocalDateTime.now();
	            
	            DateTimeFormatter d =dtf(now);
	            
	            System.out.println("\n date time in userdb "+d);
				conn = this.ds.getConnection();
				System.out.print(conn);
				
				String sql = String.format("INSERT INTO msg(rcpt,frm,msgs) VALUES('%s','%s','%s')",send.getFrindd(),send.getUserid(),send.getMsg());
				
				smt = conn.createStatement();
				
				smt.executeUpdate(sql);
	     
			

			} finally {
				close(conn, smt, psmt, res);
			}

			
		}
	 
	 private DateTimeFormatter dtf(LocalDateTime now) {
		// TODO Auto-generated method stub
		return null;
	}

	//GET_STUDENTS
	
	 public ArrayList<User> getAllStudents() throws Exception{ ArrayList<User>
	  tempStudents = new ArrayList<>();
	  
	  Connection conn = null; Statement smt = null; PreparedStatement psmt = null;
	  ResultSet res = null;
	  
	  
	  try { 
		  conn = this.ds.getConnection(); System.out.print(conn); 
		  String sql ="SELECT * FROM user";
	  
	  smt = conn.createStatement(); res = smt.executeQuery(sql);
	  
	  while(res.next())
	  { 
		 
		 String name = res.getString("email").toString(); 
		 String id = res.getString("pass").toString(); 
		 System.out.print(name+" HELOO "+id); 
	
	  tempStudents.add(new User(name,id,id,name )); 
	  }
	  
	  }finally
	  { 
		  close(conn,smt,psmt,res); 
		  }
	  
	  return tempStudents; 
	  }
	 
	
	// To Close the Connection
	private void close(Connection conn, Statement smt, PreparedStatement psmt, ResultSet res) {
		try {
			if (conn != null)
				conn.close();

			if (smt != null)
				smt.close();

			if (psmt != null)
				psmt.close();

			if (res != null)
				res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
