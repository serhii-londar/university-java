package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    driver.get(baseUrl + "/WebsiteObserver/");
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.cssSelector("#modal-login > div.modal-dialog > div.modal-content > div.modal-body > #user > div.form-group > #email")).clear();
    driver.findElement(By.cssSelector("#modal-login > div.modal-dialog > div.modal-content > div.modal-body > #user > div.form-group > #email")).sendKeys("serhii.londar@gmail.com");
    driver.findElement(By.cssSelector("#modal-login > div.modal-dialog > div.modal-content > div.modal-body > #user > div.form-group > #password")).clear();
    driver.findElement(By.cssSelector("#modal-login > div.modal-dialog > div.modal-content > div.modal-body > #user > div.form-group > #password")).sendKeys("q");
    driver.findElement(By.cssSelector("#modal-login > div.modal-dialog > div.modal-content > div.modal-body > #user > button.btn")).click();
    driver.findElement(By.linkText("Website")).click();
    driver.findElement(By.linkText("Manage")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Run analyzer')])[2]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
