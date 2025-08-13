let employee = {
  name: "Simon Denver",
  age: 34,
  position: "Software Engineer",
};
 
var litsEmployee = [
  {
    name: "John Doe",
    age: 30,
    position: "Software Engineer",
  },
  {
    name: "Mark Freeman",
    age: 32,
    position: "Software Engineer",
  },
  {
    name: "Patricia  Dark",
    age: 35,
    position: "Accounts",
  },
];
 
litsEmployee.push(employee);
 
let newEmpList=litsEmployee.map((emp) => {
   emp.name = emp.name.toUpperCase();
});  
 
for(let i=0;i<newEmpList.length;i++){
  console.log(newEmpList[i]);
 
}