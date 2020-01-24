package users;

import tools.Exit;
import tools.IO;

public class Logout {
    public static void logout() {
        IO.ioSave();
        Exit.exit();
    }


}

