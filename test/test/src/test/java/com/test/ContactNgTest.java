package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.pages.ContactPage;

public class ContactNgTest extends TestNgTestBase {
  private ContactPage contactPage;

  @BeforeClass
  public void testInit() {
    driver.get(baseUrl + "/contact.html");
    contactPage = PageFactory.initElements(driver, ContactPage.class);
  }

  @Test
  public void testFoodPageHasAHeader() {
    Assert.assertFalse("".equals(contactPage.header.getText()));
  }

  @Test
  public void testFoodPageHasATitle() {
    Assert.assertTrue("Contacto | Gastronomía Mexicana".equals(contactPage.getTitle()));
  }

  @Test
  public void tesFoodPageHasANavbar() {
    WebElement container = contactPage.navbar.findElement(By.className("container"));
    Assert.assertFalse(null == container);
  }

  @Test
  public void testFoodPageForm() {
    WebElement nameInput = contactPage.form.findElement(By.cssSelector("#contactform > div:nth-child(1) > input"));
    nameInput.sendKeys("Alfredo");
    WebElement emailInput = contactPage.form.findElement(By.cssSelector("#contactform > div:nth-child(1) > input"));
    emailInput.sendKeys("alfredo@mail.com");
    WebElement messageInput = contactPage.form.findElement(By.cssSelector("#contactform > div:nth-child(1) > input"));
    messageInput.sendKeys("Hola");
    WebElement submitBtn = contactPage.form.findElement(By.id("submit"));
    Assert.assertTrue("Enviar".equals(submitBtn.getAttribute("value")));
    submitBtn.click();
  }
}
