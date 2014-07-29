Feature: Inputting details into a form

Background:
	Given I have logged into the application


@important @fast @debug
Scenario: Input details using a data table
Given I have loaded form "form9a"
When I input the following details into the form:
	| Field 						| Value 				|
	| applicationNumber | 1234 					|
	| reference					| my reference 	|
	| citiation					| 0 						|	
Then i should be able to see "this text"


Scenario: using a doc string
Given i have been given the following information
"""
 some long text
"""
When i do something
Then i see something else

@wip
Scenario: wip example
Given i have been given the following information
When i do something
Then i see something else

