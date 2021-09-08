package com.libraryCt.UserStory1;

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
            System.out.println("Title verification Passed!");
        } else {
            System.out.println("Title verification Failed!!!");
            System.out.println("Expected Title = " + expectedTitle);
            System.out.println("Actual Title = " + actualTitle);
        }


            //When librarian enters valid email address and password
            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(name);
            System.out.println("Librarian userName = " + name);
            //password
            String password = "Sdet2022*";
            driver.findElement(By.id("inputPassword")).sendKeys(password);
            System.out.println("password = " + password);

            //And librarian click sign in button
           driver.findElement(By.cssSelector("#login-form > button")).click();

            //Then verify that there are 3 models on the page
            Thread.sleep(3000); //needs to wait until page load and we can locate the title!

            List<WebElement> titles = driver.findElements(By.xpath("//li[@class='nav-item']"));
            System.out.println("titles.size() = " + titles.size());

            ArrayList<String> title  = new ArrayList<>(Arrays.asList("Dashboard","Users", "Books"));
            int index = 0;
            for (WebElement element : titles) {
                if(element.getText().equals(title.get(index))){
                    System.out.println("Title verification Passed: \nExpected result = " + element.getText());
                } else {
                    System.out.println("Title verification Failed!!!");
                    System.out.println("Expected title = "+element.getText());
                }
                index++;
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