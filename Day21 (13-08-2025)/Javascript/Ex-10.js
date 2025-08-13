let persons = [
    { name: "Srikanth", age: 17, city: "Hyderbad" },
    { name: "Nagur", age: 22, city: "Ameerpet" },
    { name: "Chaitnaya", age: 19, city: "Jubilee Hills" },
    { name: "Sameer", age: 15, city: "Sanath Nagar" },
    { name: "Suresh", age: 30, city: "Kukatpally" }
];

persons = persons.map(person => {
    return {
        name: person.name,
        age: person.age,
        city: person.city,
        status: person.age >= 18 ? "adult" : "minor"
    };
});

console.log(persons);
