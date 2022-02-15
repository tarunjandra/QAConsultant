package browserHelper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserHelper {

    private static WebDriver webDriver = null;
    private static Integer pageLoadWT = 10;
    private static Integer elementVisibleWT = 10;

    public void setElementVisibleWT(Integer elementVisibleWT) {

        this.elementVisibleWT = elementVisibleWT;
    }

    public void setPageLoadWT(Integer pageLoadWT) {

        this.pageLoadWT = pageLoadWT;
    }

    public static WebDriver getWebDriver() {

        return webDriver;
    }

    public void setChromeWebDriver() {
        WebDriverManager.chromedriver().setup();
        this.webDriver = new ChromeDriver();
    }

    public void setSafariWebDriver(){
        WebDriverManager.edgedriver().setup();
        this.webDriver = new EdgeDriver();
    }

    public static void waitForPageLoad() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, pageLoadWT);
            webDriverWait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementVisible(WebElement element) {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(webDriver, elementVisibleWT);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void jsClick(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).click().perform();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public static void launchWebPage(String url) {
        webDriver.get(url);
        webDriver.manage().window().maximize();
        BrowserHelper.waitForPageLoad();
    }

    public static void closeDriver() {
        webDriver.quit();
    }
}
