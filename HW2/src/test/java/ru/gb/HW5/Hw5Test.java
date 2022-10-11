package ru.gb.HW5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.BooleanSupplier;

public class Hw5Test {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver(){

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void SauceDemoTest () throws InterruptedException {
        actions.sendKeys(driver.findElement(By.id("user-name")), "standard_user")
                .perform();
        actions.sendKeys(driver.findElement(By.id("password")), "secret_sauce")
                .perform();
        actions.click(driver.findElement(By.id("login-button")))
                .perform();
        actions.moveToElement(driver.findElement(By.id("item_3_title_link")))
                .click(driver.findElement(By.id("item_3_title_link")))
                        .perform();
        actions.moveToElement(driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")))
                .click()
                        .perform();
        actions.moveToElement(driver.findElement(By.id("shopping_cart_container")))
                .click()
                        .perform();
        actions.moveToElement(driver.findElement(By.id("checkout")))
                .click()
                        .perform();

        actions.sendKeys(driver.findElement(By.id("first-name")), "Aleksey")
                .perform();
        actions.sendKeys(driver.findElement(By.id("last-name")), "Petrovich")
                .perform();
        actions.sendKeys(driver.findElement(By.id("postal-code")), "145321")
                .perform();

        actions.moveToElement(driver.findElement(By.id("continue")))
                .click()
                        .perform();
        actions.moveToElement(driver.findElement(By.id("finish")))
                .click()
                        .perform();

        Assertions.assertTrue(driver.getCurrentUrl().contains("complete"));

        //actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
        //                 .perform();
        //driver.findElement(By.xpath("//div[@data-test='HEADER-MENU']//a[.='Скоро онлайн в Okko']")).click();
        // Assertions.assertTrue(driver.getCurrentUrl().contains("okko"));


Thread.sleep(5000);




    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
