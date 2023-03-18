package TestNG;

import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Test6 extends BaseDriverParameter {
    @Test
    void OrdercomputerTest6(){
    // Navigate to the Computers page
    driver.get("https://demo.nopcommerce.com/computers");

    // Click on the Desktops dropdown and select "Build your own computer"
    WebElement desktopsDropdown = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
    desktopsDropdown.click();
    WebElement buildYourOwnComputerLink = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a"));
    buildYourOwnComputerLink.click();

    driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")).click();

    WebElement processorClick=driver.findElement(By.xpath("//*[@id='product_attribute_1']"));
    Select processor=new Select(processorClick);
    processor.selectByIndex(1);

  //   List<WebElement>ramSelect=driver.findElements(By.xpath("//select[@id='product_attribute_2']"));
  //   Random randomRam=new Random();
  //   WebElement ramdomRamOption=ramSelect.get(randomRam.nextInt(ramSelect.size()));
//
  //      WebDriverWait RamWait=new WebDriverWait(driver,Duration.ofSeconds(4));
  //      wait.until(ExpectedConditions.elementToBeClickable(ramdomRamOption));
  //      ramdomRamOption.click();

   List<WebElement> random=driver.findElements(By.cssSelector("[id='product_attribute_2']>option[value='0']~option"));
   int i = (int) (Math.random() * random.size());
   WebDriverWait waitop=new WebDriverWait(driver,Duration.ofSeconds(4));
        Tools.Bekle(3);
   random.get(i).click();



      List<WebElement>hddOptions=driver.findElements(By.xpath("//input[@name='product_attribute_3']"));
      Random randomHdd=new Random();
      WebElement randomHddOption=hddOptions.get(randomHdd.nextInt(hddOptions.size()));
         WebDriverWait newWait = new WebDriverWait(driver, Duration.ofSeconds(4));
         wait.until(ExpectedConditions.elementToBeClickable(randomHddOption));
         randomHddOption.click();

    WebElement addChartComputer=driver.findElement(By.xpath("//button[@id='add-to-cart-button-1']"));
    addChartComputer.click();

    WebElement succesChart=driver.findElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertTrue(succesChart.getText().contains("The product has been added to your "));


   driver.quit();
}
}

