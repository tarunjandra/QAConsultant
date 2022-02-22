package unitTest;

import Data.Urls;
import browserHelper.BrowserHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.PODataTablesPage;
import utils.GenericTable;
import utils.TableOperations;

public class TableOperationsTest {
    GenericTable tableOperations = new TableOperations();
    private static WebDriver webDriver = null;
    private static BrowserHelper browserHelper;
    
    @BeforeClass
    public void setup() {
        browserHelper = new BrowserHelper();
        browserHelper.setChromeWebDriver();
        webDriver = browserHelper.getWebDriver();
        BrowserHelper.launchWebPage(Urls.homePage);
        browserHelper.waitForPageLoad();
    }

    @Test
    void testGetHeadersRow() {

        PODataTablesPage test = new PODataTablesPage(webDriver);
        tableOperations.withDriver(webDriver);
        tableOperations.withExtraConfig(1);
        test.validateNumberOfHeaderRowsEqualInTables();

        Assert.assertEquals(1, tableOperations.getHeadersRow().size(), "Validate that there is only one header Row");
        Assert.assertEquals("Last Name", tableOperations.getHeadersRow().get(0).getLastName(), "Validate that value of lastName field in object is Last Name");
        Assert.assertEquals("First Name", tableOperations.getHeadersRow().get(0).getFirstName(), "Validate that value of firstName field in object is First Name");
        Assert.assertEquals("Email", tableOperations.getHeadersRow().get(0).getEmail(), "Validate that value of email field in object is Email");
        Assert.assertEquals("Due", tableOperations.getHeadersRow().get(0).getDue(), "Validate that value of due field in object is Due");
        Assert.assertEquals("Web Site", tableOperations.getHeadersRow().get(0).getWebsite(), "Validate that value of website field in object is Web Site");
    }

    @Test
    void testGetHeaders() {

        PODataTablesPage test = new PODataTablesPage(webDriver);
        tableOperations.withDriver(webDriver);
        tableOperations.withExtraConfig(1);
        test.validateNumberOfHeaderRowsEqualInTables();

        Assert.assertEquals("Last Name", tableOperations.getHeaders().get(0));
        Assert.assertEquals("First Name", tableOperations.getHeaders().get(1));
        Assert.assertEquals("Email", tableOperations.getHeaders().get(2));
        Assert.assertEquals("Due", tableOperations.getHeaders().get(3));
        Assert.assertEquals("Web Site", tableOperations.getHeaders().get(4));
    }

    @Test
    void testGetRow() {

        PODataTablesPage test = new PODataTablesPage(webDriver);
        tableOperations.withDriver(webDriver);
        tableOperations.withExtraConfig(1);
        test.validateNumberOfHeaderRowsEqualInTables();

        Assert.assertEquals("Smith", tableOperations.getRow(0).getLastName(), "Validate that value of lastName field in object is Smith");
        Assert.assertEquals("John", tableOperations.getRow(0).getFirstName(), "Validate that value of firstName field in object is John");
        Assert.assertEquals("jsmith@gmail.com", tableOperations.getRow(0).getEmail(), "Validate that value of email field in object is jsmith@gmail.com");
        Assert.assertEquals("$50.00", tableOperations.getRow(0).getDue(), "Validate that value of due field in object is $50.00");
        Assert.assertEquals("http://www.jsmith.com", tableOperations.getRow(0).getWebsite(), "Validate that value of website field in object is http://www.jsmith.com");
    }

    @Test
    void testGetRows() {

        PODataTablesPage test = new PODataTablesPage(webDriver);
        tableOperations.withDriver(webDriver);
        tableOperations.withExtraConfig(1);
        test.validateNumberOfHeaderRowsEqualInTables();

        Assert.assertEquals("Doe", tableOperations.getRows().get(2).getLastName(), "Validate that value of lastName field in object is Smith");
        Assert.assertEquals("Jason", tableOperations.getRows().get(2).getFirstName(), "Validate that value of firstName field in object is John");
        Assert.assertEquals("jdoe@hotmail.com", tableOperations.getRows().get(2).getEmail(), "Validate that value of email field in object is jsmith@gmail.com");
        Assert.assertEquals("$100.00", tableOperations.getRows().get(2).getDue(), "Validate that value of due field in object is $50.00");
        Assert.assertEquals("http://www.jdoe.com", tableOperations.getRows().get(2).getWebsite(), "Validate that value of website field in object is http://www.jsmith.com");
    }

    @AfterClass
    public void closeSession() {

        browserHelper.closeDriver();
    }
}