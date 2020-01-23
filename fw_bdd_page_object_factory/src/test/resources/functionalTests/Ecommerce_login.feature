Feature: Login cases in short

  @login_happy_path @login_all
  Scenario: Login case happy path
    Given Login TC I create chrome browser instance and navigate to home page
    When I attempt to login with valid credential
    Then Login should be successful

  @login_unhappy_path @login_all
  Scenario: Login case unhappy path
    Given Login TC I launch "chrome" browser and navigate to home page
    When I attempt to login with invalid credential
    Then Login should not be successful
