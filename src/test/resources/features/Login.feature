Feature: Login functionality

  @Positive
  Scenario Outline: Ensure user succesfully login
    #precondition
    Given user is on SauceDemo homepage
    #step
    When user input <username> as username
    And user input <password> as password
    And user click enter
    #expected
    Then user verify <status> login result

    Examples:
      | username        | password     | status  |
      | standard_user   | secret_sauce | success |
#      | locked_out_user | secret_sauce | fail    |
#      | error_user      | secret_sauce | fail    |