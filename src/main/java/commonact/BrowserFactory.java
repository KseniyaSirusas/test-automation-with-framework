package commonact;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BrowserFactory {

    private static WebDriver driver=null;

    public static WebDriver createInstance(String browserName) {
        if (browserName.toLowerCase().contains("firefox")&&driver==null) {
            driver=new FirefoxDriver();
            WebDriverManager.firefoxdriver().setup();
            return driver;
        }
        if (browserName.toLowerCase().contains("chrome")&&driver==null) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--lang=en");
            WebDriverManager.chromedriver().setup();
            Log.getLog().info("setup chromeDriver");
            driver=new ChromeDriver(option);
            driver.manage().window().maximize();
            Log.getLog().info("maximize window");
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigManager.getConfig("mediumTime")), SECONDS);
            return driver;

        }
        return driver;
    }


    public static void closeDriver(){
        driver.quit();
        driver=null;
    }
}