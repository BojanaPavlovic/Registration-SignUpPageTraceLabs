package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebElements 

{

    @FindBy(xpath = "(//input[@id='ContentPlaceHolder1_txtUserName'])[1]")
    public WebElement un_element;
    
    @FindBy(xpath = "(//input[@id='ContentPlaceHolder1_txtEmail'])[1]")
    public WebElement email_element;
    
    @FindBy(id = "ContentPlaceHolder1_txtConfirmEmail")
    public WebElement confirm_element;

    @FindBy(xpath = "(//input[@id='ContentPlaceHolder1_txtPassword'])[1]")
    public WebElement pwd_element;

    @FindBy(xpath = "(//input[@id='ContentPlaceHolder1_txtPassword2'])[1]")
    public WebElement confirm_pwd_element;
    
    @FindBy(xpath = "//span[contains(@class,'progress-label fs-sm')]")
    public WebElement element_for_assertion;

    @FindBy(id = "btnCookie")
    public WebElement cookie;
    
    @FindBy(name = "ctl00$ContentPlaceHolder1$SubscribeNewsletter")
    public WebElement conf_element;

    @FindBy(name = "ctl00$ContentPlaceHolder1$MyCheckBox")
    public WebElement agree_element;
    
    @FindBy(id = "ContentPlaceHolder1_txtUserName-error")
    public WebElement error_msg_un;
    
    @FindBy(id = "ContentPlaceHolder1_txtEmail-error")
    public WebElement error_email_msg;    
    
    @FindBy(id = "ContentPlaceHolder1_txtPassword-error") 
    public WebElement error_pwd_msg;   

    @FindBy(id = "ContentPlaceHolder1_txtConfirmEmail-error")
    public WebElement error_confirm_email_msg; 

    @FindBy(id = "ContentPlaceHolder1_txtPassword2-error")  
    public WebElement error_confirm_pwd_msg; 

}
