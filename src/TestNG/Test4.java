package TestNG;

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Test4 extends BaseDriverParameter {

    @Test
    public void testTabMenuItems() {
       // driver.get("https://demo.nopcommerce.com/");
        WebElement tabMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']"));
        List<WebElement> tabMenuItems = tabMenu.findElements(By.tagName("li"));

        for (WebElement tabMenuItem : tabMenuItems) {
            String itemName = tabMenuItem.getText();
            System.out.println(itemName);
            // burada itemName değerleri ile istediğiniz doğrulama işlemini yapabilirsiniz.
        }

}
}
