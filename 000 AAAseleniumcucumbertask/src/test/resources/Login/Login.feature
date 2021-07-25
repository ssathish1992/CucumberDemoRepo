Feature: To login Application

Scenario: To test elearning Portal
Given Login to Application
And Register in Application
And Validating in Homepage



#Background:
#Given Login page

#Scenario: To test with valid credentials

#When Enter valid name "Admin"
#And Enter valid password "admin123"
#And Click on Submit button
#Then I shoud see the username as "Welcome Paul"

#Scenario: To test with valid credentials


#When Enter valid name "Admin"
#And Enter valid password "admin123"
#And Click on Submit button
#Then I shoud see the username as "Welcome Paul"


#Scenario Outline: To test login with diff data
#When Enter valid name "<name>"
#And Enter valid password "<pwd>"
#And Click on Submit button
#Then I shoud see the username as "<loginname>"

#this will be like data driven test
#Examples:
#|name|pwd|loginname|
#|Admin|admin123|Welcome Paul|
#|Admin|admin123|Welcome Paul|


#Scenario: To test with invalid valid credentials
#When Enter invalid name "sathish"
#And Enter invalid password "sathish"
#And Click on Submit button
#Then I shoud see the pagetitle as "OrangeHRM"