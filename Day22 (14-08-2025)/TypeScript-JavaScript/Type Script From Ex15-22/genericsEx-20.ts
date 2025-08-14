function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}

let numStrPair = pair<number, string>(101, "Srikanth");
console.log("Number-String Pair:", numStrPair);

let boolNumPair = pair<boolean, number>(true, 99);
console.log("Boolean-Number Pair:", boolNumPair);

let strBoolPair = pair<string, boolean>("Hello", false);
console.log("String-Boolean Pair:", strBoolPair);




// ------------- model-2 -----------

// class Pair<T, U> {
//     first: T;
//     second: U;

//     constructor(first: T, second: U) {
//         this.first = first;
//         this.second = second;
//     }

//     getPair(): [T, U] {
//         return [this.first, this.second];
//     }
// }

// let p1 = new Pair<number, string>(101, "Srikanth");
// console.log("Number-String Pair:", p1.getPair());

// let p2 = new Pair<boolean, number>(true, 99);
// console.log("Boolean-Number Pair:", p2.getPair());

// let p3 = new Pair<string, boolean>("Hello", false);
// console.log("String-Boolean Pair:", p3.getPair());

