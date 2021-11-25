package innopolisuniversity.system.notifiers;

import innopolisuniversity.system.Report;

public record SMSNotifier(String phoneNumber) implements Notifier {
    @Override
    public void send(Report report) {
        // create notification text and send SMS by phone number
        System.out.println("Sent " + createMessage(report) + " to " + phoneNumber);
    }
}
