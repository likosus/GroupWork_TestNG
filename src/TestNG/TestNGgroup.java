package TestNG;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static Utility.BaseDriver.driver;

public class TestNGgroup extends BaseDriver {
    @Test(priority = 1)
    public void RegistrationTest() {

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        driver.findElement(By.xpath("//*[@id='gender-male']")).click();
        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        firstNameInput.sendKeys("mustafa");
        lastNameInput.sendKeys("likos");

        WebElement birthDaySelect = driver.findElement(By.name("DateOfBirthDay"));
        WebElement birthMonthSelect = driver.findElement(By.name("DateOfBirthMonth"));
        WebElement birthYearSelect = driver.findElement(By.name("DateOfBirthYear"));
        birthDaySelect.sendKeys("1");
        birthMonthSelect.sendKeys("May");
        birthYearSelect.sendKeys("1990");

        driver.findElement(By.cssSelector("#Email")).sendKeys("likosmusta@gmail.com");

        driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");

        // Click register button
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();

        // Assert registration success message
        WebElement successMessage = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
        Assert.assertEquals(successMessage.getText(), "Your registration completed");

    }

    @Test (priority = 2)
    void loginTest(){

    WebElement login= driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    login.click();

    driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("likosmustaf@gmail.com");
    driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("123456");

    driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();


    }
    @Test(priority = 3,dataProvider = "mailData")

    void mailTest(String email, String password) {
        System.out.println("email = " + email+password);

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();

        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys( email);

        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);

        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();

    }

    @DataProvider
    public Object[][] mailData(){

        Object[][] data ={
                {"likosmustaf@gmail.com","123456"},
                {"rumbk1@hotmail.com","123456"},

        };
        return data;
    }

    @Test (priority = 4)
    public void TabMenuItemsTest4() {
        // driver.get("https://demo.nopcommerce.com/");
        WebElement tabMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']"));
        List<WebElement> tabMenuItems = tabMenu.findElements(By.tagName("li"));

        for (WebElement tabMenuItem : tabMenuItems) {
            String itemName = tabMenuItem.getText();
            System.out.println(itemName);
            // burada itemName değerleri ile istediğiniz doğrulama işlemini yapabilirsiniz.
        }

    }

    @Test (priority = 5)
    void giftOrderTest5()
    {
        // NopCommerce sitesine gidin ve "Gift Cards" sayfasına gidin
        driver.get("https://demo.nopcommerce.com/");
        WebElement giftCardsLink = driver.findElement(By.linkText("Gift Cards"));
        giftCardsLink.click();
        Tools.Bekle(2);

        // Find all the physical gift items on the page
        List<WebElement> giftItems = driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]"));
        Tools.Bekle(1);
        // Select a random gift item from the list
        Random rand = new Random();
        int randomIndex = rand.nextInt(giftItems.size());
        WebElement selectedGiftItem = giftItems.get(randomIndex);
        // Click on the selected gift item to go to its details page
        selectedGiftItem.click();

        Tools.Bekle(1);
        // "Recipient Name", "Sender Name" ve "Message" alanlarını doldurun ve "Add to Cart" düğmesine tıklayın
        WebElement recipientNameField = driver.findElement(By.xpath("//input[@class='recipient-name']"));
        recipientNameField.sendKeys("Rümeysa Bakir");
        Tools.Bekle(1);
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

    }
    @Test(priority = 6)
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

  //     List<WebElement>ramSelect=driver.findElements(By.xpath("//select[@id='product_attribute_2']"));
  //     Random randomRam=new Random();
  //     WebElement ramdomRamOption=ramSelect.get(randomRam.nextInt(ramSelect.size()));

  //     WebDriverWait RamWait=new WebDriverWait(driver, Duration.ofSeconds(4));
  //     wait.until(ExpectedConditions.elementToBeClickable(ramdomRamOption));
  //     ramdomRamOption.click();

        //rumeysa codes = look back and study much better.

        /******************************************/
        List<WebElement> random=driver.findElements(By.cssSelector("[id='product_attribute_2']>option[value='0']~option"));
        int i = (int) (Math.random() * random.size());
        WebDriverWait waitop=new WebDriverWait(driver,Duration.ofSeconds(4));
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


    }
    @Test(priority = 7)
  //  @Parameters("aranacakKelime")
    void SearchTest(){

       WebElement search= driver.findElement(By.cssSelector("#small-searchterms"));

       //WebDriverWait waitEnd=new WebDriverWait(driver,Duration.ofSeconds(2));
       // wait.until(ExpectedConditions.elementToBeClickable(search));
        search.sendKeys("Adobe Photoshop CS4");

        driver.findElement(By.xpath("//*[@id='small-search-box-form']/button")).click();

        WebElement CS4Message= driver.findElement(By.xpath("//a[text()='Adobe Photoshop CS4']"));
        Assert.assertTrue(CS4Message.getText().contains("Adobe Photoshop CS4"));
    }
}








