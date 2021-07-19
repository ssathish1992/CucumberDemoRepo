Feature: To login Application
Scenario: To test with valid credentials

Given Login page
When Enter valid name "Admin"
And Enter valid password "admin123"
And Click on Submit button
Then I shoud see the username as "Welcome Paul"