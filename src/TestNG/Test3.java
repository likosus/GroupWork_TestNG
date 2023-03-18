package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Utility.BaseDriver.driver;


public class Test3 {
    @Test(dataProvider = "mailData")

    void mailTest(String email, String password) {
        System.out.println("email = " + email+password);

driver.get("https://demo.nopcommerce.com/");
   driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")).click();

   driver.findElement(By.xpath("//*[@id='Email']")).sendKeys( email);

   driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);

   driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();


   WebElement succesMessage= driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2"));
   Assert.assertTrue(succesMessage.getText().contains("Welcome to our store"),"Lütfen tekrar deneyniiz");



    }





    @DataProvider
    public Object[][] mailData(){

        Object[][] data ={
                {"likosmustaf@gmail.com","123456"},
                {"rumbk1@hotmail.com","123456"},

        };
        return data;
    }
}
