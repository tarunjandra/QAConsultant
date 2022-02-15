package tests;

import Data.Urls;
import browserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.*;

public class WebScenario {

    private static WebDriver webDriver = null;
    private static BrowserHelper browserHelper;

    @BeforeTest
    public void setup() {
        browserHelper = new BrowserHelper();
        browserHelper.setChromeWebDriver();
        webDriver = browserHelper.getWebDriver();
    }

    @Test(priority = 1)
    public void validateTablesAreSame() {

        Boolean flag = true;
        PODataTablesPage poDataTablesPage = new PODataTablesPage(webDriver);
        BrowserHelper.launchWebPage(Urls.homePage);
        browserHelper.waitForPageLoad();

        Boolean validateNumberOfHeaderRowsEqualInTables = poDataTablesPage.validateNumberOfHeaderRowsEqualInTables();
        Assert.assertEquals(flag, validateNumberOfHeaderRowsEqualInTables);

        Boolean validateHeaderOrderAndDataIsSameInTables = poDataTablesPage.validateHeaderOrderAndDataIsSameInTables();
        Assert.assertEquals(flag, validateHeaderOrderAndDataIsSameInTables);

        Boolean validateNumberOfDataRowsEqualInTables = poDataTablesPage.validateNumberOfDataRowsEqualInTables();
        Assert.assertEquals(flag, validateNumberOfDataRowsEqualInTables);

        Boolean validateDataIsSameInTables = poDataTablesPage.validateDataIsSameInTables();
        Assert.assertEquals(flag, validateDataIsSameInTables);
    }

    @AfterTest
    public void closeSession() {
        browserHelper.closeDriver();
    }
}
