document.addEventListener("DOMContentLoaded", function() {
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    const loginBtn = document.getElementById("loginBtn");

    emailInput.addEventListener("blur", validateEmail);
    passwordInput.addEventListener("blur", validatePassword);
    loginBtn.addEventListener("click", login);

    function validateEmail() {
        const email = emailInput.value.trim();
        const emailError = document.getElementById("emailError");
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (email === "") {
            emailError.textContent = "Email cannot be empty";
            return false;
        } else if (!emailPattern.test(email)) {
            emailError.textContent = "Enter a valid email (e.g., user@example.com)";
            return false;
        } else {
            emailError.textContent = "";
            return true;
        }
    }

    function validatePassword() {
        const password = passwordInput.value.trim();
        const passwordError = document.getElementById("passwordError");

        if (password === "") {
            passwordError.textContent = "Password cannot be empty";
            return false;
        } else {
            passwordError.textContent = "";
            return true;
        }
    }

    function login(event) {
        event.preventDefault();
        const isEmailValid = validateEmail();
        const isPasswordValid = validatePassword();

        if (isEmailValid && isPasswordValid) {
            alert("Login successful!");
        } else {
            alert("Please fix the errors before submitting.");
        }
    }
});
