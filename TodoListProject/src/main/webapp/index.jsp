<%@ page import="java.sql.*, java.time.*, java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.aaslin.util.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo Dashboard</title>
</head>
<body>
    <h1>Todo Task Dashboard</h1>
    <p><a href="add.jsp">Add New Todo</a></p>

    <h2>Weekly Tasks (Grouped by Status)</h2>
    <%
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
        Connection conn = null;
        Map<String, List<Map<String, Object>>> weeklyGroupedTasks = new HashMap<>();

        try {
            conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM todos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String status = rs.getString("status");
                Map<String, Object> task = new HashMap<>();
                task.put("id", rs.getInt("id"));
                task.put("title", rs.getString("title"));
                task.put("priority", rs.getString("priority"));
                task.put("created_at", rs.getDate("created_at"));

                weeklyGroupedTasks.computeIfAbsent(status, k -> new ArrayList<>()).add(task);
            }

            String[] statusOrder = {"TODO", "INPROGRESS", "DONE"};
            for (String status : statusOrder) {
                List<Map<String, Object>> tasks = weeklyGroupedTasks.getOrDefault(status, new ArrayList<>());
    %>
        <h3><%= status %> Tasks (<%= tasks.size() %>)</h3>
        <table border="1" cellpadding="5" cellspacing="0">
            <tr>
                <th>Title</th>
                <th>Priority</th>
                <th>Created</th>
                <th>Action</th>
            </tr>
            <%
                for (Map<String, Object> task : tasks) {
            %>
            <tr>
                <td><%= task.get("title") %></td>
                <td><%= task.get("priority") %></td>
                <td><%= task.get("created_at") %></td>
                <td>
                    <% if ("TODO".equals(status)) { %>
                        <form action="UpdateStatusServlet" method="post">
                            <input type="hidden" name="id" value="<%= task.get("id") %>">
                            <input type="hidden" name="status" value="INPROGRESS">
                            <input type="submit" value="Mark In Progress">
                        </form>
                    <% } else if ("INPROGRESS".equals(status)) { %>
                        <form action="UpdateStatusServlet" method="post">
                            <input type="hidden" name="id" value="<%= task.get("id") %>">
                            <input type="hidden" name="status" value="DONE">
                            <input type="submit" value="Mark Done">
                        </form>
                    <% } else { %>
                        Completed
                    <% } %>
                </td>
            </tr>
            <% } %>
        </table>
    <%
            }
    %>

    <h2>Monthly Progress Summary</h2>
    <%
        LocalDate startOfMonth = today.withDayOfMonth(1);
        for (String s : statusOrder) {
            PreparedStatement stat = conn.prepareStatement("SELECT COUNT(*) FROM todos WHERE status = ? AND created_at >= ?");
            stat.setString(1, s);
            stat.setDate(2, java.sql.Date.valueOf(startOfMonth));
            ResultSet count = stat.executeQuery();
            count.next();
    %>
        <p><strong><%= s %></strong> tasks this month: <%= count.getInt(1) %></p>
    <%
        }

        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    %>
</body>
</html>
