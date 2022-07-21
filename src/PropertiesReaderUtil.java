import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderUtil {

    private PropertiesReaderUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String getValueFromSecretsProperties(String property) {
        return getValue("API.properties", property);
    }

    private static String getValue(String file, String property) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(file)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties.getProperty(property);
    }
}