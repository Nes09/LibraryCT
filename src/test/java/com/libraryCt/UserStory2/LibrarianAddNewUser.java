package com.libraryCt.UserStory2;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.ArrayList;
import java.util.Arrays;

public class LibrarianAddNewUser {
    public static void main(String[] args) throws InterruptedException {
        //Given librarian is on the homePage
        ArrayList<String> userNames = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library"));

        for (String name : userNames) {
            //Given librarian is on the loginPage
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");

            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(name);
            System.out.println("Librarian userName = " + name);
            //password
            String password = "Sdet2022*";
            driver.findElement(By.id("inputPassword")).sendKeys(password);
            System.out.println("password = " + password);
            driver.findElement(By.cssSelector("#login-form > button")).click();

        //When librarian click Users module
            Thread.sleep(2000);
            driver.findElement(By.linkText("Users")).click();

            Thread.sleep(2000);
            //And librarian click “+Add User” button
            driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm' ]")).click();

            //When librarian enter full name, password, email and address
            Faker faker = new Faker();
            String fullName = faker.name().fullName();
            String pswd = faker.internet().password();
            String mail = faker.internet().emailAddress();
            System.out.println("fullName = " + fullName);
            System.out.println("pswd = " + pswd);
            System.out.println("mail = " + mail);
            Thread.sleep(1000);
            driver.findElement(By.name("full_name")).sendKeys(fullName);
            driver.findElement(By.name("password")).sendKeys(pswd);
            driver.findElement(By.name("email")).sendKeys(mail);

            //And librarian click save changes
             driver.findElement(By.xpath("//button[@type='submit']")).click();

             //Then verify a new user is created
            WebElement newUser = driver.findElement(By.xpath("//*[@id=\"tbl_users\"]/tbody/tr[1]/td[1]"));
           if(newUser.isDisplayed()) {
               System.out.println("Test PASSED!\nNew User is Displayed = " + newUser.isDisplayed());
           }else{
               System.out.println("Test FAILED!!! \nNew User is not displayed");
           }

             driver.close();

        }

    }
}
/*
Given librarian is on the homePage
When librarian click Users module
And librarian click “+Add User” button
When librarian enter full name, password, email and address
And librarian click save changes
Then verify a new user is created
 */