
@Contact
Feature: Contact us Functionality
  

  @smokeTest
  Scenario: To validate the conntact us functionality
    Given Open the browser, enter the sparsh hospital URL
    And Clicks the contact us button
    When when user enters firstname, lastname ,phone, email and textbox
    And Select Yashwantpur hospital from Hospital dropdown
    And Write a message and click on send button
    Then Thankyou message should be displayed
    And bank info available in the page

  @tag2
  Scenario Outline: To validate the conntact us functionality with multiple data
    Given Open the browser, enter the sparsh hospital URL
    And Clicks the contact us button
    When when user enters "<firstname>", "<lastname>" ,"<phone>", "<email>" and textbox
    And Select Yashwantpur hospital from Hospital dropdown
    And Write a message and click on send button
    Then Thankyou message should be displayed
    And bank info available in the page
 

    Examples: 
      | firstname  | lastname | phone  | email|
      | vaish%     | lakh... | 899083  | ooo@.com|
      |Vaish       | 2222    |675429384|gmail@.com|
      | Vaish..    |lakho@   |89375     |@.com|
      | Vaishnavi  |Lakhore  |7828184869|vaishnavilakhore@gmail.com|