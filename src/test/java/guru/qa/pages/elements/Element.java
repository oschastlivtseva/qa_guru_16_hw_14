package guru.qa.pages.elements;

import com.codeborne.selenide.SelenideElement;

public class Element {

    private String name;
    private SelenideElement selenideElement;

    public Element(String name, SelenideElement selenideElement) {
        this.name = name;
        this.selenideElement = selenideElement;
    }

    public String getName() {
        return name;
    }

    public SelenideElement getElement() {
        return selenideElement;
    }
}
