const arr = [1, 2, 3, 4, 5];

const sumArray = (numbers) => numbers.reduce((sum, num) => sum + num, 0);

console.log(sumArray(arr));
