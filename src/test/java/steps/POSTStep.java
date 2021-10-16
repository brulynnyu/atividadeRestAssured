package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;


public class POSTStep {

    private static Response response;
    private String requestBody;

    @And("Eu insiro os dados do Body {string}, {string} e {int}")
    public void dadosBody(String title, String body, String userId) throws Throwable {

        requestBody = "{\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"body\": \"" + body + "\",\n" +
                "  \"userId\": " + userId + "\n}";
        System.out.println("O body �::: " + requestBody);
    }

    @And("Eu envio a requisi��o POST {string}")
    public void requestPost(String url) throws Throwable {
        response = given()
                .header("Content-type", "application/json; charset=UTF-8")
                .and()
                .body(requestBody)
                .when()
                .post(url)
                .then()
                .extract().response();
        System.out.println("Status Code �::: " + response.statusCode());
    }

    @Then("Eu valido o status code da requisi��o POST {int}")
    public void statusCodePostIs(int statuscode) {
        Assertions.assertEquals(statuscode, response.statusCode());
    }

    @And("Eu valido o retorno da requisi��o POST {string}, {string} e {int}")
    public void retornoPost(String title, String body, String userId) {
        if (title.equals("") && (body.equals("") && (userId.equals(""))))
        {
            System.out.println(":::Retorno vazio:::");
        }
        else{
            Assertions.assertEquals(title, response.jsonPath().getString("title"));
            Assertions.assertEquals(body, response.jsonPath().getString("body"));
            Assertions.assertEquals(userId, response.jsonPath().getString("userId"));
        }
    }
}

