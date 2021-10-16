package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;
public class DELETEStep {
    private static Response response;

    @And("Eu envio a requisição DELETE {string}")
    public void requestDelete(String url) throws Throwable {
         response = given()
                .header("Content-type", "application/json")
                .when()
                .delete(url)
                .then()
                .extract().response();
    }

    @Then("Eu valido o status code da requisição DELETE {int}")
    public void statusCodeDeleteIs(int statuscode) {
        Assertions.assertEquals(statuscode, response.statusCode());
    }
}
