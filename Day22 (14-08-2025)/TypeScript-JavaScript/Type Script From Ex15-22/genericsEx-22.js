var Stack = /** @class */ (function () {
    function Stack() {
        this.items = [];
    }
    Stack.prototype.push = function (item) {
        this.items.push(item);
    };
    Stack.prototype.pop = function () {
        return this.items.pop();
    };
    Stack.prototype.peek = function () {
        return this.items[this.items.length - 1];
    };
    return Stack;
}());
var numberStack = new Stack();
numberStack.push(9);
numberStack.push(99);
numberStack.push(999);
console.log("Peek:", numberStack.peek());
console.log("Pop:", numberStack.pop());
var stringStack = new Stack();
stringStack.push("Srikanth");
stringStack.push("Sameer");
console.log("Peek:", stringStack.peek());
console.log("Pop:", stringStack.pop());
