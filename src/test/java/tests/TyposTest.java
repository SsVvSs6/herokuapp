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
 * Проверить соответствие параграфа орфографии
 * Локатор By.tagName(“p”)
 */

public class TyposTest {

    private WebDriver driver;
    private final String TYPOS_LINK = "http://the-internet.herokuapp.com/typos";
    private final String TYPOS_ID = "p";
    private final int TESTED_TEXT_INDEX = 1;
    private final String CORRECT_TYPO_TEXT = "Sometimes you'll see a typo, other times you won't.";

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
    public void verifyCorrectTypoTextTest() {
        driver.get(TYPOS_LINK);
        ArrayList<WebElement> pageTexts = (ArrayList<WebElement>)
                driver.findElements(By.tagName(TYPOS_ID));
        String actualText = pageTexts.get(TESTED_TEXT_INDEX).getText();
        Assert.assertEquals(actualText, CORRECT_TYPO_TEXT);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
