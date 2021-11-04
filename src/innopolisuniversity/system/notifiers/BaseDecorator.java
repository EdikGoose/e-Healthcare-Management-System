package innopolisuniversity.system.notifiers;

public abstract class BaseDecorator implements Notifier {
    private final Notifier notifier;

    public BaseDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}
