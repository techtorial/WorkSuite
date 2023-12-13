package com.worksuite.work.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
    // IMPLEMENT THE CODE HERE
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        String email = "dev_techtorial@example.com";
        String password = "123456789";
        String webpage = "https://techtorialwork.com/worksuit/public/login";

        if (LoginTest(driver, webpage, email, password)){
            System.out.println("Successful");
        }
        else {
            System.out.println("Login Failed");
        }

        //close browser
        driver.quit();
    }

    private static boolean LoginTest(ChromeDriver driver, String webpage, String email, String password){
        //navigate to the login page
        driver.get(webpage);

        String title = driver.getTitle();

        try {

            //find the username and password input fields and login button
            WebElement usernameInput = driver.findElement(By.id("email"));
            WebElement passwordInput = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("submit-login"));

            //provide valid credentials
            usernameInput.sendKeys(email);
            passwordInput.sendKeys(password);

            //click the login button
            loginButton.click();

            //wait for a few seconds to see the result
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (title.equals(webpage)){
            return false;
            //TODO: add code to report login failure
        }
        else{
            //TODO: add code to report login success
            return true;
        }
    }

}
