package com.aaslin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaslin.utils.DBConnection;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("itemId");
		String quantity = request.getParameter("itemQuantity");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		if (id == null || quantity == null) {
			writer.println("<h2>Order Details are missing.</h2>");
			return;
		}
		String sql = "insert into orders_s(item_id, quantity, order_date) values ( ?, ?, ?)";
		try(Connection con=DBConnection.getConnection();
				PreparedStatement ps=con.prepareStatement(sql)){
				ps.setInt(1, Integer.parseInt(id));
				ps.setInt(2, Integer.parseInt(quantity));
				
				Timestamp now = new Timestamp(System.currentTimeMillis());
				ps.setTimestamp(3, now);
				
				int row = ps.executeUpdate();
				
				if (row > 0) {
					
					HttpSession session = request.getSession();
					
					session.setAttribute("item_id", id);
					session.setAttribute("quantity", quantity);
					session.setAttribute("order_time", now);
					
					writer.println("<h2>Data Stored Successfully</h2>");
				}
				else {
					writer.println("<h2>Failed to store...</h2>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}