package pageObjects;

import Data.UserProfile;
import browserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageFactory.PFFillPersonalInformationFormPage;

public class POFillPersonalInformationFormPage {
    private static WebDriver webDriver = null;
    private static BrowserHelper browserHelper = null;

    public POFillPersonalInformationFormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PFFillPersonalInformationFormPage checkYourRatePF = new PFFillPersonalInformationFormPage(webDriver);
    }

    public void fillForm() {
        for (WebElement webElement : PFFillPersonalInformationFormPage.formFields) {
            if (UserProfile.createUser().containsKey(webElement.getAttribute("name"))) {
                webElement.sendKeys(UserProfile.createUser().get(webElement.getAttribute("name")));
            }
        }
        PFFillPersonalInformationFormPage.streetField.sendKeys(UserProfile.createUser().get("borrowerStreet"));
    }

    public void pressContinueButton() {
        BrowserHelper.jsClick(PFFillPersonalInformationFormPage.continueButton);
    }
}
