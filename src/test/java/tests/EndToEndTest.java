package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EndToEndTest extends BaseTest {

    @Test
    public void pathFromLoginToFinishShouldBeSuccessful() {
        String productName = "Sauce Labs Backpack";
        String quantity = "1";
        String price = "29.99";
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
        productsPage
                .isPageOpened()
                .addItemToCart(productName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike(productName, quantity, price)
                .clickCheckoutButton();
        checkoutPage
                .isPageOpened()
                .continueCheckout("Arnold", "Jackson", "29020");
        checkoutOverviewPage
                .isPageOpened()
                .productDetailsShouldBeLike(productName, quantity, price)
                .itemsTotalPriceShouldBeLike()
                .finishButtonClick();
        finishPage
                .isPageOpened();
        String actualResult = finishPage.getCompleteHeaderText();
        String expectedResult = "THANK YOU FOR YOUR ORDER";
        assertEquals(actualResult, expectedResult, "Header text should be '" + expectedResult + "'");
    }
}