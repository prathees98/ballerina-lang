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
    private static final String TYPE_RECORD_TEST_DATA_ROOT = TYPE_TEST_DATA_ROOT + "record/";
    private static final String TYPE_MAP_TEST_DATA_ROOT = TYPE_TEST_DATA_ROOT + "map/";
    private static final String TYPE_OBJECT_TEST_DATA_ROOT = TYPE_TEST_DATA_ROOT + "object/";

    private static final String TYPE_RECORD_ANNOTATION_TESTCASE = TYPE_RECORD_TEST_DATA_ROOT + "annotation.json";
    private static final String TYPE_RECORD_DOCUMENTATION_TESTCASE = TYPE_RECORD_TEST_DATA_ROOT + "documentation.json";
    private static final String TYPE_RECORD_IDENTIFIER_TESTCASE = TYPE_RECORD_TEST_DATA_ROOT + "identifier.json";
    private static final String TYPE_RECORD_QUALIFIER_TESTCASE = TYPE_RECORD_TEST_DATA_ROOT + "qualifier.json";
    private static final String TYPE_RECORD_TYPE_DESCRIPTOR_TESTCASE = TYPE_RECORD_TEST_DATA_ROOT + "typeDescriptor.json";

    private static final String TYPE_MAP_ANNOTATION_TESTCASE = TYPE_MAP_TEST_DATA_ROOT + "annotation.json";
    private static final String TYPE_MAP_DOCUMENTATION_TESTCASE = TYPE_MAP_TEST_DATA_ROOT + "documentation.json";
    private static final String TYPE_MAP_IDENTIFIER_TESTCASE = TYPE_MAP_TEST_DATA_ROOT + "identifier.json";
    private static final String TYPE_MAP_QUALIFIER_TESTCASE = TYPE_MAP_TEST_DATA_ROOT + "qualifier.json";
    private static final String TYPE_MAP_TYPE_DESCRIPTOR_TESTCASE = TYPE_MAP_TEST_DATA_ROOT + "typeDescriptor.json";

    private static final String TYPE_OBJECT_ANNOTATION_TESTCASE = TYPE_OBJECT_TEST_DATA_ROOT + "annotation.json";
    private static final String TYPE_OBJECT_DOCUMENTATION_TESTCASE = TYPE_OBJECT_TEST_DATA_ROOT + "documentation.json";
    private static final String TYPE_OBJECT_IDENTIFIER_TESTCASE = TYPE_OBJECT_TEST_DATA_ROOT + "identifier.json";
    private static final String TYPE_OBJECT_QUALIFIER_TESTCASE = TYPE_OBJECT_TEST_DATA_ROOT + "qualifier.json";
    private static final String TYPE_OBJECT_TYPE_DESCRIPTOR_TESTCASE = TYPE_OBJECT_TEST_DATA_ROOT + "typeDescriptor.json";

    protected static final String ADVANCE_TYPE_TESTCASE = TYPE_TEST_DATA_ROOT + "advanceFunction.json";

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeRecordAnnotation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeRecordDocumentation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeRecordIdentifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeRecordQualifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeRecordTypeDescriptor(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeMapAnnotation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeMapDocumentation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeMapIdentifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeMapQualifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeMapTypeDescriptor(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeObjectAnnotation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeObjectDocumentation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeObjectIdentifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeObjectQualifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "typeTestDataProvider")
    public void testTypeObjectTypeDescriptor(JsonElement testData) throws Exception {
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
            case "testTypeRecordAnnotation":
                filePath = TYPE_RECORD_ANNOTATION_TESTCASE;
                break;
            case "testTypeRecordDocumentation":
                filePath = TYPE_RECORD_DOCUMENTATION_TESTCASE;
                break;
            case "testTypeRecordIdentifier":
                filePath = TYPE_RECORD_IDENTIFIER_TESTCASE;
                break;
            case "testTypeRecordQualifier":
                filePath = TYPE_RECORD_QUALIFIER_TESTCASE;
                break;
            case "testTypeRecordTypeDescriptor":
                filePath = TYPE_RECORD_TYPE_DESCRIPTOR_TESTCASE;
                break;

            case "testTypeMapArrayAnnotation":
                filePath = TYPE_MAP_ANNOTATION_TESTCASE;
                break;
            case "testTypeMapArrayDocumentation":
                filePath = TYPE_MAP_DOCUMENTATION_TESTCASE;
                break;
            case "testTypeMapArrayIdentifier":
                filePath = TYPE_MAP_IDENTIFIER_TESTCASE;
                break;
            case "testTypeMapArrayQualifier":
                filePath = TYPE_MAP_QUALIFIER_TESTCASE;
                break;
            case "testTypeMapArrayTypeDescriptor":
                filePath = TYPE_MAP_TYPE_DESCRIPTOR_TESTCASE;
                break;

            case "testTypeObjectAnnotation":
                filePath = TYPE_OBJECT_ANNOTATION_TESTCASE;
                break;
            case "testTypeObjectDocumentation":
                filePath = TYPE_OBJECT_DOCUMENTATION_TESTCASE;
                break;
            case "testTypeObjectIdentifier":
                filePath = TYPE_OBJECT_IDENTIFIER_TESTCASE;
                break;
            case "testTypeObjectQualifier":
                filePath = TYPE_OBJECT_QUALIFIER_TESTCASE;
                break;
            case "testTypeObjectTypeDescriptor":
                filePath = TYPE_OBJECT_TYPE_DESCRIPTOR_TESTCASE;
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
