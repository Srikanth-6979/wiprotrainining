let employees = [
    { name: "Sriaknth", role: "Manager", empId: 101, salary: 75000 },
    { name: "Nagur", role: "Developer", empId: 102, salary: 60000 },
    { name: "Chaitanya", role: "Manager", empId: 103, salary: 80000 },
    { name: "Farisa", role: "QA", empId: 104, salary: 55000 },
    { name: "Sameer", role: "Manager", empId: 105, salary: 72000 }
];

let totalManagerSalary = employees.filter(emp => emp.role === "Manager")
                    .reduce((total, emp) => total + emp.salary, 0);

console.log("Total salary of all managers:", totalManagerSalary);
