package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;


public class AmazonDemo {
    WebDriver driver =new ChromeDriver();
    @Given("I am on the Amazon homepage")
    public void i_am_on_the_amazon_homepage() {
       driver.get("https://www.google.com");
       //(//*[.='Accept all'])[2]
         driver.findElement(By.xpath("(//*[.='Accept all'])[2]")).click();
    }
    @When("I search for {string}")
    public void i_search_for(String searchItem) {
    //google search
        driver.findElement(By.name("q")).sendKeys(searchItem);
        driver.findElement(By.name("btnK")).click();
    }
    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String src) {
        String title = driver.getTitle();
        Assert.assertTrue(driver.getTitle().contains(title));

    }

}
