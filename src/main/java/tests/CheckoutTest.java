package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;

public class CheckoutTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(CheckoutTest.class);
    private ProductPage productPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    private PaymentPage paymentPage;

    @BeforeMethod
    @Step("Initialize Pages")
    public void setup() {
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        paymentPage = new PaymentPage(driver);
    }

    @Test(priority = 1)
    @Description("Ensure successfully checkout when the user is logged in ")
    public void successfulCheckout() {
        log.info("Start the checkout test");
        loginPage.login("m@g.com", "123456789");
        log.info("user login successful");
        log.info("Add product to the cart");
        productPage.addProductToCart();
        log.info("view cart");
        productPage.viewCart();
        log.info("start checkout process");
        cartPage.checkoutProcess();
        log.info("end checkout process");
        log.info("Enter the payment details");
        paymentPage.enterPaymentDetails("4111111111111111", "Mohamed Reda", "2029", "10", "123");
        log.info("Payment details successful");
        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully(), "Order is not placed successfully");
    }


}
