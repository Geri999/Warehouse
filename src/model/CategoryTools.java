package model;

import tools.UserInput;

import java.util.List;

public class CategoryTools {

    private static List<String> category = StoreRepository.getStoreRepository().getCategoryDB();
    private static List<Product> products = StoreRepository.getStoreRepository().getProductsDB();

    public static void showAllCategory() {
        System.out.println(category);
    }

    public static void sortCategory() {
        category.sort(String::compareToIgnoreCase);
        System.out.println("Posortowano");
        showAllCategory();
    }

    public static void addNewCategory() {
        System.out.println("Podaj nową kategorię");
        String newCategory = UserInput.userInputString();
        if (category.contains(newCategory.toUpperCase())) {
            System.out.println("Już jest taka kategoria");
        } else {
            category.add(newCategory.toUpperCase());

            System.out.println("Dodano nową kategorię");
        }
    }

    public static void deleteOneCategory() {
        System.out.println("Podaj kategorię do usunięcia");
        String categoryToDelete = UserInput.userInputString();

        if (category.contains(categoryToDelete.toUpperCase())) {

            for (Product product : products) {
                if (product.getCategory().equals(categoryToDelete.toUpperCase())) {
                    product.setCategory(category.get(0));
                }
            }
            category.remove(categoryToDelete.toUpperCase());

            System.out.println("Usunięto kategorię");
            System.out.println("Wszsytkie produkty z tej kategori zostały przypsiane do kategori: "+category.get(0));

        } else {
            System.out.println("Nie znalazłem takiej kategoii do usunięcia");
        }
    }


}

