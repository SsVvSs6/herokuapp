package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Взять все элементы дроп-дауна и проверить их наличие. Выбрать первый, проверить, что он выбран,
 * выбрать второй, проверить, что он выбран
 * Локатор By.id(“dropdown”)
 */

public class DropdownListTest {

    private WebDriver driver;
    private final String DROPDOWN_LINK = "http://the-internet.herokuapp.com/dropdown";
    private final String DROPDOWN_ID = "dropdown";
    private final String DROPDOWN_VALUES = "[Please select an option, Option 1, Option 2]";
    private final String FIRST_DROPDOWN_OPTION = "Option 1";
    private final String SECOND_DROPDOWN_OPTION = "Option 2";

    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyElementsInDropdownTest() {
        driver.get(DROPDOWN_LINK);
        Select select = new Select(driver.findElement(By.id(DROPDOWN_ID)));
        ArrayList<WebElement> dropdownElements = (ArrayList<WebElement>) select.getOptions();
        ArrayList<String> dropdownElementsText = new ArrayList<>();
        for (int i = 0; i < dropdownElements.size(); i++) {
            dropdownElementsText.add(dropdownElements.get(i).getText());
        }
        Assert.assertEquals(dropdownElementsText.toString(), DROPDOWN_VALUES);
    }

    @Test
    public void selectFirstOptionTest() {
        driver.get(DROPDOWN_LINK);
        Select select = new Select(driver.findElement(By.id(DROPDOWN_ID)));
        select.selectByVisibleText(FIRST_DROPDOWN_OPTION);
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, FIRST_DROPDOWN_OPTION);
    }

    @Test
    public void selectSecondOptionTest() {
        driver.get(DROPDOWN_LINK);
        Select select = new Select(driver.findElement(By.id(DROPDOWN_ID)));
        select.selectByVisibleText(SECOND_DROPDOWN_OPTION);
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, SECOND_DROPDOWN_OPTION);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
