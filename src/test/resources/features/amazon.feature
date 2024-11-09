Feature: Amazon Search
  As a user
  I want to search for a product on Amazon
  So that I can see the search results

  @wip
  Scenario: Search for a product
    Given I am on the Amazon homepage
    When I search for "iPhone 12"
    Then I should see search results for "iPhone 12"