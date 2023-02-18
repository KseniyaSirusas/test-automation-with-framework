package pages;
import Elements.*;
import baseclasses.BaseForm;
import commonact.Driver;
import org.openqa.selenium.By;

public class PageAlertsWindowsFrames extends BaseForm {

    public PageAlertsWindowsFrames() {
        super(By.xpath("//div[text()='Alerts, Frame & Windows']"), "Alerts page");
    }

    private static Button alerts = new Button(By.xpath("//span[text()='Alerts']"), "Alerts");

    private static Button toSeeAlert = new Button(By.xpath("//button[@id='alertButton']"), "Alert Button");

    private static Button confirmBtn = new Button(By.xpath("//button[@id='confirmButton']"), "Alert Button");

    private static TextField confirmText = new TextField(By.xpath("//span[@id='confirmResult']"), "You select Ok");

    private static Button promtButton = new Button(By.xpath("//button[@id='promtButton']"), "PromtButton");

    private static TextField promptResult = new TextField(By.xpath("//span[@id='promptResult']"), "You enter someText");

    private static Button nestedFrames = new Button(By.xpath("//span[text()='Nested Frames']"), "Nested Frames btn");

    private static Label nestedFr = new Label(By.xpath("//span[text()='Nested Frames']"), "Nested Frames label");

    private static Button frames = new Button(By.xpath("//span[text()='Frames']"), "Frames btn");

    private static Label framesLabel = new Label(By.xpath("//div[text()='Frames']"), "Frames label");

    private static Button browserWindows = new Button(By.xpath("//span[text()='Browser Windows']"), "Browser Windows btn");
    private static Frame frame= new Frame();

    public static boolean isDisplElement() {
        return alerts.displayed();
    }

    public static void clickButtonAlerts() {
        alerts.click();
    }

    public static void clickButtonToSeeAlert() {
        toSeeAlert.click();
    }

    public static void clickButtonConfirmBtn() {
        confirmBtn.click();
    }

    public static String getTextAfterAlert() {
        return confirmText.getElement().getText();
    }

    public static void clickPromtBtn() {
        promtButton.click();
    }

    public static boolean textIsEqual() {
        return promptResult.getElement().getText().contains(Alerts.uuid);}

    public static void clickNestedFrames(){
        nestedFrames.click();}

    public static boolean isDisplForm(){
        return nestedFr.displayed();
    }

    public static String getParentFrameText(){
      frame.getFrameValue("frame1");
        return Driver.getDriver().findElement(By.tagName("body")).getText();
    }

    public static String getChildFrameText(){
        frame.getFrameChildValue("frame1");
        return Driver.getDriver().findElement(By.tagName("p")).getText();
    }

    public static void clickFrameBtn() {frames.click();}

    public static boolean isFramesDispl(){
       return framesLabel.displayed();}

    public static String getBigFrameText(){
        frame.getFrameValue("frame1");
        return Driver.getDriver().findElement(By.tagName("h1")).getText();
    }

    public static String getSmallFrameText(){
        frame.backToPage();
        frame.getFrameValue("frame2");
        return Driver.getDriver().findElement(By.tagName("h1")).getText();
    }

    public static void clickBrowserBtn(){
        browserWindows.click();
    }
}