package ru.netology.domain;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class СardDeliveryOrderTest {

    @Test
    void setDayDelivery(){
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        }


    @Test
    void shouldSendValidRequestWithCalendar() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Красноярск");
        $("[data-test-id='date'] .input__control").setValue(setDayDelivery(););
        $("[data-test-id='name'] .input__control").setValue("Малышев Петр");
        $("[data-test-id='phone'] .input__control").setValue("+78542586320");
        $("[data-test-id='agreement']").click();
        $$("[type='button']").find(exactText("Забронировать")).click();
        $(byText("Встреча успешно забронирована на")).waitUntil(visible, 15000);
    }

    @Test
    void shouldSendValidRequest() {
        open("http://localhost:9999");
        $("[data-test-id='city'] .input__control").setValue("Красноярск");
        $("[data-test-id='date'] .input__control").setValue("31.10.2020");
        $("[data-test-id='name'] .input__control").setValue("Малышев Петр");
        $("[data-test-id='phone'] .input__control").setValue("+78542586320");
        $("[data-test-id='agreement']").click();
        $$("[type='button']").find(exactText("Забронировать")).click();
        $(byText("Встреча успешно забронирована на")).waitUntil(visible, 15000);
    }
}