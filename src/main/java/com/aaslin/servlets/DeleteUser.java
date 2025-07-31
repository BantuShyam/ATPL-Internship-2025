package com.aaslin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaslin.utils.DBConnection;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>UserDetails</title>");
			out.println("</head>");
		   out.println("<body>");
		   out.println("<form action= 'DeleteUser'  method='post'>");
	 	   out.println("Enter user id: <input type='text' name='user'><br>");
	 	  out.println("Enter user role: <input type='text' name='role'><br>");
	        out.println("<input type='submit' value='Insert Detail'>");
	 	   out.println("</form>");
	 	  out.println("</body>");
		   out.println("</html>");
			
		}
	       
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String idS=request.getParameter("user");
			PrintWriter out=response.getWriter();
			if(idS==null) {
				response.setContentType("text/html");
				out.println("<h3>Access denied</h3>");
			}
			int id=Integer.parseInt(idS);
			String role=request.getParameter("role");
			String sql = "delete from student where id=? && role=?";
			response.setContentType("text/html");
			try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
	            ps.setInt(1,id);
	            ps.setString(2, role);
	            ps.executeUpdate();
	            response.setContentType("text/html");
	    		out.println("<html><body>");
	            out.println("<h3>Student with id "+id+" deleted</h3>");
	            out.println("</body>");
	     	   out.println("</html>");
	     	  con.close();
	          ps.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	}

