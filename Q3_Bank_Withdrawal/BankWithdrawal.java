import java.util.Scanner;

class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    private int accountNumber;
    private String customerName;
    private double balance;

    Account(int accountNumber, String customerName, double balance) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient Balance! Available balance: Rs. " + balance
            );
        }

        balance = balance - amount;

        System.out.println("Withdrawal Successful");
        System.out.println("Amount Withdrawn: Rs. " + amount);
        System.out.println("Remaining Balance: Rs. " + balance);
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Current Balance: Rs. " + balance);
    }
}

public class BankWithdrawal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account account = new Account(
                1001,
                "Rahul",
                50000
        );

        account.displayAccountDetails();

        System.out.print("Enter amount to withdraw: Rs. ");
        double amount = sc.nextDouble();

        try {
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Transaction Failed");
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
