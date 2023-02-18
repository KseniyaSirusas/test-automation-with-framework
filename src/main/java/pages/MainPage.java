package pages;
import Elements.Button;
import baseclasses.BaseForm;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {

   private static Button alertsFrameWind =new Button(By.xpath("//h5[text()='Alerts, Frame & Windows']"), "Alerts,Frame,Windows");

   private static Button elements=new Button(By.xpath("//h5[text()='Elements']"), "Elements");

   MainPage(){
      super(By.xpath("//div[@class='home-banner']"),"Main Page");
    }
    public static MainPage mainPage =new MainPage();

    public static void clickAlertsButton(){
      alertsFrameWind.click();
    }

    public static void clickElementsButton(){
    elements.click();
  }
}
