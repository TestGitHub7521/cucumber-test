Feature: the serverport can be retrieved
  Scenario: client makes call to GET /api/config/port
    When the client calls /api/config/port
    Then the client receives status code of 200
    And the client receives server port of 8082