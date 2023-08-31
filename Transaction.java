import java.util.Date;

public class Transaction {
    private int transactionId;
    private Date date;
    private String type;
    private double amount;

    public Transaction(int transactionId, String type, double amount) {
        this.transactionId = transactionId;
        this.date = new Date(); // Automatically set the current date and time
        this.type = type;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               "\nDate: " + date +
               "\nType: " + type +
               "\nAmount: " + amount;
    }
}
