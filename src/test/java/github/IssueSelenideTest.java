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
import static org.openqa.selenium.By.linkText;

public class IssueSelenideTest {
    @DisplayName("Check issue simple selenide")
    @Owner("Tanya")
    @Story("What issue is exist?")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @Test
    public void checkIssueTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("allure");
        $(".header-search-input").submit();

        $(linkText("allure-framework/allure-java")).click();
        $("#issues-tab").click();
        $(withText("#813")).should(Condition.exist);

    }
}
