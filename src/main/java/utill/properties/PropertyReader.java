package utill.properties;

import io.cucumber.core.exception.CucumberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A class for reading test parameters from a configuration file
 *
 * @author cxqwer@yandex.ru
 */
public class PropertyReader {

    private static Logger logger = LoggerFactory.getLogger(PropertyReader.class);
    private final String PATH_TO_PROPERTIES = "src/test/resources/stand.properties";
    private Properties properties;

    public PropertyReader() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fileInputStream);
            logger.info("Test Stand Properties successfully initialized from file by path: " + PATH_TO_PROPERTIES);
        } catch (IOException e) {
            throw new CucumberException("Could not find or read the file on the path" + PATH_TO_PROPERTIES);
        }
        this.properties = properties;
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

}
