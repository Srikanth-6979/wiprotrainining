const loginBtn = document.getElementById("loginBtn");
const logoutBtn = document.getElementById("logoutBtn");
const statusMsg = document.getElementById("status");

loginBtn.addEventListener("click", () => {
    const userId = document.getElementById("userId").value;

    if (userId.trim() === "") {
        alert("Please enter a User ID");
        return;
    }

    localStorage.setItem("userId", userId);
    statusMsg.textContent = `Welcome, ${userId}! You have logged in successfully`;
});

logoutBtn.addEventListener("click", () => {
    localStorage.removeItem("userId");
    statusMsg.textContent = "You have logged out.";
});

window.onload = () => {
    const savedUser = localStorage.getItem("userId");
    if (savedUser) {
        statusMsg.textContent = `Welcome back, ${savedUser}!`;
    }
};
