package guru.qa.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginFormTest extends TestBase {

    @Test
    @Feature("Login")
    @Story("Login form visibility")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check login form visibility")
    @Owner("oschastlivtseva")
    public void checkLoginFormVisibilityOnLandingPage() {
        landingPage.clickOnLandingPage(landingPage.loginButton);
        generalActions.checkVisibility(modalPage.loginModalWindow);
        modalPage.checkModalTitle("Log In");
        generalActions
                .checkVisibility(modalPage.appleLoginButton)
                .checkVisibility(modalPage.googleLoginButton)
                .checkVisibility(modalPage.emailInput)
                .checkVisibility(modalPage.passwordInput)
                .checkVisibility(modalPage.loginSubmitButton)
                .checkVisibility(modalPage.createAnAccountButton)
                .checkVisibility(modalPage.forgotPasswordButton)
                .checkVisibility(modalPage.closeModalButton);
    }

    @Test
    @Feature("Login")
    @Story("Successful login")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check successful login via email")
    @Owner("oschastlivtseva")
    public void checkSuccessfulLoginViaEmail() {
        landingPage.clickOnLandingPage(landingPage.loginButton);
        generalActions.checkVisibility(modalPage.loginModalWindow);
        modalPage
                .setEmail(autotestUserEmail)
                .setPassword(autotestUserPassword);
        generalActions.checkButtonIsEnabled(modalPage.loginSubmitButton);
        modalPage.clickSubmitButton(modalPage.loginSubmitButton);
        generalActions.checkElementIsNotVisible(modalPage.errorAlert);
        accountPage.checkUserName(autotestUserNameAndSurname);
        generalActions
                .checkVisibility(accountPage.courseHeader)
                .checkThatURLContains("https://www.brainscape.com/l/dashboard/knowledge-rehab", "/decks");
    }

    @Test
    @Feature("Login")
    @Story("Failed login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check login failed due to invalid email")
    @Owner("oschastlivtseva")
    public void checkLoginFailedDueToWrongEmail() {
        landingPage.clickOnLandingPage(landingPage.loginButton);
        generalActions.checkVisibility(modalPage.loginModalWindow);
        modalPage
                .setEmail(autotestUserEmail + "123")
                .setPassword(autotestUserPassword);
        generalActions.checkButtonIsEnabled(modalPage.loginSubmitButton);
        modalPage
                .clickSubmitButton(modalPage.loginSubmitButton)
                .checkAlert("Invalid email or password.");
        generalActions.checkThatURLDoesNotContain("https://www.brainscape.com/l/dashboard/knowledge-rehab", "/decks");
    }

    @Test
    @Feature("Login")
    @Story("Failed login")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check login failed due to invalid password")
    @Owner("oschastlivtseva")
    public void checkLoginFailedDueToWrongPassword() {
        landingPage.clickOnLandingPage(landingPage.loginButton);
        generalActions.checkVisibility(modalPage.loginModalWindow);
        modalPage
                .setEmail(autotestUserEmail)
                .setPassword(autotestUserPassword + "123");
        generalActions.checkButtonIsEnabled(modalPage.loginSubmitButton);
        modalPage
                .clickSubmitButton(modalPage.loginSubmitButton)
                .checkAlert("Invalid email or password.");
        generalActions.checkThatURLDoesNotContain("https://www.brainscape.com/l/dashboard/knowledge-rehab", "/decks");
    }
}
