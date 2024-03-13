Feature: PetStore API User Operations

  @user
  Scenario: User Operations
    Given I have a valid user payload
    When I send a "POST" request to "/user" endpoint
    Then the response status code should be 200
    And the response should contain the "message" for "POST"

    When I send a "GET" request to "/user/username" endpoint
    Then the response status code should be 200
    And the response should contain the "userID" for "GET"

    When I send a "PUT" request to "/user/username" endpoint
    Then the response status code should be 200
    And the response should contain the "userID" for "PUT"

    When I send a "DELETE" request to "/user/username" endpoint
    Then the response status code should be 200
    And the response should contain the "userID" for "DELETE"
