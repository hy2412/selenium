package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormInteraction {
    public static void main(String[] args) {
        WebDriver driver = driver.getChromeDriver();
        try {
            //Define selector  values
            driver.get("https://the-internet.herokuapp.com/login");
            By usernameSel = By.id("#username");
            By passwordSel = By.cssSelector("#password");
            By buttonLogin = By.cssSelector("button[type='submit']");
            //Find elements
            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginButtonElem = driver.findElement(buttonLogin);
            // interact
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            //Refresh page
            driver.navigate().refresh();
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginButtonElem.click();

            //User dashboard page
            By headingSel =  By.cssSelector("h2");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(headingSel)));

            //  wait.until(ExpectedConditions.urlToBe("driver.findElement(headingSel)"));

            WebElement  headingElem = driver.findElement(headingSel);
            System.out.println("Heading title: "+headingElem.getText());

            //Find by link text, partialLinkText
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getText());
            System.out.println(driver.findElement(By.partialLinkText("Elemental")).getText());
            System.out.println(driver.findElement(By.linkText("Elemental Selenium")).getAttribute("href"));
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

            //Debug
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
