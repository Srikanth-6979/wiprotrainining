let persons = [
    { name: "Srikanth", age: 17, city: "Hyderbad" },
    { name: "Nagur", age: 22, city: "Ameerpet" },
    { name: "Chaitnaya", age: 19, city: "Jubilee Hills" },
    { name: "Sameer", age: 15, city: "Sanath Nagar" },
    { name: "Suresh", age: 30, city: "Kukatpally" }
];

let eligibleVoters = persons.filter(person => person.age >= 18);

console.log(eligibleVoters);
