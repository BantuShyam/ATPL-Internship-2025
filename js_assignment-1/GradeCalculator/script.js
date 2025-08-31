function calculateGrade() {
  let sub1 = parseInt(document.getElementById("sub1").value) || 0;
  let sub2 = parseInt(document.getElementById("sub2").value) || 0;
  let sub3 = parseInt(document.getElementById("sub3").value) || 0;
  let sub4 = parseInt(document.getElementById("sub4").value) || 0;
  let sub5 = parseInt(document.getElementById("sub5").value) || 0;

  let total = sub1 + sub2 + sub3 + sub4 + sub5;
  let avg = total / 5;

  let grade;
  if (avg >= 90) grade = "A";
  else if (avg >= 75) grade = "B";
  else if (avg >= 60) grade = "C";
  else if (avg >= 40) grade = "D";
  else grade = "F";

  let resultDiv = document.getElementById("result");
  resultDiv.innerHTML = `Total: ${total} <br> Average: ${avg.toFixed(2)} <br> Grade: ${grade}`;

  if (grade === "F") {
    resultDiv.className = "fail";
  } else {
    resultDiv.className = "pass";
  }
}
