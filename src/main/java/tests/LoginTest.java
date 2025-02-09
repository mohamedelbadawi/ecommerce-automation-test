package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

@Feature("Login test")
public class LoginTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private LoginPage loginPage;

    @Test(priority = 4, description = "verify login with valid Data")
    @Step("Login with valid Data")
    @Description("Test to verify successful login with correct email and password")
    public void validLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("m@g.com", "123456789");
        log.info("test login with correct email and password");
        Assert.assertTrue(loginPage.isLoggedIn());
        log.info("test login with correct email and password passed");
    }

    @Test(priority = 2, description = "verify login with invalid password")
    @Step("Login With invalid Password")
    @Description("verify error message when logging in with invalid password")
    public void invalidPasswordLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("m@g.com", "123452789323");
        log.info("test login with  invalid password");
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        log.info("test login with invalid password passed");
    }

    @Test(priority = 1, description = "verify login with invalid email")
    @Step("Login With invalid Email")
    @Description("verify error message when logging in with invalid email")
    public void invalidEmailLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("m32@g.com", "123456789");
        log.info("test login with  invalid email");
        Assert.assertTrue(loginPage.errorMessageDisplayed());
        log.info("test login with invalid email passed");
    }

    @Test(priority = 3, description = "Verify login with empty data")
    @Step("Login with empty data")
    @Description("verify error message appear when logging in with empty data")
    public void emptyLoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.login("", "");
        log.info("test login with empty data");
        Assert.assertTrue(loginPage.isRequiredEmailFieldValidationMessageDisplayed());
        log.info("test login with empty data passed");
    }
}
