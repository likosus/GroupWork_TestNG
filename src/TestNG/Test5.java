package TestNG;

import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Test5 extends BaseDriverParameter {
    @Test
    void giftOrderTest5()
    {
    // NopCommerce sitesine gidin ve "Gift Cards" sayfasına gidin
        driver.get("https://demo.nopcommerce.com/");
        WebElement giftCardsLink = driver.findElement(By.linkText("Gift Cards"));
        giftCardsLink.click();
        Tools.Bekle(2);

        // Find all the physical gift items on the page
      List<WebElement> giftItems = driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]"));
      // Select a random gift item from the list //
      Random rand = new Random();
      int randomIndex = rand.nextInt(giftItems.size());
      WebElement selectedGiftItem = giftItems.get(randomIndex);
      // Click on the selected gift item to go to its details page
        WebDriverWait waitGift=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(selectedGiftItem));

        selectedGiftItem.click();
    /*******************************/ //rumeysa code
      //  List<WebElement> giftCards=driver.findElements(By.cssSelector("h2>[href='physical-gift-card']")); // xpathi-> .//a[contains(text(),'Physical')]
      //  giftCards.get(((int) (Math.random()*giftCards.size()))).click();

        Tools.Bekle(1);
    // "Recipient Name", "Sender Name" ve "Message" alanlarını doldurun ve "Add to Cart" düğmesine tıklayın
    WebElement recipientNameField = driver.findElement(By.xpath("//input[@class='recipient-name']"));
        recipientNameField.sendKeys("Rümeysa Bakir");

    WebElement senderNameField = driver.findElement(By.xpath("//*[@id='giftcard_44_SenderName']"));
    senderNameField.sendKeys("Mustafa Likos");

    WebElement messageField = driver.findElement(By.xpath("//*[@id='giftcard_44_Message']"));
        messageField.sendKeys("Happy birthday!");

    WebElement addToCartButton2 = driver.findElement(By.xpath("//*[@id='add-to-cart-button-44'] "));
        addToCartButton2.click();


        WebElement succesMesage= driver.findElement(By.xpath("//*[@id='bar-notification']/div/p"));
        Assert.assertTrue(succesMesage.getText().contains("The product has been added to your shopping cart"));
  // Sepetteki ürün sayısını doğrulayın

 //  // WebDriver nesnesini kapatın
        driver.quit();
}
    }







