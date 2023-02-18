package pages;
import Elements.Button;
import Elements.TextField;
import baseclasses.BaseForm;
import commonact.Log;
import org.openqa.selenium.By;


public class RegistrationForm extends BaseForm {

    public RegistrationForm() {
        super(By.xpath("//div[@id='registration-form-modal']"), "Registration form");
    }
   public static RegistrationForm registrationForm=new RegistrationForm();

    private static TextField firstname= new TextField(By.xpath("//input[@id='firstName']"), "First name");

    private static TextField lastname= new TextField(By.xpath("//input[@id='lastName']"), "Last name");

    private static TextField useremail= new TextField(By.xpath("//input[@id='userEmail']"), "Email");

    private static TextField userage= new TextField(By.xpath("//input[@id='age']"), "Age");

    private static TextField usersalary= new TextField(By.xpath("//input[@id='salary']"), "Salary");

    private static TextField userdepartment= new TextField(By.xpath("//input[@id='department']"), "Department");

    public static Button submit = new Button(By.xpath("//button[@id='submit']"), "Submit btn");

    public static void handlingElements(String firstName, String lastName, String email, String age, String salary, String department){
        Log.getLog().info("Send keys to registration form");
        firstname.getElement().sendKeys(firstName);
        lastname.getElement().sendKeys(lastName);
        useremail.getElement().sendKeys(email);
        userage.getElement().sendKeys(age);
        usersalary.getElement().sendKeys(salary);
        userdepartment.getElement().sendKeys(department);
    }

     public static void clickSubmit(){
        submit.click();
     }
}
