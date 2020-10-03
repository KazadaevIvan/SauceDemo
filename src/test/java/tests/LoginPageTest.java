package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider = "testDataForLogin")
    public void errorMessageShouldBeShownWhenLogin(String username, String password, String errorMessage) {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(username, password);
        String actualResult = loginPage.getErrorMessageText();
        assertEquals(actualResult, errorMessage, "Error error message should be '" + errorMessage + "'");
    }

    @DataProvider(name = "testDataForLogin")
    public Object[][] testDataForLogin() {
        return new Object[][]{
                {USERNAME, "", "Epic sadface: Password is required"},
                {"", PASSWORD, "Epic sadface: Username is required"},
                {"admin", "12345678", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test
    public void userShouldBeLogined() {
        loginPage.openPage();
        loginPage.isPageOpened();
        loginPage.login(USERNAME, PASSWORD);
        assertEquals(driver.getCurrentUrl(), productsPage.getURL(), "URL should be '" + productsPage.getURL() + "'");
    }
}