package innopolisuniversity.system;

import innopolisuniversity.system.data.*;
import innopolisuniversity.users.Patient;
import innopolisuniversity.users.User;
import innopolisuniversity.users.staff.*;
import innopolisuniversity.users.staff.Doctor;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public final class Registry {
    // for simplicity make cost constant
    private final static int cost = 500;

    private static Registry instance;

    private Registry() { }

    public static Registry getInstance() {
        if (instance == null) {
            synchronized (Registry.class) {
                if (instance == null) {
                    instance = new Registry();
                }
            }
        }
        return instance;
    }

    /**
     * @param login    is a user's login
     * @param password is a user's password
     * @return an instance of {@link Doctor} logged in or
     * {@code null} if there is no registered doctor with such login and password
     */
    public User findUser(String login, String password) {
        List<User> users = new LinkedList<>(DoctorController.getInstance().getAll());
        users.addAll(PatientController.getInstance().getAll());
        users.addAll(SystemManagerController.getInstance().getAll());

        for (var user : users)
            if (user.getLogin().equals(login) && user.getPassword().equals(password))
                return user;

        return null;
    }

    public void makeReport(Patient patient, Doctor doctor) {
        int newReportId = ReportController.getInstance().getIdForNewEntity();
        Report report = new Report(newReportId, LocalDate.now(), patient, doctor, cost);
        ReportController.getInstance().create(report); // add to database
    }

    public void dischargePatient(Patient patient) {
        patient.setHospitalized(false);
        Ward occupiedWard = WardController.getInstance().getAll().stream()
                .filter(w -> w.getPatient().equals(patient))
                .toList().get(0);
        occupiedWard.makeFree();
        PatientController.getInstance().update(patient); // update in database
    }

    public void hospitalizePatient(Patient patient) {
        patient.setHospitalized(true);
        WardController.getInstance().getAnyAvailableWard().setPatient(patient);
        PatientController.getInstance().update(patient); // update in database
    }

    public List<Patient> getHospitalizedPatients() {
        var allPatients = PatientController.getInstance().getAll();
        return allPatients.stream()
                .filter(Patient::isHospitalized)
                .toList();
    }

    public List<Report> getReportsWithDoctor(Doctor doctor) {
        var allReports = ReportController.getInstance().getAll();
        return allReports.stream()
                .filter(report -> report.doctor().equals(doctor))
                .toList();
    }

    public double getOccupiedWardsPercentage() {
        double allWardsCount = WardController.getInstance().getAll().size();
        double occupiedWards = allWardsCount - WardController.getInstance().getAvailableWards().size();
        return occupiedWards / allWardsCount * 100;
    }


    public void makeAppointment(Patient patient) {
        var doctor = getAvailableDoctor(patient);
        if (!doctor.hospitalizeIfIll(patient))
            makeReport(patient, doctor);
    }

    public Patient registryPatient(String login, String password, String name, LocalDate birthdate) {
        Patient patient = new Patient(name, login, password, birthdate);
        PatientController.getInstance().create(patient);
        return patient;
    }

    /**
     * Return an available doctor which {@code patient} can visit
     *  (For simplicity, it returns a random doctor)
     * @param patient is patient that wants to visit an available doctor
     * @return an available doctor which {@code patient} can visit
     */
    private Doctor getAvailableDoctor(Patient patient) {
        List<? extends Doctor> doctors = patient.isAdult() ?
                DoctorController.getInstance().getAdultDepartmentDoctors() :
                DoctorController.getInstance().getChildDepartmentDoctor();

        return doctors.get(new Random().nextInt(doctors.size()));
    }
}
