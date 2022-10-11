package ru.gb.HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TShirtPage extends BasePage {
    public TShirtPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "add-to-cart-test.allthethings()-t-shirt-(red)" )
    private WebElement AddToCartButton;
    @Step("Нажать на кнопку Добавить в корзину")
    public void ClickOnAddToCArtButton(){
        actions.moveToElement(AddToCartButton).click()
                .perform();
    }
    @FindBy (id = "shopping_cart_container")
    private WebElement CartButton;
    @Step("Нажать на корзину для перехода в неё")
    public void ClickOnCartButton() {
        actions.moveToElement(CartButton).click()
                .perform();
    }
}
//actions.moveToElement(driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")))
//       .click()
//       .perform();
//actions.moveToElement(driver.findElement(By.id("shopping_cart_container")))
//        .click()
//       .perform();