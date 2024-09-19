package task2;
import java.util.ArrayList;
import java.util.Scanner;
public class ExpenseTracker {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Expense>expenses=ExpenseStorage.loadExpenses();
        while(true){
            System.out.println("\nExpense Tracker Menu: ");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date=sc.next();
                sc.nextLine();
                System.out.print("Enter description: ");
                String desc=sc.nextLine();
                System.out.print("Enter amount: ");
                double amount=sc.nextDouble();
                expenses.add(new Expense(date,desc,amount));
                ExpenseStorage.saveExpenses(expenses);
                break;
                case 2:
                for(Expense e: expenses){
                    System.out.println(e);
                }
                break;
                case 3:
                System.out.println("Goodbye!!!");
                return;
                default:
                System.out.println("Invalid choice, Please select from the menu.");
            }
        }
    }
    
}
