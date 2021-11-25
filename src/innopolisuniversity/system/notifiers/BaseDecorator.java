package innopolisuniversity.system.notifiers;

import innopolisuniversity.system.Report;
import innopolisuniversity.users.Patient;

public abstract class BaseDecorator implements Notifier {
    private final Notifier notifier;

    public BaseDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

     @Override
    public void send(Report report) {
        notifier.send(report);
    }
}