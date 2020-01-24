import gui.Menu;
import tools.GuiCSSTools;
import tools.IO;
import users.Loggin;
import tools.Title;

public class App {

    public static void main(String[] args) throws InterruptedException {

        IO.ioLoad();
        //GuiCSSTools.setChosenColorSet(2);
        GuiCSSTools.setColor();
        Title.castTitle();
        if (!Loggin.loggin()) System.exit(0);
        Menu.menuLoop();




    }
}
