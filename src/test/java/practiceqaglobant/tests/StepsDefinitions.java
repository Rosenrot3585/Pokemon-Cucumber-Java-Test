package practiceqaglobant.tests;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import practiceqaglobant.Pages.*;

public class StepsDefinitions{
    private HomePage homePage;
    private ResultPage resultPage;
    private BaseTest baseTest;

    public StepsDefinitions() {
        this.baseTest = new BaseTest();
    }

    @Before
    public void setup(Scenario scenario) {
        baseTest.navigateToHomePage();
        baseTest.getDriver().manage().window().maximize();
    }
     @After
    public void tearDown() {
        baseTest.getDriver().close();
    }

    @Given("User is on the Wikipedia Website")
    public void user_navigates_to_Wikipedia_page() throws Throwable {
        homePage = baseTest.navigateToHomePage();
    }
    @When("User searches for the name of the Pokemon with the Pokedex N° {int}")
    public void user_searches_for_pokemon_with_pokedex_number(int pokedexNumber) throws Throwable {
        String pokemon = baseTest.getPokemonByPokedexNumber(pokedexNumber);
        System.out.println("User searches for the name of the Pokemon with the Pokedex N° " + pokedexNumber);
        resultPage = homePage.searchText(pokemon);
    }
    @Then("User should be able to see the article page correctly displayed for the Pokemon {string}")
public void user_should_see_the_Pokemon_details(String name) throws Throwable {
    resultPage.isTitleCorrect(name);
}
    
}
