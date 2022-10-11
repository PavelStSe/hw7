package ru.gb.HW6;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.ByteArrayInputStream;

public class AdditionalLogger implements WebDriverListener {
    public void beforeFindElement(WebDriver driver, By locator){
        Allure.step("Ищем метод по локатору:" + locator);
    }

    public void beforeQuit (WebDriver driver){
        Allure.addAttachment("Скриншот перелд закрытием браузера",
                new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

    }
}
