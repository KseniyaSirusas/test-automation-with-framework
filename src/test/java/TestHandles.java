import baseclasses.BaseTest;
import commonact.BrowserUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrowserWindowsForm;
import pages.LinksForm;
import pages.MainPage;
import pages.PageAlertsWindowsFrames;
import java.io.IOException;

public class TestHandles extends BaseTest {

    @Test
    public void test() throws IOException {
        Assert.assertTrue(MainPage.mainPage.isFormOpen(), "Main page is displayed");
        BrowserUtil.scrolldown();
        MainPage.clickAlertsButton();
        PageAlertsWindowsFrames.clickBrowserBtn();
        Assert.assertTrue(BrowserWindowsForm.isBrowserWindFormDispl(), "Browser Windows page is opened");
        BrowserWindowsForm.clickNewTab();
        BrowserUtil.toNewTab();
        Assert.assertTrue(BrowserWindowsForm.isSamplePageOpen(), "Sample page is opened");
        BrowserUtil.toOldTab();
        Assert.assertTrue(BrowserWindowsForm.isBrowserWindFormDispl(), "Browser Windows page is opened");
        BrowserWindowsForm.clickElements();
        BrowserUtil.scrolldown();
        BrowserWindowsForm.clickLinks();
        Assert.assertTrue(LinksForm.islinkFormOpened(), "LinkForm is open");
        LinksForm.clickHomeBtn();
        BrowserUtil.toNewTab();
        Assert.assertTrue(MainPage.mainPage.isFormOpen(), "Main page is displayed");
        BrowserUtil.toOldTab();
        Assert.assertTrue(LinksForm.islinkFormOpened(), "LinkForm is open");
    }
}