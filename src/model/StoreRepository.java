package model;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository {
    //singleton
    //klasa jest inicjalizowana only once, tworzy instancję klasy już w momencie załadowania klasy (chciwa inicjalizacja)
    private static final StoreRepository storeRepository = new StoreRepository();

    //dostep do tej klasy/obiektu w ramach sigletonu
    public static StoreRepository getStoreRepository() {
        return StoreRepository.storeRepository;
    }

    //bazy
    private List<String> categoryDB = new ArrayList<>();
    private List<Product> productsDB = new ArrayList<>();


    //konstruktor
    private StoreRepository() {
        if (storeRepository != null) throw new IllegalStateException("ERROR: Singleton already constructed!");
        //----------TYLKO DO TESTÓW
        this.categoryDB.add( "BEZ KATEGORII".toUpperCase());
        this.categoryDB.add( "RTV".toUpperCase());
        this.categoryDB.add( "FOOD".toUpperCase());
        this.categoryDB.add( "Sport".toUpperCase());
        this.categoryDB.add( "Garden".toUpperCase());


        this.productsDB.add( new Product("RTV".toUpperCase(), "Telewizor", 2000.12, "TVW200a"));
        this.productsDB.add( new Product("FOOD".toUpperCase(), "Jabłka", 2000.12, "TVW200a"));
        this.productsDB.add( new Product("FOOD".toUpperCase(), "Jogurt", 2000.12, "TVW200a"));
        this.productsDB.add( new Product("Garden".toUpperCase(), "Konewka", 2000.12, "TVW200a"));
        //----------TYLKO DO TESTÓW
    }

    //gettery i settery
    public List<String> getCategoryDB() {
        return categoryDB;
    }

    public void setCategoryDB(List<String> categoryDB) {
        this.categoryDB = categoryDB;
    }

    public List<Product> getProductsDB() {
        return productsDB;
    }

    public void setProductsDB(List<Product> productsDB) {
        this.productsDB = productsDB;
    }
}
