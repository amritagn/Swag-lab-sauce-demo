package swaglabssaucedemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public abstract class demo {

  private static final WebElement Dropdown = null;
  private static final List < WebElement > price = null;
  private static final WebElement[] itemList = null;
  private static final WebElement[] cartItemList = null;
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Desktop\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    driver.get("https://www.saucedemo.com/inventory.html");
    driver.findElement(By.name("username")).sendKeys("standard_user");
    driver.findElement(By.name("password")).sendKeys("secret_sauce");
    driver.findElement(By.cssSelector("btn_action")).click();
  }

  WebDriver driver = new ChromeDriver(); {
    driver.get("https://www.saucedemo.com/inventory.html");
    Select select = new Select(driver.findElement(By.className("product_sort_container")));
    select.selectByValue("Price(low to high)");
    WebElement dropdown = driver.findElement(By.cssSelector("//*[@id=\"header_container\"]/div[2]/div/span/select"));

    WebDriverWait wait = new
    WebDriverWait(driver, 10);
    List < WebElement > priceElements = driver.findElements(By.className("inventory_item_price"));
    List < Double > prices = new ArrayList < > ();
    for (WebElement priceElement: priceElements) {
      String priceText =
        priceElement.getText().substring(1);
      double price = Double.parseDouble(priceText);
      prices.add(price);
    }
    for (int i = 0; i < price.size() - 1; i++) {
      Assert.assertTrue(prices.get(i) <= prices.get(i + 1));
    } {}
    driver.findElements(By.className("inventory_item"));
    for (WebElement item: itemList) {
      WebElement button = item.findElement(By.cssSelector("button.btn_inventory"));
      if (button.getText().equals("ADD TO CART")) button.click();
    }

    {
      driver.findElement(By.cssSelector("shopping_cart_link")).click();
      driver.findElement(By.cssSelector("div.cart_item"));
      for (WebElement item: cartItemList) {
        WebElement priceElement = item.findElement(By.cssSelector("div.inventory_item_price"));
        String price = priceElement.getText().replace("$", "");
        if (Float.parseFloat(price) < 15) {
          item.findElement(By.cssSelector("button.cart_button")).click();
        }

        {
          driver.findElement(By.cssSelector("btn_actioncheckout_button")).click();
        }

        {
          driver.findElement(By.cssSelector("img[alt=Swag Labs]")).click();
          driver.findElement(By.cssSelector("bm-burger-button")).click();
          driver.findElement(By.id("logout_sidebar_link")).click();
        }

      }

    }

  }

}
