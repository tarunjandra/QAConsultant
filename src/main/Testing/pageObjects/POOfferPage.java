package pageObjects;

import Data.LoanOfferDetails;
import browserHelper.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageFactory.PFOfferPage;

public class POOfferPage {
    private static WebDriver webDriver = null;

    public POOfferPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PFOfferPage pfOfferPage = new PFOfferPage(webDriver);
    }

    public void getLoanDetails() {
        for (WebElement webElement : PFOfferPage.loanDetails) {
            LoanOfferDetails.storeLoanDetails(webElement.getAttribute("data-auto"), webElement.getText());
        }
        LoanOfferDetails.storeLoanDetails("aprDetails", PFOfferPage.aprDeatils.getText());
    }

    public void logout() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BrowserHelper.jsClick(PFOfferPage.menuButton);
        PFOfferPage.signOutButton.click();
    }

    public void waitForPageLoaderDisappear() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, 2);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
