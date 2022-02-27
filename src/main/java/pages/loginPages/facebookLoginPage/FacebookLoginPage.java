package pages.loginPages.facebookLoginPage;

import base.BasePages;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacebookLoginPage extends BasePages {
    private final WebDriver driver;

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@placeholder='E-posta veya Telefon Numarası']")
    private WebElement userName;
    @FindBy(xpath = "//input[@placeholder='Şifre']")
    private WebElement userPassword;
    @FindBy(xpath = "//button[@name='login']")
    private WebElement signInButton;

    public WebElement getUserName() {
        CustomElementWaits.waitUntilElementToClickable(driver,userName);
        return userName;
    }

    public WebElement getUserPassword() {
        CustomElementWaits.waitUntilElementToClickable(driver,userPassword);
        return userPassword;
    }

    public WebElement getSignInButton() {
        CustomElementWaits.waitUntilElementToClickable(driver,signInButton);
        return signInButton;
    }
    public void loginFacebook(String userName,String userPassword){
        getUserName().sendKeys(userName);
        getUserPassword().sendKeys(userPassword);
        getSignInButton().click();
    }
}
