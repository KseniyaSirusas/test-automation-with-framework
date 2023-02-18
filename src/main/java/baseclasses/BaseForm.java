package baseclasses;

import commonact.ConfigManager;
import commonact.Driver;
import commonact.Log;
import commonact.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public abstract class BaseForm {
    By uniqueFormLocator;
   String formName;
   WebDriver driver;
   WebDriverWait wait;


    protected BaseForm(By locator, String name) {
        uniqueFormLocator = locator;
        formName = name;
        driver = Driver.getDriver();
    }

  public  boolean isFormOpen(){
      Log.getLog().info(formName+"Form is open");
      return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(uniqueFormLocator)).isDisplayed();
  }
}
