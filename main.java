import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to MyBank!");
            System.out.println("1. Create Account");
            System.out.println("2. Perform Transaction");
            System.out.println("3. View Transaction History");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    scanner.nextLine();
                    String accountNumber = bank.createAccount(accountHolderName, initialBalance);
                    System.out.println("Account created successfully. Account Number: " + accountNumber);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accNumber = scanner.nextLine();
                    System.out.print("Enter transaction amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter transaction type (deposit/withdraw): ");
                    String transactionType = scanner.nextLine();
                    bank.performTransaction(accNumber, amount, transactionType);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String accnum = scanner.nextLine();
                    TransactionHistory history = bank.getTransactionHistory(accnum);

                    if (history != null) {
                        System.out.println("Transaction History for Account: " + accnum);
                        for (Transaction transaction : history.getTransactions()) {
                            System.out.println(transaction);
                            System.out.println("--------");
                        }
                    } else {
                        System.out.println("Account not found or has no transaction history.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
