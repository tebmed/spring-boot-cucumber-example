Feature: update subcriber address
  Scenario: Update address of a subscriber living in France
    Given a subscriber with many contracts and a main address in france
    When the advisor update the subscriber address
    Then the new address of the suscriber is saved in the list of the subscriber contracts
    And an address modification movement is created with the new address 
