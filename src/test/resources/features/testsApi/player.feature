@api
@All
Feature: PLAYER MANAGEMENT api

  Scenario: Create player and check permissions
    When POST crate token
      | Parameter  | Value   |
      | HTTP Code  | 200     |
      | grant_type | guest   |
      | scope      | default |
    And POST crate player
      | Parameter       | Value               |
      | HTTP Code       | 201                 |
      | username        | janedoe             |
      | password_change | amFuZWRvZTEyMw==    |
      | password_repeat | amFuZWRvZTEyMw==    |
      | email           | janedoe@example.com |
      | name            | Jane                |
      | surname         | Doe                 |
      | currency_code   | EUR                 |
    Then check player
      | username      | janedoe             |
      | email         | janedoe@example.com |
      | name          | Jane                |
      | surname       | Doe                 |
      | currency_code | EUR                 |
    When POST crate token
      | Parameter  | Value            |
      | HTTP Code  | 200              |
      | grant_type | password         |
      | username   | janedoe          |
      | password   | amFuZWRvZTEyMw== |
    And GET player with id: "auto"
      | HTTP Code | 200 |
    Then check player
      | username      | janedoe             |
      | email         | janedoe@example.com |
      | name          | Jane                |
      | surname       | Doe                 |
      | currency_code | EUR                 |
    And GET player with id: "1234"
      | HTTP Code | 404 |