package hrcapp.com.tests;

import hrcapp.com.services.ContextMenuService;
import org.openqa.selenium.Alert;
import hrcapp.com.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    private static final String CONTEXT_MENU_PAGE_URL = "http://the-internet.herokuapp.com/context_menu";
    private static final String EXPECTED_ALERT_TEXT = "You selected a context menu";
    protected ContextMenuPage contextMenuPage = new ContextMenuPage();
    protected ContextMenuService contextMenuService = new ContextMenuService();
    Alert alert;

    @BeforeTest
    public void openAlert() {
        contextMenuPage.openPage(CONTEXT_MENU_PAGE_URL).clickHotSpotByRight();
    }

    @Test
    public void verifyAlertIsOpenedTest() {
        boolean alertIsOpen = contextMenuService.checkAlertIsNotShown(driver);
        Assert.assertFalse(alertIsOpen, "Alert is not opened");
    }

    @Test (dependsOnMethods = "verifyAlertIsOpenedTest")
    public void verifyAlertTextTest() {
        String alertActualText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertActualText, EXPECTED_ALERT_TEXT, "Alert text does not match expected");
    }

    @Test (dependsOnMethods = "verifyAlertIsOpenedTest")
    public void verifyAlertIsClosedText() {
        alert = driver.switchTo().alert();
        contextMenuPage.closeAlert(alert);
        boolean alertIsClosed = contextMenuService.checkAlertIsNotShown(driver);
        Assert.assertTrue(alertIsClosed, "Alert was not closed");
    }
}
