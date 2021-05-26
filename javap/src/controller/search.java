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
import model.Register;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public search() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		HttpSession session = request.getSession();
		Register tempUser = (Register) session.getAttribute("user");

		String ssn = (String) session.getAttribute("ssnname");
		String srch = request.getParameter("srch");
		String name = request.getParameter("fname");
	String not=null;
		
		if (srch != null) {
			
			String emailf="ff";
			String namef="ff";
			String datef="ff";
			
				  ArrayList<Register> pp = new ArrayList<>();
				
				try {
					pp = logindb.findUser(name);
					
					if(pp== null)
					{
						System.out.println("\n NOT FOUND ");
						RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
						
						
						rd.forward(request, response);
					
					}
					
					for(Register k : pp)
					{
					emailf=	k.getEmail();
					namef= k.getName();
					datef=k.getDate();
					System.out.println("\n in add SRCH SERVLET  loop"+emailf);
					}
					
					
					 request.setAttribute("pp", pp); 
					session.setAttribute("emailf", emailf);
					session.setAttribute("namef", namef);
					session.setAttribute("datef", datef);
					
					  // System.out.println("\n view profile "+profile.getName()+profile.getEmail()+profile.getDate());
					   
					
					if(pp.size()==0)
					{
						datef="";
						emailf="USER NOT FOUND ";
						namef=null;
						session.setAttribute("emailf", emailf);
						session.setAttribute("namef", namef);
						session.setAttribute("datef", datef);
						RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
						
						rd.forward(request, response);
					}
					
					else
					{
						
	RequestDispatcher rd = request.getRequestDispatcher("Viewfrnd.jsp");
						
						rd.forward(request, response);
					}
					
					
					   
					
				} 
					catch (Exception e) {
					
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
