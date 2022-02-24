package pages;

import helpers.ActionClass;
import helpers.CustomElementWaits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.BasePages;

public class MainPage extends BasePages {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='header__top js-window-menu']//a[@href='javascript:void(0);']")
    private WebElement signInArea;
    @FindBy(xpath = "//div[@class='header__top js-window-menu']//a[@title='My Account']/span[@class='user-menu__title']")
    private WebElement accountArea;
    @FindBy(xpath = "//div[@class='header']//a[@title='Log Out']")
    private WebElement logOutButton;


    public WebElement getAccountArea() {
        CustomElementWaits.waitUntilElementFind(driver, accountArea);
        return accountArea;
    }

    public WebElement getLogOutButton() {
        CustomElementWaits.waitUntilElementToClickable(driver, logOutButton);
        return logOutButton;
    }

    public WebElement getSignInArea(){
        CustomElementWaits.waitUntilElementToClickable(driver,signInArea);
        return signInArea;
    }

    public void logOut() {
        ActionClass.moveTo(driver, getAccountArea());
        ActionClass.moveTo(driver, getLogOutButton());
        ActionClass.performClick(driver);
    }
}