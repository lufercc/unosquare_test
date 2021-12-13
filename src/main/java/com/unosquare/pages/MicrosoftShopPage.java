package com.unosquare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MicrosoftShopPage extends AbstractPage {

    private final static String ITEM_PRICES = "span[itemprop='price'][aria-hidden='false']";
    private final static String ADD_TO_CART = "//div[@class = 'buy-box-buy-buttons mb-3']/div/a";
    private final static String ITEM_PRICE_CARD = ".item-price .c-price>span[itemprop='price']>span";
    private final static String SUMMARY_PRICE_CART = "span .c-price>span[itemprop='price']>span";
    private final static String TOTAL_PRICE_CART = "span > strong > span[itemprop='price']";
    private final static String INPUTEMAIL = "//div[@class='form-group']//input";
    private final static String QUANTITY = "select[aria-label = 'Visual Studio Professional Subscription  Quantity selection']";


    @Override
    public void openPage() {
        // nothing
    }

    public void printFirstItemPrices(int numberItems) {
        String message = "the first %s items have the follow prices:";
        List<WebElement> result = driver.findElements(By.cssSelector(ITEM_PRICES));
        System.out.println(String.format(message, numberItems));
        for (int i = 0; i < numberItems && i < result.size(); i++) {
            System.out.println(action.getText(result.get(i)));
        }
    }

    public float getThePriceOfItem(int NumberOfItem) {
        List<WebElement> result = driver.findElements(By.cssSelector(ITEM_PRICES));
        WebElement itemElement = result.get(NumberOfItem - 1);
        String itemPrice = action.getText(itemElement);
        String price = itemPrice.replaceAll("[\\$\\,^\\\\d]", "");
        return Float.parseFloat(price);
    }

    public void clickOnItem(int itemNumber) throws InterruptedException {
        List<WebElement> result = driver.findElements(By.cssSelector(ITEM_PRICES));
        WebElement itemElement = result.get(itemNumber - 1);
        action.click(itemElement);
        action.sendText(By.xpath(INPUTEMAIL),"rest" + Keys.ESCAPE);
    }

    public void clickOnAddToCard() {
        action.click(By.xpath(ADD_TO_CART));
    }

    public float getCartItemPrice() {
        String priceStr = action.getText(By.cssSelector(ITEM_PRICE_CARD));
        String price = priceStr.replaceAll("[\\$\\,^\\\\d]", "");
        return Float.parseFloat(price);

    }

    public float getSummaryPrice() {
        String priceStr = action.getText(By.cssSelector(SUMMARY_PRICE_CART));
        String price = priceStr.replaceAll("[\\$\\,^\\\\d]", "");
        return Float.parseFloat(price);
    }

    public float getTotalPrice() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String priceStr = action.getText(By.cssSelector(TOTAL_PRICE_CART));
        String price = priceStr.replaceAll("[\\$\\,^\\\\d]", "");
        return Float.parseFloat(price);
    }

    public void selectQuantity (String quantity){
        action.select(By.cssSelector(QUANTITY), quantity);
    }
}
