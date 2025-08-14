
class Box<T> {
    value: T;

    constructor(value: T) {
        this.value = value;
    }

    getValue(): T {
        return this.value;
    }
}

let numberBox = new Box<number>(123);
console.log("Number Box:", numberBox.getValue());

let stringBox = new Box<string>("Hello, Srikanth");
console.log("String Box:", stringBox.getValue());

let booleanBox = new Box<boolean>(true);
console.log("Boolean Box:", booleanBox.getValue());
