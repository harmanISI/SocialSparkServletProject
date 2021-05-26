package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.PostDBUtil;
import db.*;

/**
 * Servlet implementation class PostsOperationServlet
 */
@WebServlet("/PostsOperationServlet")
public class PostsOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostsOperationServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("\n   PostOperationServlet");
		HttpSession session = request.getSession();
		String ssn = (String) session.getAttribute("ssnname");
	    request.setAttribute("userName", ssn); 
		
	 	String Like = request.getParameter("Like");
	 	
	 	
       String unlike = null; //request.getParameter("unlike");
       String edit = null; // request.getParameter("edit");
        String delete = request.getParameter("delete");
        String savepost = request.getParameter("savepost");
        
       
        int postid = 0;//Integer.parseInt(request.getParameter("postid"));
  //     int userid = Integer.parseInt(request.getParameter("userid")); // my is String 
        
        
        
        
      //  String Redirectsamepage = request.getParameter("Redirectsamepage");
        
       String postcontent=null;//  request.getParameter("postcontent");
  
        PostDBUtil postdbutil = new PostDBUtil(ds); 
        usersdb userdbutil = new usersdb(ds); 
     // int loginsessionuserid = (int) session.getAttribute("loginuserid");
      
  	String userid =(String)session.getAttribute("ssnname");//get userid from session
        
       // String loginsessionuserid=(String)session.getAttribute("ssnname"); mine 
	 
        
        boolean done = false;
		
		if(Like != null) {
			try {
				
				int i=Integer.parseInt(Like);
				
				System.out.println("\n   Like clicke   like value is  "+Like);
				
				
				done = postdbutil.LikePost(i, ssn );
				
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("profilerefresh?PGE=feed.jsp");
  				
				
				request.setAttribute("ssnname", ssn); 
  				dispatcher.forward(request, response);
				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		if(unlike != null) {
			try {
				done = postdbutil.UnlikePost(postid, userid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(edit != null) {
			done = postdbutil.EditPost(postid,userid,postcontent);
		}
		
		if(savepost != null) {
			try {
				done =postdbutil.savedPost(postid, ssn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(delete != null) {
			try {

				int i=Integer.parseInt(delete);
				
				done = postdbutil.DeletePost(i, ssn);
				
RequestDispatcher dispatcher = request.getRequestDispatcher("profilerefresh?PGE=feed.jsp");
  				
				
				request.setAttribute("ssnname", ssn); 
  				dispatcher.forward(request, response);
  				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		if(done) {			
//			response.sendRedirect(Redirectsamepage);
		//	 RequestDispatcher dispatcher = request.getRequestDispatcher(Redirectsamepage);
 			 request.setAttribute("msg", "Operation performed.");
 			// dispatcher.forward(request, response);
		}
		else {
			 //RequestDispatcher dispatcher = request.getRequestDispatcher(Redirectsamepage);
 			 request.setAttribute("msg", "Operation can not Performed.");
 			// dispatcher.forward(request, response);
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
