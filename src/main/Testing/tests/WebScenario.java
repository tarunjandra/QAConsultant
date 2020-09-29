package tests;

import Data.Urls;
import browserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

public class WebScenario {

    private static WebDriver webDriver;
    private static BrowserHelper browserHelper;

    @BeforeTest
    public void setup() {
        browserHelper = new BrowserHelper();
        browserHelper.setChromeWebDriver();
        webDriver = browserHelper.getWebDriver();
    }

    @Test(priority = 1)
    public void fillScreeningForm() {
        BrowserHelper.launchWebPage(Urls.homePage);
        POScreeningPage poCheckYourRate = new POScreeningPage(webDriver);
        poCheckYourRate.enterLoanAmount("2000");
        poCheckYourRate.selectLoanPurpose("Business");
        poCheckYourRate.clickCheckYourRateButton();
        browserHelper.waitForPageLoad();
    }

    @Test(priority = 2)
    public void fillPersonalInformationForm() {
        POFillPersonalInformationFormPage poBasicInformationPage = new POFillPersonalInformationFormPage(webDriver);
        poBasicInformationPage.fillForm();
        poBasicInformationPage.pressContinueButton();
        browserHelper.waitForPageLoad();
    }

    @Test(priority = 3)
    public void fillIncomeForm() {
        POIncomeFormPage poIncomeFormPage = new POIncomeFormPage(webDriver);
        poIncomeFormPage.fillForm();
        poIncomeFormPage.pressContinueButton();
        browserHelper.waitForPageLoad();
    }

    @Test(priority = 4)
    public void createAccountForm() {
        POCreateAccountPage poCreateAccountPage = new POCreateAccountPage(webDriver);
        poCreateAccountPage.fillForm();
        poCreateAccountPage.checkMarkAgreementBox();
        poCreateAccountPage.pressContinueButton();
        browserHelper.waitForPageLoad();
    }

    @Test(priority = 5)
    public void loanOfferSummary() {
        POOfferPage poOfferPage = new POOfferPage(webDriver);
        poOfferPage.waitForPageLoaderDisappear();
        poOfferPage.getLoanDetails();
        poOfferPage.logout();
        browserHelper.waitForPageLoad();
    }

    @Test(priority = 6)
    public void validateLoanTermsOffered() {
        BrowserHelper.launchWebPage(Urls.loginPage);
        POLoginPage poLoginPage = new POLoginPage(webDriver);
        poLoginPage.fillForm();
        poLoginPage.pressLoginButton();
        browserHelper.waitForPageLoad();
        poLoginPage.validateLoanDetails();
    }

    @AfterTest
    public void closeSession() {
        browserHelper.closeDriver();
    }
}
