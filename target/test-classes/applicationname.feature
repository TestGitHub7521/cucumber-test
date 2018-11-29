Feature: the application name can be retrieved
  Scenario: client makes call to GET /api/config/name
    When the client calls /api/config/name
    Then the client gets response status code of 200
    And the client receives application name of "cucumbertest"