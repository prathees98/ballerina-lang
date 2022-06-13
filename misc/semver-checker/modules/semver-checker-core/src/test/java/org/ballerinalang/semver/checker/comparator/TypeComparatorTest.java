/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.ballerinalang.semver.checker.comparator;

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

/**
 * Type definition comparator related test cases.
 *
 * @since 2201.2.0
 */
public class TypeComparatorTest {

    private static final String TYPE_TEST_DATA_ROOT = "src/test/resources/testcases/typeDefinition/";
    protected static final String TYPE_ANNOTATION_TESTCASE = TYPE_TEST_DATA_ROOT + "annotation.json";
    protected static final String TYPE_DOCUMENTATION_TESTCASE = TYPE_TEST_DATA_ROOT + "documentation.json";
    protected static final String TYPE_IDENTIFIER_TESTCASE = TYPE_TEST_DATA_ROOT + "identifier.json";
    protected static final String TYPE_QUALIFIER_TESTCASE = TYPE_TEST_DATA_ROOT + "qualifier.json";
    protected static final String TYPE_TYPE_DESCRIPTOR_TESTCASE = TYPE_TEST_DATA_ROOT + "typeDescriptor.json";
    protected static final String ADVANCE_TYPE_TESTCASE = TYPE_TEST_DATA_ROOT + "advanceFunction.json";

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeAnnotation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeDocumentation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeIdentifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeQualifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeTypeDescriptor(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testAdvanceType(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @DataProvider(name = "typeTestDataProvider")
    public Object[] typeTestDataProvider(Method method) throws SemverTestException {
        String filePath;
        switch (method.getName()) {
            case "testTypeAnnotation":
                filePath = TYPE_ANNOTATION_TESTCASE;
                break;
            case "testTypeDocumentation":
                filePath = TYPE_DOCUMENTATION_TESTCASE;
                break;
            case "testTypeIdentifier":
                filePath = TYPE_IDENTIFIER_TESTCASE;
                break;
            case "testTypeQualifier":
                filePath = TYPE_QUALIFIER_TESTCASE;
                break;
            case "testTypeTypeDescriptor":
                filePath = TYPE_TYPE_DESCRIPTOR_TESTCASE;
                break;
            case "testAdvanceType":
                filePath = ADVANCE_TYPE_TESTCASE;
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
