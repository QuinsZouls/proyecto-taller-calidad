package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.pages.HomePage;

public class HomeNgTest extends TestNgTestBase {

  private HomePage homepage;

  @BeforeClass
  public void testInit() {
    driver.get(baseUrl);
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void testHomePageHasAHeader() {
    Assert.assertFalse("".equals(homepage.header.getText()));
  }

  @Test
  public void testHomePageHasATitle() {
    Assert.assertTrue("Inicio | Gastronomía mexicana".equals(homepage.getTitle()));
  }

  @Test
  public void testHomePageHasANavbar() {
    WebElement container = homepage.navbar.findElement(By.className("container"));
    Assert.assertFalse(null == container);
  }

  @Test
  public void testHomePageNavbarAction() {
    WebElement homeLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(1) > a"));
    homeLink.click();
    Assert.assertTrue("Inicio | Gastronomía mexicana".equals(homepage.getTitle()));
    WebElement foodLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(2) > a"));
    foodLink.click();
    Assert.assertTrue("Platillos | Gastronomía Mexicana".equals(homepage.getTitle()));
    WebElement aboutLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(3) > a"));
    aboutLink.click();
    Assert.assertTrue("Sobre nosotros | Gastronomía Mexicana".equals(homepage.getTitle()));
    WebElement contactLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(4) > a"));
    contactLink.click();
    Assert.assertTrue("Contacto | Gastronomía Mexicana".equals(homepage.getTitle()));
  }

}
