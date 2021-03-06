package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class GETStep {

    private static Response response;

    @Given("Eu executo o cen?rio de teste {string}")
    public void runTest(String testCase) {
        System.out.println(testCase);
    }

    @And("Eu envio a requisi??o GET {string}")
    public void requestGet(String url) throws Throwable {
         response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(url)
                .then()
                .extract().response();
    }

    @Then("Eu valido o status code da requisi??o GET {int}")
    public void statusCodeGetIs(int statuscode) {
        Assertions.assertEquals(statuscode, response.statusCode());
    }

    @And("Eu valido o retorno da requisi??o GET {string}")
    public void retornoGet(String title) {
        if (title.equals(""))
        {
            System.out.println(":::Retorno vazio:::");
        }
        else{
            Assertions.assertEquals(title, response.jsonPath().getString("title[1]"));
        }
    }

}
