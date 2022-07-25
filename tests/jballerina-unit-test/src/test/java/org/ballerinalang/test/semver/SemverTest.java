package org.ballerinalang.test.semver;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import static org.ballerinalang.test.semver.SemverUtilTest.executeTestData;

/**
 * Function definition comparator related test cases.
 *
 * @since 2201.2.0
 */
public class SemverTest {

    private static final String TEST_DATA_ROOT = "src/test/resources/test-src/semver/";
    private static final String SEMVER_TESTCASE = TEST_DATA_ROOT + "basic.json";


    @Test(dataProvider = "TestDataProvider")
    public void testSemver(JsonElement testData) throws Exception {
        executeTestData(testData);
    }


    @DataProvider(name = "TestDataProvider")
    public Object[] functionTestDataProvider(Method method) throws IOException {
        String filePath;
        switch (method.getName()) {
            case "testSemver":
                filePath = SEMVER_TESTCASE;
                break;
            default:
                filePath = null;
        }

        try (FileReader reader = new FileReader(filePath)) {
            Object testCaseObject = JsonParser.parseReader(reader);
            JsonArray fileData = (JsonArray) testCaseObject;
            List<JsonElement> elementList = new LinkedList<>();
            fileData.forEach(elementList::add);
            return elementList.toArray();
        } catch (IOException e) {
            throw e;
        }
    }
}
