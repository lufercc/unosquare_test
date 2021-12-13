package com.unosquare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHelpService extends AbstractPage {
    @FindBy(css = "#helpsearch")
    WebElement helpInput;

    private static final String optionSelect = "//div[@class=\"cs-help-search-results\"]//a[contains(text(), \"%s\")]";
    private static final String linksContains = "//div[@id=\"links-contain\"]//h3[contains(text(), \"%s\")]";

    @Override
    public void openPage() {
    }


    public void findHelpService(String textHelp){
        action.sendText(helpInput, textHelp + Keys.ENTER);
    }

    public void select(String option){
        action.click(By.xpath(String.format(optionSelect, option)));
    }

    public boolean optionIsVisible(String option){
        return action.isElementPresent(By.xpath(String.format(linksContains, option)));
    }

}
