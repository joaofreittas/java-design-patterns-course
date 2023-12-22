package decorator.example1;

public class Main {

    public static void main(String[] args) {

        var facebookEnable = true;
        var slackEnable = true;
        var smsEnable = true;


        BaseDecorator baseDecorator = new Notifier();

        if (facebookEnable)
            baseDecorator = new FacebookNotifier(baseDecorator);

        if (slackEnable)
            baseDecorator = new SlackNotifier(baseDecorator);

        if (smsEnable)
            baseDecorator = new SmsNotifier(baseDecorator);

        baseDecorator.send();

    }

}

interface BaseDecorator {
    void send();
}

class Notifier implements BaseDecorator {

    private final String DEFAULT = "email";

    @Override
    public void send() {
        System.out.println("notificando por " + DEFAULT);
    }
}

class SmsNotifier implements BaseDecorator {

    private BaseDecorator baseDecorator;

    public SmsNotifier(BaseDecorator baseDecorator) {
        this.baseDecorator = baseDecorator;
    }

    @Override
    public void send() {
        baseDecorator.send();
        System.out.println("notificando por sms");
    }

}

class SlackNotifier implements BaseDecorator {

    private BaseDecorator baseDecorator;

    public SlackNotifier(BaseDecorator baseDecorator) {
        this.baseDecorator = baseDecorator;
    }

    @Override
    public void send() {
        baseDecorator.send();
        System.out.println("notificando por slack");
    }

}

class FacebookNotifier implements BaseDecorator {

    private BaseDecorator baseDecorator;

    public FacebookNotifier(BaseDecorator baseDecorator) {
        this.baseDecorator = baseDecorator;
    }

    @Override
    public void send() {
        baseDecorator.send();
        System.out.println("notificando por facbook");
    }

}

