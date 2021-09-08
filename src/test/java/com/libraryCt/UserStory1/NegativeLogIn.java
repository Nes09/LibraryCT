package com.libraryCt.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NegativeLogIn {
    public static void main(String[] args) {
        //Given user is on the loginPage
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

        //When user enters invalid email address or password
        driver.findElement(By.id("inputEmail")).sendKeys("Username");
        System.out.println("Students userName = " + "Username");
        //password
        String password = "password";
        driver.findElement(By.id("inputPassword")).sendKeys(password);
        System.out.println("password = " + password);

        //And  user click sign in button
        driver.findElement(By.cssSelector("#login-form > button")).click();

        //Then verify the error message “Sorry, Wrong Email or Password”
       WebElement errorMessage = driver.findElement(By.id("inputEmail-error"));
       String expectedMessage = "Sorry, Wrong Email or Password";
       if(errorMessage.equals(expectedMessage)) {
           System.out.println("Test is Pass! \nActual result = " + errorMessage.getText());
       }else{
           System.out.println("Test is Fail!!! \nActual result = "+errorMessage.getText());
           System.out.println("Expected result = "+expectedMessage);
       }

       
       driver.close();
    }
}
/*
Given user is on the loginPage
When user enters invalid email address or password
And  user click sign in button
Then verify the error message “Sorry, Wrong Email or Password”
 */