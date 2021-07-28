package ru.training.at.hw10.tests;

import static ru.training.at.hw10.core.TrelloBoardServiceObj.deleteAllBoards;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void setUp() {
        deleteAllBoards();
    }

    @AfterTest
    public void tearDown() {
        deleteAllBoards();
    }
}

