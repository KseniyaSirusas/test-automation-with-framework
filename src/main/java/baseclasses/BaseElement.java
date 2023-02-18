package baseclasses;

import commonact.ConfigManager;
import commonact.Driver;
import commonact.Log;
import commonact.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public abstract class BaseElement {
    protected WebDriver driver;
    protected String elementName;
    protected WebDriverWait wait;
    protected By uniqueLocator;

    public BaseElement(By locator, String name) {
        uniqueLocator=locator;
        elementName=name;
        driver=Driver.getDriver();
   }

   public WebElement getElement(){
        return Driver.getDriver().findElement(uniqueLocator);
    }

    public void click(){
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(uniqueLocator)).isDisplayed();
        getElement().click();
        Log.getLog().info("click on the btn "+elementName);
    }

    public boolean displayed(){
       return  new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(uniqueLocator)).isDisplayed();
    }

}