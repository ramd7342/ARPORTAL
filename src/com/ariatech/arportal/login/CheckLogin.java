package com.ariatech.arportal.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ariatech.arportal.connections.DBConnection;
import com.sun.media.sound.AlawCodec;

/**
 * Servlet implementation class CheckLogin
 */
@WebServlet(description = "Checks Login for Admin, Trainee, HR, Trainer", urlPatterns = { "/CheckLogin" })
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("psw");
		String path = "/WEB-INF/";
		String redirectPage = "error.html";
		
		DBConnection dbc = new DBConnection();
		List al = null ;
		try {
			al = dbc.getQuestions();
			System.out.println("getQuestions : "+al);
			Map a = dbc.getLoginStatus(uname,pwd);
			if(a.size() > 0) {
				String role = (String) a.get("role");
				System.out.println("Role : "+role);
				/*if(role.equals("admin")) {
					System.out.println("HR Activated");
					redirectPage = "hrpage.html";
				}
				if(role.equals("trainee")) {
					System.out.println("ADMIN Activated");
					redirectPage = "admin.html";
				}*/
				if(role.equals("admin")) {
					System.out.println("Admin Activated");
					request.setAttribute("qData", al);
					redirectPage = "hrpage.jsp";
				} 
				if(role.equals("trainee")){
					System.out.println("TRAINER Activated");
					redirectPage = "trainer.html";
				}
			}
			//System.out.println(retData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("UserName is "+uname+"\nPassword is "+pwd);
		
		
		System.out.println(redirectPage);
		//response.sendRedirect(redirectPage);
		// PrintWriter pwriter = response.getWriter();
			RequestDispatcher dis=request.getRequestDispatcher("hrpage.jsp");
			dis.forward(request, response); 
		
//		PrintWriter out = response.getWriter();
//		response.setContentType("application/json");
//		response.setCharacterEncoding("UTF-8");
//		out.print(al);
//		out.flush();
		
	}

}
