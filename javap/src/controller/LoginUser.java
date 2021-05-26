package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import db.*;
import model.AddFrndjava;
import model.Register;
import model.*;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }
   
    @Resource(name="jdbc/new")
    private DataSource ds;
    private usersdb logindb;
    private Register loginval;

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			logindb = new usersdb(ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String userName = request.getParameter("loginemail");
        String passWord = request.getParameter("loginpass");
        Register loginuser=new Register(userName, passWord);	        
        loginuser.setEmail(userName); 
        loginuser.setPass(passWord);
        loginval= new  Register(userName,passWord);
        
        System.out.println("IN LOGIN USER  "+userName+" "+passWord);
       	     
    	try {
			
    		  PostDBUtil postdbutil = new PostDBUtil(ds); 
			
    		  boolean userValidate = logindb.authenitication(loginuser) ;
    		  //Calling authenticateUser function
    			 
  	        if(userValidate) //If function returns TRUE string then user will be rooted to PROFILE page
  	         {
  	        	 System.out.println(userValidate+"    "+loginuser);
  	        	  HttpSession session=request.getSession();
  	        	session.setAttribute("user", loginuser);
  	        	session.setAttribute("ssnname", userName); 
  	        	session.setAttribute("ssnpass", passWord); 
  	            
  	            
  	             request.setAttribute("loginval", loginuser); 
	             request.setAttribute("userName", userName); 
	             
	             // friend Suggestion
	             ArrayList<Register> frndsugestion = new ArrayList<>();
					
	             frndsugestion = logindb.getSuugestion(userName);
	             
	             request.setAttribute("frndsugestion", frndsugestion); 
	             
	             
	             
	             //friend List
	             
	             ArrayList<AddFrndjava> frnds = new ArrayList<>();
					
	             frnds = logindb.listfrnd(userName);
	             
	             request.setAttribute("frnds", frnds); 
	             
	             
	             //all user post
	        ArrayList<Post> allPOST = new ArrayList<>();
	      allPOST = postdbutil.getAllPost(); 
	       request.setAttribute("allPOST", allPOST); 
	             
	             
	        //   get my post
	          		ArrayList<Post> mypost = new ArrayList<>();
	            mypost = postdbutil.getUserPosts(userName); 
	            request.setAttribute("mypost", mypost); 
	            
	             
	             
	             
	             // get all post irrespective of loginuseremail
	           //  request.setAttribute("allUserPostlist", allUserPostlist); 
	             
	             
	             
					
  	             //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
  	            
  	             //RequestDispatcher is used to send the control to the invoked page.
  	             
  	             
  	             
  	           RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
				
				rd.forward(request, response);
  	         }
  	         else
  	         {
  	        	 System.out.println(userValidate);
  	        	RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
  				request.setAttribute("error", "email or password");
  				dispatcher.forward(request, response);
  	        	
 				
 			
  	        	   
  	        	  //If authenticateUser() function returnsother than SUCCESS string it will be sent to Login page again. Here the error message returned from function has been stored in a errMessage key.
  	           
  	         }
			 
			
			/*
			 * for(Register stu: r) { out.println(stu); }
			 */
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
