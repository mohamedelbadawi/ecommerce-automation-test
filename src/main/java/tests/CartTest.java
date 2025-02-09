package tests;

import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(CartTest.class);
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeMethod
    @Step("Initialize Pages")
    public void setup() {
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 2, groups = {"cart"}, description = "Verify adding a product to the cart successfully")
    @Description("Ensure that a product can be added to the cart and is displayed correctly.")
    public void addProductToCart() {

        log.info("Starting 'Add Product to Cart' test");
        productPage.addProductToCart();
        productPage.viewCart();
        Assert.assertTrue(cartPage.isProductAddedToCart(), "Product is not added to the cart");
        log.info("Product is displayed in the cart - Test Passed");
    }

    @Test(priority = 3, groups = {"cart"}, description = "Verify remove a product from cart successfully")
    @Description("Ensure that product removed from cart successfully and the cart is empty")
    public void removeProductFromCart() {
        log.info("Starting 'Remove Product from Cart' test");
        cartPage.removeFirstProductFromCart();
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty");
        log.info("Product is removed from the cart - Test Passed");
    }

    @Test(priority = 4, groups = {"cart"}, description = "Verify the cart is Empty when open the website for the first time")
    @Description("Ensure that cart is empty for the first time in the website")
    public void cartIsEmpty() {
        log.info("Starting 'Empty cart' test");
        Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty");
        log.info("Cart is empty - Test Passed");
    }

    @Test(priority = 1, groups = {"quantity"}, description = "Verify adding product to cart with random quantity")
    @Description("Ensure that user can add product with quantity to cart")
    public void addProductToCartWithRandomQuantity() {
        setResource("products");
        log.info("Starting 'Add Product to Cart' with random quantity Test");
        productPage.addProductToCartWithRandomQuantity();
        int quantityAdded = Integer.parseInt(productPage.getQuantityProductDetails());
        productPage.viewCart();
        int cartQuantity = Integer.parseInt(cartPage.getQuantityCartTable());
        Assert.assertEquals(quantityAdded, cartQuantity);
        log.info("Product added with the same quantity to the cart successfully - Test Passed");
    }


}
