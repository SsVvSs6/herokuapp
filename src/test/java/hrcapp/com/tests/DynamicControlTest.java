package hrcapp.com.tests;

import hrcapp.com.pages.DynamicControlsPage;
import hrcapp.com.services.DynamicControlService;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicControlTest {

    private static final String DYNAMIC_CONTROL_PAGE_URL = "http://the-internet.herokuapp.com/dynamic_controls";

    DynamicControlsPage dynamicControlsPage;
    DynamicControlService dynamicControlService;

    @BeforeTest
    public void openPage() {
        dynamicControlsPage = new DynamicControlsPage();
        dynamicControlService = new DynamicControlService();
        dynamicControlsPage.openPage(DYNAMIC_CONTROL_PAGE_URL);
    }

    @Test
    public void verifyCheckboxIsDisplayedTest() {
        boolean checkboxIsDisplayed = dynamicControlService.checkCheckboxIsVisible();
        Assert.assertTrue(checkboxIsDisplayed);
    }

    @Test
    public void verifyCheckboxIsNotDisplayedTest() {
        dynamicControlsPage.clickRemoveCheckboxButton()
                .waitVisibilityOf(dynamicControlsPage.getCheckboxIsRemovedText());
        boolean checkboxIsNotDisplayed = dynamicControlService.checkCheckboxIsVisible();
        Assert.assertFalse(checkboxIsNotDisplayed);
    }

    @Test
    public void verifyInputIsDisabledTest() {
        boolean inputIsEnable = dynamicControlService.checkInputIsEnable();
        Assert.assertFalse(inputIsEnable);
    }

    @Test
    public void verifyInputIsEnableTest() {
        dynamicControlsPage.clickInputEnableButton().waitVisibilityOf(dynamicControlsPage.getInputIsEnableText());
        boolean inputIsDisable = dynamicControlService.checkInputIsEnable();
        Assert.assertTrue(inputIsDisable);
    }
}
