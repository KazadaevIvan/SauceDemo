package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsPageTest extends BaseTest {

    @Test
    public void productShouldBeAddedToCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .addItemToCart("Sauce Labs Backpack")
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99");
    }

    @Test
    public void productsShouldBeSortedByNameFromAToZ() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Name (A to Z)");
        assertEquals(productsPage.getAllItemsNames().toString(), productsPage.sortItemsNamesFromAToZ(),
                "Items should be sorted by name from A to Z");
    }

    @Test
    public void productsShouldBeSortedByNameFromZToA() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Name (Z to A)");
        assertEquals(productsPage.getAllItemsNames().toString(), productsPage.sortItemsNamesFromZToA(),
                "Items should be sorted by name from Z to A");
    }

    @Test
    public void productsShouldBeSortedByPriceFromLowToHigh() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Price (low to high)");
        assertEquals(productsPage.getAllItemsPrices().toString(), productsPage.sortItemsPricesFromLowToHigh(),
                "Products prices should be sorted from low to high");
    }

    @Test
    public void productsShouldBeSortedByPriceFromHighToLow() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Price (high to low)");
        assertEquals(productsPage.getAllItemsPrices().toString(), productsPage.sortItemsPricesFromHighToLow(),
                "Products prices should be sorted from high to low");
    }

    @Test
    public void productShouldBeRemovedFromCart() {
        String itemName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(itemName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99")
                .continueShopping();
        productsPage
                .isPageOpened()
                .removeItemFromCart(itemName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .isCartEmpty();
    }
}
