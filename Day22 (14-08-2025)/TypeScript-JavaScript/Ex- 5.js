class Vehicle {
    constructor(make, model, year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    getInfo() {
        return `${this.year} - ${this.make} - ${this.model}`;
    }
}

class Car extends Vehicle {
    constructor(make, model, year, numDoors) {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    getInfo() {
        return `${super.getInfo()} - ${this.numDoors} doors`;
    }
}

// const vehicle1 = new Vehicle("Toyota", "Fortuner", 2020);
// console.log(vehicle1.getInfo()); 

const car1 = new Car("Mahindra", "ThaR", 2022, 4);
console.log(car1.getInfo());
