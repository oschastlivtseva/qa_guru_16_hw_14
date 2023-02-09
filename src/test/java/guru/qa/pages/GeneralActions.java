package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneralActions {

    public GeneralActions checkVisibility(SelenideElement element) {
        step("Check element visibility: " + element.name(), () -> {
            element.shouldBe(visible);
        });

        return this;
    }

    public GeneralActions checkElementIsNotVisible(SelenideElement element) {
        step("Check element is not visible", () -> {
            element.shouldNotBe(visible);
        });

        return this;
    }


    public GeneralActions inputInField(SelenideElement element, String value) {
        element.setValue(value);

        return this;
    }

    public GeneralActions click(SelenideElement element) {
        element.click();

        return this;
    }

    public GeneralActions checkButtonIsEnabled(SelenideElement element) {
        step("Check button is enabled", () -> {
            element.shouldNotHave(cssClass("is-disabled"));
        });

        return this;
    }

    public GeneralActions checkThatURLContains(CharSequence... expectedValue) {
        step("Check that current URL contains expected value", () -> {
            assertThat(url()).contains(expectedValue);
        });

        return this;
    }

    public GeneralActions checkThatURLDoesNotContain(CharSequence... expectedValue) {
        step("Check that current URL does not contain value", () -> {
            assertThat(url()).doesNotContain(expectedValue);
        });

        return this;
    }

    public GeneralActions checkThatElementContains(SelenideElement element, CharSequence... expectedValue) {
        step("Check that element contains expected value", () -> {
            assertThat(element.toString()).contains(expectedValue);
        });

        return this;
    }

    public GeneralActions switchToFrame(SelenideElement element) {
        step("Switch to another frame", () -> {
            switchTo().frame(element);
        });

        return this;
    }
}
