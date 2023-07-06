Feature: Testing Sicred requests

  Scenario Outline: Perform a POST/auth/login Tests request
    Given I set the headers
    When I send a POST request to "/api/users"
    """
{
    "name": "<username>",
    "job": "<job>"
}
    """
    Then I should receive a response <httpResponse>
    Examples:
      | username | job    | httpResponse |
      | morpheus | leader | 201          |
#      |            |         | 400          |
#      |            |         | 400          |
#      | teste      | 0lelplR | 400          |
#      | kminchelle | teste   | 400          |
#      | kminchelle | 0lelplR | 200          |
