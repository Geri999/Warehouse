package tools;

import model.Product;
import model.StoreRepository;
import users.User;
import users.UserRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class IO {

    private static String mainPath = (new File("").getAbsolutePath() + "\\src\\warehouse.txt");
    private static String mainPathBackUp = (new File("").getAbsolutePath() + "\\src\\warehouse.bak");

    public static String getMainPath() {
        return mainPath;
    }

    public static void ioLoad() {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(mainPath))) {
            String temp;

            //wczytuje zestaw kolorów
            GuiCSSTools.setChosenColorSet(Integer.parseInt(bufferedReader.readLine()));

            bufferedReader.readLine();
            //System.out.println("Ustawienia kolorów wczytane poprawnie");
            GuiCSSTools.workingShow("Ustawienia kolorów", "WCZYTANE");

            //wczytuje userów i ich hasła (login,hasło (zaszyfrowane))
            ArrayList<User> userTempList = new ArrayList<>();
            while (!(temp = bufferedReader.readLine()).equals("-----")) {
                String[] userTempArray = temp.split(",");
                userTempList.add(new User(userTempArray[0], userTempArray[1]));
            }
            UserRepository.getUserRepository().setUsers(userTempList);
            GuiCSSTools.workingShow("Baza zapisanych USERów (logn+hasła)", "WCZYTANE");

            //wczytuje baze kategorii)
            ArrayList<String> categoryTempList = new ArrayList<>();
            while (!(temp = bufferedReader.readLine()).equals("-----")) {
                categoryTempList.add(temp);
            }
            StoreRepository.getStoreRepository().setCategoryDB(categoryTempList);
            GuiCSSTools.workingShow("Baza zapisanych kategorii", "WCZYTANE");

            //wczytuje baze produktów)
            ArrayList<Product> productTempList = new ArrayList<>();
            while (!(temp = bufferedReader.readLine()).equals("-----")) {
                String[] productTempArray = temp.split(",");
                productTempList.add(new Product(
                        Integer.parseInt(productTempArray[0]), //int
                        productTempArray[1], //String
                        productTempArray[2], //String
                        Double.parseDouble(productTempArray[3]), //Double
                        productTempArray[4],  //String
                        LocalDateTime.parse(productTempArray[5])
                ));
            }
            StoreRepository.getStoreRepository().setProductsDB(productTempList);
            GuiCSSTools.workingShow("Baza zapisanych PRODUKTÓW", "WCZYTANE");

            //wczytuje aktualny nr counter (do ustalania ID)
            Product.setProductCounter(Integer.parseInt(bufferedReader.readLine()));
            GuiCSSTools.workingShow("Ustawienia stanu licznika ID", "ZREALIZOWANE");
            System.out.println("\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ioSave() {
        try {
            Files.move(Paths.get(mainPath), Paths.get(mainPathBackUp), REPLACE_EXISTING);
            GuiCSSTools.workingShow("BackUp", "UTWORZONY!!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mainPath))) {
            //tworzenie backup


            //zapisuje zestaw kolorów
            bufferedWriter.write(GuiCSSTools.getChosenColorSet() + "\n");
            bufferedWriter.write("-----\n");
            GuiCSSTools.workingShow("Ustawienia kolorów", "ZAPISANE");

            //zapisuje userów i ich hasła (login,hasło (zaszyfrowane))
            for (User user : UserRepository.getUserRepository().getUsers()) {
                bufferedWriter.write(user.getLogin() + "," + user.getPassword() + "\n");
            }
            bufferedWriter.write("-----\n");
            GuiCSSTools.workingShow("Baza USERów (logn+hasła)", "ZAPISANE");

            //zapisuje wszsytkie kategorie
            for (String s : StoreRepository.getStoreRepository().getCategoryDB()) {
                bufferedWriter.write(s + "\n");
            }
            bufferedWriter.write("-----\n");
            GuiCSSTools.workingShow("Baza kategorii", "ZAPISANE");

            //zapisuje wszsytkie produkty
            for (Product product : StoreRepository.getStoreRepository().getProductsDB()) {
                bufferedWriter.write(product.getId() + ",");
                bufferedWriter.write(product.getCategory() + ",");
                bufferedWriter.write(product.getName() + ",");
                bufferedWriter.write(product.getPrice() + ",");
                bufferedWriter.write(product.getCode() + ",");
                bufferedWriter.write(product.getGenerationTimestamp().toString() + "\n");
            }
            bufferedWriter.write("-----\n");
            GuiCSSTools.workingShow("Baza  PRODUKTÓW", "ZAPISANE");

            //zapisuje aktualny nr counter (do ustalania ID)
            bufferedWriter.write(Product.getProductCounter() + "\n");
            bufferedWriter.write("-----\n");
            GuiCSSTools.workingShow("Stanu licznika ID", "ZAPISANE");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
