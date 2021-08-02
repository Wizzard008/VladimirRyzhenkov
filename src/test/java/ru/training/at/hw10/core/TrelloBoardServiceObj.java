package ru.training.at.hw10.core;

import static org.hamcrest.Matchers.lessThan;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpStatus;
import ru.training.at.hw10.beans.TrelloAnswer;

public class TrelloBoardServiceObj {

    public static final String TRELLO_URL = "https://api.trello.com/1/boards/";
    public static final String API_KEY = "9b7f8f269665ef6c3d04a0ce7e979ae5";
    public static final String SECRET = "72f60593b22762ec58a73cd2879c01c0115a229eb9acc5a4d431df869f47749e";
    public static final String TOKEN = "9322f5bad5b03c6dc4183417c615eb6ee1c358db0b8e4476dbb48d067ff451ac";
    public static final String BOARDS_URL = "https://api.trello.com/1/members/me/boards?fields=name,url,desc";

    private Method requestMethod;
    private Map<String, String> parameters;

    protected TrelloBoardServiceObj(Map<String, String> parameters, Method method) {
        this.parameters = parameters;
        this.requestMethod = method;
    }

    public static class ApiRequestBuilder {
        private Map<String, String> parameters = new HashMap<>();
        private Method requestMethod = Method.GET;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setBoardId(String boardId) {
            parameters.put("id", boardId);
            return this;
        }

        public ApiRequestBuilder setBoardName(String boardName) {
            parameters.put("name", boardName);
            return this;
        }

        public ApiRequestBuilder setBoardDescription(String boardDescription) {
            parameters.put("desc", boardDescription);
            return this;
        }

        public ApiRequestBuilder setBoardSubscription(Boolean subscription) {
            parameters.put("subscribed", String.valueOf(subscription));
            return this;
        }

        public TrelloBoardServiceObj buildRequest() {
            return new TrelloBoardServiceObj(parameters, requestMethod);
        }
    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public Response sendRequest() {
        String boardId = parameters.getOrDefault("id", "");
        return RestAssured
            .given(requestSpecification()).log().all()
            .queryParam("key", API_KEY)
            .queryParam("token", TOKEN)
            .header("Content-Type", "application/json")
            .queryParams(parameters)
            .request(requestMethod, TRELLO_URL + boardId)
            .prettyPeek();
    }

    public static TrelloAnswer getResultBoard(Response response) {
        return response.as(TrelloAnswer.class);
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
            .setAccept(ContentType.JSON)
            .setBaseUri(TRELLO_URL)
            .build();
    }

    public static ResponseSpecification goodResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    public static ResponseSpecification badResponseSpecification() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.TEXT)
            .expectResponseTime(lessThan(10000L))
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .build();
    }

    public static void deleteAllBoards() {
        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .log().everything()
            .auth().oauth(API_KEY, SECRET, TOKEN, TOKEN)
            .get(BOARDS_URL);

        List<TrelloAnswer> boards = new Gson()
            .fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswer>>() {
            }.getType());

        boards.forEach(board -> RestAssured
            .given()
            .log().everything()
            .auth().oauth(API_KEY, SECRET, TOKEN, TOKEN)
            .delete(TRELLO_URL + board.getId()));
    }

    public static List<TrelloAnswer> getAllBoards() {
        Response response = RestAssured
            .given()
            .header("Content-Type", "application/json")
            .log().everything()
            .auth().oauth(API_KEY, SECRET, TOKEN, TOKEN)
            .get(BOARDS_URL);

        return new Gson()
            .fromJson(response.asString().trim(), new TypeToken<List<TrelloAnswer>>() {
            }.getType());
    }
}
