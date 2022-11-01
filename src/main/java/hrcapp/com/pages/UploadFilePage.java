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

    @FindBy (xpath = "//div[@id='drag-drop-upload']")
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

    public WebElement getUploadFileDragAndDrop() {
        return uploadFileDragAndDrop;
    }

    public void clickFileUploadButton() {
        fileUploadButton.click();
    }

    public WebElement getFileUploadButton() {
        return fileUploadButton;
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
}
