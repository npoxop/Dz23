package ru.dz23;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    WebDriver webDriver;

    @Before
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\npoxop\\IdeaProjects\\DZ23\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void google(){
        webDriver.get("https://www.google.ru/");
        WebElement searchInput = webDriver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
        searchInput.sendKeys("Hello World");
        searchInput.submit();

        String title = webDriver.getTitle();
        Assert.assertTrue(title.contains("Hello World"));
    }

    @After
    public void closeDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
