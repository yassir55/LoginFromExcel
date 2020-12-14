Feature: Excel Data Reader

  Scenario: User Login scenario
    Given User is at the login page of the application
    When User login with the following username and password with data in excel at "/home/user/Downloads/data1.xlsx"