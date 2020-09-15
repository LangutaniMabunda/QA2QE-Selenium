Feature:    As a user
  I would like to search for a product
  So that i can add the product to car

  Scenario: Browsing product list

    Given that i have opened url site
    When I search for product
    Then the view product list must be displayed