package innopolisuniversity.system.notifiers;

import innopolisuniversity.system.Report;
import innopolisuniversity.users.Patient;

public class EmailDecorator extends BaseDecorator {
    private final String email;

    public EmailDecorator(Notifier notifier, String email) {
        super(notifier);
        this.email = email;
    }

    @Override
    public void send(Report report) {
        super.send(report);
        sendEmail(report);
    }

    private void sendEmail(Report report) {
        // create notification text and send by email
        System.out.println("Send " + createMessage(report) + " to " + email);
    }

    @Override
    public void addGreetings(StringBuilder message, Patient patient) {
        message.append("Dear ").append(patient);
    }

    @Override
    public void addMainPart(StringBuilder message, Report report) {
        message.append("Your report is ready. Doctor: ").append(report.doctor().getName())
                .append("\nCost: ").append(report.cost())
                .append("\nDate: ").append(report.date());
    }
}