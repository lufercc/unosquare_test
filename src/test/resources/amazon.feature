Feature: unosquare second test

  Scenario: Second sceanrio test
    Given I open "AMAZON_PAGE"
    And I hover the Account List option
    And I click on "Start_Here"
    And I get values from "http://dummy.restapiexample.com/api/v1/employee/1"
    And I set form with request values
    And I click on "Condition_of_Use"
    And I search "Echo" in help Service page
    And I select "Support for Echo Dot"
    And I expect is visible
      | Getting Started              |
      | Wi-Fi and Bluetooth          |
      | Device Software and Hardware |
      | Troubleshoot                 |
