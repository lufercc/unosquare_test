package com.unosquare.steps;

import com.unosquare.pages.AbstractPage;
import com.unosquare.pages.DriveFactoryPage;
import io.cucumber.java.en.Given;

public class MainStepDefinition {

    @Given("I open {string}")
    public void iOpen(String url_page) {
        AbstractPage page = DriveFactoryPage.createMainPage(url_page);
        page.openPage();
    }
}
