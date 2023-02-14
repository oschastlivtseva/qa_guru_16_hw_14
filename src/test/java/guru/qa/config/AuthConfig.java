package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("testUserEmail")
    String getTestUserEmail();

    @Key("testUserPassword")
    String getTestUserPassword();

    @Key("testUserNameAndSurname")
    String getTestUserNameAndSurname();
}
