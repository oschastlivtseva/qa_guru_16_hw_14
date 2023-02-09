package guru.qa.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ConfigProvider {

    public static void configure() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        Configuration.baseUrl = config.getBaseURL();
        Configuration.browser = config.getBrowser();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.timeout = config.getTimeout();

        if ((config.getEnv()).equals("remote")) {
            Configuration.remote = config.getRemoteURL();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }
}
