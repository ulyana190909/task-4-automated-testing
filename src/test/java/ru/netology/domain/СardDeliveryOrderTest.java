package ru.netology.domain;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class СardDeliveryOrderTest {

    @Test
    void shouldSendValidRequest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Смоленск");
        $("[data-test-id='date'] .input__control").setValue("15.11.2020");
        $("[data-test-id='name'] .input__control").setValue("Смирнова Юлия");
        $("[data-test-id='phone'] .input__control").setValue("+78542586320");
        $("[data-test-id='agreement']").click();
        $$("[type='button']").find(exactText("Забронировать")).click();
        $(byText("Встреча успешно забронирована на")).waitUntil(visible, 15000);
    }
}