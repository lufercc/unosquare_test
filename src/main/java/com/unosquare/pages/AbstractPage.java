package com.unosquare.pages;

import com.unosquare.core.DriverManager;
import com.unosquare.core.WebDriverAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverAction action;

    public AbstractPage(){
        this.driver = DriverManager.getInstance().getDriver();
        this.wait = new WebDriverWait(this.driver, 30);
        this.action = new WebDriverAction(driver, this.wait);

        PageFactory.initElements(this.driver, this);
    }

    public abstract void openPage();

}
