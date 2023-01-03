package com.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

import static junit.framework.TestCase.assertEquals;

public class TestNGDataProvader {

    WebDriver driver;
    By singInLocator= By.linkText("My Account");
    By emailInput=By.id("username");
    By passwordInput=By.id("password");
    By submit=By.name("login");
    By logoutLocator=By.linkText("Sign out");



    @BeforeClass
    public void  beforeClass(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\matia\\OneDrive\\Escritorio\\Selenium Web Driver\\Selenium Web Driver #P2\\OneSelenium\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in/");
    }

    @Test(dataProvider = "authenticationData")
    public void login(String email,String password){
    if (driver.findElement(singInLocator).isDisplayed()){
        driver.findElement(singInLocator).click();

        //singIn

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));

        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);

        driver.findElement(submit).click();
        assertEquals(driver.findElement(logoutLocator).getText(),"Sign out");

        driver.findElement(logoutLocator).click();
    }else {
        System.out.println("Logout link not found");
    }

    }

    @DataProvider(name = "authenticationData")
    public Object[][] getData(){
        Object[][] data =new Object[2][2];
        data[0][0]="pruebaOne@gmail.com"; data[0][1]="Clavedebarrio2088";
        data[1][0]="pruebaTwo@gmail.com"; data[1][1]="Clavedebarrio2088";

        return data;
    }


    @AfterClass
    public void afterClass(){
        //driver.close();
    }

}
