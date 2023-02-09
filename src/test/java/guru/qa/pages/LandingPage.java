package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LandingPage {

    private SelenideElement registrationButton = $("#registration-button");
    public SelenideElement loginButton = $("#login-button");
    public SelenideElement watchVideoButton = $(".watch-video-button");


    public LandingPage clickRegistrationButton() {
        step("Click registration button", () -> {
            registrationButton.click();
        });

        return this;
    }

    public LandingPage clickLoginButton() {
        step("Click login button", () -> {
            loginButton.click();
        });

        return this;
    }

    public LandingPage clickWatchVideoButton() {
        step("Click 'Watch Video' button", () -> {
            watchVideoButton.click();
        });

        return this;
    }
}
