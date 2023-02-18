package Elements;

import commonact.Driver;
import commonact.Log;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.UUID;

public class Alerts {

    public static String AlertGetText(){
        String alert1Text = Driver.getDriver().switchTo().alert().getText();
        return alert1Text;
    }

    public static void acceptAlert(){
        Driver.getDriver().switchTo().alert().accept();
    }

    public static boolean isAlertClosed(){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(0)) ;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = false;
        } catch (TimeoutException eTO) {
            foundAlert = true;
        }
        return foundAlert;
    }

    public static String uuid = UUID.randomUUID().toString();

    public static void sendRandomText(){
        Driver.getDriver().switchTo().alert().sendKeys(uuid);
        Log.getLog().info("Send random text");
    }
}
