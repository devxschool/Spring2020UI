package windowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {


    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close(); //--> closing current window only, if you have only one window open it would close the window and the browser
        driver.quit(); //->closing all the open windows, closing the browser
    }

    @Test
    public void tes1(){
        driver.get("https://www.google.com/");
        String currentWindowHandle = driver.getWindowHandle();

        System.out.println(currentWindowHandle);
    }

    @Test
    public void test2(){
        driver.get("http://www.practiceselenium.com/");

        driver.findElement(By.xpath("//a[text()='seleniumframework.com']")).click();
        String mainWindow = driver.getWindowHandle();// this will store the id of original window

        Set<String> allWindowHandles = driver.getWindowHandles(); //this will have ids of all open windows

        for(String windowHandle:allWindowHandles){
            if(!windowHandle.equals(mainWindow)){
                driver.switchTo().window(windowHandle);
            }
        }

        driver.findElement(By.xpath("//a[text()='Choosing an Automation Solution']")).click();

        WebElement agenda = driver.findElement(By.xpath("//strong[contains(text(),'Agenda')]"));

        Assert.assertTrue(agenda.isDisplayed());

        driver.switchTo().window(mainWindow);
        driver.findElement(By.linkText("Menu")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Check Out'][1]")).isDisplayed());

    }





}
