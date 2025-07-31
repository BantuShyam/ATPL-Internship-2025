package com.aaslin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaslin.utils.DBConnection;

public class UserDetails extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String role=req.getParameter("role");
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String sql = "select * from student where role=?";
		try(Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql)){
			ps.setString(1,role);
            ResultSet rs = ps.executeQuery();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Detail </title>");
            out.println("</head>");
            out.println("<body>");
            while (rs.next()) {
                out.println("<h2> Details: "+rs.getString("id") + " " + rs.getString("name")+" "+rs.getString("role")+ " "+rs.getString("age")+"</h2>");
            }
            out.println("</body>");
            out.println("</html>");
            con.close();
            ps.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}

}
