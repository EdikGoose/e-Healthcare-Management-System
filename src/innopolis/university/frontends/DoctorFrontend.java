package innopolis.university.frontends;

import innopolis.university.system.Report;
import innopolis.university.users.staff.Doctor;

import java.io.PrintWriter;
import java.util.List;

public final class DoctorFrontend extends Frontend {
    private final Doctor doctor;

    public DoctorFrontend(PrintWriter writer, Doctor doctor) {
        super(writer);
        this.doctor = doctor;
    }

    @Override
    public void start() { }

    public List<Report> getDoctorReportsClicked(){
        return doctor.getReports();
    }

    public void conductExamClicked(){
        doctor.conductExam();
    }
}
