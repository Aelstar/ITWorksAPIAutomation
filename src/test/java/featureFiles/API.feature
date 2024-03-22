Feature: API Activity Endpoint Test

  Scenario: Verify API Activity Response
    Given the API endpoint "https://www.boredapi.com/api/activity"
    When I send a GET request to the API
    Then the response code should be 200
    And the response body should match the expected body