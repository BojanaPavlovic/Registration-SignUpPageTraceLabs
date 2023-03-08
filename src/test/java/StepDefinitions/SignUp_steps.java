package StepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import utility.CrossBrowser;
import pages.SignUp_page;

public class SignUp_steps{
	
	public SignUp_page sp;
	public CrossBrowser cb;
	public WebDriver driver;
	    

	@Given ("Navigate to the {string}")
	public void navigate_to_the (String URL) 

	{
    	cb = new CrossBrowser();
    	cb.setUp();
    	sp = new SignUp_page(cb.driver);
    	sp.get_url(URL);
	}
    
	@And("into the Username field enter input {string}")
	public void into_the_username_field_enter_valid_input(String un) throws InterruptedException 
	
	{
		Thread.sleep(2000);
		sp.enter_username(un);			
	}


	@And("into the Email Address field enter input {string}")
	public void into_the_email_address_field_enter_valid_input(String email) 
	
	{
		sp.enter_email(email);
	}
    
	@Then("un_msg should contain {string}")
    public void username_error_msg(String msg)
    {
    	sp.username_msg_assert(msg);
    }	    
	
	@And("email_msg should contain {string}")
    public void email_error_msg(String msg)
    {
    	sp.email_msg_assert(msg);;
    }
	
	@When("confirm Email Address {string}")
	public void confirm_email_address(String email) 
	
	{
		sp.confirm(email);
	}
    
//	@Then ("email_confirm_msg should contains {string}")
//    public void email_confirm_error_msg(String msg) throws InterruptedException
//    
//    {
//    	sp.email_confirm_msg_assert(msg);;
//    }
    
	@But("before enter pwd user clicks first on GotIt COOKIES")
    public void cookies()
    
	{
    	sp.cookies();
    }
	
	@When("into the Password field enter pwd input {string}")
	public void into_the_password_field_enter_valid_pwd_input(String pwd) throws InterruptedException 
	
	{
		sp.enter_password(pwd);
	}
    @Then ("pwd_msg should contains {string}")
    public void pwd_msg_assertion(String msg)
    {
    	sp.pwd_msg_assert(msg);
    }    
	
    @And("pwd title should contain {string}")
	public void degree_of_security(String msg)
	{
		sp.assertions(msg);
    	
	}

	@When("confirm Password {string}")
	public void confirm_password(String pwd) throws InterruptedException 
	
	{
		sp.confirm_pwd(pwd);
	}
	
//    @Then("pwd_confirm_msg should contains {string}")
//    public void pwd_confirm_msg_assertion(String msg) 
//    {
//    	sp.pwd_confirm_msg_assert(msg);
//    }

    
    @And("before check agree box, click on link Tersm and Conditions and title should be {string} and navigate back")
    public void click_Terms_link_and_get_back(String title) 
    
    {
    	sp.go_to_the_link_Terms_and_get_back(title);;
    }
    
	@Then("click on agrees chack-box")
	public void click_on_agrees_chack_boxes_and_i_m_not_a_robot() throws InterruptedException 
	
	{
		sp.AGREE();
	}
	
    @And("click on chack-box2")   
	public void click_on_chackBox2() throws InterruptedException
	
    {
		sp.Confirm_to_receive_Newsletter();	
	}
    
 

    @Then("browser_closed")
    
    public void tear_down()
    
    {
    	sp.close_the_browser();
    }
}