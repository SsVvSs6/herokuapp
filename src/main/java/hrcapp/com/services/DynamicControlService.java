package hrcapp.com.services;

import hrcapp.com.pages.DynamicControlsPage;

public class DynamicControlService {

    protected DynamicControlsPage dynamicControlPage = new DynamicControlsPage();

    public boolean checkCheckboxIsVisible() {
        return dynamicControlPage.getCheckbox().size() != 0;
    }

    public boolean checkInputIsEnable() {
        return dynamicControlPage.getInput().isEnabled();
    }
}
