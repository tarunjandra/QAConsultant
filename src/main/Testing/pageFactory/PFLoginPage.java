package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PFLoginPage {

    @FindAll({@FindBy(how = How.CSS, using = "span[data-auto='userLoanAmount']"),
            @FindBy(how = How.CSS, using = "span[data-auto='defaultMonthlyPayment']"),
            @FindBy(how = How.CSS, using = "div[data-auto='defaultLoanTerm']"),
            @FindBy(how = How.CSS, using = "div[data-auto='defaultLoanInterestRate']")})
    public static List<WebElement> loanDetails;

    @FindBy(how = How.XPATH, using = "//div[1]/div/main/div/div[2]/div[1]/div/div[1]/div[1]/div[3]/div/div/div/div[2]/div/div/div[3]/div/div")
    public static WebElement aprDetails;

    @FindAll({@FindBy(how = How.CSS, using = "input[data-auto='username']"),
            @FindBy(how = How.CSS, using = "input[data-auto='password']")})
    public static List<WebElement> formFields;

    @FindBy(how = How.CSS, using = "button[data-auto='login']")
    public static WebElement loginButton;

    public PFLoginPage(WebDriver webDriver) {
        initElements(new AjaxElementLocatorFactory(webDriver, 10), this);
    }
}
