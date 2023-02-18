package pages;

import Elements.Button;
import Elements.Label;
import Elements.TextField;
import baseclasses.BaseForm;
import org.openqa.selenium.By;

public class BrowserWindowsForm extends BaseForm {

    public BrowserWindowsForm() {
        super(By.xpath("//div[text()='Browser Windows']"), "Browser Windows form");
    }

    private static Label webTablesLabel = new Label(By.xpath("//div[text()='Browser Windows']"), "Browser Windows label");

    private static Button newTab = new Button(By.xpath("//button[@id='tabButton']"), "NewTab btn");

    private static TextField samplePageText= new TextField(By.xpath("//h1[@id='sampleHeading']"), "SamplePage text");

    private static Button elements = new Button(By.xpath("//div[text()='Elements']"), "Elements btn");

    private static Button linksBtn = new Button(By.xpath("//span[text()='Links']"), "Links btn");

    public static boolean isBrowserWindFormDispl(){
        return webTablesLabel.displayed();
    }

    public static void clickNewTab(){
        newTab.click();
    }

    public static boolean isSamplePageOpen(){
        return samplePageText.displayed();
    }

    public static void clickElements(){
        elements.click();
    }

    public static void clickLinks(){
        linksBtn.click();
    }
}
