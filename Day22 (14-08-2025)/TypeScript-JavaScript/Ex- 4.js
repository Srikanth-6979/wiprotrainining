class BankAccount {
    constructor(accountNumber, balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    deposit(amount) {
        if (amount > 0) {
            this.balance += amount;
            console.log(`Deposited ₹${amount}. New balance: ₹${this.balance}`);
        } else {
            console.log("Deposit amount must be positive.");
        }
    }

    withdraw(amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            console.log(`Withdrew ₹${amount}. New balance: ₹${this.balance}`);
        } else {
            console.log("Insufficient balance.");
        }
    }
}

const myAccount = new BankAccount("123456", 5000);
myAccount.deposit(2000);  
myAccount.withdraw(1500); 
myAccount.withdraw(6000); 
