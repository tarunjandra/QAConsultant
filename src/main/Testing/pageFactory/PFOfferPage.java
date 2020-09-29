package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PFOfferPage extends org.openqa.selenium.support.PageFactory {

    @FindAll({@FindBy(how = How.CSS, using = "span[data-auto='userLoanAmount']"),
            @FindBy(how = How.CSS, using = "span[data-auto='defaultMonthlyPayment']"),
            @FindBy(how = How.CSS, using = "div[data-auto='defaultLoanTerm']"),
            @FindBy(how = How.CSS, using = "div[data-auto='defaultLoanInterestRate']")})
    public static List<WebElement> loanDetails;

    @FindBy(how = How.XPATH, using = "//div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[3]/div/div")
    public static WebElement aprDeatils;

    @FindBy(how = How.CSS, using = "div[class='header-nav']")
    public static WebElement menuButton;

    @FindBy(how = How.LINK_TEXT, using = "Sign Out")
    public static WebElement signOutButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[2]/div")
    public static WebElement pageLoader;

    public PFOfferPage(WebDriver webDriver) {
        initElements(new AjaxElementLocatorFactory(webDriver, 10), this);
    }
}

