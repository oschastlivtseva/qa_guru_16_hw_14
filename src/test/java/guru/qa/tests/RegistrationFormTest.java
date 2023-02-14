package guru.qa.tests;

import guru.qa.utils.UserData;
import guru.qa.utils.UserDataGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormTest extends TestBase {
    UserDataGenerator userDataGenerator = new UserDataGenerator();
    UserData userData = userDataGenerator.generateUserData();

    @Test
    @Feature("Registration")
    @Story("Registration form visibility")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check registration form visibility")
    @Owner("oschastlivtseva")
    public void checkRegistrationFormVisibility() {
        landingPage.clickOnLandingPage(landingPage.registrationButton);
        generalActions.checkVisibility(modalPage.registrationModalWindow);
        modalPage.checkModalTitle("Get Started");
        generalActions
                .checkVisibility(modalPage.appleLoginButton)
                .checkVisibility(modalPage.googleLoginButton)
                .checkVisibility(modalPage.firstNameInput)
                .checkVisibility(modalPage.lastNameInput)
                .checkVisibility(modalPage.emailInput)
                .checkVisibility(modalPage.passwordInput)
                .checkVisibility(modalPage.passwordConfirmation)
                .checkVisibility(modalPage.acceptTermsButton)
                .checkVisibility(modalPage.registrationSubmitButton)
                .checkVisibility(modalPage.alreadyHaveAccountButton)
                .checkVisibility(modalPage.closeModalButton);
    }

    @Test
    @Feature("Registration")
    @Story("Successful registration")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Check successful registration")
    @Owner("oschastlivtseva")
    public void checkSuccessfulRegistration() {
        landingPage.clickOnLandingPage(landingPage.registrationButton);
        generalActions.checkVisibility(modalPage.registrationModalWindow);
        modalPage
                .setFirstName(userData.getFirstName())
                .setLastName(userData.getLastName())
                .setEmail(userData.getEmail())
                .setPassword(userData.getPassword())
                .confirmPassword(userData.getPassword())
                .clickAcceptAgreement();
        generalActions.checkButtonIsEnabled(modalPage.registrationSubmitButton);
// TODO: Some of the checks are disabled to avoid the creation of new test accounts
//        modalPage.clickSubmitButton(modalPage.registrationSubmitButton);
//        generalActions.checkElementIsNotVisible(modalPage.errorAlert);
//        accountPage.checkUserName(userData.getFirstName() + " " + userData.getLastName());
//        generalActions.checkVisibility(accountPage.courseHeader);
//        accountPage.checkBubbleWithTitle("Welcome");
//        generalActions.checkThatURLContains(
//          "https://www.brainscape.com/l/dashboard/knowledge-rehab",
//          "/decks?reg=complete"
//          );
    }

    @Test
    @Feature("Registration")
    @Story("Failed registration")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Check registration failed due to existing email")
    @Owner("oschastlivtseva")
    public void checkFailedRegistration() {
        landingPage.clickOnLandingPage(landingPage.registrationButton);
        generalActions.checkVisibility(modalPage.registrationModalWindow);
        modalPage
                .setFirstName(userData.getFirstName())
                .setLastName(userData.getLastName())
                .setEmail(autotestUserEmail)
                .setPassword(userData.getPassword())
                .confirmPassword(userData.getPassword())
                .clickAcceptAgreement();
        generalActions
                .checkButtonIsEnabled(modalPage.registrationSubmitButton);
        modalPage
                .clickSubmitButton(modalPage.registrationSubmitButton)
                .checkAlert("This email is already registered.");
        generalActions.checkThatURLDoesNotContain(
                "https://www.brainscape.com/l/dashboard/knowledge-rehab",
                "/decks?reg=complete"
        );
    }

}
