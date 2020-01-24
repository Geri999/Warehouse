package tools;

import java.util.Scanner;

public class UserInput {

    public static int userChoiceInt(int... range) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wpisuj tylko cyfry");
                scanner.nextLine(); //czyszczenie bufora z <entera>
                continue;
            }

            for (int i : range) {
                if (choice == i) return choice;
            }
            System.out.println("Brak takiej pozycji w menu");
        }
    }


    public static double userInputDouble() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Wpisuj tylko cyfry z kropką");
                scanner.nextLine(); //czyszczenie bufora z <entera>
                continue;
            }
        }
    }

    public static double userInputInt() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wpisuj tylko cyfry z kropką");
                scanner.nextLine(); //czyszczenie bufora z <entera>
                continue;
            }
        }
    }





    public static String userInputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choice = scanner.nextLine();
            if (!choice.equals("")) return choice;
            System.out.println("Musisz coś wpisać");
        }
    }
}
