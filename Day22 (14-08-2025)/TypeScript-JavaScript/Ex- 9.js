const numbers = [1, 2, 3];

function sum(a, b, c) {
    return a + b + c;
}

const total = sum(...numbers);

console.log("Sum :", total);
