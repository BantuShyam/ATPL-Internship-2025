package com.aaslin.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.aaslin.utils.DBConnection;

import java.io.*;
import java.sql.*;
@WebServlet("/user")

public class PatchExample extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		String active = request.getParameter("active");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (id == null || active == null) {
			out.println("<h2>User ID is missing.</h2>");
			return;
		}
		try {
		
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("update student set active= ? where id= ?");
					
				ps.setInt(1, Integer.parseInt(active));
				ps.setInt(2, Integer.parseInt(id));
				
				int rowsUpdated=ps.executeUpdate();
				if(rowsUpdated>0) {
					out.println("user id "+id+"updated active: "+active);
				}
				else {
					out.println("user not found");
				}
				ps.close();
				con.close();
			}
			catch(Exception e) {
				out.println("Error: "+e.getMessage());
	}
}
}