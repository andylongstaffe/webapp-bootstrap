Feature: Navigating bbc website

@fixtures 
Scenario: Viewing weather info
Given i am on the bbc weather page
When i enter "cf144sf" into the search box and click search
Then the weather forecase for "CF14" is displayed