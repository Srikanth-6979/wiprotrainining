function printEmployees(employees) {
    console.log("Employee Details:");
    employees.forEach(function (emp) {
        console.log("ID: ".concat(emp.empId, ", Name: ").concat(emp.empName, ", Salary: ").concat(emp.salary));
    });
    return employees.length;
}
var employeeList = [
    { empId: 1, empName: "Srikanth", salary: 50000 },
    { empId: 2, empName: "Nagur", salary: 60000 },
    { empId: 3, empName: "Sameer", salary: 55000 }
];
var count = printEmployees(employeeList);
console.log("Total Employees: ".concat(count));
