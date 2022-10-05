import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SepeteekleckarTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void sepeteekleckar() {
    driver.get("https://www.trendyol.com/butik/liste/1/kadin");
    driver.manage().window().setSize(new Dimension(1382, 754));
    driver.findElement(By.cssSelector("a:nth-child(1) > .p-card-img")).click();
    driver.findElement(By.cssSelector(".p-card-wrppr:nth-child(1) .add-to-basket-button")).click();
    driver.findElement(By.cssSelector(".visible > .add-to-bs-tx")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".pb-item"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector(".pb-basket-item-wrapper")).click();
    driver.findElement(By.cssSelector(".pb-basket-item-actions > button")).click();
    driver.findElement(By.cssSelector(".ty-notr:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".pb-empty-basket")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 5);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pb-empty-basket span")));
    }
    assertThat(driver.findElement(By.cssSelector(".pb-empty-basket span")).getText(), is("Sepetinde ürün bulunmamaktadır."));
  }
}
