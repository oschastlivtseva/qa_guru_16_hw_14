package guru.qa.pages;

import guru.qa.pages.elements.Element;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.SetValueOptions.withText;
import static io.qameta.allure.Allure.step;

public class ModalPage {
    private GeneralActions generalActions = new GeneralActions();

    // fields
    public Element firstNameInput = new Element("'First Name' input", $("#firstName"));
    public Element lastNameInput = new Element("'Last Name' input", $("#lastName"));
    public Element emailInput = new Element("'Email' input", $("#email"));
    public Element passwordInput = new Element("'Password' input", $("#password"));
    public Element passwordConfirmation = new Element(
            "'Password Confirmation' input",
            $("#passwordConfirmation")
    );

    // buttons
    public Element closeModalButton = new Element("'Close modal window' button", $(".close-modal-button"));
    public Element loginSubmitButton = new Element(
            "'Login submit' button",
            $(".modal-actions #login-button")
    );
    public Element registrationSubmitButton = new Element(
            "'Registration submit' button",
            $(".modal-actions .register-button")
    );
    public Element acceptTermsButton = new Element(
            "'Accept terms' button",
            $(".modal-actions .terms .checkbox-control")
    );
    public Element appleLoginButton = new Element("'Apple login' button", $(".apple-login-button"));
    public Element googleLoginButton = new Element("'Google login' button", $(".google-login-button"));
    public Element createAnAccountButton = new Element(
            "'Create an account' button",
            $(".footer .register-text-button")
    );
    public Element forgotPasswordButton = new Element(
            "'Forgot password' button",
            $(".footer .forgot-text-button")
    );
    public Element alreadyHaveAccountButton = new Element(
            "'Already have an account' button",
            $(".footer .login-text-button")
    );

    // modal windows
    public Element loginModalWindow = new Element("'Login' modal window", $(".login-modal"));
    public Element registrationModalWindow = new Element(
            "'Registration' modal window",
            $(".registration-modal")
    );
    public Element videoModalWindow = new Element("'Video' modal window", $(".video-modal"));

    // other elements
    public Element errorAlert = new Element("'Error alert'", $(".alert-error"));
    public Element video = new Element("'Video'", $(".video-iframe"));

    public ModalPage setFirstName(String firstName) {
        step("Set first name: '" + firstName + "'", () -> {
            generalActions.inputInField(firstNameInput, firstName);
        });

        return this;
    }

    public ModalPage setLastName(String lastName) {
        step("Set last name: '" + lastName + "'", () -> {
            generalActions.inputInField(lastNameInput, lastName);
        });

        return this;
    }

    public ModalPage setEmail(String email) {
        step("Set email: '" + email + "'", () -> {
            generalActions.inputInField(emailInput, email);
        });

        return this;
    }

    public ModalPage setPassword(String password) {
        step("Set password", () -> {
            passwordInput.getElement().setValue(withText(password).sensitive());
        });

        return this;
    }

    public ModalPage confirmPassword(String password) {
        step("Confirm password", () -> {
            passwordConfirmation.getElement().setValue(withText(password).sensitive());
        });

        return this;
    }

    public ModalPage clickAcceptAgreement() {
        step("Click Accept Terms", () -> {
            generalActions.click(acceptTermsButton);
        });

        return this;
    }

    public ModalPage clickSubmitButton(Element element) {
        step("Click submit button: " + element.getName(), () -> {
            generalActions.click(element);
            element.getElement().shouldHave(cssClass("is-processing"));
        });

        return this;
    }

    public ModalPage checkModalTitle(String title) {
        step("Check modal window has title: '" + title + "'", () -> {
            $(".modal-title").shouldHave(text(title));
        });

        return this;
    }

    public ModalPage checkAlert(String text) {
        step("Check alert: '" + text + "'", () -> {
            errorAlert.getElement().shouldHave(text(text)).shouldBe(visible);
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
