package pages.loginPages;

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
    @FindBy(xpath = "//span[text()='Sign in with Google']")
    private WebElement googleLoginButton;
    @FindBy(xpath = "//span[text()='Sign in with Facebook']")
    private WebElement facebookLoginButton;


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

    public WebElement getGoogleLoginButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,googleLoginButton);
        return googleLoginButton;
    }

    public WebElement getFacebookLoginButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,facebookLoginButton);
        return facebookLoginButton;
    }

}
