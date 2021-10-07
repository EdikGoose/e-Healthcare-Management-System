package innopolisuniversity.system;

import innopolisuniversity.users.Patient;

public class Ward {
    private static int numberOfCreatedWard = 0;

    private final int number;
    private final int id;
    private Patient patient;

    public Ward(int number) {
        this.number = number;
        this.id = ++numberOfCreatedWard;
    }

    public void makeFree() {
        patient = null;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return patient == null;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("{Ward number=%d, free=%b}", number, isFree());
    }
}
