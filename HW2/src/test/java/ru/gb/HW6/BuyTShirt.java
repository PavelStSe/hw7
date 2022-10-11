package ru.gb.HW6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyTShirt {

WebDriver driver;
    @Step("Добавление товара в корзину")

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator<>(new AdditionalLogger()).decorate(new ChromeDriver());
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    @Feature("Покупка товара")
    void buyTShirtTest() throws InterruptedException {
        new SighInPage(driver).login("standard_user","secret_sauce");
        new InventoryPage(driver).ClickOnTheTShirt();
        new TShirtPage(driver).ClickOnAddToCArtButton();
        new TShirtPage(driver).ClickOnCartButton();
        new CartPage(driver).CheckOutButtonClick();
        new CheckOutInformation(driver).InputCheckOutInfo("Fedor", "Mikhailovich", "100200");
        new CheckOutOverviewPage(driver).finishButtonClick();

        Assertions.assertTrue(driver.getCurrentUrl().contains("complete"));
    }



    @AfterEach
    void tearDown() {
      //  LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
      //  for (LogEntry log: logs){
      //      Allure.addAttachment("Элемент лога браузера", log.getMessage());
       // }
        driver.quit();

    }
}


