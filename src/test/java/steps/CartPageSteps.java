package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.CartPage;

import static org.testng.Assert.assertEquals;

public class CartPageSteps {
    private CartPage cartPage;

    public CartPageSteps(WebDriver driver) {
        cartPage = new CartPage(driver);
    }

    @Step("Validate product details is quantity: '{quantity}', price: '{price}'")
    public CartPageSteps productDetailsShouldBeLike(String productName, String quantity, String price) {
        cartPage
                .openPage()
                .isPageOpened();
        assertEquals(cartPage.getProductPrice(productName), price, "Price is not correct");
        assertEquals(cartPage.getProductQuantity(productName), quantity, "Quantity is not correct");
        return this;
    }

    @Step("Verify that shopping cart is empty")
    public CartPageSteps cartShouldBeEmpty() {
        cartPage
                .openPage()
                .isPageOpened()
                .numberOfItemsInTheCart(0);
        return this;
    }

    @Step("Checkout")
    public CartPageSteps checkout() {
        cartPage
                .isPageOpened()
                .clickCheckoutButton();
        return this;
    }

    @Step("Continue shopping")
    public CartPageSteps continueShopping() {
        cartPage
                .isPageOpened()
                .clickContinueShoppingButton();
        return this;
    }

    @Step("Remove product '{productName}' from shopping cart")
    public CartPageSteps removeItemFromCart(String productName) {
        cartPage
                .isPageOpened()
                .removeItemFromCart(productName);
        return this;
    }
}
