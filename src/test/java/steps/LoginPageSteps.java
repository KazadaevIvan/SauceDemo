package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

@Log4j2
public class LoginPageSteps {
    private LoginPage loginPage;

    public LoginPageSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Attempt to login with username '{username}' and password '{password}'")
    public LoginPageSteps attemptToLogin(String username, String password) {
        log.info(String.format("Attempt to login with username '%s' and password '%s'", username, password));
        loginPage
                .openPage()
                .isPageOpened()
                .attemptToLogin(username, password);
        return this;
    }

    @Step("Login with username '{username}' and password '{password}'")
    public LoginPageSteps login(String username, String password) {
        log.info(String.format("Login with username '%s' and password '%s'", username, password));
        loginPage
                .openPage()
                .isPageOpened()
                .login(username, password)
                .isPageOpened();
        return this;
    }

    @Step("Validate error message is: '{errorMessage}'")
    public LoginPageSteps errorMessageShouldBeLike(String errorMessage) {
        log.info(String.format("Validate error message is: '%s'", errorMessage));
        String actualResult = loginPage
                .isErrorMessageAppeared()
                .getErrorMessageText();
        assertEquals(actualResult, errorMessage, "Error error message should be '" + errorMessage + "'");
        return this;
    }
}
