Feature: Cucumber, Maven, Selenium, TestNG and Restassured integration

  Background:
    Given User is on the Wikipedia Website

  Scenario Outline: Check that the Wikipedia result title meets the searched Pokemon
    When User searches for the name of the Pokemon with the Pokedex N° <number>
    Then User should be able to see the article page correctly displayed for the Pokemon "<name>"

    Examples:
    | number | name |
    | 1      | Bulbasaur    |
    | 2      | Ivysaur      |
    | 3      | Venusaur     |
    



