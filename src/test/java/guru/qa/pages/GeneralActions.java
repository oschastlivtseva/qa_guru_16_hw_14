package guru.qa.pages;

import guru.qa.pages.elements.Element;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class GeneralActions {

    public GeneralActions checkVisibility(Element element) {
        step("Check element visibility: " + element.getName(), () -> {
            element.getElement().shouldBe(visible);
        });

        return this;
    }

    public GeneralActions checkElementIsNotVisible(Element element) {
        step("Check element is not visible: " + element.getName(), () -> {
            element.getElement().shouldNotBe(visible);
        });

        return this;
    }


    public GeneralActions inputInField(Element element, String value) {
        element.getElement().setValue(value);

        return this;
    }

    public GeneralActions click(Element element) {
        element.getElement().click();

        return this;
    }

    public GeneralActions checkButtonIsEnabled(Element element) {
        step("Check that button is enabled: " + element.getName(), () -> {
            element.getElement().shouldNotHave(cssClass("is-disabled"));
        });

        return this;
    }

    public GeneralActions checkThatURLContains(CharSequence... expectedValue) {
        step("Check that current URL contains expected value: " + Arrays.toString(expectedValue), () -> {
            assertThat(url()).contains(expectedValue);
        });

        return this;
    }

    public GeneralActions checkThatURLDoesNotContain(CharSequence... expectedValue) {
        step("Check that current URL does not contain value: " + Arrays.toString(expectedValue), () -> {
            assertThat(url()).doesNotContain(expectedValue);
        });

        return this;
    }

    public GeneralActions checkThatElementContains(Element element, CharSequence... expectedValue) {
        step("Check that element " + element.getName() + " contains expected value: " + Arrays.toString(expectedValue), () -> {
            assertThat(element.getElement().toString()).contains(expectedValue);
        });

        return this;
    }

    public GeneralActions switchToFrame(Element element) {
        step("Switch to another frame", () -> {
            switchTo().frame(element.getElement());
        });

        return this;
    }
}
