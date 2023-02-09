package guru.qa.config;

import org.aeonbits.owner.Config;

public interface WebConfig extends Config {

    @Key("env")
    @DefaultValue("local")
    String getEnv();

    @Key("baseURL")
    @DefaultValue("https://www.brainscape.com/")
    String getBaseURL();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("remoteURL")
    String getRemoteURL();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("109")
    String getBrowserVersion();

    @Key("timeout")
    @DefaultValue("15000")
    Long getTimeout();
}
