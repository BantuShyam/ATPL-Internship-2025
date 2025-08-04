package com.aaslin.servlets;

import com.aaslin.util.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

public class AddTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String priority = request.getParameter("priority");
        String status="TODO";
        LocalDate createdAt=LocalDate.now();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO todos (title, priority, status,created_at) values(?,?,?,?)"
            		+"on duplicate key update priority=values(priority),status=values(status),created_at=values(created_at)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, title);
            stmt.setString(2, priority);
            stmt.setString(3, status);
            stmt.setDate(4, Date.valueOf(createdAt));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException("DB Insert Error", e);
        }
        response.sendRedirect("index.jsp");
	}
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {

     response.sendRedirect("add.jsp");
 }
}
