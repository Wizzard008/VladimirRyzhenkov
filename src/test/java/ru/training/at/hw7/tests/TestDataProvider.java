package ru.training.at.hw7.tests;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.testng.annotations.DataProvider;
import ru.training.at.hw7.entities.TestData;

public class TestDataProvider {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
    public static final String RESOURCE_ROOT_FOLDER = "src/test/resources/";
    public static final String METALS_AND_COLORS_DATA = "metals.and.colors.data";

    @DataProvider(name = "TestDataProvider")
    public Object[] testDataSet() throws IOException {
        String dataFilePath = RESOURCE_ROOT_FOLDER + resourceBundle.getString(METALS_AND_COLORS_DATA);
        FileReader reader = new FileReader(dataFilePath);
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
            } catch (NullPointerException e) {
                break;
            }
        }
        return testDataList.toArray();
    }
}

