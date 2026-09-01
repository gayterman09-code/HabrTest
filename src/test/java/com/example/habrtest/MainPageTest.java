package com.example.habrtest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class MainPageTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://www.github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {driver.quit();}

    @Test
    public void avtorTest() {

        WebElement userIcon = driver.findElement(By.cssSelector("#app > div > div.tm-footer-menu > div > div > div:nth-child(3) > div > ul > li:nth-child(1) > a"));
        userIcon.click();

        WebElement tablink = driver.findElement(By.xpath("//*[@id='app']/div/header/div[2]/div/a[contains(text(), 'Все потоки')]"));
                tablink.click();

        assertTrue(driver.findElement(By.xpath("//*[@id='app']/div/div[3]/main/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div/span[5]/a")).isDisplayed(),  "Авторы не найден");

    }


    @Test

    public void companyTest() {
        WebElement userIcon = driver.findElement(By.cssSelector("#app > div > div.tm-footer-menu > div > div > div:nth-child(3) > div > ul > li:nth-child(1) > a"));
        userIcon.click();

        WebElement tablink = driver.findElement(By.xpath("//*[@id='app']/div/header/div[2]/div/a[contains(text(), 'Все потоки')]"));
        tablink.click();

        assertTrue(driver.findElement(By.xpath("//*[@id='app']/div/div[3]/main/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div/span[5]/a")).isDisplayed(),  "Компании не найден");

    }
}
