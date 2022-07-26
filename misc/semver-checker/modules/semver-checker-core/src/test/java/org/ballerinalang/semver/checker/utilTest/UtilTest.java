package org.ballerinalang.semver.checker.utilTest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.ballerinalang.semver.checker.exception.SemverTestException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import static org.ballerinalang.semver.checker.util.TestUtils.executeTestData;
import static org.ballerinalang.semver.checker.utilTest.SemverCheckerTest.executeData;

public class UtilTest {
    private static final String TEST_DATA_ROOT = "src/test/resources/testcases/utilTest/";
    private static final String SEMVER_TESTCASE = TEST_DATA_ROOT + "semverTest.json";

    @Test(dataProvider = "semverTestDataProvider")
    public void testSemver(JsonElement testData) throws Exception {
        executeData(testData);
    }

    @DataProvider(name = "semverTestDataProvider")
    public Object[] semverTestDataProvider(Method method) throws SemverTestException {

        String filePath;
        switch (method.getName()) {
            case "testSemver":
                filePath = SEMVER_TESTCASE;
                break;
            default:
                filePath = null;
        }

        if (filePath == null) {
            throw new SemverTestException("Failed to load dataset for method: " + method.getName());
        }
        try (FileReader reader = new FileReader(filePath)) {
            Object testCaseObject = JsonParser.parseReader(reader);
            JsonArray fileData = (JsonArray) testCaseObject;
            List<JsonElement> elementList = new LinkedList<>();
            fileData.forEach(elementList::add);
            return elementList.toArray();
        } catch (IOException e) {
            throw new SemverTestException("failed to load test data");
        }
    }
}
