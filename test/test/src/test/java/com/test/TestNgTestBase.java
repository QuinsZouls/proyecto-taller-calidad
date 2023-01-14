package com.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import ru.stqa.selenium.factory.WebDriverFactory;

import com.test.util.PropertyLoader;

/**
 * Base class for all the TestNG-based test classes
 */
public class TestNgTestBase {

  protected WebDriver driver;
  protected String webdriverPath;
  protected String baseUrl;

  @BeforeClass
  public void init() throws IOException {
    DesiredCapabilities dc = DesiredCapabilities.chrome();

    baseUrl = PropertyLoader.loadProperty("site.url");
    webdriverPath = PropertyLoader.loadProperty("browser.driver_path");

    System.setProperty("webdriver.chrome.driver", webdriverPath);
    driver = new ChromeDriver(dc);

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    if (driver != null) {
      WebDriverFactory.dismissDriver(driver);
    }
  }

  @AfterTest
  // Close windows after test
  public void close() {
    driver.quit();
  }
}
