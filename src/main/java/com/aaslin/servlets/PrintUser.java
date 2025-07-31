package com.aaslin.servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.aaslin.utils.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintUser extends HttpServlet{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			String sql = "select * from student";
			try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
	            ResultSet rs = ps.executeQuery();
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>User Detail </title>");
	            out.println("</head>");
	            out.println("<body>");
	            while (rs.next()) {
	                out.println("<h2> StudentDetails: "+rs.getString("id") + " " + rs.getString("name")+" "+rs.getString("age")+ "</h2>");
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

