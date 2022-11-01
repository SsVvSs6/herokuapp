package hrcapp.com.tests;

import hrcapp.com.pages.FramePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    private static final String FRAME_PAGE_URL = "http://the-internet.herokuapp.com/frames";
    private static final String FRAME_TEXT = "Your content goes here.";
    FramePage framePage;

    @BeforeTest
    public void openPage() {
        framePage = new FramePage();
        framePage.openPage(FRAME_PAGE_URL);
    }

    @Test
    public void verifyOpenFrameTest() {
        framePage.clickIFrameHyperlink();
        framePage.waitVisibilityOf(framePage.getIFrameLabel());
        framePage.switchToFrame();
        String frameText = framePage.getIFrameContentText().getText();
        Assert.assertEquals(frameText, FRAME_TEXT);
    }
}
