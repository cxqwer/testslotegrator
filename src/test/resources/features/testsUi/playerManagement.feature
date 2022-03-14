@All
@PLAYER_MANAGEMENT

Feature: PLAYER MANAGEMENT

  Scenario: Сортировка таблицы игроков по Username
    When Open auth page
    Then On the authorization page display a list of items:
      | Login Input    |
      | Password Input |
      | Sign in Button |
    When Login:
      | Login    | admin1           |
      | Password | [9k<k8^z!+$$GkuP |
    Then The navigation menu is displayed on the main page
    When In the navigation menu select "Users"
    And In the navigation menu in the drop-down list select "Players"
    Then The main page displays "PLAYERS TABLE"
    When In the table click on the heading of the 1st column
    And wait 10 seconds
    Then The table is sorted in ascending order by 1st column