package tests;

import jdk.jfr.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(ProductTest.class);
    private ProductPage productPage;

    public ProductTest() {
        setResource("products"); // Setting resource for the products page
    }

    @BeforeMethod
    public void setUp() {
        productPage = new ProductPage(driver); // Initialize once before each test
        productPage.clearSearchField();        // Clear the search field
        log.info("Search field cleared before test execution.");
    }

    @Test(priority = 1, description = "Verify the search functionality for an existing product")
    @Description("Verify the search functionality for an existing product")
    public void searchForProduct() {
        log.info("Starting test: Search for existing product");
        productPage.searchProduct("Men Tshirt");
        Assert.assertTrue(productPage.isProductListDisplayed(), "Product list should be displayed for existing product.");
        log.info("Search for existing product completed successfully.");
    }

    @Test(priority = 2, description = "Verify the search functionality for a non-existent product")
    @Description("Verify the search functionality for a non-existent product")
    public void searchForNonExistentProduct() {
        log.info("Starting test: Search for non-existent product");
        productPage.searchProduct("Super");
        Assert.assertFalse(productPage.isProductListDisplayed(), "Product list should not be displayed for non-existent product.");
        log.info("Search for non-existent product completed successfully.");
    }
}
