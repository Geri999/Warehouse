import java.util.Locale;

public class AppTest {

    public static void main(String[] args) {
        System.out.printf(Locale.forLanguageTag("PL"),
                "%3s - %20s |%20s |%12s |%20s |%30s]", "ID", "category", "name", "price", "code",
                "Data&TIME");
    }
}
