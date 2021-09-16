package com.libraryCt.UserStory3;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.Assertion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibrarianAddNewBook {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> userNames = new ArrayList<>(Arrays.asList("librarian43@library", "librarian18@library"));

        for (String name : userNames) {
    //1 Given librarian is on the homePage
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://library2.cybertekschool.com/login.html");
            driver.manage().window().maximize();

            WebElement email = driver.findElement(By.id("inputEmail"));
            email.sendKeys(name);
            System.out.println("Librarian userName = " + name);
            //password
            String password = "Sdet2022*";
            driver.findElement(By.id("inputPassword")).sendKeys(password);
            System.out.println("password = " + password);
            driver.findElement(By.cssSelector("#login-form > button")).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

   //2 When librarian click Books module
         //   Thread.sleep(2000);
            driver.findElement(By.linkText("Books")).click();
            Thread.sleep(1000);
    //3. Add librarian click "+Add Book" button
            driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")).click();

    //4. When librarian enter BookName, ISBN, Year, Author, and Description
            Faker faker = new Faker();

            String bookName = faker.book().title();
            System.out.println("bookName = " + bookName);
            String ISBN = faker.internet().ipV4Cidr();
            System.out.println("ISBN = " + ISBN);
            String year = ""+faker.date().birthday().getYear();
            System.out.println("year = " + year);
            String author = faker.book().author();
            System.out.println("author = " + author);
            String description = faker.chuckNorris().fact();
            System.out.println("description = " + description);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@name='name']")).sendKeys(bookName);
            driver.findElement(By.xpath("//input[@name='isbn']")).sendKeys(ISBN);
            driver.findElement(By.xpath("//input[@name='year']")).sendKeys(year);
            driver.findElement(By.xpath("//input[@name='author']")).sendKeys(author);
            driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys(description);

            //5. And librarian click save changes

            driver.findElement(By.xpath("//button[@type='submit']")).click();

            //6. Then verify a new book is added
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@type='search']")).sendKeys(bookName);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           // Thread.sleep(1000);



            WebElement findEl = driver.findElement(By.xpath("//table[@id='tbl_books']//td[text()='"+ISBN+"']"));

            System.out.println("findEl.getText() = " + findEl.getText());
            System.out.println("findEl.isDisplayed() = " + findEl.isDisplayed());

            List<WebElement>allBookInfo = driver.findElements(By.xpath("//table[@id='tbl_books']//tr"));
            for (WebElement element : allBookInfo) {

                if(element.getText().contains(ISBN) ){
                    System.out.println("element = " + element.getText());
                }
            }



            driver.close();




        }
    }
}
/*
Given librarian is on the homePage
When librarian click Books module
And librarian click “+Add Book” button
When librarian enter BookName, ISBN, Year, Author, and Description
And librarian click save changes
Then verify a new book is added
 */
