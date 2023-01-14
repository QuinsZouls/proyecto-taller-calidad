package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.pages.FoodPage;

public class FoodNgTest extends TestNgTestBase {
  private FoodPage foodPage;

  @BeforeClass
  public void testInit() {
    driver.get(baseUrl + "/gallery.html");
    foodPage = PageFactory.initElements(driver, FoodPage.class);
  }

  @Test
  public void testFoodPageHasAHeader() {
    Assert.assertFalse("".equals(foodPage.header.getText()));
  }

  @Test
  public void testFoodPageHasATitle() {
    Assert.assertTrue("Platillos | Gastronomía Mexicana".equals(foodPage.getTitle()));
  }

  @Test
  public void tesFoodPageHasANavbar() {
    WebElement container = foodPage.navbar.findElement(By.className("container"));
    Assert.assertFalse(null == container);
  }

  @Test
  public void testFoodPageLayoutFilter() {
    List<WebElement> childs = driver.findElements(By.cssSelector("#content > div > div > div > ul > li"));
    for (WebElement e : childs) {
      e.click();
      String cls[] = e.getAttribute("class").split(" ");
      Assert.assertTrue(cls[1].equals("active"));
    }
  }

  @Test
  public void testFoodPageItemView() {
    WebElement element = foodPage.container
        .findElement(By.cssSelector("#thumbs > li:nth-child(1) > a"));
    element.click();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    WebElement foodTitle = driver.findElement(By.xpath(
        "/html/body/div[2]/div/div/div[2]/h4"));
    Assert.assertTrue("h4".equals(foodTitle.getTagName()));
    // Cerramos el modal
    //driver.findElement(By.cssSelector("body > div.fancybox-overlay.fancybox-overlay-fixed > div > div > a")).click();
  }

  @Test
  public void testFoodPageNavbarAction() {
    WebElement homeLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(1) > a"));
    Assert.assertTrue("INICIO".equals(homeLink.getText()));
    WebElement foodLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(2) > a"));
    Assert.assertTrue("PLATILLOS".equals(foodLink.getText()));
    WebElement aboutLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(3) > a"));
    Assert.assertTrue("SOBRE NOSOTROS".equals(aboutLink
        .getText()));
    WebElement contactLink = driver.findElement(
        By.cssSelector("#wrapper > header > div > div > div.navbar-collapse.collapse > ul > li:nth-child(4) > a"));
    Assert.assertTrue("CONTACTO".equals(contactLink.getText()));
  }

}
