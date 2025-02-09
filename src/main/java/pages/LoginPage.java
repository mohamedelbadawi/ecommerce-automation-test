package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private WebDriver driver;

    private By emailField = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    private By passwordField = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    private By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    private By logoutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private String loginPage = "https://www.automationexercise.com/login";
    private By errorMessage = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        navigateTo(loginPage);
        typeText(emailField, email);
        typeText(passwordField, password);
        clickElement(loginButton);
    }

    public boolean isLoggedIn() {
        WebElement element = waitForElementToBeVisible(logoutButton);
        return element.isDisplayed();
    }

    public boolean errorMessageDisplayed() {
        WebElement element = waitForElementToBeVisible(errorMessage);
        return element.isDisplayed();
    }

    public boolean isRequiredEmailFieldValidationMessageDisplayed() {
        String message = getElementAttribute(emailField, "validationMessage");
        return message.length() > 0;
    }

}
