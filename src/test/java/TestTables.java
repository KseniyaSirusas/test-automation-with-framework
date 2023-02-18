import baseclasses.BaseTest;
import commonact.BrowserUtil;
import commonact.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.MainPage;
import pages.RegistrationForm;
import java.io.IOException;

public class TestTables extends BaseTest {

        @Test(dataProvider="testdata")
        public void test(String firstName, String lastname, String email, String age, String salary, String department) throws IOException {
            Assert.assertTrue(MainPage.mainPage.isFormOpen(), "Main page is displayed");
            BrowserUtil.scrolldown();
            MainPage.clickElementsButton();
            ElementsPage.clickWebTables();
            Assert.assertTrue(ElementsPage.isWebTableOpen(), "Web Table is open");
            int numberOfUsersBefore=ElementsPage.countRowsWithUsers();
            ElementsPage.clickAddBtn();
            Assert.assertTrue(RegistrationForm.registrationForm.isFormOpen(), "Registration form is opened");
            RegistrationForm.handlingElements(firstName,lastname,email,age,salary,department);
            RegistrationForm.clickSubmit();
            int numberOfUsersAfter=ElementsPage.countRowsWithUsers();
            Assert.assertNotEquals(numberOfUsersBefore, numberOfUsersAfter, "Quantity of users is changed");
            ElementsPage.clickDelete();
            int numberOfUsersAfter2=ElementsPage.countRowsWithUsers();
            Assert.assertEquals(numberOfUsersBefore, numberOfUsersAfter2, "Quantity of users is changed");
        }
    @DataProvider(name="testdata")
    public Object[][] testDataExample(){
        ReadExcelFile configuration = new ReadExcelFile("UsersTestData.xls");
        Object[][]user = new Object[2][6];

        for(int i=1;i<=2;i++)
        {
            user[i-1][0] = ReadExcelFile.getData(0, i, 1);
            user[i-1][1] = ReadExcelFile.getData(0, i, 2);
            user[i-1][2] = ReadExcelFile.getData(0, i, 3);
            user[i-1][3] = ReadExcelFile.getData(0, i, 4);
            user[i-1][4] = ReadExcelFile.getData(0, i, 5);
            user[i-1][5] = ReadExcelFile.getData(0, i, 6);
        }
        return user;
    }
}
