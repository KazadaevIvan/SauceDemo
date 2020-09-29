import org.testng.annotations.Test;

public class ShoppingCartTest extends BaseTest {

    @Test
    public void shoppingCartShouldBeOpened() {
        CartPage cartPage = loginPage.login("standard_user", "secret_sauce")
                .openShoppingCart();
    }
}
