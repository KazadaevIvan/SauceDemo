import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test
    public void printAllItemsNames() {
        loginPage.login("standard_user", "secret_sauce")
                .getAllItemsNames();
    }

    @Test
    public void printAllItemsPrices() {
        loginPage.login("standard_user", "secret_sauce")
                .getAllItemsPrices();
    }

    @Test
    public void itemShouldBeAddedToCart() {
        loginPage.login("standard_user", "secret_sauce")
                .addItemToCart("Sauce Labs Backpack");
    }

    @Test
    public void sortingMethodShouldBeSelected() {
        loginPage.login("standard_user", "secret_sauce")
                .chooseSortingMethod("Name (Z to A)");
    }
}
