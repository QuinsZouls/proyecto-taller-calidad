package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactPage extends Page {
  @FindBy(how = How.XPATH, using = "//*[@id=\"inner-headline\"]/div/div/div/h2")
  @CacheLookup
  public WebElement header;

  @FindBy(how = How.CLASS_NAME, using = "navbar")
  @CacheLookup
  public WebElement navbar;

  @FindBy(how = How.ID, using = "contactform")
  public WebElement form;

  public ContactPage(WebDriver webDriver) {
    super(webDriver);
  }
}
