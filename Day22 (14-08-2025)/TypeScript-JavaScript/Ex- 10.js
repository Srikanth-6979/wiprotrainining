function sumNumbers(...numbers) {
    return numbers.reduce((sum, num) => sum + num, 0);
}

console.log(sumNumbers(1, 2, 3));        // 6
console.log(sumNumbers(10, 20, 30, 40)); // 100
console.log(sumNumbers());               // 0
