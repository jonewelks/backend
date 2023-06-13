package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import static Base.Token.token;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

public class MyStepDefinitions {

    private Response response;
    protected Map<String, Object> headers = new HashMap<String, Object>();
    SetEnviromentSicred ambiente = new SetEnviromentSicred();
    private String env = ambiente.baseUrl();

    @Given("I set the headers")
    public void setHeaders() {
        // Defina os cabeçalhos (headers) aqui
        headers.put("content-type", "application/json");
    }

    @Given("I set the headers and Token")
    public void setHeadersToken() {
        // Defina os cabeçalhos (headers) aqui
        headers.put("content-type", "application/json");
        headers.put("Authorization", "Bearer " + token);
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String path) {
        response =
                given()
                .headers(headers)
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .get(env + path);
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String path, String jsonBody ) {
        response =
                given()
                        .headers(headers)
                        .body(jsonBody)
                        .relaxedHTTPSValidation()
                        .log().all()
                        .when()
                        .post(env + path);
    }

    @Then("I should receive a response {int}")
    public void verifyResponse(int httpStatusCode) {
        response.then()
                .log().all();
        Assert.assertEquals(response.statusCode(), httpStatusCode);
    }

    @And("I Save Token a response")
    public void saveResponse() {
        response.then()
                .log().all();
        token = response.getBody().path("token");
    }

    @Then("I should receive a response not null {string}")
    public void verifyResponseBody(String pathResponse) {
        response.then()
                .log().all();
        Assert.assertNull(response.path(pathResponse));
    }


}
