package com.unosquare.pages;

import com.unosquare.core.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class AmazonPage extends AbstractPage {

    private String url = Environment.getInstance().getValue("$['amazon_url']");

    @FindBy(css = "#nav-flyout-ya-newCust>a")
    private WebElement StartHere;

    @FindBy(xpath = "//div[@id=\"legalTextRow\"]/a[contains(text(), \"Conditions of Use\")]")
    WebElement conditionUse;

    private final String MENU = "//li[@class= 'single-link js-nav-menu uhf-menu-item']/a[contains(text(), \"%s\")]";
    private final String ACCOUNT_LIST = "#nav-link-accountList";

    private HashMap<String, WebElement> links = new HashMap<>();

    public AmazonPage(){
        links.put("Start_Here", StartHere);
        links.put("Condition_of_Use", conditionUse);
    }


    @Override
    public void openPage() {
        driver.get(url);
    }

    public void hoverAccountList(){
        action.hover(By.cssSelector(ACCOUNT_LIST));
    }

    public void clickOn(String option){
        action.click(links.get(option));
    }
}
