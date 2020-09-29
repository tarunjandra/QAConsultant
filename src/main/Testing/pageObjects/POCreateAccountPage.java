package pageObjects;

import Data.UserProfile;
import browserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageFactory.PFCreateAccountPage;

public class POCreateAccountPage {
    private static WebDriver webDriver = null;

    public POCreateAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PFCreateAccountPage pfCreateAccountPage = new PFCreateAccountPage(webDriver);
    }

    public void fillForm() {
        for (WebElement webElement : PFCreateAccountPage.formFields) {
            if (UserProfile.createUser().containsKey(webElement.getAttribute("name"))) {
                webElement.sendKeys(UserProfile.createUser().get(webElement.getAttribute("name")));
            }
        }
    }

    public void checkMarkAgreementBox() {
        PFCreateAccountPage.agreementsCheckBox.click();
    }

    public void pressContinueButton() {
        BrowserHelper.jsClick(PFCreateAccountPage.continueButton);
    }
}
