package hrcapp.com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ContextMenuPage extends BasePage {

    @FindBy (xpath = "//div[@id='hot-spot']")
    private WebElement hotSpot;

    public ContextMenuPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void clickHotSpotByRight() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hotSpot).moveByOffset(10, 10).contextClick();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void closeAlert(Alert alert) {
        alert.accept();
    }
}
