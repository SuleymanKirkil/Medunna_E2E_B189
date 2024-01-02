@e2e @db
Feature: DataBase Room Validation
  Scenario: Select Created Room From DB
    Given Admin Connect to the Data Base
    When  send query for created room
    Then validates created room from result set