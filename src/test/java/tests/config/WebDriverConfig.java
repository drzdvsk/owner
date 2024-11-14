package tests.config;


import org.aeonbits.owner.Config;
import java.net.URL;

@Config.Sources({
        "classpath:${env}.properties"
})

public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser getBrowser();

    @Key("browser.version")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("URL")
    @DefaultValue("https://localhost:8080")
    URL getRemoteURL();
}
