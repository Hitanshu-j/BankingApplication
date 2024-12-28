import java.util.Scanner;
public class BankingApp {
    private static double balance = 0.0;

    private static void checkBalance() {
        System.out.printf("Your current balance is: Rs%.2f\n", balance);
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited Rs%.2f. Your new balance is: Rs%.2f\n", amount, balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
            depositMoney(scanner);
        }
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew Rs%.2f. Your new balance is: Rs%.2f\n", amount, balance);
        } else if (amount > balance) {
             if(balance <= 0) {
                 System.out.println("Your account balance is " + balance + ",Please deposit some money in your account");
             }
             else {
                 System.out.println("Insufficient balance. Please try a smaller amount.");
                 withdrawMoney(scanner);
             }
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
            withdrawMoney(scanner);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Simple Banking Application!");

        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("Press 1 to Check Balance");
            System.out.println("Press 2 to Deposit Money");
            System.out.println("Press 3 to Withdraw Money");
            System.out.println("Press 4 to Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Simple Banking Application. Have a nice day!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

