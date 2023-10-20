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

public class checkout {
    WebDriver driver;
    String baseURL = "https://www.saucedemo.com/";
    @Given("User open browser")
    public void userOpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @And("user open website login page")
    public void userOpenWebsiteLoginPage() {
        driver.get(baseURL);
        String loginPageAssert = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @And("user input the valid username")
    public void userInputTheValidUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("user input the valid password")
    public void userInputTheValidPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @When("user clicked the login button")
    public void userClickedTheLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("user get redirected to dashboard page")
    public void userGetRedirectedToDashboardPage() {
        String dashboardAssert = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div")).getText();
        Assert.assertEquals(dashboardAssert, "Swag Labs");
    }

    @When("user see item in dashboard page")
    public void userSeeItemInDashboardPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]")).isDisplayed());
    }

    @And("user click add to cart button in each item")
    public void userClickAddToCartButtonInEachItem() {
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Then("user will see cart logo with number in it indicating item has been added")
    public void userWillSeeCartLogoWithNumberInItIndicatingItemHasBeenAdded() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).isDisplayed());
    }

    @When("user click the cart button")
    public void userClickTheCartButton() {
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    }

    @Then("user will redirected to your cart page")
    public void userWillRedirectedToYourCartPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }

    @And("user will see item QTY and item description that already been added before")
    public void userWillSeeItemQTYAndItemDescriptionThatAlreadyBeenAddedBefore() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]")).isDisplayed());
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("user will redirected to Checkout information page")
    public void userWillRedirectedToCheckoutInformationPage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }

    @And("user input firstname")
    public void userInputFirstname() {
        driver.findElement(By.id("first-name")).sendKeys("Amaral");
    }

    @And("user input lastname")
    public void userInputLastname() {
        driver.findElement(By.id("last-name")).sendKeys("Zidane");
    }

    @And("user input zip code")
    public void userInputZipCode() {
        driver.findElement(By.id("postal-code")).sendKeys("24434");
    }

    @When("user click continue button")
    public void userClickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("user will see detail item")
    public void userWillSeeDetailItem() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }

    @And("user will see detail payment information")
    public void userWillSeeDetailPaymentInformation() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")).isDisplayed());
    }

    @When("user click finish button")
    public void userClickFinishButton() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("user will redirected to Checkout complete page")
    public void userWillRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed());
    }

    @And("user will see success message")
    public void userWillSeeSuccessMessage() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).isDisplayed());
    }
}
