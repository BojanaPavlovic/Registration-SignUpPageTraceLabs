package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class CrossBrowser 

{
	public WebDriver driver;
   
    public void setUp() 
  
    {
        String browser = System.getProperty("browser", "chrome"); //Here we can change a browser type :)
        switch (browser) 
        
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "opera":
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
    
        }
    
    }

    
    public void tearDown() 
    
    {
        if (driver != null)         
        {
            driver.quit();
        }
    }

}
