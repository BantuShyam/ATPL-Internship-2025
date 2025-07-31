package com.aaslin.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class UserFilterServlet implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        PrintWriter out = response.getWriter();
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            chain.doFilter(request, response);
            return;
        }
        String role = request.getParameter("role");
        String ageStr = request.getParameter("age");
        if (role == null || ageStr == null || ageStr.isEmpty()) {
            response.setContentType("text/html");
            out.println("<h3>Missing role or age</h3>");
            return;
        }
        int age;
        try {
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            response.setContentType("text/html");
            out.println("<h3>Invalid age value</h3>");
            return;
        }
//        if (!"admin".equalsIgnoreCase(role)) {
//            response.setContentType("text/html");
//            out.println("<h3>Access denied: Only admin can submit</h3>");
//            return;
//        }
        if (age <= 1) {
            response.setContentType("text/html");
            out.println("<h3>Not allowed to store: Age too low</h3>");
            return;
        }

        chain.doFilter(request, response);
    }
}