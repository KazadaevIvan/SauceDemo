package tests;

import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void shoppingCartShouldBeOpened() {
        cartPage.openPage();
        cartPage.isPageOpened();
    }
}
