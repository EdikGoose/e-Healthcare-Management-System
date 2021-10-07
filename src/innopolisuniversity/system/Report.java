package innopolisuniversity.system;

import innopolisuniversity.users.Patient;
import innopolisuniversity.users.staff.Doctor;

import java.time.LocalDate;

public record Report(int id, LocalDate date, Patient patient, Doctor doctor, int cost) { }
