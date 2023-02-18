package Elements;

import commonact.Driver;

public class Frame  {

    public  void getFrameValue(String id){
        Driver.getDriver().switchTo().frame(id);
    }

    public  void getFrameChildValue(String id){
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame(id);
        Driver.getDriver().switchTo().frame(0);
    }

    public static void backToPage(){
        Driver.getDriver().switchTo().defaultContent();
    }
}
