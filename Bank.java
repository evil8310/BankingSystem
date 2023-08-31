import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private List<BankAccount> accounts;
    private int nextAccountNumber;
    private int nextTransactionId;
    private Map<String, TransactionHistory> transactionHistories;

    public Bank() {
        accounts = new ArrayList<>();
        transactionHistories = new HashMap<>();
        nextAccountNumber = 1;
        nextTransactionId = 1;
    }

    public String createAccount(String accountHolderName, double initialBalance) {
        String accountNumber = "ACC" + nextAccountNumber++;
        BankAccount account = new BankAccount(accountNumber, accountHolderName, initialBalance);
        accounts.add(account);
        
        TransactionHistory history = new TransactionHistory();
        transactionHistories.put(accountNumber, history);
        
        return accountNumber;
    }

    public void performTransaction(String accountNumber, double amount, String transactionType) {
        BankAccount account = findAccountByNumber(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        Transaction transaction = new Transaction(nextTransactionId++, transactionType, amount);

        if (transactionType.equalsIgnoreCase("deposit")) {
            account.deposit(amount);
        } else if (transactionType.equalsIgnoreCase("withdraw")) {
            account.withdraw(amount);
        } else {
            System.out.println("Invalid transaction type.");
            return;
        }

        TransactionHistory history = transactionHistories.get(accountNumber);
        history.addTransaction(transaction);

        System.out.println("Transaction successful.");
    }

    public TransactionHistory getTransactionHistory(String accountNumber) {
        return transactionHistories.get(accountNumber);
    }

    private BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
