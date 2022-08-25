package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueLambdaTest {
    public static final String REPO = "allure-framework/allure-java";

    @Test
    @DisplayName("Check issue by lambda")
    @Owner("Tanya")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    public void checkIssueTest() {


        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {

            open("https://github.com");
        });
        step("Search repository" + REPO, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPO);
            $(".header-search-input").submit();
        });
        step("Click by link of repository -" + REPO, () -> {
            $(linkText(REPO)).click();
        });
        step("Click by issue", () -> {
            $("#issues-tab").click();
        });
        step("Check that element #813 is exist on page", () -> {
            $(withText("#813")).should(Condition.exist);
        });


    }

}