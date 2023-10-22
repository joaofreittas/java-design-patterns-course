package factorymethod.example3;

public class PaymentProcessorFactory {

    public static PaymentProcessor create(int typePayment) {

        if (typePayment == 1) {
            return new CreditCardPaymentProcessor();
        }

        if (typePayment == 2) {
            return new DigitalWalletPaymentProcessor();
        }

        throw new IllegalArgumentException("Type Payment not available");
    }

}
