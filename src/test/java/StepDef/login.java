package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    WebDriver driver;
    String basURL = "https://www.saucedemo.com/";
    @Given("user open browser")
    public void user_open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(basURL);
        driver.manage().window().maximize();
    }

    @And("user open the website")
    public void user_open_the_website() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user input username")
    public void user_input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input password")
    public void user_input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user tap the login button")
    public void user_tap_the_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user will redirected to dashboard page")
    public void user_will_redirected_to_dashboard_page() {
        String dashboardAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(dashboardAssert, "Swag Labs");
    }

    @And("user input invalid password")
    public void userInputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("54413");
    }

    @Then("user will see error message")
    public void userWillSeeErrorMessage() {
        String errorAssert = driver.findElement(By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3")).getText();
        Assert.assertEquals(errorAssert, "Epic sadface: Username and password do not match any user in this service");
    }
}
