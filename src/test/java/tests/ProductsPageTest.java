package tests;

import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {

    @Test
    public void itemShouldBeAddedToCart() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCart("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.productDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99");
    }
}
