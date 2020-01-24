package users;

import tools.IO;

public class Logout {
    public static void logout() {
        IO.ioSave();
        System.exit(0);
    }


}

