package practiceqaglobant.tests;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import practiceqaglobant.Pages.*;


/**
 * Unit test for simple App.
 */
public class BaseTest {
    private WebDriver driver;

    public BaseTest() {
        this.driver = new ChromeDriver();
    }

    public HomePage navigateToHomePage() {
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
        return new HomePage(driver);
    }


    protected String getRandomPokemon() {
        Response response = given()
                .when()
                .get("https://pokeapi.co/api/v2/pokemon/")
                .then()
                .statusCode(200)
                .extract().response();

        List<Map<String, String>> pokemons =  response.jsonPath().getList("forms");
        return pokemons.get((int) (Math.random() * 25)).get("name");
    }

    /* @After
    public void tearDown() {
    hook.tearDown();
    }
 */

    public String getPokemonByPokedexNumber(int pokedexNumber) {
        Response response = given()
                .when()
                .get("https://pokeapi.co/api/v2/pokemon/" + pokedexNumber)
                .then()
                .statusCode(200)
                .extract().response();
        List<Map<String, String>> pokemons =  response.jsonPath().getList("forms");
        return pokemons.get(0).get("name");
    }

    public WebDriver getDriver() {
        return driver;
    }

    
}
