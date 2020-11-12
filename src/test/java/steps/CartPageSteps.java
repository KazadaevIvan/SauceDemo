package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CartPageSteps {
    private CartPage cartPage;

    public CartPageSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
    }

    @Step("Validate product details is quantity: '{quantity}', price: '{price}'")
    public CartPageSteps productDetailsShouldBeLike(String productName, String quantity, String price) {
        log.info(String.format("Validate product details is quantity: '%s', price: '%s'", quantity, price));
        cartPage
                .openPage()
                .isPageOpened();
        assertEquals(cartPage.getProductPrice(productName), price, "Price is not correct");
        assertEquals(cartPage.getProductQuantity(productName), quantity, "Quantity is not correct");
        return this;
    }

    @Step("Verify that shopping cart has '{numberOfItems}' products")
    public CartPageSteps numberOfItemsInTheCartShouldBe(int numberOfItems) {
        log.info(String.format("Verify that shopping cart has '%s' products", numberOfItems));
        cartPage
                .openPage()
                .isPageOpened();
        assertEquals(cartPage.getNumberOfItemsInTheCart(), numberOfItems,
                "Number of products in the cart should be " + numberOfItems);
        return this;
    }

    @Step("Checkout")
    public CartPageSteps checkout() {
        log.info("Checkout");
        cartPage
                .openPage()
                .isPageOpened()
                .clickCheckoutButton();
        return this;
    }

    @Step("Continue shopping")
    public CartPageSteps continueShopping() {
        log.info("Continue shopping");
        cartPage
                .isPageOpened()
                .clickContinueShoppingButton();
        return this;
    }

    @Step("Remove product '{productName}' from shopping cart")
    public CartPageSteps removeItemFromCart(String productName) {
        log.info(String.format("Remove product '%s' from shopping cart", productName));
        cartPage
                .isPageOpened()
                .removeItemFromCart(productName);
        return this;
    }
}
