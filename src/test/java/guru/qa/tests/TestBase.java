package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.ConfigProvider;
import guru.qa.helpers.TestAttachment;
import guru.qa.pages.AccountPage;
import guru.qa.pages.GeneralActions;
import guru.qa.pages.LandingPage;
import guru.qa.pages.ModalPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    GeneralActions generalActions = new GeneralActions();
    LandingPage landingPage = new LandingPage();
    ModalPage modalPage = new ModalPage();
    AccountPage accountPage = new AccountPage();

    public String autotestUserNameAndSurname = ConfigProvider.getTestUserNameAndSurname();
    public String autotestUserEmail = ConfigProvider.getTestUserEmail();
    public String autotestUserPassword = ConfigProvider.getTestUserPassword();

    @BeforeEach
    public void setUpForTest() {
        addListener();
        ConfigProvider.configure();
        open(Configuration.baseUrl);
    }

    @AfterEach
    public void completeTest() {
        Selenide.clearBrowserCookies();
        addTestAttachments();
        Selenide.closeWebDriver();
    }

    private void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    private void addTestAttachments() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String attachDate = localDateTime.toString();

        TestAttachment.screenshotAs("Screenshot " + attachDate);
        TestAttachment.pageSource("Page source " + attachDate);
        TestAttachment.addVideo("Video " + attachDate);
        TestAttachment.browserConsoleLogs();
    }
}
