package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductPage extends BasePage {
    private static final Logger log = LoggerFactory.getLogger(ProductPage.class);

    private final By searchField = By.xpath("//*[@id=\"search_product\"]");
    private final By searchButton = By.xpath("//*[@id=\"submit_search\"]");
    private final By productList = By.cssSelector(".features_items .col-sm-4");
    private final By viewCartButton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private final By viewProductButton = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[2]/ul/li/a");
    private final By quantityProductDetails = By.xpath("//*[@id=\"quantity\"]");
    private final By addProductButtonProductDetails = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getAllProducts() {
        return driver.findElements(productList);
    }

    public void searchProduct(String productName) {
        typeText(searchField, productName);
        clickElement(searchButton);
    }


    public boolean isProductListDisplayed() {
        try {
            waitForElementToBeVisible(productList);
            List<WebElement> products = getAllProducts();
            if (products == null || products.isEmpty()) {
                log.info("No products found in the product list.");
                return false;
            }
            log.info("Number of products displayed: {}", products.size());
            return true;
        } catch (TimeoutException e) {
            log.warn("Product list is not visible within the expected time.");
            return false;
        } catch (Exception e) {
            log.error("An unexpected error occurred while checking the product list.", e);
            return false;
        }
    }


    public void clearSearchField() {
        driver.findElement(searchField).clear();
    }

    public WebElement getFirstProduct() {
        waitForElementToBeVisible(productList);
        List<WebElement> products = getAllProducts();
        return products.getFirst();
    }

    public void addProductToCart() {
        try {
            WebElement addToCart = getFirstProduct().findElement(By.cssSelector(".add-to-cart"));
            addToCart.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getQuantityProductDetails() {
        return driver.findElement(quantityProductDetails).getDomProperty("value");
    }


    public void addProductToCartWithRandomQuantity() {
        log.info("Get the first product in the list of products");
        WebElement product = getFirstProduct();
        product.findElement(viewProductButton).click();
        WebElement quantity = waitForElementToBeVisible(quantityProductDetails);
        log.info("clear quantity product details");
        quantity.clear();
        log.info("Add quantity product details");
        typeText(quantityProductDetails, "4");
        log.info("add product to the cart");
        clickElement(addProductButtonProductDetails);
        log.info("product added to the cart");
    }

    public void viewCart() {
        clickElement(viewCartButton);
    }


}

