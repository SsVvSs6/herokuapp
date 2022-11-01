package hrcapp.com.tests;

import hrcapp.com.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class ContextMenuTest extends BaseTest {

    private static final String CONTEXT_MENU_PAGE_URL = "http://the-internet.herokuapp.com/context_menu";
    private static final String EXPECTED_ALERT_TEXT = "You selected a context menu";
    protected ContextMenuPage contextMenuPage = new ContextMenuPage();

    @BeforeTest
    public void openPage() {
        contextMenuPage.openPage(CONTEXT_MENU_PAGE_URL).clickHotSpotByRight();
        contextMenuPage.waitAlert();
    }

    @Test
    public void verifyAlertTextTest() {
        String alertActualText = contextMenuPage.switchToAlert().getText();
        contextMenuPage.switchToAlert().accept();
        Assert.assertEquals(alertActualText, EXPECTED_ALERT_TEXT, "Alert text does not match expected");
    }
}
