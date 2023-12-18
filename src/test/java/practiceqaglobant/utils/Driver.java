package practiceqaglobant.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private WebDriver driver;

    public Driver(String browser) {
        String path = System.getProperty("user.dir");
        if ("firefox".equals(browser)){
            System.setProperty("webdriver.gecko.driver", path+"\\driver\\geckodriver.exe");
            driver = new FirefoxDriver();
        }else if ("edge".equals(browser)){
            System.setProperty("webdriver.edge.driver", path+"\\driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        else{
            System.setProperty("webdriver.chrome.driver", path+"\\driver\\chromedriver.exe");
            
            
            
            driver = new ChromeDriver();
        }
    }
    public WebDriver getDriver() {
        return this.driver;
    }
}
