package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginPageSteps {
    private LoginPage loginPage;

    public LoginPageSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Attempt to login with username '{username}' and password '{password}'")
    public LoginPageSteps attemptToLogin(String username, String password) {
        loginPage
                .openPage()
                .isPageOpened()
                .attemptToLogin(username, password);
        return this;
    }

    @Step("Login with username '{username}' and password '{password}'")
    public LoginPageSteps login(String username, String password) {
        loginPage
                .openPage()
                .isPageOpened()
                .login(username, password)
                .isPageOpened();
        return this;
    }

    @Step("Validate error message is: '{errorMessage}'")
    public LoginPageSteps errorMessageShouldBeLike(String errorMessage) {
        String actualResult = loginPage
                .isErrorMessageAppeared()
                .getErrorMessageText();
        assertEquals(actualResult, errorMessage, "Error error message should be '" + errorMessage + "'");
        return this;
    }
}
