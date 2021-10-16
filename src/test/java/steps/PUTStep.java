package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

public class PUTStep {

    private static Response response;
    private String requestBody;

    @And("Body para a requisição PUT {string}, {string}, {int} e {int}")
    public void dadosBodyPut(String title, String body, String userId, String id) throws Throwable {

        requestBody = "{\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"body\": \"" + body + "\",\n" +
                "  \"userId\": " + userId + ",\n" +
                "  \"id\": " + id + "\n}";
        System.out.println(requestBody);
    }

    @And("Eu envio a requisição PUT {string}")
    public void requestPut(String url) throws Throwable {
         response = given()
                .header("Content-type", "application/json; charset=UTF-8")
                .and()
                .body(requestBody)
                .when()
                .put(url)
                .then()
                .extract().response();
        System.out.println(response.statusCode());
    }

    @Then("Eu valido o status code da requisição PUT {int}")
    public void statusCodePutIs(int statuscode) {
        Assertions.assertEquals(statuscode, response.statusCode());
    }


    @And("Eu valido o retorno da requisição PUT {string}, {string}, {int} e {int}")
    public void retornoPUT(String title, String body, String userId, String id) {
        if (title.equals("") && (body.equals("") && (userId.equals("")) && (id.equals(""))))
        {
            System.out.println(":::Retorno vazio:::");
        }
        else{
            Assertions.assertEquals(title, response.jsonPath().getString("title"));
            Assertions.assertEquals(body, response.jsonPath().getString("body"));
            Assertions.assertEquals(userId, response.jsonPath().getString("userId"));
            Assertions.assertEquals(id, response.jsonPath().getString("id"));
        }
    }
}

