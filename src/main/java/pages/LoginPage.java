package pages;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePages {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='Email']")
    private WebElement userNameField;
    @FindBy(xpath = "//input[@name='Password']")
    private WebElement userPasswordField;
    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement loginButton;


    public WebElement getUserPasswordField() {
        CustomElementWaits.waitUntilElementToClickable(driver, userPasswordField);
        return userPasswordField;
    }

    public WebElement getUserNameField() {
        CustomElementWaits.waitUntilElementToClickable(driver, userNameField);
        return userNameField;
    }

    public WebElement getLoginButton() {
        CustomElementWaits.waitUntilElementToClickable(driver, loginButton);
        return loginButton;
    }

    public void userLogin(String userName, String userPassword){
        getUserNameField().sendKeys(userName);
        getUserPasswordField().sendKeys(userPassword);
        getLoginButton().click();
    }
}
