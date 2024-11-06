package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import tests.config.WebDriverProvider;

import static java.sql.DriverManager.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTests {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    public void testGithub() {
        String title = driver.getTitle();
        assertEquals("GitHub: Build and ship software on a single, collaborative platform", title);
    }


    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}



