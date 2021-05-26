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
import javax.sql.DataSource;

import db.usersdb;
import model.Register;
import model.User;

/**
 * Servlet implementation class GetRegistar
 */
@WebServlet("/GetRegistar")
public class GetRegistar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRegistar() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
    
    
    @Resource(name="jdbc/new")
    private DataSource ds;
    private usersdb studentdb;
    private Register registarion;

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
		
		PrintWriter out = response.getWriter();
		
		
		
		String email = request.getParameter("email");
        String name  = request.getParameter("name");
		
		 
		  String pas=request.getParameter("pass");
		  String date=request.getParameter("dob");
		  String que=request.getParameter("que");
		  String ans=request.getParameter("ans");;  
		  
		  registarion= new  Register(email,pas,date,name,que,ans);
		  registarion.setAns(ans);
		  registarion.setName(name);
		  registarion.setPass(pas);
		  registarion.setDate(date);
		  registarion.setEmail(email);
		  registarion.setQue(que);
		  
		  
		  //login
		  
		
		
		
		try {
			
			
			
			 studentdb.getAll(registarion);
			 
			 
			 
		     
	           RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	       	request.setAttribute("name", name);
				rd.forward(request, response);
			 			
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
