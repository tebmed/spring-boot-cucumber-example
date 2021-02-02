Feature: subscriber feature
  Scenario: A user gets the subscribers
    Given the following subscribers
       | firstName | lastName  | address | contracts |
       | mohammed  | tebib     | Paris   | null      |
       | yassine   | youssfi   | Lyon    | null      |
    When the user requests all the subscribers
    Then all the subscribers are returned




