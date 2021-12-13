package com.unosquare.steps;

import com.unosquare.pages.MicrosoftPage;
import com.unosquare.pages.MicrosoftShopPage;
import com.unosquare.pages.MicrosoftWindowsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Hashtable;
import java.util.List;

public class MicrosoftSteps {

    private MicrosoftPage microsoftPage;
    private MicrosoftWindowsPage microsoftWindowsPage;
    private MicrosoftShopPage microsoftShopPage;
    private Hashtable<String, Object> variables;

    public MicrosoftSteps(MicrosoftPage microsoftPage, MicrosoftWindowsPage microsoftWindowsPage,
                          MicrosoftShopPage microsoftShopPage) {
        this.microsoftPage = microsoftPage;
        this.microsoftWindowsPage = microsoftWindowsPage;
        this.microsoftShopPage = microsoftShopPage;
        this.variables = new Hashtable<String, Object>();
    }

    @And("I validate menu")
    public void iValidateMenu(List<String> entries) {
        String failMessage = "menu %s is not displayed";
        for (String entry : entries) {
            boolean result = microsoftPage.menuIsDisplayed(entry);
            Assert.assertTrue(String.format(failMessage, entry), result);
        }
    }

    @And("I go to {string} menu")
    public void iGoToMenu(String menu) {
        microsoftPage.goMenu(menu);
    }

    @Then("I go to {string} submenu")
    public void iGoToSubmenu(String submenu) {
        microsoftWindowsPage.goMenu(submenu);
    }

    @And("I print all options displayed in menu")
    public void iPrintAllOptionsDisplayedInMenu() {
        microsoftWindowsPage.listSubMenu();

    }

    @And("I hover the {string} option")
    public void iHoverTheOption(String submenu) {
        microsoftWindowsPage.goSubmenu(submenu);
    }

    @Then("I search {string} word")
    public void iSearchWord(String word) {
        microsoftPage.searchWord(word);
    }

    @And("I print {int} first items prices")
    public void iPrintFirstItemsPrices(int itemQuantity) {
        microsoftShopPage.printFirstItemPrices(itemQuantity);
        microsoftShopPage.getThePriceOfItem(1);
    }

    @And("I save the price item number {int} in {string} variable")
    public void iSaveThePriceItemNumberInVariable(int itemNumber, String variableName) {
        float priceItem = microsoftShopPage.getThePriceOfItem(itemNumber);
        this.variables.put(variableName, priceItem);
    }

    @And("I select the item {int} in shop page")
    public void iSelectTheItemInShopPage(int itemNumber) {
        try {
            microsoftShopPage.clickOnItem(itemNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("I add to the card")
    public void iAddToTheCard() {
        microsoftShopPage.clickOnAddToCard();
    }

    @And("I expect the item is price {string}")
    public void iExpectTheItemIsPrice(String variable) {
        float pricevar = (Float) variables.get(variable);
        float pricepage = microsoftShopPage.getCartItemPrice();
        Assert.assertEquals(pricevar, pricepage, 0.1);
    }

    @And("I expect the price in summary item is {string}")
    public void iExpectThePriceInSummaryItemIs(String variable) {
        float pricevar = (Float) variables.get(variable);
        float pricepage = microsoftShopPage.getSummaryPrice();
        Assert.assertEquals(pricevar, pricepage, 0.1);

    }

    @And("I expect the total price is {string}")
    public void iExpectTheTotalPriceIs(String variable) {
        float pricevar = (Float) variables.get(variable);
        float pricepage = microsoftShopPage.getTotalPrice();
        Assert.assertEquals(pricevar, pricepage, 0.1);
    }

    @And("I change quantity for {string}")
    public void iChangeQuantityFor(String valueQuantity) {
        microsoftShopPage.selectQuantity(valueQuantity);
    }

    @And("I multiply {string} by {string} and store at {string}")
    public void iMultiplyByAndStoreAt(String valueParam, String mutiply, String valueStore) {
        float newValue = (Float) variables.get(valueParam);
        int multi = Integer.parseInt(mutiply);
        variables.put(valueStore, newValue * multi);
    }
}
