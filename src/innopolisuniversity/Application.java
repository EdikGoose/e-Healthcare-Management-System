package innopolisuniversity;

import innopolisuniversity.frontends.AuthorizationFrontend;

import java.io.PrintWriter;

public class Application {

    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out);

        AuthorizationFrontend authorizationFrontend = new AuthorizationFrontend(writer); // page of authorization
        authorizationFrontend.start();

        authorizationFrontend.registerClicked("andrey123", "123", "Andrey",
                10, 12, 1968, "andrey123@gmail.com", "+78005553535");

    }
}