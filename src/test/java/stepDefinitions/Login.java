package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.pageLogin;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com";
    pageLogin elementLogin = new pageLogin();

    @Given("user is on SauceDemo homepage")
    public void user_is_on_SauceDemo_homepage() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);

        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @When("user input (.*) as username$")
    public void input_username(String username) {
        WebElement user_name = driver.findElement(elementLogin.getUser_name());
        user_name.isDisplayed();
        user_name.sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void input_password(String password) {
        WebElement pass_user = driver.findElement(elementLogin.getPasswd());
        Assert.assertTrue(pass_user.isEnabled());
        pass_user.sendKeys(password);
    }

    @And("user click enter")
    public void click_enter() {
        WebElement pass_user =driver.findElement(elementLogin.getPasswd());
        pass_user.sendKeys(Keys.ENTER);
    }

    @Then("user verify (.*) login result$")
    public void user_verify_success_login(String status) {
        if(status.contains("success")) {
//            wait.until(
//                    ExpectedCondition.presenceOfElementLocated(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"))
                    driver.findElements(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
//            );
        }else{
            driver.findElement(By.className("error-button"));
        }
    }

    @Then("user verify failed login")
    public void user_verify_failed_login() {driver.findElement(By.className("error-button"));}

}
