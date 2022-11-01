package hrcapp.com.tests;

import hrcapp.com.pages.UploadFilePage;
import hrcapp.com.services.UploadFileService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileTest {

    private static final String UPLOAD_FILE_PAGE_URL = "http://the-internet.herokuapp.com/upload";
    private static final String FILE_NAME = "image_2022-09-26_20-02-43.png";
    UploadFilePage uploadFilePage;
    UploadFileService uploadFileService;

    @BeforeTest
    public void openPage() {
        uploadFilePage = new UploadFilePage();
        uploadFileService = new UploadFileService();
        uploadFilePage.openPage(UPLOAD_FILE_PAGE_URL);
    }

    @Test
    public void verifyUploadFileTest() {
        uploadFileService.submitUploadFile();
        String fileName = uploadFilePage.getFileName().getText();
        Assert.assertEquals(fileName, FILE_NAME);
    }
}
