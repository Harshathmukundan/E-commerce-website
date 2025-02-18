const formsContainer = document.querySelector(".forms");
const pwShowHide = document.querySelectorAll(".eye-icon");
const loginLink = document.querySelector(".login-link");
const signupLink = document.querySelector(".signup-link");
const loginForm = document.getElementById("loginForm");
const signupForm = document.getElementById("signupForm");

// Toggle password visibility
pwShowHide.forEach(eyeIcon => {
  eyeIcon.addEventListener("click", () => {
    let pwFields = eyeIcon.parentElement.querySelectorAll(".password");
    pwFields.forEach(password => {
      password.type = password.type === "password" ? "text" : "password";
      eyeIcon.classList.toggle("bx-hide");
      eyeIcon.classList.toggle("bx-show");
    });
  });
});

// Toggle between Login and Signup forms
signupLink.addEventListener("click", (e) => {
  e.preventDefault();
  formsContainer.classList.add("show-signup");
});

loginLink.addEventListener("click", (e) => {
  e.preventDefault();
  formsContainer.classList.remove("show-signup");
});

// Handle Login Form Submission
// Handle Login Form Submission
// Handle Login Form Submission
loginForm.addEventListener("submit", async (e) => {
  e.preventDefault();

  const formData = new FormData(loginForm);
  const data = Object.fromEntries(formData.entries());

  try {
    const response = await fetch("/api/user/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });

    if (response.status === 200) {
      // Successful login, redirect to index.html
      window.location.href = "index.html";
    } else if (response.status === 401) {
      // Unauthorized - show an error message
      alert("Incorrect email or password. Please try again.");
    } else {
      // Handle other errors, if any
      const message = await response.text();
      alert(`Error: ${message}`);
    }
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred while logging in.");
  }
});


// Handle Signup Form Submission
signupForm.addEventListener("submit", async (e) => {
  e.preventDefault();

  const formData = new FormData(signupForm);
  const data = Object.fromEntries(formData.entries());

  try {
    const response = await fetch("/api/user/register", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    });

    const message = await response.text();
    alert(message); // Display server response
  } catch (error) {
    console.error("Error:", error);
    alert("An error occurred while signing up.");
  }
});
