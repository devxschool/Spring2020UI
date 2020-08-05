package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicValidationSteps {
    WebDriver driver;

    @Given("^the user is on the MeetUp homepage$")
    public void the_user_is_on_the_MeetUp_homepage() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.meetup.com/");
    }

    @Then("^the title should be \"([^\"]*)\"$")
    public void the_title_should_be(String expectedTitle) throws Throwable {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        driver.close();
    }
}
