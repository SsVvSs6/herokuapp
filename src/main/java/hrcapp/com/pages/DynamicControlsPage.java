package hrcapp.com.pages;

/*
Найти чекбокс
Нажать на кнопку
Дождаться надписи “It’s gone”
Проверить, что чекбокса нет
Найти инпут
Проверить, что он disabled
Нажать на кнопку
Дождаться надписи “It's enabled!”
Проверить, что инпут enabled
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class DynamicControlsPage extends BasePage {

    @FindBy (xpath = "//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy (xpath = "//form[@id='checkbox-example']//button")
    private WebElement removeCheckboxButton;

    @FindBy (xpath = "//form[@id='checkbox-example']//p")
    private WebElement checkboxIsRemovedText;

    @FindBy (xpath = "//input[@type='text']")
    private WebElement input;

    @FindBy (xpath = "//form[@id='input-example']//button")
    private WebElement inputEnableButton;

    @FindBy (xpath = "//form[@id='input-example']//p")
    private WebElement inputIsEnableText;

    public DynamicControlsPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public DynamicControlsPage clickRemoveCheckboxButton() {
        removeCheckboxButton.click();
        return this;
    }

    public DynamicControlsPage clickInputEnableButton() {
        inputEnableButton.click();
        return this;
    }

    public ArrayList<WebElement> findCheckbox() {
        return new ArrayList<>(driver.findElements(By.xpath("//input[@type='checkbox']")));
    }

    public ArrayList<WebElement> getCheckbox() {
        return new ArrayList<>(driver.findElements(By.xpath("//input[@type='checkbox']")));
    }

    public WebElement getCheckboxIsRemovedText() {
        return checkboxIsRemovedText;
    }

    public WebElement getInput() {
        return input;
    }

    public WebElement getInputIsEnableText() {
        return inputIsEnableText;
    }
}
