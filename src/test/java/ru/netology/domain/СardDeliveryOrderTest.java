package ru.netology.domain;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class СardDeliveryOrderTest {

    @Test
    void shouldSendValidRequest() {
        open("http://localhost:9999");
        $("[data-test-id='city']").setValue("Красноярск");
        $("[data-test-id='date']").setValue("05.11.2020");
        $("[data-test-id='name']").setValue("Малышев Петр");
        $("[data-test-id='phone']").setValue("+78542586320");
        $("[data-test-id='agreement']").click();
        $$("button__text").find(exactText("Забронировать")).click();
        $(withText("Встреча успешно забронирована на 05.11.2020")).waitUntil(visible, 15000);
    }
}
