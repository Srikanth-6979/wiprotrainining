let persons = [
    { name: "Srikanth", age: 17, city: "Hyderbad" },
    { name: "Nagur", age: 22, city: "Ameerpet" },
    { name: "Chaitnaya", age: 19, city: "Jubilee Hills" },
    { name: "Sameer", age: 15, city: "Sanath Nagar" },
    { name: "Suresh", age: 30, city: "Kukatpally" }
];

for (let i = 0; i < persons.length; i++) {
    if (persons[i].age >= 18) {
        persons[i].status = "adult";
    } else {
        persons[i].status = "minor";
    }
}

console.log(persons);
