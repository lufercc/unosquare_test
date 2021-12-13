package com.unosquare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MicrosoftWindowsPage extends AbstractPage {

    private final String MENU = "//li[contains(@class, 'uhf-menu-item')]//button[contains(text(), '%s')]";
    private final String SUBMENU = "//li[@class = 'f-sub-menu js-nav-menu nested-menu']//button[contains(text(), '%s')]";
    private final String WIN_OPTIONS = "//span[contains(text(), 'Windows 10')]/parent :: li[@class = 'f-sub-menu js-nav-menu nested-menu']//li//a";

    @Override
    public void openPage() {
        // no enable to open directly the menu /// can be implemented LuisCachi
    }

    public void goMenu(String menu) {
        action.click(By.xpath(String.format(MENU, menu)));
    }

    public void goSubmenu(String submenu){
        action.hover(By.xpath(String.format(SUBMENU, submenu)));
    }

    public void listSubMenu(){
        List<WebElement> result = driver.findElements(By.xpath(WIN_OPTIONS));
        System.out.println("the follow options are displayed: \n");
        for (WebElement item: result) {
            System.out.println(action.getText(item));
        }

    }
}
