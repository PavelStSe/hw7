package ru.gb.HW6;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutInformation extends BasePage {
    public CheckOutInformation(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    public WebElement postalCodeField;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @Step("Заполнить поля First name, Last name, Postal code и кликнуть Continue")
    public void InputCheckOutInfo(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        actions.moveToElement(continueButton).click()
                .perform();

    }
}
//actions.sendKeys(driver.findElement(By.id("first-name")), "Aleksey")
//                .perform();
//        actions.sendKeys(driver.findElement(By.id("last-name")), "Petrovich")
//                .perform();
//        actions.sendKeys(driver.findElement(By.id("postal-code")), "145321")
//                .perform();
//actions.moveToElement(driver.findElement(By.id("continue")))
//                .click()