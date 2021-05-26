package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Resource(name="jdbc/new")
    private DataSource ds;
    private usersdb userdb;
    private PostDBUtil postdb;
    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			userdb = new usersdb(ds);
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
			System.out.println("CreatePostServelet");
		
		HttpSession session = request.getSession();
		
		String ssn=(String)session.getAttribute("ssnname");
       String myPass=(String)session.getAttribute("ssnpass");
		
	
		
	    
	    SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date = SDF.format(new Date());
		
 String postContent = request.getParameter("postContent");
		
	
		 Post posttemp=new Post(ssn, postContent, date);
		 
	        
	     PostDBUtil postdbutil = new PostDBUtil(ds); 
	
		
			
	     RequestDispatcher dispatcher = request.getRequestDispatcher("LoginUser?loginemail=" +ssn+ "&loginpass="+myPass);
	     
	        boolean createdposted;
			try {
				createdposted = postdbutil.createPost(posttemp);
				if (createdposted)
				{
					
					request.setAttribute("pstdn", "Post Created");
				 dispatcher.forward(request, response);
				}
				else
					
					request.setAttribute("pstnd", "Post cannot be Created");
					
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
