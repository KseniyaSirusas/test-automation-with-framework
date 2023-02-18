package commonact;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static commonact.ConfigManager.inputStream;

public class TestDataManager {

    public static String getTestData(String string) throws IOException {
        Log.getLog().info("get test data");
        Properties prop = new Properties();
        String propFileName = "testData.properties";
        inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        String result = prop.getProperty(string);
        return result;}
}