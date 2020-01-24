package users;

import org.apache.commons.codec.digest.DigestUtils;
import tools.GuiCSSTools;
import tools.UserInput;

public class Loggin {
    static String login;

    public static boolean loggin() {

        System.out.println("                       "+GuiCSSTools.stringERROR("HINT: (login: ADMIN, password: ADMIN)"));
        System.out.println("War Operation Plan Response (WOPR)\n");
        System.out.println("GREETINGS PROFESSOR FALKEN");
        System.out.println("SHALL WE PLAY A GAME?\n");
        System.out.println("Please logon with user password");

        int counter = 3;
        do {
            System.out.println("LOGIN:");
            login = UserInput.userInputString();
            System.out.println("PASSWORD:");
            String password = UserInput.userInputString();

            for (User user : UserRepository.getUserRepository().getUsers()) {
                if (login.equals(user.getLogin()) && DigestUtils.md5Hex(password).equals(user.getPassword())) {
                    System.out.println("Logowanie poprawne");
                    return true;
                }
            }
            counter--;
            if (counter==2) GuiCSSTools.printERROR("Zły login lub hasło, zostało jeszcze 2 próby");
            else if (counter==1) GuiCSSTools.printERROR("Zły login lub hasło, zostało jeszcze ostatnia próba");
            else if (counter==0) GuiCSSTools.printERROR("Brak dostępu!!!!!!!");
        }
        while (counter > 0);

        return false;
    }
}

