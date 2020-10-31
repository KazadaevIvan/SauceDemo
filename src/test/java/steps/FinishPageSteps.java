package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.FinishPage;

import static org.testng.Assert.assertEquals;

public class FinishPageSteps {
    private FinishPage finishPage;

    public FinishPageSteps(WebDriver driver) {
        finishPage = new FinishPage(driver);
    }

    @Step("Verify complete header is '{completeHeader}'")
    public FinishPageSteps completeHeaderShouldBeLike(String completeHeader) {
        String actualResult = finishPage
                .isPageOpened()
                .getCompleteHeaderText();
        assertEquals(actualResult, completeHeader, "Header text should be '" + completeHeader + "'");
        return this;
    }
}
