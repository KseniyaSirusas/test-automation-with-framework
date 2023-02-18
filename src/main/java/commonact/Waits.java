package commonact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Waits {
    WebDriverWait wait;
    public Waits(WebDriverWait wait){
       this.wait= wait;
    }
static WebDriver driver=Driver.getDriver();
    public static WebDriverWait getWait(){
        WebDriverWait wait;
        try {
            wait=new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getConfigTime("mediumTime")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wait;

    }
}
