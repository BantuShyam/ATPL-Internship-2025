function updateClock() {
  const now = new Date();
  let hours = String(now.getHours()).padStart(2, '0');
  let minutes = String(now.getMinutes()).padStart(2, '0');
  let seconds = String(now.getSeconds()).padStart(2, '0');
  document.getElementById("clock").innerText = `${hours}:${minutes}:${seconds}`;
}

setInterval(updateClock, 1000);
updateClock();

function toggleMode() {
  const body = document.body;
  const button = document.getElementById("modeBtn");

  if (body.classList.contains("light")) {
    body.classList.remove("light");
    body.classList.add("dark");
    button.innerText = "Toggle Light";
  } else {
    body.classList.remove("dark");
    body.classList.add("light");
    button.innerText = "Toggle Dark";
  }
}
