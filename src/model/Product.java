package model;

import java.time.LocalDateTime;
import java.util.Locale;

public class Product {

    private static int productCounter;  //liczik produktów używany przy tworzeniu id , inicjiowany na początku do 0
    private int id;
    private String category;

    private String name;
    private Double price;
    private String code;
    private LocalDateTime generationTimestamp;

    public Product(String category, String name, Double price, String code) {
        this.id = ++productCounter;  //dodaja do aktualnego numer +1 i przypisuje
        this.category = category;
        this.name = name;
        this.price = price;
        this.code = code;
        this.generationTimestamp = LocalDateTime.now();//zapisuje obecny czas utowrzenia obiektu
    }

//konstruktor do wczytywania z dysku
    public Product(int id, String category, String name, Double price, String code, LocalDateTime generationTimestamp) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.code = code;
        this.generationTimestamp = generationTimestamp;
    }

    public static int getProductCounter() {
        return productCounter;
    }

    public static void setProductCounter(int productCounter) {
        Product.productCounter = productCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getGenerationTimestamp() {
        return generationTimestamp;
    }


    @Override
    public String toString() {
        return String.format(Locale.forLanguageTag("PL"),
                "ID:%03d - [%20s |%20s |%,10.2f |%20s |%30s]", id, category, name, price, code, generationTimestamp);

    }
}
