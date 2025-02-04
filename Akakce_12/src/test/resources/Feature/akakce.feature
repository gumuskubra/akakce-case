@smoke
Feature: Akakce.com Search and Add to Favorites

  Scenario: User searches for a product and adds it to the favorites list
    Given User visits the akakce.com website
    And User logs in
    When User searches for a popular product like "iphone"
    Then The product list should be displayed
    And User selects a product from the list
    And User clicks Go To Product
    And User adds the product to the favorites list
