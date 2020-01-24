package model;

import tools.GuiCSSTools;
import tools.UserInput;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class ProductTools {

    private static List<String> categoryDB = StoreRepository.getStoreRepository().getCategoryDB();
    private static List<Product> productsDB = StoreRepository.getStoreRepository().getProductsDB();

    public static void showAllProducts() {

        System.out.printf(Locale.forLanguageTag("PL"),
                GuiCSSTools.stringHL1("%3s  %25s |%20s |%10s |%20s |%30s%n"), "ID", "category", "name", "price", "code",
                "Data&TIME");
        for (Product product : productsDB) {
            System.out.println(product);
        }
    }


    public static void showProductsInSelectedCategory(){
        System.out.println("Podaj kategorię do wyświetlenia");
        String category = UserInput.userInputString().toUpperCase();
        int counter=0;
        for (Product product : productsDB) {
            if (product.getCategory().equals(category))
            System.out.println(product);
            counter++;
        }
        if (counter>0) System.out.println("Brak pozycji do wyświetlnie a tej kategorii");
        }

    public static void sortName() {
        Collections.sort(productsDB, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println("Posortowano po NAZWIE");
        showAllProducts();
    }

    public static void sortCategoryName() {
        Collections.sort(productsDB, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Collections.sort(productsDB, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));
        System.out.println("Posortowano po kategorii i nazwie");
        showAllProducts();
    }

    public static void sortPrice() {
        Collections.sort(productsDB, Comparator.comparing(Product::getPrice));
        System.out.println("Posortowano po cenie");
        showAllProducts();
    }

    public static void sortDate() {
        Collections.sort(productsDB, Comparator.comparing(Product::getGenerationTimestamp));
        System.out.println("Posortowano po dacie dodania");
        showAllProducts();
    }

    public static void addNewProduct() {
        String category;
        while (true) {
            System.out.println("Podaj kategorię");
            category = UserInput.userInputString().toUpperCase();
            if (!categoryDB.contains(category)) continue;
            break;
        }

        System.out.println("Podaj nazwę produktu");
        String name = UserInput.userInputString();

        System.out.println("Podaj cenę produktu (Double z kropką)");
        Double price = UserInput.userInputDouble();

        System.out.println("Podaj kod produktu (String)");
        String code = UserInput.userInputString();

        productsDB.add(new Product(category, name, price, code));

        System.out.println("Dodano nowy produkt");
    }


    public static void deleteOneProduct() {
        System.out.println("Podaj ID produktu do usunięcia");
        Double id = UserInput.userInputInt();

        for (Product product : productsDB) {
            if (product.getId() == id) {
                productsDB.remove(product);
                System.out.println("usunuięto produkt");
                return;
            }
        }
        System.out.println("brak produktu o takim ID");
    }
}


