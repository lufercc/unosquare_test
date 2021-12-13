package com.unosquare.pages;

import com.unosquare.core.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MicrosoftPage extends AbstractPage {

    private String url = Environment.getInstance().getValue("$['google_url']");

    private final String MENU = "//li[@class= 'single-link js-nav-menu uhf-menu-item']/a[contains(text(), \"%s\")]";
    private final String SEARCH_BUTTON = "#search";
    private final String SEARCH_INPUT = "input#cli_shellHeaderSearchInput";
    private final String REDIRECT_CLOSE = "#R1MarketRedirect-close";
    private final String SHOP_BUTTON = "header[role] > a[aria-label = 'shop pivot']";

    @Override
    public void openPage() {
        driver.get(url);
    }

    public boolean menuIsDisplayed(String locatorString){
        return action.isElementPresent(By.xpath(String.format(MENU, locatorString)));
    }

    public void goMenu(String menu) {
        action.click(By.xpath(String.format(MENU, menu)));
    }

    public void searchWord(String lookForWorld){
        action.click(By.cssSelector(SEARCH_BUTTON));
        action.sendText(By.cssSelector(SEARCH_INPUT), lookForWorld + Keys.ENTER);
        if (action.isElementPresent(By.cssSelector(REDIRECT_CLOSE))){
            action.click(By.cssSelector(REDIRECT_CLOSE));
        }
        action.click(By.cssSelector(SHOP_BUTTON));
    }
}
