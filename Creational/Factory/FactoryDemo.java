// Product interface
interface Payment {
    void pay(int amount);
}

// 2) Concrete Products
class CreditCardPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " with Credit Card");
    }
}

class UpayPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}

class CryptoPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " in Bitcoin");
    }
}

class PaypalPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " in Paypal");

    }
}

class PaymentFactory {
    public static Payment getPaymentMethod(String type) {
        switch (type.toLowerCase()) {
            case "credit":
                return new CreditCardPayment();
            case "upi":
                return new UpayPayment();
            case "crypto":
                return new CryptoPayment();
            case "paypal":
                return new PaypalPayment();
            default:
                throw new IllegalArgumentException("Unknown payment method: " + type);
        }
    }
}


// 4) Demo (client code)
public class FactoryDemo {
    public static void main(String[] args) {
        Payment p1 = PaymentFactory.getPaymentMethod("credit");
        p1.pay(1000);

        Payment p2 = PaymentFactory.getPaymentMethod("upi");
        p2.pay(2500);

        Payment p3 = PaymentFactory.getPaymentMethod("crypto");
        p3.pay(5000);

        Payment p4 = PaymentFactory.getPaymentMethod("paypal");
        p4.pay(2459);
    }
}

