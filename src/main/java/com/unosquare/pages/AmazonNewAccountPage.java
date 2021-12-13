package com.unosquare.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class AmazonNewAccountPage extends AbstractPage{

    @FindBy(css = "#ap_customer_name")
    WebElement customerName;

    @FindBy(css = "#ap_email")
    WebElement emailNumber;

    @FindBy(css = "#ap_password")
    WebElement password;

    @FindBy(css = "#ap_password_check")
    WebElement reEnterPassword;

    private HashMap<String, WebElement> links = new HashMap<>();


    @Override
    public void openPage() {
        //nothing
    }

    public void clickOn(String option){
        action.click(links.get(option));
    }

    public void fillForm(String name, String mail, String passwprd, String checkPw){
        action.sendText(customerName, name);
        action.sendText(emailNumber, mail);
        action.sendText(password, passwprd);
        action.sendText(reEnterPassword, checkPw);
    }

}
