import Elements.Frame;
import commonact.BrowserUtil;
import commonact.TestDataManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseclasses.BaseTest;
import pages.MainPage;
import pages.PageAlertsWindowsFrames;
import java.io.IOException;

public class TestFrames extends BaseTest {

        @Test
        public void test() throws IOException {
            Assert.assertTrue(MainPage.mainPage.isFormOpen(), "Main page is displayed");
            BrowserUtil.scrolldown();
            MainPage.clickAlertsButton();
            BrowserUtil.scrolldown();
            PageAlertsWindowsFrames.clickNestedFrames();
            Assert.assertTrue(PageAlertsWindowsFrames.isDisplForm(), "Nested Frames is displayed");
            Assert.assertEquals(PageAlertsWindowsFrames.getParentFrameText(), TestDataManager.getTestData("nestedFrameText1"), "Text in ParentFrame is right");
            Assert.assertEquals(PageAlertsWindowsFrames.getChildFrameText(), TestDataManager.getTestData("nestedFrameText2"), "Text in ChildFrame is right");
            Frame.backToPage();
            BrowserUtil.scrolldown();
            PageAlertsWindowsFrames.clickFrameBtn();
            Assert.assertTrue(PageAlertsWindowsFrames.isFramesDispl());
            BrowserUtil.scrolldown();
            Assert.assertEquals(PageAlertsWindowsFrames.getBigFrameText(), PageAlertsWindowsFrames.getSmallFrameText(), "Text is the same");
        }
}
