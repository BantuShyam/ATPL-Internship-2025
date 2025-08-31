function generateTable() {
  let num = document.getElementById("numberInput").value;
  let output = "";
  if (num === "") {
    document.getElementById("table").innerText = "Enter a number";
    return;
  }
  num = parseInt(num);
  for (let i = 1; i <= 10; i++) {
    output += `${num} × ${i} = ${num * i}\n`;
  }
  document.getElementById("table").innerText = output;
}
