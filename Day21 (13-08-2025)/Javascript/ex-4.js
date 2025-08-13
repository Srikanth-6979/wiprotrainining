const textbox = document.getElementById("myTextbox");
const counterLabel = document.getElementById("charCounter");
const maxLength = 50;

textbox.addEventListener("input", function() {
    const remaining = maxLength - textbox.value.length;
    counterLabel.textContent = remaining + " characters remaining";
});
