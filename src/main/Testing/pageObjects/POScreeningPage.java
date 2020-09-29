package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pageFactory.PFScreeningPage;

public class POScreeningPage {
    private static WebDriver webDriver = null;

    public POScreeningPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PFScreeningPage checkYourRatePF = new PFScreeningPage(webDriver);
    }

    public void enterLoanAmount(String amount) {
        PFScreeningPage.enterLoanAmountBox.sendKeys(amount);
    }

    public void selectLoanPurpose(String purpose) {
        PFScreeningPage.loanPurposeDropDownButton.click();
        Select select = new Select(PFScreeningPage.loanPurposeList);
        select.selectByVisibleText(purpose);
    }

    public void clickCheckYourRateButton() {
        PFScreeningPage.checkYourRateButton.click();
    }
}
