package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AddFrnd
 */
@WebServlet("/AddFrnd")
public class AddFrnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFrnd() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(name="jdbc/new")
    private DataSource ds;
    private usersdb studentdb;
    private AddFrndjava frndadd;

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			studentdb = new usersdb(ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("Add");
		
		PrintWriter out = response.getWriter();
		//out.println(email);
		
		
		 HttpSession session=request.getSession(false);
	      String myName=(String)session.getAttribute("ssnname");
	      String myPass=(String)session.getAttribute("ssnpass");
	      
	      
	      
	      session.setAttribute("ssnname", myName); 
      	//session.setAttribute("ssnpass", myPass); 
          
          
          
       request.setAttribute("userName", myName);
	 
	      
	  	String view = request.getParameter("view");
	      
	      System.out.println("\n username "+myName+"    passs "+myPass);
	      
	      frndadd= new AddFrndjava(myName,email,1);
	      frndadd.setUserid(myName);
	      frndadd.setStatus(1);
	      frndadd.setFrndid(email);
	      

	//out.println(myName);
	try {
		
		
		
		 studentdb.addingfrnd(frndadd);
		 
		 
		   ArrayList<Register> frndsugestion = new ArrayList<>();
			
           frndsugestion = studentdb.getSuugestion(myName);
           
           request.setAttribute("frndsugestion", frndsugestion); 
           
           
           
           //friend List
           
           ArrayList<AddFrndjava> frnds = new ArrayList<>();
				
           frnds = studentdb.listfrnd(myName);
           
           request.setAttribute("frnds", frnds); 
           
				
             //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
            
             //RequestDispatcher is used to send the control to the invoked page.
             
             
             
          // RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
			
			//rd.forward(request, response);
		 

 	      System.out.println("\n IN ADD FRI username  AGAIN "+myName+"    passs  "+myPass);
 	      
		// response.sendRedirect("LoginUser?loginemail=" +myName+ "&loginpass="+myPass);
		
		 
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("LoginUser?loginemail=" +myName+ "&loginpass="+myPass);
			request.setAttribute("ADD", "email or password");
			dispatcher.forward(request, response);
       	
		
		
		
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
