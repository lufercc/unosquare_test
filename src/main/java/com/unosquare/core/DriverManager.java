package com.unosquare.core;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static DriverManager driverManager;
    private WebDriver driver;

    private DriverManager(){
        String browser = Environment.getInstance().getValue("$['browser']");
        this.driver = DriverFactory.createDriver(browser);
        this.driver.manage().window().maximize();
    }

    public static DriverManager getInstance(){
        if(driverManager == null){
            driverManager = new DriverManager();
        }
        return driverManager;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit(){
        this.driver.quit();
        driverManager = null;
    }

    public void maximize(){
        driver.manage().window().maximize();
    }
}
