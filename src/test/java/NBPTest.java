import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

public class NBPTest {

    @Test
    public void getCurrencies() {

        // Get all data
        Response response = RestAssured.get("http://api.nbp.pl/api/exchangerates/tables/A");

        // Get all currencies
        List<Float> allMids = response.path("rates[0].mid");

        // Get the rate for the currency with code: USD
        Float midUSD = response.path("rates[0].find{it.code == 'USD'}.mid");

        // Get the rate for the currency with name: dolar amerykański
        Float midUSD2 = response.path("rates[0].find{it.currency == 'dolar amerykański'}.mid");

        // Get currencies with rate above: 5
        List<String> currenciesAbove5 = response.path("rates[0].findAll{it.mid > 5}.currency");

        // Get currencies with rate below: 3
        List<String> currenciesBelow3 = response.path("rates[0].findAll{it.mid < 3}.currency");

        System.out.println("All mids: " + allMids);
        System.out.println("USD mid: " + midUSD);
        System.out.println("USD mid2: " + midUSD2);
        System.out.println("Currencies above 5: " + currenciesAbove5);
        System.out.println("Currencies below 3: " + currenciesBelow3);
    }
}
