package ru.gb.HW6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutOverviewPage extends  BasePage{
    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "finish")
    private WebElement finishButton;
    @Step("Нажать на кнопку Finish")
    public void finishButtonClick(){
        actions.moveToElement(finishButton).click()
                .perform();
    }
}
//actions.moveToElement(driver.findElement(By.id("finish")))
//                .click()
//                        .perform();