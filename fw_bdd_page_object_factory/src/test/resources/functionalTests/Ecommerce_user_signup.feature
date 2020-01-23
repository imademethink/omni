Feature: Signup cases in short

  @signup_with_mandatory_param @signup_all
  Scenario: Signup case with mandatory parameters
    Given I launch "chrome" browser and navigate to home page SignupTC
    When I attempt to signup with mandatory parameters
    Then Signup should be successful

  @signup_without_mandatory_param @signup_all
  Scenario: Signup case without mandatory parameters
    Given I launch "chrome" browser and navigate to home page SignupTC
    When I attempt to signup without mandatory parameters
    Then Signup should not be successful
