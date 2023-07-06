Feature: Testing GetNet requests

  Scenario Outline: Perform a POST/auth/login Tests request
    Given I set the headers
    When I send a POST request to "/api/users"
    """
{
    "name": <username>,
    "job": <job>
}
    """
    Then I should receive a response <httpResponse>
    Examples:
      | username   | job      | httpResponse |
      | "morpheus" | "leader" | 201          |
      |            |          | 400          |
      | "morpheus" |          | 400          |
      |            | "leader" | 400          |
      | 1233       | 1233     | 201          |
      | #@$$%      | #$%#$    | 400          |
      |            | #$%#$    | 400          |
      | #@$$%      |          | 400          |
