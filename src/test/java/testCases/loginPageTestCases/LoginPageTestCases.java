package testCases.loginPageTestCases;

import base.BaseClass;
import helpers.ActionClass;
import helpers.Listeners;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.loginPages.LoginPage;
import pages.MainPage;
import pages.loginPages.facebookLoginPage.FacebookLoginPage;
import pages.loginPages.googlePages.GoogleUserNamePage;
import pages.loginPages.googlePages.GoogleUserPasswordPage;
import pages.popUp.PopUpLoginPage;

import java.util.Set;

import static base.Constants.*;

@org.testng.annotations.Listeners(Listeners.class)
public class LoginPageTestCases extends BaseClass {
    MainPage mainPage;
    LoginPage loginPage;
    PopUpLoginPage popUpLoginPage;
    GoogleUserNamePage googleUserNamePage;
    GoogleUserPasswordPage googleUserPasswordPage;
    FacebookLoginPage facebookLoginPage;

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        super.beforeMethod(browser);
        mainPage = new MainPage(driver);
        popUpLoginPage = new PopUpLoginPage(driver);
        loginPage = new LoginPage(driver);
        googleUserNamePage = new GoogleUserNamePage(driver);
        googleUserPasswordPage = new GoogleUserPasswordPage(driver);
        facebookLoginPage = new FacebookLoginPage(driver);
    }

    @AfterClass
    public void terminateWebDriver() {
        super.afterMethod();
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class, retryAnalyzer = retry.RetryAnalyzer.class)
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

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class, retryAnalyzer = retry.RetryAnalyzer.class)
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

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class, retryAnalyzer = retry.RetryAnalyzer.class)
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

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class, retryAnalyzer = retry.RetryAnalyzer.class)
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

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class, retryAnalyzer = retry.RetryAnalyzer.class)
    public void googleLoginAreaWithSuccess(String author, String searchKey) {
        System.out.println(author);
        driver.get(baseUrl + searchKey + "/login");
        loginPage.getGoogleLoginButton().click();
        googleUserNamePage.enterUserNameAndGoNextPage(GOOGLE_USER_NAME);
        googleUserPasswordPage.enterUserPasswordAndGoNextPage(GOOGLE_USER_PASSWORD);
        //region Excepted and Actual
        String excepted = "My Account";
        String actual = mainPage.getAccountArea().getText();
        //endregion
        Assert.assertEquals(actual, excepted, "Login failed with (" + GOOGLE_USER_NAME + ") Google Account");
    }

    @Test(dataProvider = "SearchProvider", dataProviderClass = helpers.DataProvider.class, retryAnalyzer = retry.RetryAnalyzer.class)
    public void facebookLoginAreaWithSuccess(String author, String searchKey) {
        System.out.println(author);
        driver.get(baseUrl + searchKey + "/login");
        loginPage.getFacebookLoginButton().click();
        String parentWindow = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        for (String childWindow : s) {
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                facebookLoginPage.loginFacebook(FACEBOOK_USER_NAME, FACEBOOK_USER_PASSWORD);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        //region Excepted and Actual
        String excepted = "My Account";
        String actual = mainPage.getAccountArea().getText();
        //endregion
        Assert.assertEquals(actual, excepted, "Login failed with (" + FACEBOOK_USER_NAME + ") Facebook Account");
    }


}