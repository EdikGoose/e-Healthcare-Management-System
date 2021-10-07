package innopolis.university.system.data;

import innopolis.university.system.Report;
import innopolis.university.system.Ward;
import innopolis.university.users.Patient;
import innopolis.university.users.SystemManager;
import innopolis.university.users.User;
import innopolis.university.users.staff.Clerk;
import innopolis.university.users.staff.Doctor;
import innopolis.university.users.staff.Nurse;

import java.util.HashMap;
import java.util.Map;

/**
 * Class represents main interface to interact with application database.
 *  Singleton
 */
final class Database {
    private static volatile Database instance;

    private final Map<Integer, Doctor> doctors;
    private final Map<Integer, Nurse> nurses;
    private final Map<Integer, Clerk> clerks;
    private final Map<Integer, Patient> patients;
    private final Map<Integer, SystemManager> systemManagers;
    private final Map<Integer, Report> reports;
    private final Map<Integer, Ward> wards;
    private int medicinesNumber;

    private Database() {
        this.doctors = new HashMap<>();
        this.nurses = new HashMap<>();
        this.clerks = new HashMap<>();
        this.patients = new HashMap<>();
        this.systemManagers = new HashMap<>();
        this.reports = new HashMap<>();
        this.wards = new HashMap<>();
        medicinesNumber = 0;

        //this.systemManagers.put(1, );
    }

    /**
     * Uses Double-Checked Locking
     * @return an instance of this singleton-class
     */
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    void addMedicine() {
        medicinesNumber+=50;
    }

    void reduceMedicines() {
        --medicinesNumber;
    }

    public int getMedicinesNumber() {
        return medicinesNumber;
    }

    Map<Integer, Doctor> getDoctors() {
        return doctors;
    }

    Map<Integer, Nurse> getNurses() {
        return nurses;
    }

    Map<Integer, Patient> getPatients() {
        return patients;
    }

    Map<Integer, Clerk> getClerks() {
        return clerks;
    }

    Map<Integer, SystemManager> getSystemManagers() {
        return systemManagers;
    }

    Map<Integer, Report> getReports() {
        return reports;
    }

    Map<Integer, Ward> getWards() {
        return wards;
    }

    HashMap<Integer, User> getUsers() {
        HashMap<Integer, User> allUsers = new HashMap<>();
        allUsers.putAll(patients);
        allUsers.putAll(doctors);
        allUsers.putAll(nurses);
        allUsers.putAll(clerks);
        allUsers.putAll(systemManagers);
        return allUsers;
    }
}
