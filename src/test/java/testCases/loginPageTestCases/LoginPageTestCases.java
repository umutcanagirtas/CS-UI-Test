package testCases.loginPageTestCases;

import base.BaseClass;
import helpers.ActionClass;
import helpers.Listeners;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;
import pages.popUp.PopUpLoginPage;

import static base.Constants.*;

@org.testng.annotations.Listeners(Listeners.class)
public class LoginPageTestCases extends BaseClass {
    MainPage mainPage;
    LoginPage loginPage;
    PopUpLoginPage popUpLoginPage;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        super.beforeMethod(browser);
        mainPage = new MainPage(driver);
        popUpLoginPage = new PopUpLoginPage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void terminateWebDriver() {
        super.afterMethod();
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class)
    public void successfulLogin(String author, String searchKey) {
        System.out.println(author);
        driver.get(baseUrl + searchKey + "/login");
        loginPage.userLogin(VALID_USER_NAME, VALID_USER_PASSWORD);
        //region Excepted and Actual
        String excepted = "My Account";
        String actual = mainPage.getAccountArea().getText();
        //endregion
        ActionClass.performClick(driver);
        mainPage.logOut();
        Assert.assertEquals(actual, excepted, "Login failed..!");
    }
/*
    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class)
    public void failedLoginWithInvalidUserPasswordAndValidUserName(String author, String searchKey) {
        System.out.println(author);
        driver.get(baseUrl + searchKey + "/login");
        loginPage.userLogin(VALID_USER_NAME, INVALID_USER_PASSWORD);
        //region Excepted and Actual
        String excepted = "E-mail address or password is incorrect. Please check your information and try again.";
        String actual = popUpLoginPage.getPopupTextForFailedLogin().getText();
        //endregion
        Assert.assertEquals(actual, excepted, "Login should have failed but ended successfully..!");
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class)
    public void failedLoginWithInvalidUserNameAndValidUserPassword(String author, String searchKey) {
        System.out.println(author);
        driver.get(baseUrl + searchKey + "/login");
        loginPage.userLogin(INVALID_USER_NAME, VALID_USER_PASSWORD);
        //region Excepted and Actual
        String excepted = "E-mail address or password is incorrect. Please check your information and try again.";
        String actual = popUpLoginPage.getPopupTextForFailedLogin().getText();
        //endregion
        Assert.assertEquals(actual, excepted, "Login should have failed but ended successfully..!");
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class)
    public void failedLoginWithInvalidUserNameAndInvalidUserPassword(String author, String searchKey) {
        System.out.println(author);
        driver.get(baseUrl + searchKey + "/login");
        loginPage.userLogin(INVALID_USER_NAME, INVALID_USER_PASSWORD);
        //region Excepted and Actual
        String excepted = "E-mail address or password is incorrect. Please check your information and try again.";
        String actual = popUpLoginPage.getPopupTextForFailedLogin().getText();
        //endregion
        Assert.assertEquals(actual, excepted, "Login should have failed but ended successfully..!");
    }

 */
}