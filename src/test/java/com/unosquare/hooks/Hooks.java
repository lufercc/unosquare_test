package com.unosquare.hooks;

import com.unosquare.core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @After
    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            WebDriver driver = DriverManager.getInstance().getDriver();
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
    }

    @After
    public void close(){
        DriverManager.getInstance().quit();
    }
}
