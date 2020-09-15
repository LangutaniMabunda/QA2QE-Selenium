package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.productlistPageObject;

import static org.junit.Assert.assertEquals;

public class productliststepdefinitions {
   WebDriver driver;
   productlistPageObject ProductlistPage;

    @Given("that i have opened url site")
    public void that_i_have_opened_url_site() {
        // open url site
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\mabundal\\Desktop\\Intellij\\Drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("https://magento.abox.co.za/index.php/");

        String expectedTitle = "Home Page";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


    }



    @When("I search for product")
    public void i_search_for_product() {
        // search for pants

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("pants");
        element.submit();
    }


    @Then("the view product list must be displayed")
    public void the_view_product_list_must_be_displayed() {
            //Verify expected page bodytext and actual page bodytext is same

         WebElement body = driver.findElement(By.tagName("Body"));
           String bodyText = body.getText();
          Assert.assertTrue("Does not contains the text 'pants'",bodyText.contains("pants"));

        //Negative test
       // Verify expected page bodytext and actual page bodytext is not the same

        //Assert.assertTrue("Does not contains the text 'Langu'",bodyText.contains("Langu"));
    }





}

