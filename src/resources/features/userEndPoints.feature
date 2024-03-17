Feature: PetStore API User CRUD Operations

  @user
  Scenario: User Operations
    Given I have a valid user payload
    When I send a "POST" request to "/user" endpoint
    Then the response status code should be 200

    When I send a "GET" request to "/user/username" endpoint
    Then the response status code should be 200

    When I send a "PUT" request to "/user/username" endpoint
    Then the response status code should be 200

    When I send a "DELETE" request to "/user/username" endpoint
    Then the response status code should be 200

