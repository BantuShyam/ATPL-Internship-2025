 function checkEvenOdd() {
      let num = document.getElementById("numberInput").value;

      if (num === "") {
        alert(" Please enter a number!");
        return;
      }

      num = parseInt(num);

      if (num % 2 === 0) {
        document.getElementById("result").innerText = num + " is EVEN ";
      } else {
        document.getElementById("result").innerText = num + " is ODD ";
      }
    }