package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @Test
    public void errorMessageShouldBeShown() {
        loginPage.openPage();
        loginPage.login(USERNAME, "");
        String actualResult = loginPage.getErrorMessageText();
        String expectedResult = "Epic sadface: Password is required";
        assertEquals(actualResult, expectedResult, "Error message should be '" + expectedResult + "'");
    }
}