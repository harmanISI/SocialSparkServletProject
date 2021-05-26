package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.*;

public class PostDBUtil {
private DataSource ds;
	
	public PostDBUtil(DataSource ds) {
		this.ds = ds;
	}
	
public boolean createPost(Post post) throws Exception {
		Connection conn = null;
		Statement smt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
	
		String email = post.getEmail();
		String content = post.getContent();
		String date = post.getDate();	
		
		try {
			conn = this.ds.getConnection();
			
			String sql = String.format("INSERT "
					+ "INTO post (email,content,date) "
					+ "VALUES ('%s', '%s', '%s')",email,content,date);
			smt = conn.createStatement();
			smt.executeUpdate(sql);
						
		}catch(Exception e) {
       	 e.printStackTrace();
       }
		return true;	
	}
	
	
public ArrayList<Post> getAllPost() throws Exception{
		
		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		
		ArrayList<Post> allUserPosts = new ArrayList<>();
			
		try {
			conn = this.ds.getConnection();
			
			String sql = "SELECT p.*, u.name, count(l.PostId) as likes \r\n" + 
					"FROM post p \r\n" + 
					"LEFT JOIN likes l ON p.PostId = l.PostId\r\n" + 
					"JOIN user u ON p.email = u.email \r\n" + 
					"GROUP BY p.PostId";
			
			smt = conn.createStatement();
			res = smt.executeQuery(sql);
		System.out.println(sql);
			while(res.next()) {
				String postId = Integer.toString(res.getInt("PostId"));
				  String UserId = res.getString("email").toString(); 
				  
				String fullname =res.getString("name").toString();							
				String content = res.getString("content").toString();
			//	String email = res.getString("email").toString();
				String date = res.getString("date").toString();
				String likes = res.getString("likes").toString();
				System.out.println("\n get all post for feed ");
				allUserPosts.add(new Post(postId,UserId,fullname, content,date,likes));
				
				  //UserPosts.add(new Post(postId,UserId,fullname, content,date,likes));
			}
					
		}finally {
			close(conn,smt,psmt,res);
		}

		return allUserPosts;
	}
	// get user post(like login user and show on their profile)
	
	  public ArrayList<Post> getUserPosts(String user) throws Exception{ 
		  Connection
	  conn = null;
		  Statement smt = null; PreparedStatement pstmt = null; 
	  ResultSet
	  res = null;
	  
	  ArrayList<Post> UserPosts = new ArrayList<>();
	  
	  try {
		  conn = this.ds.getConnection(); 
	
	  String sql =
	  "SELECT p.*, u.*, count(l.PostId) as likes FROM post p \r\n"
	  + "					LEFT JOIN likes l ON p.PostId = l.PostId \r\n" +
	  "                    JOIN user u ON p.email = u.email \r\n" +
	  "					GROUP BY  p.PostId HAVING  p.email =  ?";
	  pstmt =
	  conn.prepareStatement(sql); pstmt.setString(1,user); 
	  System.out.println("\n Sql "+sql );
	  res =
	  pstmt.executeQuery(); 
	  System.out.println(user); 
	  while(res.next()) 
	  { 
		  String postId =
	  Integer.toString(res.getInt("PostId"));
	  String UserId = res.getString("email").toString(); 
	  
	  
	
	  String fullname = res.getString("name").toString();
	  String content
	  = res.getString("content").toString();
	//  String email =  res.getString("email").toString(); 
	  String date =
	  res.getString("date").toString();
	  String likes =
	  res.getString("likes").toString(); // System.out.println("hello");
	  UserPosts.add(new Post(postId,UserId,fullname, content,date,likes));
	  
	  } 
	
	  System.out.println("hii"); 
	  } 
	  finally { close(conn,smt,pstmt,res);
	  } 
	  return  UserPosts; 
	  
	  }
	
public boolean savedPost(int PostId, String UserId) throws SQLException
	{
		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
	    PreparedStatement preparedStatement = null;         
	    try
	    {
	    	conn = this.ds.getConnection();
	        String query = "insert into savedposts(PostId, UserId) values (?,?)"; 
	        preparedStatement = conn.prepareStatement(query); 
	        preparedStatement.setInt(1, PostId);
	        preparedStatement.setString(2, UserId);	        
	        preparedStatement.executeUpdate();
	        System.out.println("hii");
	    }
	    catch(SQLException e)
	    {
	       e.printStackTrace();
	    }    
		return true;
}
public boolean LikePost(int PostId, String UserId) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "insert into likes(PostId, UserId) values (?,?)"; 
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setInt(1, PostId);
        preparedStatement.setString(2, UserId);
        preparedStatement.executeUpdate();
        System.out.println("\n likepost");
    }
    catch(SQLException e)
    {
       e.printStackTrace();
       return false;
    }    
	return true;
}
public boolean UnlikePost(int PostId, String UserId) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
    	String query = String.format("DELETE "
				+ "FROM likes "
				+ "WHERE UserId = ? AND PostId = ?");
    	
    	System.out.println(query);
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setInt(2, PostId);
        preparedStatement.setString(1, UserId);
        preparedStatement.executeUpdate();
        System.out.println("unlike");
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }    
	return true;
}
public boolean DeletePost(int PostId, String UserId) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
    	String query = String.format("DELETE "
				+ "FROM post "
				+ "WHERE email = ? AND PostId = ?");
    	
    	System.out.println(query);
        preparedStatement = conn.prepareStatement(query); 
        preparedStatement.setString(1, UserId);
        preparedStatement.setInt(2, PostId);
        preparedStatement.executeUpdate();
        System.out.println("delete");
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }    
	return true;
}



//clear all data of loginuser
public boolean ClearPostData(String UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM post WHERE email=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}
public boolean ClearFriendData(String UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM frnd WHERE email=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, UserId);
		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}

public boolean ClearMeassgeData(String UserId) throws Exception{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	
	try {
		conn = this.ds.getConnection();		
		String sql = "delete FROM msg WHERE rcpt =? and frm =?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, UserId);
		pstmt.setString(2, UserId);

		pstmt.executeUpdate();
	}
	finally {
		close(conn,smt,pstmt,res);
	}
	return true;
}


public boolean EditPost(int PostId,String UserId, String postcontent)
{
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "update post \r\n" +"set content=\"\r\n" + postcontent + "\" \r\n" + 
        		"where postID ="+ PostId+" and UserId="+UserId;  
        preparedStatement = conn.prepareStatement(query); 
//        preparedStatement.setInt(1, postIDEdit);
//        preparedStatement.setInt(2, userID);
//        preparedStatement.setString(3, editText);
        
        preparedStatement.executeUpdate();
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }   
    return true; 
}
private void close(Connection conn, Statement smt, PreparedStatement pstmt, ResultSet res) {
	try {	
		if(conn != null) {
			conn.close();
		}
		if(pstmt != null) {
			pstmt.close();
		}
		if(smt != null) {
			smt.close();
		}
		if(res != null) {
			res.close();
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
}
}
