package ru.training.at.hw10.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.training.at.hw10.core.TrelloBoardServiceObj.badResponseSpecification;
import static ru.training.at.hw10.core.TrelloBoardServiceObj.getAllBoards;
import static ru.training.at.hw10.core.TrelloBoardServiceObj.getResultBoard;
import static ru.training.at.hw10.core.TrelloBoardServiceObj.goodResponseSpecification;
import static ru.training.at.hw10.core.TrelloBoardServiceObj.requestBuilder;
import static ru.training.at.hw10.util.DateAndTimeProvider.getCurrentTimeAsString;

import io.restassured.http.Method;
import java.util.List;
import java.util.stream.Collectors;
import org.testng.annotations.Test;
import ru.training.at.hw10.beans.TrelloAnswer;

public class TrelloApiTest extends BaseTest {

    @Test
    public void simpleTestToCheckCorrectResponse() {
        String boardDescription = "Demo Board created with pattern";
        String boardName = "TestingTrelloApi";

        requestBuilder()
            .setBoardName(boardName)
            .setBoardDescription(boardDescription)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()
            .then()
            .assertThat()
            .spec(goodResponseSpecification());
    }

    @Test
    public void simpleTestToCheckIncorrectResponse() {
        String boardRandomId = "DemoBoardId" + getCurrentTimeAsString();
        requestBuilder()
            .setBoardId(boardRandomId)
            .setMethod(Method.GET)
            .buildRequest()
            .sendRequest()
            .then()
            .assertThat()
            .spec(badResponseSpecification());
    }

    @Test
    public void testOfCreationProperBoard() {
        String boardDescription = "Demo Board created with pattern";
        String boardName = "TestBoard";

        TrelloAnswer resultBoard = getResultBoard(requestBuilder()
            .setBoardName(boardName)
            .setBoardDescription(boardDescription)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest());
        assertThat("Verify proper board name", resultBoard.getName(), equalTo(boardName));
        assertThat("Verify proper board description", resultBoard.getDesc(), equalTo(boardDescription));
    }

    @Test
    public void verifyProperBoardNameModification() {
        String boardNameInitial = "Demo Board created with pattern";
        String boardNameModified = "Board name modified at" + " " + getCurrentTimeAsString();

        String boardId = getResultBoard(
            requestBuilder()
                .setBoardName(boardNameInitial)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest())
            .getId();

        String actualBoardName = getResultBoard(
            requestBuilder()
                .setBoardName(boardNameModified)
                .setBoardId(boardId)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest())
            .getName();

        assertThat("Verify modification of board name", actualBoardName, equalTo(boardNameModified));
    }

    @Test
    public void verifyProperBoardDescModification() {
        String boardDescInitial = "Demo Board: description";
        String boardDescModified = "Description modified at" + " " + getCurrentTimeAsString();

        String boardId = getResultBoard(
            requestBuilder()
                .setBoardDescription(boardDescInitial)
                .setBoardName("Board created for Description Modification Testing")
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest())
            .getId();

        String actualBoardDesc = getResultBoard(
            requestBuilder()
                .setBoardDescription(boardDescModified)
                .setBoardId(boardId)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest())
            .getDesc();

        assertThat("Verify modification of board name", actualBoardDesc, equalTo(boardDescModified));
    }

    @Test
    public void verifyBoardSubscription() {

        String boardName = "Board created for test at" + " " + getCurrentTimeAsString();

        TrelloAnswer initialBoard = getResultBoard(
            requestBuilder()
                .setBoardName(boardName)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest());

        TrelloAnswer actualBoard = getResultBoard(
            requestBuilder()
                .setBoardId(initialBoard.getId())
                .setBoardSubscription(true)
                .setMethod(Method.PUT)
                .buildRequest()
                .sendRequest());

        assertThat("Board subscribed", actualBoard.getSubscribed());
    }

    @Test
    public void verifyBoardDeleteOperation() {

        int initialBoardsAmount = getAllBoards().size();

        String boardDescription = "Demo Board created with pattern";
        String boardName = "TestBoard";

        String boardId = getResultBoard(
            requestBuilder()
                .setBoardDescription(boardDescription)
                .setBoardName(boardName)
                .setMethod(Method.POST)
                .buildRequest()
                .sendRequest())
            .getId();

        requestBuilder()
            .setBoardId(boardId)
            .setMethod(Method.DELETE)
            .buildRequest()
            .sendRequest()
            .then()
            .assertThat()
            .spec(goodResponseSpecification());

        int actualBoardsAmount = getAllBoards().size();

        assertThat("Verify that amount of boards didn't change", initialBoardsAmount, equalTo(actualBoardsAmount));
    }

    @Test
    public void createTwoBoardsWithTheSameName() {
        String boardDescription = "Demo Board created with pattern";
        String boardName = "TestingTrelloApi";

        requestBuilder()
            .setBoardName(boardName)
            .setBoardDescription(boardDescription)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()
            .then()
            .assertThat()
            .spec(goodResponseSpecification());

        requestBuilder()
            .setBoardName(boardName)
            .setBoardDescription(boardDescription)
            .setMethod(Method.POST)
            .buildRequest()
            .sendRequest()
            .then()
            .assertThat()
            .spec(goodResponseSpecification());

        List<TrelloAnswer> listOfAllBoards = getAllBoards();
        List<String> boardsNames = listOfAllBoards.stream().map(TrelloAnswer::getName).collect(Collectors.toList());

        assertThat("Amount of created boards is 2", listOfAllBoards.size(), equalTo(2));
        assertThat("Boards have the same name", boardsNames, everyItem(equalTo(boardName)));
    }
}
