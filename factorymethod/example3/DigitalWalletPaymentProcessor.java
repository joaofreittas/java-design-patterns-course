package factorymethod.example3;

public class DigitalWalletPaymentProcessor implements PaymentProcessor {

    @Override
    public void pay() {
        System.out.println("payment done!");
    }
    
}
