package innopolisuniversity.system.notifiers;

public class EmailDecorator extends BaseDecorator {
    private final String email;

    public EmailDecorator(Notifier notifier, String email) {
        super(notifier);
        this.email = email;
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendToEmail(message);
    }

    private void sendToEmail(String message) {
        System.out.println("Send " + message + " to " + email);
    }
}