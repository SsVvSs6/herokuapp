package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN
 * Локатор By.tagName(“input”)
 */

public class InputsTest {

    private WebDriver driver;
    private final String INPUTS_LINK = "http://the-internet.herokuapp.com/inputs";
    private final String INPUTS_TAG_NAME = "input";
    private final String DIGITS_VALUE = "10";
    private final String LATIN_VALUE = "Latin";
    private final String CYRILLIC_VALUE = "Кириллица";
    private final String SPECIAL_CHARACTER_VALUE = "!@#$%^&*";
    private final String DIGITS_VALUE_ARROW_UP = "1";
    private final String DIGITS_VALUE_ARROW_DOWN = "-1";

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
    public void enterDigitsValueWithKeyboardTest() {
        driver.get(INPUTS_LINK);
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).sendKeys(DIGITS_VALUE);
        String enteredValue = driver.findElement(By.tagName(INPUTS_TAG_NAME)).getAttribute("value");
        Assert.assertEquals(enteredValue, DIGITS_VALUE);
    }

    @Test
    public void enterLatinValueWithKeyboardTest() {
        driver.get(INPUTS_LINK);
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).sendKeys(LATIN_VALUE);
        String enteredValue = driver.findElement(By.tagName(INPUTS_TAG_NAME)).getAttribute("value");
        Assert.assertEquals(enteredValue, LATIN_VALUE);
    }

    @Test
    public void enterCyrillicValueWithKeyboardTest() {
        driver.get(INPUTS_LINK);
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).sendKeys(CYRILLIC_VALUE);
        String enteredValue = driver.findElement(By.tagName(INPUTS_TAG_NAME)).getAttribute("value");
        Assert.assertEquals(enteredValue, CYRILLIC_VALUE);
    }

    @Test
    public void enterSpecialCharacterValueWithKeyboardTest() {
        driver.get(INPUTS_LINK);
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).sendKeys(SPECIAL_CHARACTER_VALUE);
        String enteredValue = driver.findElement(By.tagName(INPUTS_TAG_NAME)).getAttribute("value");
        Assert.assertEquals(enteredValue, SPECIAL_CHARACTER_VALUE);
    }

    @Test
    public void enterDigitsWithArrowsUpTest() {
        driver.get(INPUTS_LINK);
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).click();
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).sendKeys(Keys.ARROW_UP);
        String enteredValue = driver.findElement(By.tagName(INPUTS_TAG_NAME)).getAttribute("value");
        Assert.assertEquals(enteredValue, DIGITS_VALUE_ARROW_UP);
    }

    @Test
    public void enterDigitsWithArrowsDownTest() {
        driver.get(INPUTS_LINK);
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).click();
        driver.findElement(By.tagName(INPUTS_TAG_NAME)).sendKeys(Keys.ARROW_DOWN);
        String enteredValue = driver.findElement(By.tagName(INPUTS_TAG_NAME)).getAttribute("value");
        Assert.assertEquals(enteredValue, DIGITS_VALUE_ARROW_DOWN);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
