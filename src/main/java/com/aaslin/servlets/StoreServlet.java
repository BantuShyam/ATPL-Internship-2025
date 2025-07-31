
package com.aaslin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/StoreServlet")
public class StoreServlet extends HttpServlet {
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
	   out.println("<form action= 'StoreServlet'  method='post'>");
 	   out.println("Enter user id: <input type='text' name='user'><br>");
 	   out.println("Enter user name: <input type='text' name='usern'><br>");
        out.println("<input type='submit' value='Insert Detail'>");
 	   out.println("</form>");
 	  out.println("</body>");
	   out.println("</html>");
		
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("user"));
		String user_name=request.getParameter("usern");
		String sql = "insert into student(id,name) values(?,?)";
		 String url="jdbc:mysql://localhost:3306/Studentdb";
	        String userName="root";
	        String password="shyam@1773";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2,user_name);
            ps.executeUpdate();
            response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
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
