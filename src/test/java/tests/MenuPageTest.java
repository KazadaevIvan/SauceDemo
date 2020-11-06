package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class MenuPageTest extends BaseTest {

    @Test(description = "Verify user could logout from Products page")
    public void userShouldBeLoggedOut() {
        productPageSteps
                .openMenu();
        menuPageSteps
                .logout();
    }

    @Test(description = "Verify user could open About page")
    public void userShouldBeRedirectedToAboutPage() {
        productPageSteps
                .openMenu();
        menuPageSteps
                .openAboutPage();
    }
}
