Feature: Search and Place the order for Products 

@PlaceOrder
Scenario Outline: Search experience for product search in both home and offers page
Given User is on GreenCart Landing page
When User searched with shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page
And Validate product name in offers page matches with landing page

Examples:
|Name|
|Tom|
