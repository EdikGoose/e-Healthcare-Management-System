package innopolisuniversity.frontends;

import innopolisuniversity.users.Patient;

import java.io.PrintWriter;


public final class PatientFrontend extends Frontend {
    Patient patient;

    public PatientFrontend(PrintWriter writer, Patient patient) {
        super(writer);
        this.patient = patient;
    }

    @Override
    public void start() {

    }

    public void visitDoctorClicked(){
        patient.visitDoctor();
    }
}
