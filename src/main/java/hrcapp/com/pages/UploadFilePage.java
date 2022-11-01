package hrcapp.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Загрузить файл
 * Проверить, что имя файла на странице совпадает с именем загруженного файла
 */

public class UploadFilePage extends BasePage {

    @FindBy (xpath = "//input[@id='file-upload']")
    private WebElement fileUploadButton;

    @FindBy (xpath = "//form/input[@type='file']")
    private WebElement uploadFileDragAndDrop;

    @FindBy (xpath = "//input[@id='file-submit']")
    private WebElement uploadSubmitButton;

    @FindBy (xpath = "//div[@id='uploaded-files']")
    private WebElement fileName;

    @FindBy (xpath = "//div/h3")
    private WebElement successUploadText;

    public UploadFilePage openPage(String url) {
        driver.get(url);
        return this;
    }

    public WebElement getFileName() {
        return fileName;
    }

    public WebElement getSuccessUploadText() {
        return successUploadText;
    }

    public void clickUploadSubmitButton() {
        uploadSubmitButton.click();
    }

    public UploadFilePage dragAndDropFile(String urlToFile) {
        uploadFileDragAndDrop.sendKeys(urlToFile);
        return this;
    }
}
