package commonact;

import org.openqa.selenium.JavascriptExecutor;
import java.util.ArrayList;

public class BrowserUtil {

    public static void scrolldown() {
        Log.getLog().info("scroll down");
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void toNewTab() {
        Log.getLog().info("switch to new tab");
        String oldTab = Driver.getDriver().getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        newTab.remove(oldTab);
        Driver.getDriver().switchTo().window(newTab.get(0));
    }

    public static void toOldTab(){
        Log.getLog().info("switch to old tab");
        Driver.getDriver().close();
        ArrayList<String> newTab = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(newTab.get(0));
    }
}

