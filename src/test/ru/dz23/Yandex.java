package ru.dz23;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Yandex {
    WebDriver webDriver;

    @Before
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\npoxop\\IdeaProjects\\DZ23\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void yandex(){
        webDriver.get("https://yandex.ru");
        WebElement searchInput = webDriver.findElement(By.cssSelector("#text"));
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
