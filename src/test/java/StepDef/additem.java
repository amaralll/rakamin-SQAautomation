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

import java.time.Duration;

public class additem {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";
    @Given("user open the browser")
    public void userOpenTheBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("user open website and see the login page")
    public void userOpenWebsiteAndSeeTheLoginPage() {
        driver.get(baseURL);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @Then("user input the username")
    public void userInputTheUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input the password")
    public void userInputThePassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user will redirected to the dashboard page")
    public void userWillRedirectedToTheDashboardPage() {
        String dashboardAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(dashboardAssert, "Swag Labs");
    }

    @When("user see several item in dashboard page")
    public void userSeeSeveralItemInDashboardPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]")).isDisplayed());
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Then("user will see the cart logo with number of the item being added")
    public void userWillSeeTheCartLogoWithNumberOfTheItemBeingAdded() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).isDisplayed());
    }
}
