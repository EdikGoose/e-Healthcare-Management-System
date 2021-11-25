package innopolisuniversity.system.notifiers;

import innopolisuniversity.system.Report;

public class TelegramDecorator extends BaseDecorator {
    private final String phoneNumber;

    public TelegramDecorator(Notifier notifier, String phoneNumber) {
        super(notifier);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(Report report) {
        super.send(report);
        sendTelegram(report);
    }

    private void sendTelegram(Report report) {
        // create notification text and send by telegram
        System.out.println("Sent to Telegram " + this.phoneNumber + "): " + createMessage(report));
    }

    @Override
    public void addMainPart(StringBuilder message, Report report) {
        super.addMainPart(message, report);
        message.append("\n**Date:** ").append(report.date()); // make "Date"-text bold
        message.append("\n**Cost:** ").append(report.cost()); // make "Cost"-text bold
    }
}
