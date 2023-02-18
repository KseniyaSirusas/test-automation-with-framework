package commonact;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    static InputStream inputStream;

    public static String getConfig(String string){
        Log.getLog().info("get configuration data");
        Properties prop = new Properties();
        String propFileName = "config.properties";
        inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        String result = prop.getProperty(string);
        return result;
    }

    public static Long getConfigTime(String string) throws IOException {
        Log.getLog().info("get configuration data time");
        Properties prop = new Properties();
        String propFileName = "config.properties";
        inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        Long result = Long.parseLong(prop.getProperty(string));
        return result;
    }
}
