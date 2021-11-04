package innopolisuniversity.frontends;


import innopolisuniversity.system.Registry;
import innopolisuniversity.users.Patient;
import innopolisuniversity.users.SystemManager;
import innopolisuniversity.users.User;
import innopolisuniversity.users.staff.Doctor;

import java.io.PrintWriter;
import java.time.DateTimeException;
import java.time.LocalDate;

/*

    login    [                  ]
    password [                  ]
        (log in) | (register)
 */


public final class AuthorizationFrontend extends Frontend {

    public AuthorizationFrontend(PrintWriter writer) {
        super(writer);
    }

    @Override
    public void start() {
        /* https://www.youtube.com/watch?v=dQw4w9WgXcQ */

    }

    /**
     * This method is invoked when the user clicks on <b>register<b/>
     *  button
     * Only patients can register because other users are registered by
     *  system managers or by system
     * @param login is a login of a new user
     * @param password is a password of a new user
     * @param name is a name of a new user
     * @param birthDay is a birthday of a new user
     * @param birthMonth is a birth-month of a new user
     * @param birthYear is a birth-year of a new user
     * @throws IllegalStateException when user with such parameters has already had registered
     */
    public void registerClicked(String login, String password, String name,
                                int birthDay, int birthMonth, int birthYear, String email, String phoneNumber)
            throws IllegalStateException {
        User user = Registry.getInstance().findUser(login, password);

        if (user != null) { // user has already had registered
            writer.println("System has already had a user with this login");
            return;
        }
        try {
            LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
            Patient patient = Registry.getInstance().registryPatient(login, password, name,
                    birthdate, email, phoneNumber);

            PatientFrontend patientFrontend = new PatientFrontend(writer, patient);
            patientFrontend.start();
        } catch (DateTimeException dte) {
            writer.println("The date of birth is incorrect");
        }
    }

    public void loginClicked(String login, String password) throws IllegalStateException {
        User user = Registry.getInstance().findUser(login, password);

        if (user == null) { // user is not registered
            writer.println("User with such login and password does not exist");
            return;
        }

        Frontend frontend = null;

        if (user instanceof Doctor) {
            frontend = new DoctorFrontend(writer, (Doctor) user); // go to doctorFrontend page
        } else if (user instanceof Patient) {
            frontend = new PatientFrontend(writer, (Patient) user); // go to patientFrontend page
        } else if (user instanceof SystemManager) {
            frontend = new SystemManagerFrontend(writer, (SystemManager) user); // go to systemManagerFrontend page
        }

        if (frontend != null)
            frontend.start();
    }
}
