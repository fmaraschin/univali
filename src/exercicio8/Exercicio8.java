package exercicio8;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercicio8 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.calculatoria.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testExercicio8() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("C")).click();
    driver.findElement(By.linkText("2")).click();
    driver.findElement(By.linkText("0")).click();
    driver.findElement(By.linkText("×")).click();
    driver.findElement(By.linkText("4")).click();
    driver.findElement(By.linkText("=")).click();
    driver.findElement(By.linkText("1")).click();
    driver.findElement(By.linkText("0")).click();
    driver.findElement(By.linkText("0")).click();
    driver.findElement(By.linkText("÷")).click();
    driver.findElement(By.linkText("3")).click();
    driver.findElement(By.linkText("=")).click();
    driver.findElement(By.linkText("5")).click();
    driver.findElement(By.linkText("÷")).click();
    driver.findElement(By.linkText("2")).click();
    driver.findElement(By.linkText("=")).click();
    driver.findElement(By.linkText("DEL")).click();
    driver.findElement(By.linkText("DEL")).click();
    driver.findElement(By.linkText("+")).click();
    driver.findElement(By.linkText("4")).click();
    driver.findElement(By.linkText("=")).click();
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
