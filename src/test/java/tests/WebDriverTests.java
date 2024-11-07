package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import tests.config.WebDriverConfig;
import tests.config.WebDriverProvider;


import static org.assertj.core.api.Assertions.assertThat;
import static tests.config.Browser.CHROME;


public class WebDriverTests {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testGithub() {

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        String env = System.getProperty("env", "local");

        System.out.println("URL: " + config.getRemoteURL());

        assertThat(config.getBaseUrl()).isEqualTo("https://github.com");
        assertThat(config.getBrowser()).isEqualTo(CHROME);
        assertThat(config.getBrowserVersion()).isEqualTo("100.0");
        if ("local".equals(env)) {
            assertThat(config.getRemoteURL().toString()).isEqualTo("https://localhost:8080");
        } else if ("remote".equals(env)) {
            assertThat(config.getRemoteURL().toString()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub");
        } else {
            throw new IllegalArgumentException("Unknown env: " + env);
        }
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}



