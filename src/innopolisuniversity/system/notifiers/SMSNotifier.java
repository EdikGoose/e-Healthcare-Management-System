package innopolisuniversity.system.notifiers;

public record SMSNotifier(String phoneNumber) implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Send " + message + " to " + phoneNumber);
    }
}
