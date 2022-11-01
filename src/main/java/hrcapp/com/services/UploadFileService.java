package hrcapp.com.services;

import hrcapp.com.pages.UploadFilePage;

public class UploadFileService {

    private static final String URL_TO_FILE =
            "/Users/svetlanaseredenko/Desktop/Courses/HomeWorks/Automatization/herokuapp/src/test/resources/image_2022-09-26_20-02-43.png";
    UploadFilePage uploadFilePage = new UploadFilePage();

    public void uploadFile() {
        uploadFilePage.dragAndDropFile(URL_TO_FILE);
    }

    public void submitUploadFile() {
        uploadFile();
        uploadFilePage.clickUploadSubmitButton();
        uploadFilePage.waitVisibilityOf(uploadFilePage.getSuccessUploadText());
    }
}
