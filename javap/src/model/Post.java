package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Post {
	
	private String PostId;	
	private String UserId;
	private String fullname;	
    private String content;
	private String email;
    private String date;
    private String Likes;
   
	public Post( String email, String content, String date) {
		super();
		
		this.email = email;
		this.content = content;
		this.date = date;
	}
	
	public Post( String PostId,String UserId,String fullname, String content,String email,  String date,String Likes)
	{
		super();
		
		this.PostId = PostId;
		this.UserId = UserId;
		this.fullname = fullname;		
		this.content = content;
		this.email = email;
		this.date = date;
		this.Likes= Likes;
		
	}

	
	
	public Post( String PostId,String UserId,String fullname, String content,  String date,String Likes)
	{
		super();
		
		this.PostId = PostId;
		this.UserId = UserId;
		this.fullname = fullname;		
		this.content = content;
		this.email = email;
		this.date = date;
		this.Likes= Likes;
		
	}

	
	
	public String getLikes() {
		return Likes;
	}

	public void setLikes(String likes) {
		Likes = likes;
	}

	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getPostId() {
		return PostId;
	}

	public void setPostId(String postId) {
		PostId = postId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	
      
}
