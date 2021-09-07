package com.libraryCt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginAsLibrarian {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<String> userNames = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library"));

        for (String name : userNames) {

            //Given librarian is on the loginPage
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

        //Then verify that the title is “Login - Library”
        String expectedTitle = "Login - Library";
        String actualTitle = driver.getTitle();
            System.out.println("actualTitle = " + actualTitle);

            if (expectedTitle.equals(actualTitle)) {
            System.out.println("Title verification Pass!");
        } else {
            System.out.println("Title verification Failed!!!");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }


            //When librarian enters valid email address and password
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(name);
            System.out.println("Librarian userName = " + name);
            //password
            String password = "Sdet2022*";
            driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");
            System.out.println("password = " + password);

            //And librarian click sign in button
           driver.findElement(By.cssSelector("#login-form > button")).click();
            
            //Then verify that there are 3 models on the page
            Thread.sleep(3000);

            //
            List<WebElement> titles = driver.findElements(By.xpath("//li[@class='nav-item']"));
            System.out.println("titles.size() = " + titles.size());


            if (driver.findElement(By.linkText("Dashboard")).getText().equals("Dashboard")) {
                System.out.println("Title verification passed: " + driver.findElement(By.linkText("Dashboard")).getText());
            } else {
                System.out.println("Title verification failed");
            }

            if (driver.findElement(By.linkText("Users")).getText().equals("Users")) {
                System.out.println("Title verification passed: " + driver.findElement(By.linkText("Users")).getText());
            } else {
                System.out.println("Title verification failed!!!");
            }

            if (driver.findElement(By.linkText("Books")).getText().equals("Books")) {
                System.out.println("Title verification passed: " + driver.findElement(By.linkText("Books")).getText());
            } else {
                System.out.println("Title verification failed!!!");
            }

            driver.close();

        }


    }

}
/*
Given librarian is on the loginPage
Then verify that the title is “Login - Library”
When librarian enters valid email address and password
And librarian click sign in button
Then verify that there are3 models on the page
 */