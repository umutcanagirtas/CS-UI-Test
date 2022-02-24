package pages.popUp;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpLoginPage extends BasePages {
    private WebDriver driver;
    public PopUpLoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @FindBy(xpath = "//div[text()='E-mail address or password is incorrect. Please check your information and try again.']")
    private WebElement popupTextForFailedLogin;

    public WebElement getPopupTextForFailedLogin() {
        CustomElementWaits.waitUntilElementFind(driver,popupTextForFailedLogin);
        return popupTextForFailedLogin;
    }
}
