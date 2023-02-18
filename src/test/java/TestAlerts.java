import Elements.Alerts;
import baseclasses.BaseTest;
import commonact.BrowserUtil;
import commonact.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PageAlertsWindowsFrames;
import java.io.IOException;

public class TestAlerts extends BaseTest {

  @Test
  public void test() throws IOException {
      Assert.assertTrue(MainPage.mainPage.isFormOpen(), "Main page is displayed");
    BrowserUtil.scrolldown();
    MainPage.clickAlertsButton();
    Assert.assertTrue(PageAlertsWindowsFrames.isDisplElement(), "Button Alerts is displayed");
   BrowserUtil.scrolldown();
    PageAlertsWindowsFrames.clickButtonAlerts();
    PageAlertsWindowsFrames.clickButtonToSeeAlert();
    Assert.assertEquals(Alerts.AlertGetText(), TestDataManager.getTestData("alert1"), "Text in Alert is right");
    Alerts.acceptAlert();
    Assert.assertTrue(Alerts.isAlertClosed(), "Alert is closed");
    PageAlertsWindowsFrames.clickButtonConfirmBtn();
    Assert.assertEquals(Alerts.AlertGetText(), TestDataManager.getTestData("alert2"), "Text in Alert is right");
    Alerts.acceptAlert();
    Assert.assertTrue(Alerts.isAlertClosed(), "Alert is closed");
    Assert.assertEquals(PageAlertsWindowsFrames.getTextAfterAlert(),TestDataManager.getTestData("text"), "The text is right");
    PageAlertsWindowsFrames.clickPromtBtn();
    Assert.assertEquals(Alerts.AlertGetText(),TestDataManager.getTestData("promtBtnText"), "Text in Alert is right");
    Alerts.sendRandomText();
    Alerts.acceptAlert();
    Assert.assertTrue(PageAlertsWindowsFrames.textIsEqual(), "Random text equals textField");
  }
}
