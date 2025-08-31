document.getElementById("registerForm").addEventListener("submit", function(e) {
  e.preventDefault(); 

  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const password = document.getElementById("password").value.trim();
  const confirmPassword = document.getElementById("confirmPassword").value.trim();

  const nameError = document.getElementById("nameError");
  const emailError = document.getElementById("emailError");
  const passwordError = document.getElementById("passwordError");
  const confirmError = document.getElementById("confirmError");

  nameError.textContent = "";
  emailError.textContent = "";
  passwordError.textContent = "";
  confirmError.textContent = "";

  let isValid = true;

  if (name === "") {
    nameError.textContent = "Name is required";
    isValid = false;
  }

  const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  if (email === "") {
    emailError.textContent = "Email is required";
    isValid = false;
  } else if (!email.match(emailPattern)) {
    emailError.textContent = "Invalid email format";
    isValid = false;
  }

  if (password === "") {
    passwordError.textContent = "Password is required";
    isValid = false;
  } else if (password.length < 6) {
    passwordError.textContent = "Password must be at least 6 characters";
    isValid = false;
  }

  if (confirmPassword === "") {
    confirmError.textContent = "Please confirm password";
    isValid = false;
  } else if (confirmPassword !== password) {
    confirmError.textContent = "Passwords do not match";
    isValid = false;
  }

  if (isValid) {
    alert("Registration Successful ✅");
    document.getElementById("registerForm").reset();
  }
});
