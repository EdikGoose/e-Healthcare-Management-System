package innopolisuniversity.frontends;

import innopolisuniversity.users.Patient;

import java.io.PrintWriter;


public final class PatientFrontend extends Frontend {
    private final Patient patient;
    private boolean checkBoxForEmail;
    private boolean checkBoxForTelegram;

    public PatientFrontend(PrintWriter writer, Patient patient) {
        super(writer);
        this.patient = patient;
        checkBoxForEmail = false;
        checkBoxForTelegram = false;
    }

    @Override
    public void start() {
        // loading page of frontend
    }

    public void visitDoctorClicked(){
        patient.visitDoctor();
    }

    public void emailCheckBoxUnselected() {
        patient.updateNotifier(true, checkBoxForTelegram);
    }

    public void telegramCheckBoxUnselected() {
        checkBoxForTelegram = true;
        patient.updateNotifier(checkBoxForEmail, checkBoxForTelegram);
    }

    public void emailCheckBoxSelected() {
        checkBoxForEmail = !checkBoxForEmail;
        patient.updateNotifier(checkBoxForEmail, checkBoxForTelegram);
    }

    public void telegramCheckBoxSelected() {
        checkBoxForTelegram=!checkBoxForTelegram;
        patient.updateNotifier(checkBoxForEmail, checkBoxForTelegram);
    }
}
