function checkPalindrome(str) {
    let reversed = str.split("").reverse().join("");
    if (str === reversed) {
        console.log("Palindrome");
    } else {
        console.log("Not Palindrome");
    }
}
checkPalindrome("madam");  
checkPalindrome("hello");  
