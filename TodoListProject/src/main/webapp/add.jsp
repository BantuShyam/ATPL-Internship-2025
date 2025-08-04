<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Todo</title>
</head>
<body>
    <h2>Add New Todo</h2>
    
    <form action="addTodo" method="post">
        <label>Title:</label>
        <input type="text" name="title" required><br><br>

        <label>Priority:</label>
        <select name="priority" required>
            <option value="">--Select--</option>
            <option value="LOW">LOW</option>
            <option value="MEDIUM">MEDIUM</option>
            <option value="HIGH">HIGH</option>
        </select><br><br>

        <button type="submit">Add</button>
    </form>

    <br>
    <a href="viewTodos">Back to List</a>
</body>
</html>
