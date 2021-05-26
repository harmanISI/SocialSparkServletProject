package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
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
import model.User;

/**
 * Servlet implementation class Sendmsg
 */
@WebServlet("/Sendmsg")
public class Sendmsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sendmsg() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/new")
    private DataSource ds;
    private usersdb sendmsgdb;
    private Msg sendmsg;
    public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			sendmsgdb = new usersdb(ds);
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
	      String From=(String)session.getAttribute("ssnname");
	      String To = request.getParameter("to");
	      
	  	session.setAttribute("frindid", To); 
	      String msg = request.getParameter("msg");
	      
	      
	      System.out.println("\n in sendMSg   "+From+"   To    "+To +" msg "+ msg);
	      sendmsg= new Msg(From,msg,To);
	      
	      String fEmail=To;
	      
	      
	      sendmsg.setUserid(From);   sendmsg.setMsg(msg);   sendmsg.setFrindd(To);
	  	Register user = (Register) session.getAttribute("user");
	      
	      try {
				
				
				
	    	 sendmsgdb.send(sendmsg);
	    	 
	    	 
	    	 
	    	 response.sendRedirect("sendingMsg?FRNDID="+fEmail);
	    	
				 			
			} catch (Exception e) {
				// TODO 78 Auto-generated catch block    //	
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
