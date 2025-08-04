package com.aaslin.servlets;

import com.aaslin.util.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ViewTodosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Map<String, String>> todos = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM todos ORDER BY created_at DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Map<String, String> todo = new HashMap<>();
                todo.put("id", rs.getString("id"));
                todo.put("title", rs.getString("title"));
                todo.put("priority", rs.getString("priority"));
                todo.put("status", rs.getString("status"));
                todos.add(todo);
            }
        } catch (SQLException e) {
            throw new ServletException("DB Read Error", e);
        }

        request.setAttribute("todos", todos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}