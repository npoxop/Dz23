package ru.dz23;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    WebDriver webDriver;

    @Test
    public void google(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\npoxop\\IdeaProjects\\DZ23\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.google.ru/");
        WebElement searchInput = webDriver.findElement(By.name("q"));
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
