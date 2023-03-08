#Author: bojka.bg@gmail.com

Feature: Sign Up Fields - registration page
	
	Background:
	
	  Given Navigate to the "https://etherscan.io/register"
    But before enter pwd user clicks first on GotIt COOKIES   

    
  
  @test1
  Scenario: Positive test with valid inputs 
    And into the Username field enter input "Bojana"
    And into the Email Address field enter input "bojka.bg@gmail.com"
    Then un_msg should contain ""
    When confirm Email Address "bojka.bg@gmail.com"
    Then email_msg should contain ""
    When into the Password field enter pwd input "Javolimgrafiku123"
    Then pwd_msg should contains ""
    And pwd title should contain "Medium!"        
    When confirm Password "Javolimgrafiku123"
    And before check agree box, click on link Tersm and Conditions and title should be "Etherscan Terms and Policies" and navigate back 
    Then click on agrees chack-box
    And click on chack-box2
    Then browser_closed
    

    
	@test2
  Scenario Outline: Negative test cases for username field -> Username field is filled with less than five necessary characters | 
    And into the Username field enter input "<invalid_user_input>"
    And into the Email Address field enter input "bojka.bg@gmail.com"
    Then un_msg should contain "<error_msg>"
    When confirm Email Address "bojka.bg@gmail.com"
    Then email_msg should contain ""
    When into the Password field enter pwd input "Javolimgrafiku123"
    Then pwd_msg should contains ""
    And pwd title should contain "Medium!"        
    When confirm Password "Javolimgrafiku123"
    And before check agree box, click on link Tersm and Conditions and title should be "Etherscan Terms and Policies" and navigate back 
    Then click on agrees chack-box
    And click on chack-box2   
    Then browser_closed
		


    Examples: 
      | invalid_user_input  | 							error_msg 			        |		
      |	Bojana	            | 																		  |
      | Boja                | Please enter at least 5 characters.	  |      
      |	@$$%^&							|	Only alphanumeric characters allowed. |

  
	@test3
  Scenario Outline: Test cases about password security field -> Password could be /Weak/Medium/Strong  
    And into the Username field enter input "Dejana"
    And into the Email Address field enter input "bojka.bg@gmail.com"
    Then un_msg should contain ""
    When confirm Email Address "bojka.bg@gmail.com"
    Then email_msg should contain ""
    When into the Password field enter pwd input "<pwd>"
    Then pwd_msg should contains ""
    And pwd title should contain "<status_of_pwd_security>"        
    When confirm Password "<pwd>"
    And before check agree box, click on link Tersm and Conditions and title should be "Etherscan Terms and Policies" and navigate back 
    Then click on agrees chack-box
    And click on chack-box2   
    Then browser_closed
		


    Examples: 
      | pwd								  | 							status_of_pwd_security 			        |		
      |	12345678					  | Weak! 																		  			|
      | Javolimgrafiku123   | Medium!															  						|      
      |	Javolimgrafiku123$	|	Strong!																 						|

	@test4
  Scenario Outline: Negative test cases for email field -> | Input which is not fit with an email form    
    And into the Username field enter input "Dejana"
    And into the Email Address field enter input "<email_invalid_input>"
    Then un_msg should contain "" 
    When confirm Email Address "<email_invalid_input>"
    Then email_msg should contain "<worning_msg_about_invalid_inputs>"
    When into the Password field enter pwd input "12345678"
    Then pwd_msg should contains ""
    And pwd title should contain "Weak!"        
    When confirm Password "12345678"
    And before check agree box, click on link Tersm and Conditions and title should be "Etherscan Terms and Policies" and navigate back 
    Then click on agrees chack-box
    And click on chack-box2   
    Then browser_closed
		


    Examples: 
      | email_invalid_input			| worning_msg_about_invalid_inputs							 		|		
      |	Bojana					  		  | Please enter a valid email address. 							|
      | @bojana   							| Please enter a valid email address.								|      
      |	1234567890							|	Please enter a valid email address.								|
      
	@test5
  Scenario Outline: Negative test cases for pwd field -> | Input which is not fit with an rules for pwd, eg. less then expected input.   
    And into the Username field enter input "Dejana"
    And into the Email Address field enter input "bojka.bg@gmail.com"
    Then un_msg should contain "" 
    When confirm Email Address "bojka.bg@gmail.com"
    Then email_msg should contain ""
    When into the Password field enter pwd input "<invalid pwd input>"
    Then pwd_msg should contains "<error warning msg>"
    And pwd title should contain ""         
    When confirm Password "<invalid pwd input>"
    And before check agree box, click on link Tersm and Conditions and title should be "Etherscan Terms and Policies" and navigate back 
    Then click on agrees chack-box
    And click on chack-box2   
    Then browser_closed
		


    Examples: 
      | invalid pwd input 			| error warning msg															 		|		
      |	Bojana					  		  | Your password must be at least 8 characters long. |										 
      | 1234567   						| Your password must be at least 8 characters long.	  |      							 
      																																																	 
      
      
      
      
      
      