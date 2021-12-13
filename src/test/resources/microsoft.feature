Feature: Unosquare tests

  Scenario: First Test Cases
    Given I open "MICROSOFT_PAGE"
    And I validate menu
      | Microsoft 365 |
      | Office        |
      | Windows       |
      | Surface       |
      | Xbox          |
      | Deals         |
      | Support       |
    And I go to "Windows" menu
    When I go to "Windows OS" submenu
    And I hover the "Windows 10" option
    And I print all options displayed in menu
    Then I search "Visual Studio" word
    And I print 3 first items prices
    And I save the price item number 1 in "price1" variable
    And I select the item 1 in shop page
    And I add to the card
    And I expect the item is price "price1"
    And I expect the price in summary item is "price1"
    And I expect the total price is "price1"
    And I change quantity for "20"
    And I multiply "price1" by "20" and store at "price2"
    And I expect the total price is "price2"

