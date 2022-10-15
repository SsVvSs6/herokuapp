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
 * добавить 2 элемента, удалить элемент, проверить количество элементов
 * Локаторы xpath:
 * By.xpath("//button[text()='Add Element']")
 * By.xpath("//button[text()='Delete']")
 */

public class AddAndRemoteElementsTest {

    private WebDriver driver;
    private final int AFTER_REMOVE_SECOND_ELEMENT_COUNT = 1;
    private final int ADD_ONE_ELEMENT_COUNT = 1;
    private final int ADD_TWO_ELEMENTS_COUNT = 2;

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
    public void addOneElementTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        ArrayList<WebElement> actualElements = (ArrayList<WebElement>)
                driver.findElements(By.xpath("//button[text()='Delete']"));
        int actualElementsNumber = actualElements.size();
        Assert.assertEquals(actualElementsNumber, ADD_ONE_ELEMENT_COUNT);
    }

    @Test
    public void addTwoElementsTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        ArrayList<WebElement> actualElements = (ArrayList<WebElement>)
                driver.findElements(By.xpath("//button[text()='Delete']"));
        int actualElementsNumber = actualElements.size();
        Assert.assertEquals(actualElementsNumber, ADD_TWO_ELEMENTS_COUNT);
    }

    @Test
    public void addAndRemoveSecondElementTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        ArrayList<WebElement> actualElements = (ArrayList<WebElement>)
                driver.findElements(By.xpath("//button[text()='Delete']"));
        int actualElementsNumber = actualElements.size();
        Assert.assertEquals(actualElementsNumber, AFTER_REMOVE_SECOND_ELEMENT_COUNT);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
