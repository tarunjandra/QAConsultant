package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PFFillPersonalInformationFormPage extends org.openqa.selenium.support.PageFactory {

    @FindAll({@FindBy(how = How.CSS, using = "input[class='sc-lmgQde hMWSMp']")})
    public static List<WebElement> formFields;

    @FindBy(how = How.ID, using = "borrowerStreet")
    public static WebElement streetField;

    @FindBy(how = How.CSS, using = "button[data-auto='continuePersonalInfo']")
    public static WebElement continueButton;

    public PFFillPersonalInformationFormPage(WebDriver webDriver) {
        initElements(new AjaxElementLocatorFactory(webDriver, 10), this);
    }
}
