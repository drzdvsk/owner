package tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.config.WebDriverConfig;
import tests.config.WebDriverProvider;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
        WebElement heading = driver.findElement(By.id("hero-section-brand-heading"));
        String headingText = heading.getText();

        assertEquals("Build and ship software on a single, collaborative platform", headingText);
        assertThat(config.getBaseUrl()).isEqualTo("https://github.com");
        assertThat(config.getBrowser()).isEqualTo(CHROME);
        assertThat(config.getBrowserVersion()).isEqualTo("100.0");
        assertThat(config.getRemoteURL().toString())
                .isIn("https://localhost:8080", "https://user1:1234@selenoid.autotests.cloud/wd/hub");


    }

    @AfterEach
   public void stopDriver() {
        driver.quit();
    }
}



