package api.controller.service;

import api.controller.utility.constant.Keyword;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static api.controller.utility.LogUtils.logInfo;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class GeneralApiController {

    private RequestSpecification spec;

    public GeneralApiController() {
    }

    public GeneralApiController(String baseUrl) {
        this.spec = new RequestSpecBuilder().setBaseUri(baseUrl).setBasePath("/").build();
    }

    protected ReadableResponse getRequest(String endPoint) {
        Response response = given()
                .spec(spec)
                .header(Keyword.CONTENT_TYPE, Keyword.APPLICATION_JSON)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();

        logInfo(format("Endpoint: %s, Request Type: %s", endPoint, "get"));

        return new ReadableResponse(response);
    }

    public RequestSpecification getSpec() {
        return spec;
    }
}
