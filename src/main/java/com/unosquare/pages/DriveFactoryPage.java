package com.unosquare.pages;

import java.util.HashMap;
import java.util.Map;

public class DriveFactoryPage {

    private static final Map<String, AbstractPage> PAGES = new HashMap<>();

    static {
        PAGES.put("MICROSOFT_PAGE", new MicrosoftPage());
        PAGES.put("AMAZON_PAGE", new AmazonPage());
    }

    public static AbstractPage createMainPage(String pageName) {
        return PAGES.get(pageName);
    }

}
