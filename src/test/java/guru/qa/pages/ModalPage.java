package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SetValueOptions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ModalPage {
    private GeneralActions generalActions = new GeneralActions();

    public SelenideElement firstNameInput = $("#firstName");
    public SelenideElement lastNameInput = $("#lastName");
    public SelenideElement emailInput = $("#email");
    public SelenideElement passwordInput =  $("#password");
    public SelenideElement passwordConfirmation = $("#passwordConfirmation");

    public SelenideElement closeModalButton = $(".close-modal-button");
    public SelenideElement loginSubmitButton = $(".modal-actions #login-button");
    public SelenideElement registrationSubmitButton = $(".modal-actions .register-button");
    public SelenideElement acceptTermsButton = $(".modal-actions .terms .checkbox-control");
    public SelenideElement appleLoginButton = $(".apple-login-button");
    public SelenideElement googleLoginButton = $(".google-login-button");
    public SelenideElement createAnAccountButton = $(".footer .register-text-button");
    public SelenideElement forgotPasswordButton = $(".footer .forgot-text-button");
    public SelenideElement alreadyHaveAccountButton = $(".footer .login-text-button");

    public SelenideElement loginModalWindow = $(".login-modal");
    public SelenideElement registrationModalWindow = $(".registration-modal");
    public SelenideElement videoModalWindow = $(".video-modal");

    public SelenideElement errorAlert = $(".alert-error");

    public SelenideElement video = $(".video-iframe");

    public ModalPage setFirstName(String firstName) {
        step("Set first name: " + firstName, () -> {
            generalActions.inputInField(firstNameInput, firstName);
        });

        return this;
    }

    public ModalPage setLastName(String lastName) {
        step("Set last name: " + lastName, () -> {
            generalActions.inputInField(lastNameInput, lastName);
        });

        return this;
    }

    public ModalPage setEmail(String email) {
        step("Set email: " + email, () -> {
            generalActions.inputInField(emailInput, email);
        });

        return this;
    }

    public ModalPage setPassword(String password) {
        step("Set password",  () -> {
            passwordInput.setValue(SetValueOptions.withText(password).sensitive());
        });

        return this;
    }

    public ModalPage confirmPassword(String password) {
        step("Confirm password", () -> {
            passwordConfirmation.setValue(SetValueOptions.withText(password).sensitive());
        });

        return this;
    }

    public ModalPage clickAcceptAgreement() {
        step("Click Accept Terms", () -> {
            generalActions.click(acceptTermsButton);
        });

        return this;
    }

    public ModalPage clickSubmitButton(SelenideElement element) {
        step("Click submit button", () -> {
            generalActions.click(element);
            element.shouldHave(cssClass("is-processing"));
        });

        return this;
    }

    public ModalPage checkModalTitle(String title) {
        step("Check modal window has title: '" + title  + "'", () -> {
            $(".modal-title").shouldHave(text(title));
        });

        return this;
    }

    public ModalPage checkAlert(String text) {
        step("Check alert: '" + text + "'", () -> {
            errorAlert.shouldHave(text(text)).shouldBe(visible);
        });

        return this;
    }

    public ModalPage checkVideoIsPlaying() {
        step("Check video is playing", () -> {
            $("#movie_player").shouldHave(cssClass("playing-mode"));
        });

        return this;
    }

}
