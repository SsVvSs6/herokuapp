package hrcapp.com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenuPage extends BasePage {

    @FindBy (xpath = "//div[@id='hot-spot']")
    private WebElement hotSpot;

    public ContextMenuPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void clickHotSpotByRight() {
        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform();
    }

    public Alert switchToAlert() {
        return driver.switchTo().alert();
    }
}
