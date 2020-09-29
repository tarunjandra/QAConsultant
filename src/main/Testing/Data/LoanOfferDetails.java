package Data;

import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class LoanOfferDetails {

    private static HashMap<String, String> loanDeatils = new HashMap<>();

    public static void storeLoanDetails(String key, String value) {
        loanDeatils.put(key, value);
    }

    public static HashMap<String, String> getLoanDetails() {
        return loanDeatils;
    }


}
