package Data;

import java.util.HashMap;
import java.util.Random;

public class UserProfile {

    private static final String FIRSTNAME = "Test1";
    private static final String LASTNAME = "User1";
    private static final String STREET = "983  Drummond Street";
    private static final String CITY = "Newark";
    private static final String STATE = "NJ";
    private static final String ZIPCODE = "07102";
    private static final String DOB = "11/12/1990";
    private static final String INCOME = "120001";
    private static final String ADDITIONALINCOME = "5001";
    private static final String EMAIL = "testuser" + ((int) (Math.random() * 100 + 10)) + "@upgrade-challenge.com";
    private static final String PASSWORD = "Holiday@2100";


    public static HashMap<String, String> createUser() {
        HashMap<String, String> user1 = new HashMap<>();
        user1.put("borrowerFirstName", FIRSTNAME);
        user1.put("borrowerLastName", LASTNAME);
        user1.put("borrowerStreet", STREET);
        user1.put("borrowerCity", CITY);
        user1.put("borrowerState", STATE);
        user1.put("borrowerZipCode", ZIPCODE);
        user1.put("borrowerDateOfBirth", DOB);
        user1.put("borrowerIncome", INCOME);
        user1.put("borrowerAdditionalIncome", ADDITIONALINCOME);
        user1.put("username", EMAIL);
        user1.put("password", PASSWORD);
        return user1;
    }
}
