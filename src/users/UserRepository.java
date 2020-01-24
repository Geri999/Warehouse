package users;

import org.apache.commons.codec.digest.DigestUtils;
import tools.GuiCSSTools;
import tools.UserInput;

import java.util.ArrayList;

import static users.Loggin.login;

public class UserRepository {

    private static UserRepository userRepository = new UserRepository();
    private ArrayList<User> users = new ArrayList<>();


    public static UserRepository getUserRepository() {
        return userRepository;
    }

    private UserRepository() {
        users.add(new User("ADMIN", DigestUtils.md5Hex("ADMIN")));
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public static void changePassword() {

        boolean flag = true;
        while (flag) {
            System.out.println("Podaj stare hasło:");
            String password = UserInput.userInputString();

            for (User user : UserRepository.getUserRepository().getUsers()) {
                if (login.equals(user.getLogin()) && DigestUtils.md5Hex(password).equals(user.getPassword())) {
                    flag = false;
                } else GuiCSSTools.printERROR("Podałeś złe hasło");
            }
        }

        String password1, password2;

        do {
            System.out.println("Podaj nowe hasło:");
            password1 = UserInput.userInputString();
            System.out.println("Podaj jeszcze raz nowe hasło:");
            password2 = UserInput.userInputString();
            System.out.println(((password1.equals(password2)) ? "Hasła zgodne" : "Hasła niezgodne"));
        }
        while (!password1.equals(password2));

        for (
                User user : UserRepository.getUserRepository().

                getUsers()) {
            if (login.equals(user.getLogin())) {
                user.setPassword(DigestUtils.md5Hex(password1));
                System.out.println("Hasło zmienione!");
            }
        }


    }

}


