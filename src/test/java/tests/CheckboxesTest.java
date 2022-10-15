package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * проверить, что первый чекбокс unchecked, отметить первый чекбокс, проверить что он checked.
 * Проверить, что второй чекбокс checked, сделать unheck, проверить, что он unchecked
 * Локатор By.cssSelector(“[type=checkbox]”)
 */

public class CheckboxesTest {

    private WebDriver driver;
    private final String CHECKBOX_LINK = "http://the-internet.herokuapp.com/checkboxes";
    private final String CHECKBOX_CSS_SELECTOR = "[type=checkbox]";
    private final int FIRST_CHECKBOX_INDEX = 0;
    private final int SECOND_CHECKBOX_INDEX = 1;
    private final String CHECKBOX_IS_SELECTED_TEXT = "Checkbox is selected";
    private final String CHECKBOX_IS_UNSELECTED_TEXT = "Checkbox is unselected";

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
    public void verifyFirstCheckboxIsUncheckedTest() {
        driver.get(CHECKBOX_LINK);
        ArrayList<WebElement> checkboxes = (ArrayList<WebElement>)
                driver.findElements(By.cssSelector(CHECKBOX_CSS_SELECTOR));
        boolean isCheckboxSelected = checkboxes.get(FIRST_CHECKBOX_INDEX).isSelected();
        Assert.assertFalse(isCheckboxSelected, CHECKBOX_IS_SELECTED_TEXT);
    }

    @Test
    public void selectFirstCheckboxTest() {
        driver.get(CHECKBOX_LINK);
        ArrayList<WebElement> checkboxes = (ArrayList<WebElement>)
                driver.findElements(By.cssSelector(CHECKBOX_CSS_SELECTOR));
        WebElement checkboxElement = checkboxes.get(FIRST_CHECKBOX_INDEX);
        checkboxElement.click();
        boolean isCheckboxSelected = checkboxes.get(FIRST_CHECKBOX_INDEX).isSelected();
        Assert.assertTrue(isCheckboxSelected, CHECKBOX_IS_UNSELECTED_TEXT);
    }

    @Test
    public void verifySecondCheckboxIsUncheckedTest() {
        driver.get(CHECKBOX_LINK);
        ArrayList<WebElement> checkboxes = (ArrayList<WebElement>)
                driver.findElements(By.cssSelector(CHECKBOX_CSS_SELECTOR));
        boolean isCheckboxSelected = checkboxes.get(SECOND_CHECKBOX_INDEX).isSelected();
        Assert.assertTrue(isCheckboxSelected, CHECKBOX_IS_UNSELECTED_TEXT);
    }

    @Test
    public void unselectSecondCheckboxTest() {
        driver.get(CHECKBOX_LINK);
        ArrayList<WebElement> checkboxes = (ArrayList<WebElement>)
                driver.findElements(By.cssSelector(CHECKBOX_CSS_SELECTOR));
        WebElement checkboxElement = checkboxes.get(SECOND_CHECKBOX_INDEX);
        checkboxElement.click();
        boolean isCheckboxSelected = checkboxes.get(SECOND_CHECKBOX_INDEX).isSelected();
        Assert.assertFalse(isCheckboxSelected, CHECKBOX_IS_SELECTED_TEXT);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
