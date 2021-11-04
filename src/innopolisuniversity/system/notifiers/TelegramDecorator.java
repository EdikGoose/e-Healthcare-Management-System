package innopolisuniversity.system.notifiers;

public class TelegramDecorator extends BaseDecorator{
    private final String phoneNumber;

    public TelegramDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendTelegram(message);
    }

    private void sendTelegram(String message) {
        System.out.println("Sent to Telegram (" + this.phoneNumber + "): " + message);
    }
}
