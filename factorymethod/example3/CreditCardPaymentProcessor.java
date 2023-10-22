package factorymethod.example3;

public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void pay() {
        System.out.println("payment done!");
    }
    
}
