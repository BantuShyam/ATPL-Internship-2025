package com.aaslin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int id=Integer.parseInt(req.getParameter("user"));
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String sql = "select * from student where id=?";
		 String url="jdbc:mysql://localhost:3306/Studentdb";
	        String username="root";
	        String password="shyam@1773";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Detail </title>");
            out.println("</head>");
            out.println("<body>");
            while (rs.next()) {
                out.println("<h2> StudentDetails: "+rs.getString("id") + " " + rs.getString("name")+"</h2>");
            }
            out.println("</body>");
            out.println("</html>");
            con.close();
            ps.close();
            rs.close();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
		
	}

}
