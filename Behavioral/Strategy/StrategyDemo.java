
// You have multiple ways to do something 
// (e.g., different payment methods, sorting algorithms, pricing rules) 
// and you want to switch between them without if/else chaos.

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override 
    public void pay(int amount){
        System.out.println("Paid " + amount + " with Credit Card " + cardNumber);
    }
}

class UpayPayment implements PaymentStrategy {
    private final String upiId;

    UpayPayment(String upiId) { 
        this.upiId = upiId; 
    }

    @Override public void pay(int amount) {
        System.out.println("Paid " + amount + " via UPI: " + upiId);
    }
}

class CryptoPayment implements PaymentStrategy {
    private final String walletAddress;

    CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override public void pay(int amount){
        System.out.println("Paid " + amount + " via Crypto Payment: " + walletAddress);
    }

}

class Checkout {
    private PaymentStrategy strategy;
    public void setStrategy(PaymentStrategy strategy){ this.strategy = strategy; }

    public void process( int amount) {
        if (strategy == null) throw new IllegalStateException("No payment strategy set");
        strategy.pay(amount);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        CreditCardPayment creditCardPayment = new CreditCardPayment("41111111111111");

        checkout.setStrategy(creditCardPayment);
        checkout.process(1500);

        checkout.setStrategy(new UpayPayment("Sachith@upi"));
        checkout.process(2300);
    }
}