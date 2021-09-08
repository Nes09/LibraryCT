package com.libraryCt.UserStory1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginAsStudent {
    public static void main(String[] args) throws InterruptedException{
        ArrayList<String> userNames = new ArrayList<>(Arrays.asList("student54@library", "student55@library", "student56@library"));

        for (String name : userNames) {

            //Given student is on the loginPage
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");

            //Then verify that the URL is “https://library2.cybertekschool.com/login.html”
            String expectedURL ="https://library2.cybertekschool.com/login.html";
            String actualURL = driver.getCurrentUrl();
            System.out.println("actualURL = " + actualURL);

            if (expectedURL.equals(actualURL)) {
                System.out.println("URL verification Passed!");
            } else {
                System.out.println("URL verification Failed!!!");
                System.out.println("Expected URL = " + expectedURL);
                System.out.println("Actual URL = " + actualURL);
            }


            //When student enters valid email address and password
            driver.findElement(By.id("inputEmail")).sendKeys(name);
            System.out.println("Students userName = " + name);
            //password
            String password = "Sdet2022*";
            driver.findElement(By.id("inputPassword")).sendKeys(password);
            System.out.println("password = " + password);

            //And student click sign in button
            driver.findElement(By.cssSelector("#login-form > button")).click();

            Thread.sleep(3000);
            //Then verify that there are 2 models on the page
            List<WebElement> titles = driver.findElements(By.xpath("//li[@class='nav-item']"));
            System.out.println("titles.size() = " + titles.size());

            ArrayList<String> title  = new ArrayList<>(Arrays.asList("Books", "Borrowing Books"));
            int index = 0;
            for (WebElement element : titles) {
                if(element.getText().equals(title.get(index))){
                    System.out.println("Title verification Passed! \nExpected result = " + element.getText());
                } else {
                    System.out.println("Title verification Failed!!!");
                    System.out.println("Expected result = "+element.getText());
                }
                index++;
            }

            driver.quit();

        }

    }
}
/*
Given student is on the loginPage
Then verify that the URL is “https://library2.cybertekschool.com/login.html”
When student enters valid email address and password
And student click sign in button
Then verify that there are 2 models on the page
 */