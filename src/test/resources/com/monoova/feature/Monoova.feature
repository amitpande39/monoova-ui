Feature: Monoova Registration Process

  Scenario: Register with monoova and Create AutoMatcher Account
    Given I navigate to monoova registration page
    And I enter my detail to register an account
    And I verify email link
    When I login to monoova with email, password
    And I create new automatcher account by entering accountName, clientUniqueId
    Then I validate a new automatcher account is created successfully

