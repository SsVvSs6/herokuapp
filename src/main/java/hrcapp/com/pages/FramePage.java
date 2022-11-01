package hrcapp.com.pages;

/**
 * Открыть iFrame
 * Проверить, что текст внутри параграфа равен “Your content goes here.”
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage {

    @FindBy(xpath = "//a[@href='/iframe']")
    private WebElement iFrameHyperlink;

    @FindBy(xpath = "//div[@class='example']/h3")
    private WebElement iFrameLabel;

    @FindBy(xpath = "//body[@id='tinymce']/p")
    private WebElement iFrameContentText;

    public FramePage openPage(String url) {
        driver.get(url);
        return this;
    }

    public void clickIFrameHyperlink() {
        iFrameHyperlink.click();
    }

    public WebElement getIFrameLabel() {
        return iFrameLabel;
    }

    public WebElement getIFrameContentText() {
        return iFrameContentText;
    }

    public void switchToFrame() {
        driver.switchTo().frame("mce_0_ifr");
    }
}
