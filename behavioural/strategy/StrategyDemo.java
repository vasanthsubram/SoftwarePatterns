package patterns.behavioural.strategy;

// Strategy Interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy A
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

// Concrete Strategy B
class PayPalPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Set the strategy dynamically
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

// Client
public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100); // Output: Paid $100 using Credit Card.

        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200); // Output: Paid $200 using PayPal.
    }
}