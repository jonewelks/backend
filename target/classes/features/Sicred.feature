Feature: Testing Sicred requests

  Scenario Outline: Perform a POST/auth/login Tests request
    Given I set the headers
    When I send a POST request to "/auth/login"
    """
{
    "username": "<username>",
    "password": "<password>"
}
    """
    Then I should receive a response <httpResponse>
    And I Save Token a response
    Examples:
      | username   | password | httpResponse |
      |            | 0lelplR  | 400          |
      | kminchelle |          | 400          |
      |            |          | 400          |
      | teste      | 0lelplR  | 400          |
      | kminchelle | teste    | 400          |
      | kminchelle | 0lelplR  | 200          |

  Scenario: Perform a GET/Tests request
    Given I set the headers
    When I send a GET request to "/test"
    Then I should receive a response 200

  Scenario: Perform a GET/auth/products Tests request
    Given I set the headers and Token
    When I send a GET request to "/auth/products"
    Then I should receive a response 200

  Scenario: Perform a GET/products Tests request
    Given I set the headers
    When I send a GET request to "/products"
    Then I should receive a response 200

  Scenario Outline: Perform a GET/products/{id} Tests request
    Given I set the headers
    When I send a GET request to "/products/<id>"
    Then I should receive a response <httpResponse>
    Examples:
      | id                                      | httpResponse |
      | 1                                       | 200          |
      | a                                       | 404          |
      | $#@#                                    | 404          |
      | 999999999999999999999999999999999999999 | 404          |

  Scenario: Perform a GET/users Tests request
    Given I set the headers
    When I send a GET request to "/users"
    Then I should receive a response 200

  Scenario: Perform a POST/products/add request Tests
    Given I set the headers
    When I send a POST request to "/products/add"
    """
{
    "title": "Perfume Oil",
    "description": "Mega Discount, Impression of A...",
    "price": 13,
    "discountPercentage": 8.4,
    "rating": 4.26,
    "stock": 65,
    "brand": "Impression of Acqua Di Gio",
    "category": "fragrances",
    "thumbnail": "https://i.dummyjson.com/data/products/11/thumnail.jpg"
}
    """
    Then I should receive a response 200