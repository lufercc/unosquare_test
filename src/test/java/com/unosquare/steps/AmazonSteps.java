package com.unosquare.steps;

import com.unosquare.core.RequestManager;
import com.unosquare.pages.AmazonHelpService;
import com.unosquare.pages.AmazonNewAccountPage;
import com.unosquare.pages.AmazonPage;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Hashtable;
import java.util.List;

public class AmazonSteps {

    private AmazonPage amazonPage;
    private AmazonNewAccountPage newAccountPage;
    private AmazonHelpService amazonHelpService;

    private Hashtable<String, Object> variables = new Hashtable<>();

    public AmazonSteps(AmazonPage amazonPage, AmazonNewAccountPage amazonNewAccountPage,
                       AmazonHelpService amazonHelpService) {
        this.amazonPage = amazonPage;
        this.newAccountPage = amazonNewAccountPage;
        this.amazonHelpService = amazonHelpService;
    }

    @And("I hover the Account List option")
    public void iHoverTheAccountListOption() {
        amazonPage.hoverAccountList();
    }

    @And("I click on {string}")
    public void iClickOn(String variable) {
        amazonPage.clickOn(variable);
    }

    @And("I get values from {string}")
    public void iGetValuesFrom(String endpoint) {
        Response res = RequestManager.get(endpoint);
        variables.put("name", res.jsonPath().getString("data.employee_name"));
        variables.put("number", res.jsonPath().getString("data.employee_salary"));
    }

    @And("I set form with request values")
    public void iSetFormWithRequestValues() {
        String name = (String) variables.get("name");
        String number = (String) variables.get("number");
        String pw = name + number;
        newAccountPage.fillForm(name, number, pw, pw);
    }

    @And("I search {string} in help Service page")
    public void iSearchInHelpServicePage(String textSearch) {
        amazonHelpService.findHelpService(textSearch);
    }

    @And("I select {string}")
    public void iSelect(String optionSelect) {
        amazonHelpService.select(optionSelect);
    }

    @And("I expect is visible")
    public void iExpectIsVisible(List<String> entries) {
        String failMessage = "option %s is not displayed";
        for (String entry : entries) {
            boolean result = amazonHelpService.optionIsVisible(entry);
            Assert.assertTrue(String.format(failMessage, entry), result);
        }
    }
}
