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

        //Given librarian is on the loginPage
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

        //Then verify that the title is “Login - Library”
        String expectedTitle = "Login - Library";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.printf("match");
        }else{
            System.out.printf("not match");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        //When librarian enters valid email address and password
          WebElement email = driver.findElement(By.id("inputEmail"));
          email.sendKeys("librarian50@library");

          Thread.sleep(3000);

          WebElement password = driver.findElement(By.id("inputPassword"));
          password.sendKeys("Sdet2022*");

        Thread.sleep(3000);

        //And librarian click sign in button
        WebElement signInBtn = driver.findElement(new By.ByCssSelector("button"));
        signInBtn.click();

        Thread.sleep(3000);



        //Then verify that there are 3 models on the page
      List<String> expectedModules = new ArrayList<>(Arrays.asList("Dashboard" , "Users", "Books"));

      //List<WebElement> actualModules = driver.findElements(By.id());






        //driver.quit();
    }
}
/*
Given librarian is on the loginPage
Then verify that the title is “Login - Library”
When librarian enters valid email address and password
And librarian click sign in button
Then verify that there are3 models on the page
 */