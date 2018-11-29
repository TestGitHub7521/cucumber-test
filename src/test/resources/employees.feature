Feature: the employees can be retrieved
  Scenario: client makes call to GET /api/employees
    When the client calls /api/employees
    Then the client gets status code of 200
    And the client receives employee details