import org.testng.annotations.Test;

public class ItemInfoPageTest extends BaseTest {
    @Test
    public void itemShouldBePrinted() {
        ItemInfoPage itemInfoPage = loginPage.login("standard_user", "secret_sauce")
                .openItemInfo("Sauce Labs Backpack");
        String itemPrice = itemInfoPage.getItemPrice();
        itemInfoPage.clickAddToCartButton();
        System.out.println(itemPrice);
    }
}
