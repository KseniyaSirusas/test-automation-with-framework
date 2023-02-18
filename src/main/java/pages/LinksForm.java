package pages;

import Elements.Button;
import Elements.Label;
import baseclasses.BaseForm;
import org.openqa.selenium.By;

public class LinksForm extends BaseForm {

    public LinksForm(){
        super(By.xpath("//div[text()='Links']"), "Links Form");
    }

    private static Label link=new Label(By.xpath("//div[text()='Links']"), "Links Form label");

    private static Button home = new Button(By.xpath("//a[@id='simpleLink']"), "Home btn");

    public static boolean islinkFormOpened(){
        return link.displayed();
    }

    public static void clickHomeBtn(){
        home.click();
    }
}
