package com.trendyolbusraa;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AppTest {
    public static WebDriver driver;

    @BeforeClass

    public static void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.trendyol.com");
        driver.findElement(By.id("Group-38")).click();

    }

    @Test
    public void a_login() throws InterruptedException {
        driver.findElement(By.cssSelector("div.account-nav-item.user-login-container")).click();
        driver.findElement(By.id("login-email")).sendKeys("busra-9234@hotmail.com");
        driver.findElement(By.id("login-password-input")).sendKeys("654321b" + Keys.ENTER);
        Thread.sleep(3000);

    }

    @Test
    public void b_selectWoman() {
        driver.findElement(By.cssSelector("a[href='/butik/liste/1/kadin']")).click();

    }

    @Test

    public void c_searchbuton() {
        driver.findElement(By.cssSelector("input.search-box")).sendKeys("Kazak" + Keys.ENTER);

    }

    @Test
    public void d_productSelect() throws InterruptedException {
        driver.findElement(By.xpath("//body")).click();
        List<WebElement> img = driver.findElements(By.className("p-card-wrppr"));
        System.out.println(img.size());
        WebElement item = img.get(9);
        item.click();
        TimeUnit.SECONDS.sleep(5);

        //actions.moveToElement(driver.findElement(By.cssSelector("div.srch-prdcts-cntnr"))).click();
        //driver.findElements(By.cssSelector("div.prdct-cntnr-wrppr div.p-card-wrppr")).get(10).click();

    }

    @Test
    public void e_addFavorite() {
        driver.findElement(By.cssSelector(".fv>.i-heart")).click();

    }

    @Test
    public void f_addbasket() {
        driver.findElement(By.cssSelector("div>button.add-to-basket")).click();

    }
}