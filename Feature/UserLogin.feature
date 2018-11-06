Feature: User login into the project
Scenario Outline: User login into the project under different conditions
	Given user input username "<username>"
	And user input password "<password>"
  And user click login button
	Then user click mandator button
	And user click mandator
  And user click continue button
 

Examples:
    |username|password|
    |Emma|testtest|