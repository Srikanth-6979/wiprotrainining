class Stack<T> {
    private items: T[] = [];

    push(item: T): void {
        this.items.push(item);
    }

    pop(): T | undefined {
        return this.items.pop();
    }


    peek(): T | undefined {
        return this.items[this.items.length - 1];
    }
}

let numberStack = new Stack<number>();
numberStack.push(9);
numberStack.push(99);
numberStack.push(999);

console.log("Peek:", numberStack.peek());
console.log("Pop:", numberStack.pop()); 

let stringStack = new Stack<string>();
stringStack.push("Srikanth");
stringStack.push("Sameer");

console.log("Peek:", stringStack.peek());
console.log("Pop:", stringStack.pop());  
