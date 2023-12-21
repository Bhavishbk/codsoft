import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }
}

// ATM class for user interactions
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        this.bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful.");
                }
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            case 3:
                System.out.println("Your balance is: " + bankAccount.getBalance());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance of $1000
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            atm.processOption(option);
        } while (option != 4);
    }
}