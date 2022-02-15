package unitTest;

import browserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.PODataTablesPage;

public class PODataTablesPageTest {

    private static WebDriver webDriver = null;
    private static BrowserHelper browserHelper;
    Boolean flag = true;

    @BeforeClass
    public void setup() {
        browserHelper = new BrowserHelper();
        browserHelper.setChromeWebDriver();
        webDriver = browserHelper.getWebDriver();
    }

    @Test
    public void validateNumberOfHeaderRowsEqualInTablesTest() {
        PODataTablesPage test = new PODataTablesPage(webDriver);
        Assert.assertEquals(flag, test.validateNumberOfHeaderRowsEqualInTables());
    }

    @Test
    public void validateHeaderOrderAndDataIsSameInTablesTest() {
        PODataTablesPage test = new PODataTablesPage(webDriver);
        Assert.assertEquals(flag, test.validateHeaderOrderAndDataIsSameInTables());
    }

    @Test
    public void validateDataIsSameInTablesTest() {
        PODataTablesPage test = new PODataTablesPage(webDriver);
        Assert.assertEquals(flag, test.validateDataIsSameInTables());
    }

    @Test
    public void validateNumberOfDataRowsEqualInTablesTest() {
        PODataTablesPage test = new PODataTablesPage(webDriver);
        Assert.assertEquals(flag, test.validateNumberOfDataRowsEqualInTables());
    }

    @AfterClass
    public void closeSession() {

        browserHelper.closeDriver();
    }

}
