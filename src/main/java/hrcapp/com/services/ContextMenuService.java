package hrcapp.com.services;

import org.openqa.selenium.WebDriver;

public class ContextMenuService {

    public boolean checkAlertIsNotShown(WebDriver driver) {
        return null != driver.switchTo().alert();
    }
}
