package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemler() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize(); // Ekranı max yapıyor.

        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);


        wait = new WebDriverWait(driver,
                Duration.ofSeconds(30));
        loginTest();

    }

    @AfterClass
    public void bitisIslemleri() {
        Tools.Bekle(5);
        driver.quit();
    }


    void loginTest() {

        System.out.println("Login Test");


        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");

        WebElement inputEmail = driver.findElement(By.cssSelector("#Email"));
        inputEmail.sendKeys("likosmustaf@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("123456");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginBtn.click();

       // Assert.assertTrue(driver.getTitle().equals("My Account"));
        // Assert.assertTrue(driver.getCurrentUrl().contains("account/account"));

    }
}


