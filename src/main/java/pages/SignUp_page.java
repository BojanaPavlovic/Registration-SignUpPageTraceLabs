package pages;

import org.openqa.selenium.WebDriver;
import utility.CrossBrowser;
import utility.basic_functions;

public class SignUp_page 

{

	public WebDriver driver;	
	public CrossBrowser cb;
	public basic_functions bf;
	
	public SignUp_page(WebDriver driver)

	{
		bf = new basic_functions(driver); 
		this.driver = driver;		
	
	}

	public void get_url(String URL) 
	
	{
		bf.URL_get(URL);
	}

	public void close_the_browser() 
	
	{
		bf.browser_close();
	}
	
	public void enter_username (String un) 
	
	{
		bf.enter_un(un);
	}
	
	
	public void enter_email (String email) 
	
	{
		bf.enter_email(email);
	}
	
	public void confirm (String email)
	
	{
		bf.confirm_email(email);
	}	
	
	public void enter_password (String pwd) throws InterruptedException 
	
	{
		bf.enter_pwd(pwd);
	}
		
	public void confirm_pwd (String pwd) throws InterruptedException 
	
	{
		bf.confirm_pwd(pwd);
	}	
	
	public void AGREE() throws InterruptedException
	
	{		
		bf.agree_chackBox();
	}


	public void Confirm_to_receive_Newsletter() throws InterruptedException
	
	{		
		bf.confirm_terms();
	}
	
	
	public void cookies() 
	
	{
		bf.cookies_button();
	}
	
	
	public void assertions(String title) 
	
	{		
		bf.actual_result(title);
	}

	public void go_to_the_link_Terms_and_get_back(String title)
	
	{
		bf.click_Term_and_Conditions(title);
	}
	
	public void username_msg_assert(String title) 
	
	{
		bf.get_username_msg(title);
	}
	
	public void email_msg_assert(String title) 
	
	{
		bf.get_email_msg(title);
	}
	
	public void email_confirm_msg_assert(String title) throws InterruptedException
	
	{
		bf.get_email_confirm_msg(title);
	}
	public void pwd_msg_assert(String title) 
	
	{
		bf.get_pwd_msg(title);
	}

	public void pwd_confirm_msg_assert(String title) throws InterruptedException 
	
	{
		bf.get_pwd_confirm_msg(title);
	}

}