package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PFScreeningPage extends org.openqa.selenium.support.PageFactory {

    @FindBy(how = How.CSS, using = "input[name='desiredAmount']")
    public static WebElement enterLoanAmountBox;

    @FindBy(how = How.CSS, using = "select[data-auto='dropLoanPurpose']")
    public static WebElement loanPurposeDropDownButton;

    @FindBy(how = How.CSS, using = "button[data-auto='CheckYourRate']")
    public static WebElement checkYourRateButton;

    @FindBy(how = How.XPATH, using = "//form/div/div/div[2]/div/select")
    public static WebElement loanPurposeList;

    public PFScreeningPage(WebDriver webDriver) {
        initElements(new AjaxElementLocatorFactory(webDriver, 10), this);
    }
}
