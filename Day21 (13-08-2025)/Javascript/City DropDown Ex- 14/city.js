const cities = ["Hyderabad", "Mumbai", "Andhra Pradesh", "Delhi", "Chennai", "Kolkata", "Bangalore"];
console.log(cities);

const button = document.getElementById("addCitiesBtn");
const dropdown = document.getElementById("cityDropdown");

button.addEventListener("click", function() {

    dropdown.length = 1;

    const sortedCities = cities.slice().sort();

    sortedCities.forEach(function(city) {
        const option = document.createElement("option");
        option.value = city;
        option.text = city;
        dropdown.add(option);
    });
});
