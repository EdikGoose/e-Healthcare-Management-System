package innopolisuniversity.system.notifiers;

import innopolisuniversity.system.Report;
import innopolisuniversity.users.Patient;

public interface Notifier {
    void send(Report report);

    /** Before sending a notification the system forms text of this notification */
    default String createMessage(Report report) {
        var message = new StringBuilder();
        addGreetings(message, report.patient());
        addMainPart(message, report);
        addSenderInfo(message);
        return message.toString();
    }

    /** Add greetings to existing text of notification */
    default void addGreetings(StringBuilder message, Patient patient) {
        message.append("Hello, ").append(patient.getName());
    }

    /** Add main content of notification text to existing one */
    default void addMainPart(StringBuilder message, Report report){
        message.append("\nYour report is ready!");
    }

    /**
     * Add information about sender organization
     * to existing text of notification
     */
    default void addSenderInfo(StringBuilder message){
        message.append("\nWith regards, Innopolis Hospital");
    }
}
