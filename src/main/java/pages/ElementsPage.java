package pages;

import Elements.Button;
import Elements.Label;
import baseclasses.BaseForm;
import commonact.Driver;
import commonact.Log;
import org.openqa.selenium.By;

public class ElementsPage extends BaseForm {

    public ElementsPage() {
        super(By.xpath("//div[text()='Elements']"), "Elements page");
    }

    private static Button webTables= new Button(By.xpath("//span[text()='Web Tables']"), "Web Tables btn");

    private static Label webTablesLabel = new Label(By.xpath("//div[text()='Web Tables']"), "Web Tables header");

    private static Button addButton= new Button(By.xpath("//button[@id='addNewRecordButton']"), "Add btn");

    private static Button deleteUserBtn= new Button(By.xpath("//span[@id='delete-record-1']"), "DeleteUser btn");

    public static void clickWebTables(){
         webTables.click();
    }

    public static boolean isWebTableOpen(){
        return webTablesLabel.displayed();
    }

    public static void clickAddBtn(){
        addButton.click();
    }

    public static int countRowsWithUsers(){
        Log.getLog().info("count rows in a table");
       return Driver.getDriver().findElements((By.xpath("//span[@title='Delete']"))).size();
    }

    public static void clickDelete(){
        deleteUserBtn.click();
    }
}
