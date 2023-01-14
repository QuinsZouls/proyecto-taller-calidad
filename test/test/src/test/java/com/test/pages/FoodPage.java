package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Página de platillos
 */
public class FoodPage extends Page {

  @FindBy(how = How.XPATH, using = "//*[@id=\"inner-headline\"]/div/div/div/h2")
  @CacheLookup
  public WebElement header;

  @FindBy(how = How.CLASS_NAME, using = "navbar")
  @CacheLookup
  public WebElement navbar;

  @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div")
  public WebElement container;

  @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/div/ul")
  public WebElement tabFilter;

  public FoodPage(WebDriver webDriver) {
    super(webDriver);
  }
}
