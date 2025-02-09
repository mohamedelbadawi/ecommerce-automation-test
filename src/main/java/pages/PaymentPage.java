package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private final By cardHolderField = By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");
    private final By cardNumberField = By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");
    private final By cvcField = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");
    private final By expirationMonthField = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
    private final By expirationYearField = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");
    private final By payAndConfirmOrderBtn = By.xpath("//*[@id=\"submit\"]");
    private final By orderPlacedMessage = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void enterPaymentDetails(String cardNumber, String cardHolder, String expiryYear, String expiryMonth, String cvv) {
        typeText(cardHolderField, cardHolder);
        typeText(cardNumberField, cardNumber);
        typeText(cvcField, cvv);
        typeText(expirationMonthField, expiryMonth);
        typeText(expirationYearField, expiryYear);
        clickElement(payAndConfirmOrderBtn);
    }

    public boolean isOrderPlacedSuccessfully() {
        return waitForElementToBeVisible(orderPlacedMessage).isDisplayed();
    }
}
