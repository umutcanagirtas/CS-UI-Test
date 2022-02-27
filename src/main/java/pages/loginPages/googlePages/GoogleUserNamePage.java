package pages.loginPages.googlePages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleUserNamePage extends BasePages {
    private final WebDriver driver;
    public GoogleUserNamePage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    @FindBy(xpath = "//input[@type='email']")
    private WebElement userName;
    @FindBy(xpath = "//span[text()='İleri']")
    private WebElement forwardButton;

    public WebElement getForwardButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,forwardButton);
        return forwardButton;
    }

    public WebElement getUserName() {
        CustomElementWaits.waitUntilElementToClickable(driver,userName);
        return userName;
    }
    public void enterUserNameAndGoNextPage(String userName){
        getUserName().sendKeys(userName);
        getForwardButton().click();
    }
}
