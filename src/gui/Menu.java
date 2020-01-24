package gui;

import model.CategoryTools;
import model.ProductTools;
import tools.Exit;
import tools.GuiCSSTools;
import tools.IO;
import tools.UserInput;
import users.UserRepository;

public class Menu {
    static String menuSign = "*";
    static int menuFrameLenght =35;

    public static void menuLoop() {
        while (true) {
            showMainMenu();
            serviceMainMenu();
        }
    }

    //---------------------------------------------------------------------------------------------------
    public static void showMainMenu() {
        System.out.println(GuiCSSTools.multiText(menuSign, menuFrameLenght));
        GuiCSSTools.printHL1("MAIN MENU");
        GuiCSSTools.printHL2("[1]-Category...");
        GuiCSSTools.printHL2("[2]-Products...");
        GuiCSSTools.printHL2("[3]-Setup...");
        GuiCSSTools.printHL2("[4]-Save/Load...");
        GuiCSSTools.printHL2("[0]-Exit...");
        System.out.println(GuiCSSTools.multiText(menuSign, menuFrameLenght));
    }

    public static void serviceMainMenu() {
        switch (UserInput.userChoiceInt(1, 2, 3, 4, 0)) {
            case 1:
                showMenuCategory();
                serviceMenuCategory();
                break;
            case 2:
                showMenuProduct();
                serviceMenuProduct();
                break;
            case 3:
                showMenuSetup();
                serviceMenuSetup();
                break;
            case 4:
                showMenuIO();
                serviceMenuIO();
                break;
            case 0:
                IO.ioSave();
                Exit.exit();
                break;
        }
    }

    //---------------------------------------------------------------------------------------------------
    public static void showMenuCategory() {
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
        GuiCSSTools.printHL1("\tMAIN MENU  --->  CATEGORY");
        GuiCSSTools.printHL2("\t[1]-Shaw all category");
        GuiCSSTools.printHL2("\t[2]-Sort category");
        GuiCSSTools.printHL2("\t[3]-Add new category");
        GuiCSSTools.printHL2("\t[4]-Delete category");
        GuiCSSTools.printHL2("\t[0]-Back");
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
    }

    public static void serviceMenuCategory() {
        switch (UserInput.userChoiceInt(1, 2, 3, 4, 0)) {
            case 1:
                CategoryTools.showAllCategory();
                break;
            case 2:
                CategoryTools.sortCategory();
                break;
            case 3:
                CategoryTools.addNewCategory();
                break;
            case 4:
                CategoryTools.deleteOneCategory();
                break;
            case 0:
                return;
        }
        showMenuCategory();
        serviceMenuCategory();

    }


    //---------------------------------------------------------------------------------------------------
    public static void showMenuProduct() {
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
        GuiCSSTools.printHL1("\tMAIN MENU  --->  PRODUCTS");
        GuiCSSTools.printHL2("\t[1]-Show all products");
        GuiCSSTools.printHL2("\t[2]-Show products in selected category");
        GuiCSSTools.printHL2("\t\tSORTOWANIE");
        GuiCSSTools.printHL2("\t\t[3]-Sort products (name)");
        GuiCSSTools.printHL2("\t\t[4]-Sort products (category & name)");
        GuiCSSTools.printHL2("\t\t[5]-Sort products (price)");
        GuiCSSTools.printHL2("\t\t[6]-Sort products (date)");
        GuiCSSTools.printHL2("\t[7]-Add new product");
        GuiCSSTools.printHL2("\t[8]-Delete product");
        GuiCSSTools.printHL2("\t[0]-Back");
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
    }

    public static void serviceMenuProduct() {
        switch (UserInput.userChoiceInt(1, 2, 3, 4, 5, 6, 7, 8, 0)) {
            case 1:
                ProductTools.showAllProducts();
                break;
            case 2:
                ProductTools.showProductsInSelectedCategory();
                break;
            case 3:
                ProductTools.sortName();//name
                break;
            case 4:
                ProductTools.sortCategoryName();//category & name
                break;
            case 5:
                ProductTools.sortPrice();//price
                break;
            case 6:
                ProductTools.sortDate();//date
                break;
            case 7:
                ProductTools.addNewProduct();
                break;
            case 8:
                ProductTools.deleteOneProduct();
                break;
            case 0:
                return;
        }
        showMenuProduct();
        serviceMenuProduct();
    }


    //---------------------------------------------------------------------------------------------------
    public static void showMenuSetup() {
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
        GuiCSSTools.printHL1("\tMAIN MENU  --->  SETUP");
        GuiCSSTools.printHL2("\t[1]-Change colors set");
        GuiCSSTools.printHL2("\t[2]-Change password");
        GuiCSSTools.printHL2("\t[0]-Back");
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
    }

    public static void serviceMenuSetup() {
        switch (UserInput.userChoiceInt(1, 2, 0)) {
            case 1:
                GuiCSSTools.choiceColorSet();
                break;
            case 2:
                UserRepository.changePassword();
                break;
            case 0:
                return;
        }
        showMenuSetup();
        serviceMenuSetup();
    }


    //---------------------------------------------------------------------------------------------------
    public static void showMenuIO() {
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
        GuiCSSTools.printHL1("\tMAIN MENU  --->  LOAD/SAVE");
        GuiCSSTools.printHL2("\t[1]-Load database");
        GuiCSSTools.printHL2("\t[2]-Save database");
        GuiCSSTools.printHL2("\t[3]-Show full path");
        GuiCSSTools.printHL2("\t[0]-Back");
        System.out.println("\t"+GuiCSSTools.multiText(menuSign, menuFrameLenght));
    }

    public static void serviceMenuIO() {
        switch (UserInput.userChoiceInt(1, 2, 3,  0)) {
            case 1:
                IO.ioLoad();
                break;
            case 2:
                IO.ioSave();
                break;
            case 3:
                System.out.println(IO.getMainPath());
                break;
            case 0:
                return;
        }
        showMenuIO();
        serviceMenuIO();
    }
}
