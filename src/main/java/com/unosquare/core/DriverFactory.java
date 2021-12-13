package com.unosquare.core;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static final Map<String, AbstractDriver> DRIVERS = new HashMap<>();

    static {
        DRIVERS.put("chrome", new Chrome());
        DRIVERS.put("firefox", new FireFox());
    }

    public static WebDriver createDriver(String browser) {
        return DRIVERS.get(browser).initDriver();
    }
}
