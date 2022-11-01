package hrcapp.com.services;

import hrcapp.com.pages.UploadFilePage;

public class UploadFileService {

    UploadFilePage uploadFilePage = new UploadFilePage();

    public UploadFilePage uploadFile() {
        uploadFilePage.getUploadFileDragAndDrop().sendKeys("//herokuapp/src/test/resources");
        return new UploadFilePage();
    }

    public void submitUploadFile() {
        uploadFile();
        uploadFilePage.clickUploadSubmitButton();
        uploadFilePage.waitVisibilityOf(uploadFilePage.getSuccessUploadText());
    }
}
