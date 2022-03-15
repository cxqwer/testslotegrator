package utill.properties;

/**
 * Class with test parameters
 *
 * @author cxqwer@yandex.ru
 */
public abstract class TestProperties {

    public static PropertyReader propertyReader = new PropertyReader();

    public final static String HOST = propertyReader.getProperty("host");
    public final static String BROWSER_NAME = propertyReader.getProperty("browser");
    public final static Boolean CLOSE_DRIVER_AFTER_RUN = Boolean.parseBoolean(propertyReader.getProperty("closeDriverAfterRun"));
    public final static Long BASE_TIMEOUT = Long.parseLong(propertyReader.getProperty("baseTimeOut"));

}