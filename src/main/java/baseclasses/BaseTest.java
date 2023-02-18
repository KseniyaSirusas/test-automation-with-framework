package baseclasses;

import commonact.BrowserFactory;
import commonact.ConfigManager;
import commonact.Driver;
import commonact.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;


public abstract class BaseTest {
    @BeforeMethod
    public static void before() throws IOException {
       Driver.getDriver();
       Driver.open(ConfigManager.getConfig("webpage"));
    }

    @AfterMethod
    public static void after() throws IOException {
        Log.getLog().info("close driver");
        BrowserFactory.closeDriver();
    }
}
