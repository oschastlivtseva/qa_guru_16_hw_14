package guru.qa.pages;

import guru.qa.pages.elements.Element;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class AccountPage {

    public Element courseHeader = new Element("'Course Header'", $(".pack-header-main"));
    public Element userNameIcon = new Element("'User profile name'", $(".user-name"));
    public Element bubbleWithTitle = new Element("'Dialog bubble with title'", $(".bubble-title"));

    public AccountPage checkUserName(String nameAndSurname) {
        step("Check user name is: '" + nameAndSurname + "'", () -> {
            userNameIcon.getElement().shouldHave(attribute("title", nameAndSurname)).shouldBe(visible);
        });

        return this;
    }

    public AccountPage checkBubbleWithTitle(String title) {
        step("Check bubble dialog with title: " + title, () -> {
            bubbleWithTitle.getElement().shouldHave(text(title)).shouldBe(visible);
        });

        return this;
    }
}
