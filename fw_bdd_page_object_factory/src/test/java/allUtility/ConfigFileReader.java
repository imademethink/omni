package allUtility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties propertiesConfig            = null;

    private final String propertyFilePathConfig    = "configs//global_config.properties";

    public String getApplicationUrl() {
        String url = propertiesConfig.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the global_config.properties file.");
    }

    public String getUserName() {
        return propertiesConfig.getProperty("username");
    }

    public String getPassword() {
        return propertiesConfig.getProperty("password");
    }

    public void ReadConfigFile_General(){
        BufferedReader reader = null;
        try {
            reader            = new BufferedReader(new FileReader(propertyFilePathConfig));
            propertiesConfig  = new Properties();
            try {
                propertiesConfig.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("global_config.properties not found at " + propertyFilePathConfig);
        }
    }

}