package StepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUp_page;
import utility.CrossBrowser;

public class SignUpConfirmFields_steps {
	
	public SignUp_page sp;
    	public CrossBrowser cb;
    	public WebDriver driver;
	
    @Given("Navigate {string}")
    public void url_navigate(String Url)
	
    {
    	cb = new CrossBrowser();
    	cb.setUp();
    	sp = new SignUp_page(cb.driver);
    	sp.get_url(Url);
	
    }

    @But("before all user clicks first on GotIt COOKIES")
    public void GotIt()

    {
	sp.cookies();
    }  

    @And("into the Email field enter input {string}")
    public void into_the_email_field_enter_input(String enter_mail_address) 
	
    {
	sp.enter_email(enter_mail_address);
    }

    @When("confirm Email {string}")
    public void confirm_email_address(String confirm_email) 
	
    {
	sp.confirm(confirm_email);
    }

    @Then("email confirm msg should contains {string}")
    public void email_confirm_msg_should_contain(String email_assertion) throws InterruptedException 
	
    {
	sp.email_confirm_msg_assert(email_assertion);
    }

    @And("into the PWD field enter input {string}")
    public void into_the_pwd_field_enter_input(String enter_pwd) throws InterruptedException 
	
    {
	sp.enter_password(enter_pwd);
    }
	
    @When("confirm pwd {string}")
    public void confirm_pwd(String confirm_pwd) throws InterruptedException 
	
    {
	sp.confirm_pwd(confirm_pwd);
    }
	


    @Then("pwd confirm msg should contains {string}")
    public void pwd_confirm_msg_should_contains(String title) throws InterruptedException 
    
    {
	sp.pwd_confirm_msg_assert(title);
    }
	
    @And("driver quit")
    public void tearDown() 
	
    {
	sp.close_the_browser();
    }

}

