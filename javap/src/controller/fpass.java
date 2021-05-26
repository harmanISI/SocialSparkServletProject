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

import db.usersdb;
import model.AddFrndjava;
import model.Register;

/**
 * Servlet implementation class fpass
 */
@WebServlet("/fpass")
public class fpass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fpass() {
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
		
		String btnforgot = request.getParameter("forgot");
		String btncnfrm = request.getParameter("updatepass");
		
		if(btnforgot!=null)
		{
		
		
		
		
		String ffemail = request.getParameter("forgotemail");
        String fque = request.getParameter("secQues");
        
        String fans = request.getParameter("secans");
        System.out.println(ffemail +" "+fque+" "+fans);
        
        
    	try {
			
			
			
  		  String fname = logindb.fpass(ffemail,fque,fans) ;
  		  //Calling authenticateUser function
  			 
	        if(fname!=null) //If function returns success string then user will be rooted to Home page
	         {
	        	 System.out.println("\n "+fname+ " return name    ");
	        	 
	        	
	            
	             
	             
	             
	           RequestDispatcher rd = request.getRequestDispatcher("Cofirmpassword.jsp");
	           HttpSession session=request.getSession();
 	        	session.setAttribute("emailid", ffemail);
 	        	
	           request.setAttribute("fname", fname); 
	           request.setAttribute("ffemail", ffemail);
				rd.forward(request, response);
	         }
	         else
	         {
	        	
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("Forgotpassword.jsp");
	        	request.setAttribute("notmatch", "notmatched");
		
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
		
			       
			
		}
        
        
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
