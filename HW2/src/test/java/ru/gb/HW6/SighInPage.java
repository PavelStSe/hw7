package ru.gb.HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.time.Duration;

public class SighInPage extends BasePage {


    public SighInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    public WebElement SighInButton;

@Step("Заполнить поля логин, пароль и кликнуть войти")
    public void login(String login, String password) {
        userNameField.sendKeys(login);
        passwordField.sendKeys(password);
        SighInButton.click();
    }
}







    //actions.sendKeys(driver.findElement(By.id("user-name")), "standard_user")
    //        .perform();
    // actions.sendKeys(driver.findElement(By.id("password")), "secret_sauce")
    //       .perform();
    //actions.click(driver.findElement(By.id("login-button")))
    //        .perform();

