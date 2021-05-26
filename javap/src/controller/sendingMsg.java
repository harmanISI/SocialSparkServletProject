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

import model.Msg;
import model.Register;

/**
 * Servlet implementation class sendingMsg
 */
@WebServlet("/sendingMsg")
public class sendingMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendingMsg() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/new")
    private DataSource ds;
    private usersdb logindb;
    private Register loginval;
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
		 HttpSession session=request.getSession(false);
	      String myName=(String)session.getAttribute("ssnname");
	    
	      String frindid=request.getParameter("FRNDID");
	      String frndname = request.getParameter("FRNDID");
	      System.out.println("\n in servllet SENDingMSg  "+frindid+"   login   "+myName +"  name of frnd"+frndname);
	      
	 	session.setAttribute("myName", myName); 
	      
	      Register user = (Register) session.getAttribute("user");
	      
	      
	      try {
				
	    	   ArrayList<Msg> msgs = new ArrayList<>();
	    		ArrayList<Msg> fMessages = new ArrayList<>();
	    		
	    	msgs=  logindb.getMyMessages(myName,frindid);
	    	
	    	fMessages = logindb.getFriendMessages(frindid,myName);
	    	
	    	
		request.setAttribute("msgs", msgs); 
	   request.setAttribute("fMessages", fMessages);
			
		     session.setAttribute("frindid", frindid); 
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("Sendmsg.jsp");
				
				rd.forward(request, response);
			
		    //	response.sendRedirect("Messenger?message="+fEmail);
		    	
					 			
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
