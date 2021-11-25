package innopolisuniversity.frontends;

import innopolisuniversity.users.Patient;

import java.io.PrintWriter;

public final class PatientFrontend extends Frontend {
    private Patient patient;
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

    public void emailCheckBoxClicked(boolean selected) {
        checkBoxForEmail = selected;
        updateNotifier();
    }

    public void telegramCheckBoxClicked(boolean selected) {
        checkBoxForTelegram = selected;
        updateNotifier();
    }

    private void updateNotifier() {
        patient.updateNotifier(checkBoxForEmail, checkBoxForTelegram);
    }
}
