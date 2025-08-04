package com.aaslin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;

import com.aaslin.util.DBConnection;

public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement stmt;
            if ("DONE".equalsIgnoreCase(status)) {
                stmt = conn.prepareStatement(
                    "UPDATE todos SET status = ?, done_time = NOW() WHERE id = ?");
                stmt.setString(1, status);
                stmt.setInt(2, id);
            } else {
                stmt = conn.prepareStatement(
                    "UPDATE todos SET status = ? WHERE id = ?");
                stmt.setString(1, status);
                stmt.setInt(2, id);
            }

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new ServletException("Failed to update task status", e);
        }

        response.sendRedirect("index.jsp");
    }
}