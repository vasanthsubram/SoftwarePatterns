package patterns.structural.adapter;

interface PaymentProcessor {
    void processPayment(double amount);
}

class OldPaymentSystem {
    public void makePayment(String accountNumber, double amount) {
        System.out.println("Processing payment of $" + amount + " for account: " + accountNumber);
    }
}

class PaymentAdapter implements PaymentProcessor {
    private OldPaymentSystem oldPaymentSystem;
    private String defaultAccountNumber = "ACC12345"; // Default account for simplicity

    public PaymentAdapter(OldPaymentSystem oldPaymentSystem) {
        this.oldPaymentSystem = oldPaymentSystem;
    }

    @Override
    public void processPayment(double amount) {
        // Translate the new interface call to the old system's method
        oldPaymentSystem.makePayment(defaultAccountNumber, amount);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        // Create the legacy system (Adaptee)
        OldPaymentSystem oldSystem = new OldPaymentSystem();

        // Create the adapter
        PaymentProcessor processor = new PaymentAdapter(oldSystem);

        // Client uses the new interface
        processor.processPayment(100.50);
    }
}