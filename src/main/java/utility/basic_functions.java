package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class basic_functions

{

    public WebDriverWait wait;
	public WebDriver driver;  
    private WebElements elements;

	public basic_functions(WebDriver driver)	  
	  
	{   
		elements = PageFactory.initElements(driver, WebElements.class);
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
		
    
	public void waitIsClickable(WebElement locator) 
    
    {   
 
		wait.until(ExpectedConditions.elementToBeClickable(locator));
    	if (locator == null) 
        
    	{
            throw new IllegalArgumentException("Input must be set");
        }    
    	
    	else 
    	
    	{
    		locator.click();
    	}
 
    }

    public void URL_get (String Url) 
    
    {
    	driver.get(Url);
		driver.manage().window().maximize();
    }
    

    public void browser_close() 
    
    {
    	driver.quit();
    }
    
    public void enter_un (String username) 
    
    {
		waitIsClickable(elements.un_element);
		elements.un_element.clear();
		elements.un_element.sendKeys(username);

    }

    
    public void enter_email(String email)
    
    {
		waitIsClickable(elements.email_element);
		elements.email_element.clear();
		elements.email_element.sendKeys(email);  
    }
    
    
    public void confirm_email(String email)
    
    {
		waitIsClickable(elements.confirm_element);
		elements.confirm_element.clear();
		elements.confirm_element.sendKeys(email);  
    }
    
    
    public void enter_pwd(String pwd) throws InterruptedException
    
    {
	
		
    	WebElement element = elements.pwd_element;
    	boolean is_element_enabled = element.isEnabled();
		if(is_element_enabled == true) 
		
		{
			Thread.sleep(2000);
			waitIsClickable(element);
			element.clear();
			element.sendKeys(pwd);  			
		}
		
		else 
		
		{
			Assert.assertTrue(false);
			System.out.println("Element is disabled");
		}
    
    }
    
    
    public void confirm_pwd(String pwd) throws InterruptedException
    
    {
    	
		
//		WebElement element = elements.confirm_pwd_element;
//		boolean is_element_enabled = element.isEnabled();
//		if(is_element_enabled == true) 
//		
//		{
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//			Thread.sleep(3000); 
//			waitIsClickable(element);
//			element.clear();
//			element.sendKeys(pwd);  		
//		}
//		
//		else 
//		
//		{
//			Assert.assertTrue(false);
//			System.out.println("Element is disabled");
//		}
    	try {
    	    WebElement passwordConfirmField = driver.findElement(By.id("ContentPlaceHolder1_txtPassword2"));
    	    passwordConfirmField.click();
    	} catch (ElementClickInterceptedException e) {
    	    // čekaj da se element učita i klikni ponovno
    	    WebDriverWait wait = new WebDriverWait(driver, 10);
    	    WebElement searchForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".auto-search-max-height")));
    	    searchForm.click();

    	    WebElement passwordField = driver.findElement(By.id("ContentPlaceHolder1_txtPassword2"));
    	    waitIsClickable(passwordField);
    	    passwordField.clear();
    	    passwordField.sendKeys(pwd);
    	}

    }
    
    
    public void actual_result(String title) 
    
    {
		String actual_text = elements.element_for_assertion.getText();
		Assert.assertEquals(title, actual_text);    	
	}
    
    
    public void cookies_button() 
    
    {
    	waitIsClickable(elements.cookie);
    }

    
    public void confirm_terms() throws InterruptedException
    
    {    	
	
        WebElement element = elements.conf_element;
    	boolean is_element_displayed = element.isDisplayed();

        if (is_element_displayed == true) 
        
        {
            Thread.sleep(2000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } 
        
        else 
        
        {
            Assert.fail("Element is not displayed");
        }     

    }
    
    public void agree_chackBox() throws InterruptedException
    
    {
		
    	WebElement element = elements.agree_element;
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		boolean is_element_displayed = element.isDisplayed();
		if (is_element_displayed == true) 		
		
			{
				Thread.sleep(2000);
				executor.executeScript("arguments[0].click();", element);
			}

		else 

			{
				Assert.assertTrue(false);
				System.out.println("Element is not displayed");
			}


    }

    
    public void click_Term_and_Conditions(String title) 
    
    {
    	String mainWindow = driver.getWindowHandle();
    	WebElement Link_Terms = driver.findElement(By.linkText("Terms and Conditions")); 
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", Link_Terms);
		
		for (String handle : driver.getWindowHandles()) 
		
		{
		    if (!handle.equals(mainWindow)) 
		
		    	{
		        	driver.switchTo().window(handle);
		    	}
		
		}
		
		String result = driver.getTitle();
		Assert.assertEquals(title, result);		
		
		driver.switchTo().window(mainWindow);

    }
    
    public void get_username_msg(String title)
    
    {
    	WebElement element = elements.error_msg_un;
    	String actual_username_msg = element.getText();
    	Assert.assertEquals(title,actual_username_msg );
    }

    public void get_email_msg(String title)
    
    {
    	WebElement element = elements.error_email_msg;
    	String actual_email_msg = element.getText();
    	Assert.assertEquals(title,actual_email_msg );
    }

	public void get_email_confirm_msg(String title) throws InterruptedException
    
    { 
		Thread.sleep(5000);
    	WebElement element = elements.error_confirm_email_msg;
    	String actual_confirm_email_msg = element.getText();
    	System.out.println(actual_confirm_email_msg);
    	Assert.assertEquals(title,actual_confirm_email_msg );
    }

    public void get_pwd_msg(String title) 
    
    {
    	WebElement element = elements.error_pwd_msg;
    	String actual_pwd_msg = element.getText();
    	Assert.assertEquals(title,actual_pwd_msg );
    }
	public void get_pwd_confirm_msg(String expectedText) throws InterruptedException
    
    { 
    	WebElement SCROLL_to_element = elements.agree_element;
    	// Skrolujte do elementa koristeći JavaScriptExecutor
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
    	Thread.sleep(4000);
    	executor.executeScript("arguments[0].scrollIntoView(true);", SCROLL_to_element);
    	
    	WebElement element = elements.error_confirm_pwd_msg;    	
    	String actualText = element.getText();
    	Assert.assertEquals(actualText, expectedText);



    }  

}  
	

	
    


