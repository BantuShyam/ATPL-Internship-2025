package com.aaslin.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StorageServlet extends HttpServlet{
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
	   out.println("<form action= 'StorageServlet'  method='post'>");
 	   out.println("Enter user id: <input type='text' name='user'><br>");
 	   out.println("Enter user name: <input type='text' name='usern'><br>");
 	  out.println("Enter user role: <input type='text' name='role'><br>");
	   out.println("Enter user age: <input type='text' name='age'><br>");
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
		String user_name=request.getParameter("usern");
		String role=request.getParameter("role");
		int age=Integer.parseInt(request.getParameter("age"));
		String sql = "insert into student(id,name,role,age) values(?,?,?,?)";
		 String url="jdbc:mysql://localhost:3306/Studentdb";
	        String userName="root";
	        String password="shyam@1773";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2,user_name);
            ps.setString(3,role);
            ps.setInt(4,age);
            ps.executeUpdate();
            response.setContentType("text/html");
    		out.println("<html><body>");
            out.println("<h3>Student with "+id+" inserted...</h3>"+user_name);
            out.println("</body>");
     	   out.println("</html>");
     	  con.close();
          ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
}
}

