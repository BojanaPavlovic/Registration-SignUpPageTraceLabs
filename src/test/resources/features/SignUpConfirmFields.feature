#Author: bojka.bg@gmail.com

Feature: Sign Up Confirm fields - registration page
	
  Background:
	
	Given Navigate "https://etherscan.io/register"
    	But before all user clicks first on GotIt COOKIES  
     
	@test1
  Scenario: Positive tests with valid email confirms 
      And into the Email field enter input "bojka.bg@gmail.com"
      When confirm Email "bojka.bg@gmail.com"
      Then email confirm msg should contains ""
      And into the PWD field enter input "bojana12$"
      When confirm pwd "bojana12$"
      Then pwd confirm msg should contains ""
      And driver quit
      
	@test2
  Scenario Outline: Negative test with invalid confirms 
      And into the Email field enter input "<email>"
      When confirm Email "<invalid_confirming>"
      Then email confirm msg should contains "<error_email_msg>"
      And into the PWD field enter input "<pwd>"
      When confirm pwd "<invalid_pwd_confirming>"
      Then pwd confirm msg should contains "<error_pwd_msg>"
      And driver quit      

	Examples:   
      |     email	   |        invalid_confirming           |	error_email_msg                |    pwd		  |  invalid_pwd_confirming    |         error_pwd_msg     		           |
      | bojka.bg@gmial.com | bojana 				 | Please re-enter your email address. | boja             | boja		       | Your password must be at least 8 characters long. |                    
      | bojka.bg@gmial.com | bojka@gmail.com		         | Email address does not match.       | bojana12         | blabla		       | Your password must be at least 8 characters long. |
      |                    | bojana		                 | Please re-enter your email address. |     	          | bojana12		       | Password does not match, please check again.      |
      | b		   | b					 | Please re-enter your email address. | bojana12         | bojana133                  | Password does not match, please check again.      |
  		
