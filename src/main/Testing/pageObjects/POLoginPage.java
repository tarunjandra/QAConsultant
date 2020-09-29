package pageObjects;

import Data.LoanOfferDetails;
import Data.UserProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageFactory.PFLoginPage;

import java.util.HashMap;

public class POLoginPage {

    private static WebDriver webDriver = null;

    public POLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PFLoginPage pfLoginPage = new PFLoginPage(webDriver);
    }

    public void fillForm() {
        for (WebElement webElement : PFLoginPage.formFields) {
            if (UserProfile.createUser().containsKey(webElement.getAttribute("name"))) {
                webElement.sendKeys(UserProfile.createUser().get(webElement.getAttribute("name")));
            }
        }
    }

    public void pressLoginButton() {
        PFLoginPage.loginButton.click();
    }

    public void validateLoanDetails() {
        HashMap<String, String> loanDetails = LoanOfferDetails.getLoanDetails();
        for (WebElement webElement : PFLoginPage.loanDetails) {
            Assert.assertEquals(loanDetails.get(webElement.getAttribute("data-auto")), webElement.getText());
        }
        Assert.assertEquals(loanDetails.get("aprDetails"), PFLoginPage.aprDetails.getText());
    }
}
