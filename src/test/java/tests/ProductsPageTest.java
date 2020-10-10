package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsPageTest extends BaseTest {

    @Test(description = "Validation that product could be added to cart from Products page")
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

    @Test(description = "Validation that products sorted by name in alphabetical order")
    public void productsShouldBeSortedByNameFromAToZ() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Name (A to Z)");
        assertEquals(productsPage.getAllItemsNames().toString(), productsPage.sortItemsNamesFromAToZ(),
                "Items should be sorted by name from A to Z");
    }

    @Test(description = "Checking that items are sorted by name in reverse alphabetical order")
    public void productsShouldBeSortedByNameFromZToA() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Name (Z to A)");
        assertEquals(productsPage.getAllItemsNames().toString(), productsPage.sortItemsNamesFromZToA(),
                "Items should be sorted by name from Z to A");
    }

    @Test(description = "Checking that items are sorted by price in ascending order")
    public void productsShouldBeSortedByPriceFromLowToHigh() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Price (low to high)");
        assertEquals(productsPage.getAllItemsPrices().toString(), productsPage.sortItemsPricesFromLowToHigh(),
                "Products prices should be sorted from low to high");
    }

    @Test(description = "Checking that items are sorted by price in descending order")
    public void productsShouldBeSortedByPriceFromHighToLow() {
        productsPage
                .openPage()
                .isPageOpened()
                .chooseSortingMethod("Price (high to low)");
        assertEquals(productsPage.getAllItemsPrices().toString(), productsPage.sortItemsPricesFromHighToLow(),
                "Products prices should be sorted from high to low");
    }

    @Test(description = "Validation that product could be removed from cart from Products page")
    public void productShouldBeRemovedFromCart() {
        String productName = "Sauce Labs Backpack";
        productsPage
                .openPage()
                .isPageOpened()
                .addItemToCart(productName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .productDetailsShouldBeLike(productName, "1", "29.99")
                .continueShopping();
        productsPage
                .isPageOpened()
                .removeItemFromCart(productName)
                .openShoppingCart();
        cartPage
                .isPageOpened()
                .isCartEmpty();
    }
}