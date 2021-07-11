package ru.training.at.hw7.tests;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;
import ru.training.at.hw7.entities.TestData;

public class TestDataProvider {
    @DataProvider(name = "TestDataProvider")
    public Object[] testDataSet() throws IOException {
        FileReader reader = new FileReader("src/test/resources/JDI_ex8_metalsColorsDataSet.json");
        JsonObject object = Json.parse(reader).asObject();
        int index = 0;
        List<TestData> testDataList = new ArrayList<>();
        for (; ; ) {
            index++;
            String parser = "data_" + index;
            try {
                JsonObject orders = object.get(parser).asObject();
                JsonValue summaryValue = orders.get("summary");
                JsonValue elementsValue = orders.get("elements");
                JsonValue colorValue = orders.get("color");
                JsonValue metalsValue = orders.get("metals");
                JsonValue vegetablesValue = orders.get("vegetables");
                int[] summary = new int[summaryValue.asArray().size()];
                for (int i = 0; i < summaryValue.asArray().size(); i++) {
                    summary[i] = (summaryValue.asArray().get(i).asInt());
                }
                String[] elements = new String[elementsValue.asArray().size()];
                for (int i = 0; i < elementsValue.asArray().size(); i++) {
                    elements[i] = (elementsValue.asArray().get(i).asString());
                }

                String color = colorValue.asString();
                String metal = metalsValue.asString();

                String[] vegetables = new String[vegetablesValue.asArray().size()];
                for (int i = 0; i < vegetablesValue.asArray().size(); i++) {
                    vegetables[i] = (vegetablesValue.asArray().get(i).asString());
                }

                TestData testData =
                    new TestData(summary, elements, color, metal, vegetables);
                testDataList.add(testData);
            } catch (Exception e) {
                break;
            }
        }
        return testDataList.toArray();
    }
}

