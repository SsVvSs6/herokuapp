package hrcapp.com.pages;

import hrcapp.com.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private static final int WAIT_TIMEOUT_SECONDS = 10;
    protected WebDriver driver = DriverSingleton.getDriver();

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement waitVisibilityOf(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
