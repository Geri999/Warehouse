package tools;

public class GuiCSSTools {

    private static int chosenColorSet;

    private static String colorHL1;
    private static String colorHL2;
    private static String colorERROR;
    private static String colorOK;

    public static int getChosenColorSet() {
        return chosenColorSet;
    }

    public static void setChosenColorSet(int chosenColorSet) {
        GuiCSSTools.chosenColorSet = chosenColorSet;
        setColor();
    }

    public static void setColor() {

        switch (GuiCSSTools.getChosenColorSet()) {
            case 1:
                colorHL1 = BGblue + white; //ok
                colorHL2 = blue + BGgray; //ok
                colorOK = x1 + BGx1; //ok
                colorERROR = white + BGred;  //ok
                break;
            case 2:
                colorHL1 = YELLOW_BOLD_BRIGHT;
                colorHL2 = YELLOW;
                colorOK = GREEN_BOLD + BLUE_BACKGROUND;
                colorERROR = BLUE_BACKGROUND + RED_BOLD; //ok
                break;
            case 3:
                colorHL1 = BLUE_BOLD;
                colorHL2 = BLUE_BOLD_BRIGHT;
                colorOK = green;
                colorERROR = red;
                break;
        }
    }

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE


    public static String white = "\u001B[30m";
    public static String red = "\u001B[31m";
    public static String green = "\u001B[32m";
    public static String yellow = "\u001B[33m";
    public static String blue = "\u001B[34m";
    public static String magenta = "\u001B[35m";
    public static String cyan = "\u001B[36m";
    public static String gray = "\u001B[37m";
    public static String x1 = "\033[0;102m";

    public static String BGwhite = "\u001B[40m";
    public static String BGred = "\u001B[41m";
    public static String BGgreen = "\u001B[42m";
    public static String BGyellow = "\u001B[43m";
    public static String BGblue = "\u001B[44m";
    public static String BGmagenta = "\u001B[45m";
    public static String BGcyan = "\u001B[46m";
    public static String BGgray = "\u001B[47m";
    public static String BGx1 = "\033[1;90m";

    public static String stop = "\u001B[0m"; //off


    public static String stringHL1(String tekst) {
        return colorHL1 + tekst + stop;
    }

    public static String stringHL2(String tekst) {
        return colorHL2 + tekst + stop;
    }

    public static String stringOK(String tekst) {
        return colorOK + tekst + stop;
    }

    public static String stringERROR(String tekst) {
        return colorERROR + tekst + stop;
    }


    public static void printHL1(String tekst) {
        System.out.println(colorHL1 + tekst + stop);
    }

    public static void printHL2(String tekst) {
        System.out.println(colorHL2 + tekst + stop);
    }

    public static void printOK(String tekst) {
        System.out.println(colorOK + tekst + stop);
    }

    public static void printERROR(String tekst) {
        System.out.println(colorERROR + tekst + stop);
    }


    public static void choiceColorSet() {
        System.out.println();
        tester();
        System.out.println("Wybierz zestaw kolorów");
        GuiCSSTools.setChosenColorSet(UserInput.userChoiceInt(1, 2, 3));
    }


    public static void tester() {
        for (int i = 1; i < 4; i++) {

            GuiCSSTools.setChosenColorSet(i);
            GuiCSSTools.setColor();
            System.out.println("Zestaw: " + i);
            printHL1(" Ala ma kota ");
            printHL2(" Ala ma kota ");
            printOK(" Ala ma kota ");
            printERROR(" Ala ma kota ");
            System.out.println("---------------------------------");
        }
    }

    public static String multiText(String sign, int repetition) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repetition; i++) sb.append(sign);
        return sb.toString();
    }


    public static void workingShow(String firstText, String lastText)  {
        System.out.print(firstText);
        for (int i = 0; i < 15; i++) {
            System.out.print(".");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(lastText);
    }

}
