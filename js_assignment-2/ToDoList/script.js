let tasks = JSON.parse(localStorage.getItem("tasks")) || [];

function displayTasks() {
  const taskList = document.getElementById("taskList");
  taskList.innerHTML = "";

  tasks.forEach((task, index) => {
    const li = document.createElement("li");
    li.className = task.completed ? "completed" : "";

    const span = document.createElement("span");
    span.innerText = task.text;
    span.onclick = () => toggleComplete(index);

    const delBtn = document.createElement("button");
    delBtn.innerText = "Delete";
    delBtn.onclick = () => deleteTask(index);

    li.appendChild(span);
    li.appendChild(delBtn);
    taskList.appendChild(li);
  });

  localStorage.setItem("tasks", JSON.stringify(tasks));
}

function addTask() {
  const input = document.getElementById("taskInput");
  const taskText = input.value.trim();

  if (taskText) {
    tasks.push({ text: taskText, completed: false });
    input.value = "";
    displayTasks();
  }
}

function toggleComplete(index) {
  tasks[index].completed = !tasks[index].completed;
  displayTasks();
}

function deleteTask(index) {
  tasks.splice(index, 1);
  displayTasks();
}

// Load tasks on page load
window.onload = displayTasks;
