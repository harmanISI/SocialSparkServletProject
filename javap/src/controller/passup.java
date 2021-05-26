package controller;

import java.io.IOException;

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
import model.Register;

/**
 * Servlet implementation class passup
 */
@WebServlet("/passup")
public class passup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passup() {
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
		
		
		HttpSession session = request.getSession();


		String femail = (String) session.getAttribute("emailid");
		String btnforgot = request.getParameter("forgot");
	
		String fname= (String) request.getAttribute("fname");

		
		
		String pass1 = request.getParameter("pass");
        String pass2 = request.getParameter("cpass");
        if(pass1.equals(pass2))
        {
        	  System.out.println("\n new pass "+pass1 +" "+pass2+" ffemail"+" "+femail );
        	  
        	  
        	  
        	  try {
      			
      			
      			
          		  int ll = logindb.passupdation(femail,pass1) ;
          		  //Calling authenticateUser function
          			 
        	        if(ll!=0) //If function returns success string then user will be rooted to Home page
        	         {
        	        	 System.out.println("\n "+fname+ " return name    ");
        	        	 
        	        	
        	            
        	             
        	             
        	             
        	           RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
        	       	request.setAttribute("ll", ll);
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
        
        else 
        {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("Cofirmpassword.jsp");
        	   request.setAttribute("fname", fname); 
			request.setAttribute("unequal", "password mot matching");
			dispatcher.forward(request, response);
        	
			
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
