package ru.gb.HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "checkout")
    private WebElement CheckOutButton;
    @Step("нажать на кнопку Checkout")
    public void CheckOutButtonClick() {
        actions.moveToElement(CheckOutButton).click()
                .perform();
    }
}

//actions.moveToElement(driver.findElement(By.id("checkout")))
//                .click()
//                        .perform();