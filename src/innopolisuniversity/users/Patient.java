package innopolisuniversity.users;

import innopolisuniversity.system.Registry;
import innopolisuniversity.system.Report;
import innopolisuniversity.system.data.PatientController;
import innopolisuniversity.system.notifiers.EmailDecorator;
import innopolisuniversity.system.notifiers.Notifier;
import innopolisuniversity.system.notifiers.SMSNotifier;
import innopolisuniversity.system.notifiers.TelegramDecorator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class represents the account of a patient
 */
public class Patient extends User {
    private final LocalDate birthDate;
    private String email;
    private String phoneNumber;
    private boolean hospitalized;
    private Notifier notifier;

    public Patient(String name, String login, String password, LocalDate birthDate, String email, String phoneNumber) {
        super(name, login, password);
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hospitalized = false;
        this.id = PatientController.getInstance().getIdForNewEntity();
        notifier = new SMSNotifier(phoneNumber);
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(boolean hospitalized) {
        this.hospitalized = hospitalized;
    }

    public boolean isAdult() {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now()) > 18;
    }

    public void visitDoctor() {
        Registry.getInstance().makeAppointment(this);
    }

    /**
     * If patient selects/unselects some notification types then this method
     *  updates notifier
     * @param emailSelected is state of email notification selection (checkbox)
     * @param telegramSelected is state of email notification selection (checkbox)
     */
    public void updateNotifier(boolean emailSelected, boolean telegramSelected) {
        notifier = new SMSNotifier(phoneNumber);
        if (emailSelected)
            notifier = new EmailDecorator(notifier, email);
        if (telegramSelected)
            notifier = new TelegramDecorator(notifier, phoneNumber);
    }

    /**
     * Send notification to this patient in different formats
     *  (always by sms and optionally by telegram or/and by email)
     * @param report represents information about the report that the user is notified about
     */
    public void sendNotificationTo(Report report) {
        notifier.send(report);
    }

    @Override
    public int getId() {
        return PatientController.getInstance().getIdForNewEntity();
    }

    @Override
    public String toString() {
        return super.toString() + String.format(
                "Birt date: %s. Phone Number: %s. Email: %s. Is hospitalized: %b",
                birthDate, phoneNumber, email, hospitalized
        );
    }
}
