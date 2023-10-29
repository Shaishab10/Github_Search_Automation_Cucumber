package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GithubHomePage;
import setup.Setup;


public class GithubStepDefinitions extends Setup {

    GithubHomePage githubHomePage;

    @Given("User visited the Github site")
    public void user_visited_the_github_site() {
        driver.get("https://github.com");
    }
    @When("User search with {string}")
    public void user_search_with(String repoName) throws InterruptedException {
        githubHomePage = new GithubHomePage(driver);
        githubHomePage.doSearch(repoName);

    }
    @Then("User verify with {string}")
    public void user_verify_with(String repoExpectName) throws InterruptedException {
        githubHomePage = new GithubHomePage(driver);
        Thread.sleep(2000);
        String repoActual = githubHomePage.repoResultField.get(0).getText();
        Assert.assertTrue(repoActual.contains(repoExpectName));
    }
    @When("User click the About button in the landing page footer")
    public void user_click_the_about_button_in_the_landing_page_footer() throws InterruptedException {
        githubHomePage = new GithubHomePage(driver);
        githubHomePage.doClick();

    }

    @Then("User verify the About page")
    public void user_verify_the_about_page() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("about"));;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
