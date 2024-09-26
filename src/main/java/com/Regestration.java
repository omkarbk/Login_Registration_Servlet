package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Regestration
 */
public class Regestration extends HttpServlet {
	Connection con;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regestration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rl", "root", "Oma@0426");
			

			// TODO Auto-generated method stub
		} catch (ClassNotFoundException | SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
		PrintWriter pw= response.getWriter();

			String s1=request.getParameter("fname");
			String s2=request.getParameter("lname");
			String s3=request.getParameter("uname");
			String s4=request.getParameter("pword");
			try {
				PreparedStatement psmt = con.prepareStatement("INSERT INTO registration (fname, uname, username, password) VALUES (?, ?, ?, ?)");
				//PreparedStatement psmt=con.prepareStatement("insert into registration values(?,?,?,?)");
				psmt.setString(1, s1);
				psmt.setString(2, s2);
				psmt.setString(3, s3);
				psmt.setString(4, s4);
				psmt.executeUpdate();
				pw.print("<html><body>");
				pw.print("<h1>You have Successfuly Regesterd</h1>");
                pw.print("<html><body ><a href=login.html>Login</a></body></html>");

				pw.print("</body></html>");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				pw.println("sql exception");

			}  
			//PreparedStatement psmt=con.prepareStatement("insert into registration values(?,?,?,?)");
//			PrintWriter pw= response.getWriter();
			


		}
	}


