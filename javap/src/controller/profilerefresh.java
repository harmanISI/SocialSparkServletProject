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

import db.PostDBUtil;

import db.*;
import model.*;

/**
 * Servlet implementation class profilerefresh
 */
@WebServlet("/profilerefresh")
public class profilerefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public profilerefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Resource(name="jdbc/new")
    private DataSource ds;
    private usersdb logindb;
    private Register loginval;
    private PostDBUtil postdb;

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			logindb = new usersdb(ds);
			postdb=new PostDBUtil(ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ref = request.getParameter("PGE");
		  PostDBUtil postdbutil = new PostDBUtil(ds); 
		HttpSession session = request.getSession();
		
		String ssn = (String) session.getAttribute("ssnname");
	    request.setAttribute("userName", ssn); 
		  ArrayList<Register> frndsugestion = new ArrayList<>();
			
          try {
			frndsugestion = logindb.getSuugestion(ssn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          request.setAttribute("frndsugestion", frndsugestion); 
          
          
          
          //friend List
          
          ArrayList<AddFrndjava> frnds = new ArrayList<>();
				
          try {
			frnds = logindb.listfrnd(ssn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          request.setAttribute("frnds", frnds); 
          //all user post
       /*   ArrayList<Post> allUserPostlist = new ArrayList<>();
          allUserPostlist = postdbutil.getAllPost(); 
          request.setAttribute("allUserPostlist", allUserPostlist); 
          */
          
          // get my post
     ArrayList<Post> mypost = new ArrayList<>();
     
     
     
     //all user post
ArrayList<Post> allPOST = new ArrayList<>();

     
     
     
          try {
			mypost = postdbutil.getUserPosts(ssn);
			
			
			

allPOST = postdbutil.getAllPost(); 
request.setAttribute("allPOST", allPOST); 
     
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          request.setAttribute("mypost", mypost); 
         
          
          
          
          // get all post irrespective of loginuseremail
        //  request.setAttribute("allUserPostlist", allUserPostlist); 
          
          
          
          
          
          
          
          
          
          
          
          
          
          
				
            //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
           
            //RequestDispatcher is used to send the control to the invoked page.
            
            System.out.print("refresh"+ref);
            
          RequestDispatcher rd = request.getRequestDispatcher(ref);
			
			rd.forward(request, response);
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
