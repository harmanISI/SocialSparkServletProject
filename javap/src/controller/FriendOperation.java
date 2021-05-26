package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
import model.User;

/**
 * Servlet implementation class FriendOperation
 */
@WebServlet("/FriendOperation")
public class FriendOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FriendOperation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Resource(name = "jdbc/new")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Register tempUser = (Register) session.getAttribute("user");

		String ssn = (String) session.getAttribute("ssnname");
		String view = request.getParameter("view");
		String remove = request.getParameter("remove");

		
		
		
		
	   //   String myName=(String)session.getAttribute("ssnname");
	      String myPass=(String)session.getAttribute("ssnpass");
	      
		if (view != null) {
			
		String emailf="ff";
		String namef="ff";
		String datef="ff";
		
			  ArrayList<Register> pp = new ArrayList<>();
			
			try {
				pp = logindb.findUser(view);
				for(Register k : pp)
				{
				emailf=	k.getEmail();
				namef= k.getName();
				datef=k.getDate();
				System.out.println("\n in add frind loop"+emailf);
				}
				
				
				   request.setAttribute("pp", pp); 
				   
				session.setAttribute("emailf", emailf);
				session.setAttribute("namef", namef);
				session.setAttribute("datef", datef);
				
				  // System.out.println("\n view profile "+profile.getName()+profile.getEmail()+profile.getDate());
				   
				if(pp.size()==0)
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
	  				request.setAttribute("errorf", "user doesnt exist");
	  				dispatcher.forward(request, response);
				}
				
				else
				{
					
					RequestDispatcher rd = request.getRequestDispatcher("Viewfrnd.jsp");
					
					rd.forward(request, response);
				}
				
				   
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				
				
			}
			  
			
			 
		}

		
		if (remove != null) {
			
			boolean done=  false ;
			try {
				done = logindb.removeFriend(remove,ssn);
				 if(done) { 
					 RequestDispatcher dispatcher = request.getRequestDispatcher("LoginUser?loginemail=" +ssn+ "&loginpass="+myPass);
						request.setAttribute("REM", remove);
						dispatcher.forward(request, response);
			       	
					 }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		
			 
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
