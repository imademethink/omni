Feature: Search cases in short

  @search_happy_path @search_all
  Scenario: Search case happy path
    Given I launch "chrome" browser and navigate to home page SearchTC
    When I attempt to search for valid item
    Then Valid search result should be shown

  @search_unhappy_path @search_all
  Scenario: Search case unhappy path
    Given I launch "chrome" browser and navigate to home page SearchTC
    When I attempt to search for invalid item
    Then Valid search result should not be shown
