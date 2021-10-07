package innopolis.university.system;

import innopolis.university.users.Patient;
import innopolis.university.users.staff.Doctor;

import java.time.LocalDate;

public record Report(int id, LocalDate date, Patient patient, Doctor doctor, int cost) { }
