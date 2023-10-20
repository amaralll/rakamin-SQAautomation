package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class logout {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";
    @Given("user open browser and login to website")
    public void userOpenBrowserAndLoginToWebsite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user input valid username")
    public void userInputValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input valid password")
    public void userInputValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user will redirected to dashboard page with menu button")
    public void userWillRedirectedToDashboardPageWithMenuButton() {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).isDisplayed();
    }

    @When("user click menu button")
    public void userClickMenuButton() {
        driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @And("user click logout button")
    public void userClickLogoutButton() {
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    @Then("user will redirected to login page")
    public void userWillRedirectedToLoginPage() {
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @Then("user close the browser")
    public void user_close_the_browser() {
        driver.close();
    }
}
