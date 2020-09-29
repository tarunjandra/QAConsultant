package pageObjects;

import Data.UserProfile;
import browserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageFactory.PFIncomeFormPage;

public class POIncomeFormPage {
    private static WebDriver webDriver = null;

    public POIncomeFormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PFIncomeFormPage checkYourRatePF = new PFIncomeFormPage(webDriver);
    }

    public void fillForm() {
        for (WebElement webElement : PFIncomeFormPage.formFields) {
            if (UserProfile.createUser().containsKey(webElement.getAttribute("name"))) {
                webElement.sendKeys(UserProfile.createUser().get(webElement.getAttribute("name")));
            }
        }
    }

    public void pressContinueButton() {
        BrowserHelper.jsClick(PFIncomeFormPage.continueButton);
    }
}
