package ru.netology.service;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ValidationTest {
    @Test
    void shouldNotTest() {

        open("http://localhost:9999");
        SelenideElement form = $(".form");
        form.$("[data-test-id=name] input").setValue("");
        form.$("[data-test-id=phone] input").setValue("+72930000000");
        form.$("[data-test-id=agreement] ").click();
        form.$(".button").click();
        form.$(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}
