import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main (String[] args){
        WebDriver driver = initChromeDriver();
   
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement login = driver.findElement(By.id("email")); 
        login.sendKeys("webinar.test@gmail.com"); 

        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement button = driver.findElement(By.name("submitLogin")); 
       waittime(); 
     
        button.submit(); 
        waittime();

        WebElement catalog = driver.findElement(By.linkText("Каталог"));
     
        Actions find = new Actions(driver);
        find.moveToElement(catalog).build().perform();
     
        waittime();
        WebElement catalogi = driver.findElement(By.xpath("//*[@id=\"subtab-AdminCategories\"]/a"));
      
        catalogi.click();


    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Test3.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

   public static void waittime() {   //создание метода время ожидания загрузки
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
