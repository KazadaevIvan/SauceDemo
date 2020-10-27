package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @Test(description = "Validation that correct message appears when login with invalid credentials",
            dataProvider = "testDataForLogin")
    public void errorMessageShouldBeShownWhenLogin(String username, String password, String errorMessage) {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptToLogin(username, password)
                .isErrorMessageAppeared();
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

    @Test(description = "Validation that user could login with valid credentials")
    public void userShouldBeLogined() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(System.getProperty("username", "standard_user"), PASSWORD)
                .isPageOpened();
    }
}