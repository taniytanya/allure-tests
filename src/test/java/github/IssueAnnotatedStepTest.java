package github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IssueAnnotatedStepTest {
    String repo = "allure-framework/allure-java";
    String issue = "#813";
    @Test
    @DisplayName("Check issue by steps")
    @Owner("Tanya")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository(repo);
        steps.clickOnRepositoryLink(repo);
        steps.checkShouldSeeIssueWithNumber(issue);
        steps.takeScreenshot();
    }
}
