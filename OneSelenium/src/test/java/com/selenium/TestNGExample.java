package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class TestNGExample {

    WebDriver driver;
    By searchBoxLocator= By.name("s");
    By resultsLocator= By.cssSelector("h1.page-title");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\matia\\OneDrive\\Escritorio\\Selenium Web Driver\\Selenium Web Driver #P2\\OneSelenium\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/");
    }

    @Test
    public void search_html(){
        WebElement searchBox=driver.findElement(searchBoxLocator);
        searchBox.clear();
        searchBox.sendKeys("html");
        searchBox.submit();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));

        System.out.println("This is the result number: "+ driver.findElement(resultsLocator).getText());

        assertTrue("Not found",driver.findElement(resultsLocator).isDisplayed());

    }

    @AfterClass
    public void afterClass(){
        //driver.close();

    }


}
