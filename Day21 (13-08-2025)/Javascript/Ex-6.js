let names = ["Srikanth", "Nagur", "Sameer", "Sri", "Chaitanya", "Ramesh"];

let result = names.filter(name => name.length > 5);
console.log(result);
let upperCaseNames= result.map(name => name.toUpperCase());  
console.log(upperCaseNames);

