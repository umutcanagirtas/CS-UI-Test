package pages.loginPages.googlePages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleUserPasswordPage extends BasePages {
    private final WebDriver driver;
    public GoogleUserPasswordPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @FindBy(xpath = "//input[@type='password']")
    private WebElement userPassword;
    @FindBy(xpath = "//span[text()='İleri']")
    private WebElement forwardButton;

    public WebElement getUserPassword() {
        CustomElementWaits.waitUntilElementToClickable(driver,userPassword);
        return userPassword;
    }

    public WebElement getForwardButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,forwardButton);
        return forwardButton;
    }
    public void enterUserPasswordAndGoNextPage(String userPassword){
        getUserPassword().sendKeys(userPassword);
        getForwardButton().click();
    }
}
