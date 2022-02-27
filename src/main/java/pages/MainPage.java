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

    @FindBy(xpath = "//div[@class='header__top js-window-menu']//a[@title='My Account']/span[@class='user-menu__title']")
    private WebElement accountArea;
    @FindBy(css = "div.header a[title='Log Out']")
    private WebElement logOutButton;


    public WebElement getAccountArea() {
        CustomElementWaits.waitUntilElementFind(driver, accountArea);
        return accountArea;
    }

    public WebElement getLogOutButton() {
        CustomElementWaits.waitUntilElementToClickable(driver, logOutButton);
        return logOutButton;
    }

    public void logOut() {
        ActionClass.moveToMouseOnElement(driver, getAccountArea());
        ActionClass.moveToMouseOnElement(driver, getLogOutButton());
        ActionClass.performClick(driver);
    }
}