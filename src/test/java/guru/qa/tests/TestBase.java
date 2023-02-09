package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.ConfigProvider;
import guru.qa.helpers.Attach;
import guru.qa.pages.GeneralActions;
import guru.qa.pages.LandingPage;
import guru.qa.pages.ModalPage;
import guru.qa.pages.AccountPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    GeneralActions generalActions = new GeneralActions();
    LandingPage landingPage = new LandingPage();
    ModalPage modalPage = new ModalPage();
    AccountPage accountPage = new AccountPage();

    @BeforeEach
    public void setUpForTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        ConfigProvider.configure();
        open(Configuration.baseUrl);
    }

    @AfterEach
    public void completeTest() {
        Selenide.clearBrowserCookies();

        LocalDateTime localDateTime = LocalDateTime.now();
        String attachName = localDateTime.toString();

        Attach.screenshotAs("Screenshot " + attachName);
        Attach.pageSource("Page source " + attachName);
        Attach.addVideo("Video " + attachName);
        Attach.browserConsoleLogs();
    }
}
