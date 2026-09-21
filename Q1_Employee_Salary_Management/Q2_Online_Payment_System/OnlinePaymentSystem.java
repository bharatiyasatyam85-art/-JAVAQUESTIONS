import java.util.Scanner;

interface Payment {
    void pay(double amount);
    void getPaymentStatus();
}

class CreditCardPayment implements Payment {

    private boolean paymentSuccessful;

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment of Rs. " + amount);
        paymentSuccessful = true;
    }

    @Override
    public void getPaymentStatus() {
        if (paymentSuccessful) {
            System.out.println("Credit Card Payment Successful");
        } else {
            System.out.println("Credit Card Payment Failed");
        }
    }
}

class UPIPayment implements Payment {

    private boolean paymentSuccessful;

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of Rs. " + amount);
        paymentSuccessful = true;
    }

    @Override
    public void getPaymentStatus() {
        if (paymentSuccessful) {
            System.out.println("UPI Payment Successful");
        } else {
            System.out.println("UPI Payment Failed");
        }
    }
}

class NetBankingPayment implements Payment {

    private boolean paymentSuccessful;

    @Override
    public void pay(double amount) {
        System.out.println("Processing Net Banking payment of Rs. " + amount);
        paymentSuccessful = true;
    }

    @Override
    public void getPaymentStatus() {
        if (paymentSuccessful) {
            System.out.println("Net Banking Payment Successful");
        } else {
            System.out.println("Net Banking Payment Failed");
        }
    }
}

public class OnlinePaymentSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter payment amount: Rs. ");
        double amount = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter payment method (Credit Card / UPI / Net Banking): ");
        String method = sc.nextLine();

        Payment payment = null;

        if (method.equalsIgnoreCase("Credit Card")) {
            payment = new CreditCardPayment();
        } else if (method.equalsIgnoreCase("UPI")) {
            payment = new UPIPayment();
        } else if (method.equalsIgnoreCase("Net Banking")) {
            payment = new NetBankingPayment();
        } else {
            System.out.println("Invalid payment method.");
            sc.close();
            return;
        }

        payment.pay(amount);
        payment.getPaymentStatus();

        sc.close();
    }
}
