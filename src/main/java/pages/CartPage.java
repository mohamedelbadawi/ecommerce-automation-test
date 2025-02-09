package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By productsTable = By.cssSelector("#cart_info_table tbody tr");
    private final By removeProductButton = By.cssSelector(".cart_delete  .cart_quantity_delete");
    private final By cartIsEmpty = By.xpath("//*[@id=\"empty_cart\"]/p/b");
    private final By checkoutButton = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    private final By placeOrderButton = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
    private final By quantityCartTable = By.xpath("//*[@id=\"product-1\"]/td[4]/button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllProducts() {
        return (driver.findElements(productsTable));
    }

    public boolean isProductAddedToCart() {
        return !getAllProducts().isEmpty();
    }

    public void removeFirstProductFromCart() {
        List<WebElement> products = getAllProducts();
        products.getFirst().findElement(removeProductButton).click();
    }

    public boolean isCartEmpty() {
        try {
            return waitForElementToBeVisible(cartIsEmpty).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void checkoutProcess() {
        clickElement(checkoutButton);
        clickElement(placeOrderButton);
    }

    public String getQuantityCartTable() {
        return driver.findElement(quantityCartTable).getText();
    }
}
