import java.util.Scanner;

// Class representing the user's bank account
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
            return true; // Withdrawal successful
        }
        return false; // Insufficient balance for withdrawal
    }
}

// Class representing the ATM machine
public class ATM {
    private BankAccount userAccount;

    public ATM(double initialBalance) {
        this.userAccount = new BankAccount(initialBalance);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
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
                boolean isWithdrawn = userAccount.withdraw(withdrawAmount);
                if (isWithdrawn) {
                    System.out.println("Amount withdrawn successfully.");
                } else {
                    System.out.println("Insufficient balance for withdrawal.");
                }
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                userAccount.deposit(depositAmount);
                System.out.println("Amount deposited successfully.");
                break;
            case 3:
                double balance = userAccount.getBalance();
                System.out.println("Your current balance is: " + balance);
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please select again.");
                break;
        }
    }

    public static void main(String[] args) {
        double initialBalance = 1000.0; // Initial balance for the user account
        ATM atm = new ATM(initialBalance);

        Scanner scanner = new Scanner(System.in);
        int option;
        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            atm.processOption(option);
        }
    }
}
