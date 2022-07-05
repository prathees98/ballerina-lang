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
 * Class declaration comparator related test cases.
 *
 * @since 2201.2.0
 */
public class ClassComparatorTest {

    private static final String TEST_ROOT = "src/test/resources/testcases/classDefinition/";
    private static final String MEMBER_TEST_ROOT = TEST_ROOT + "classMember/";
    private static final String METHOD_TEST_ROOT = MEMBER_TEST_ROOT + "methodDefinition/";
    private static final String OBJECT_FIELD_TEST_ROOT = MEMBER_TEST_ROOT + "objectField/";

    private static final String OBJECT_TYPE_INCLUSION_TESTCASE = MEMBER_TEST_ROOT + "objectTypeInclusion.json";

    private static final String CLASS_ANNOTATION_TESTCASE = TEST_ROOT + "annotation.json";
    private static final String CLASS_DOCUMENTATION_TESTCASE = TEST_ROOT + "documentation.json";
    private static final String CLASS_IDENTIFIER_TESTCASE = TEST_ROOT + "identifier.json";
    private static final String CLASS_QUALIFIER_TESTCASE = TEST_ROOT + "qualifier.json";
    private static final String ADVANCE_CLASS_TESTCASE = TEST_ROOT + "advanceClass.json";

    private static final String OBJECT_FIELD_ANNOTATION_TESTCASE = OBJECT_FIELD_TEST_ROOT + "annotation.json";
    private static final String OBJECT_FIELD_DOCUMENTATION_TESTCASE = OBJECT_FIELD_TEST_ROOT + "documentation.json";
    private static final String OBJECT_FIELD_IDENTIFIER_TESTCASE = OBJECT_FIELD_TEST_ROOT + "identifier.json";
    private static final String OBJECT_FIELD_QUALIFIER_TESTCASE = OBJECT_FIELD_TEST_ROOT + "qualifier.json";
    private static final String OBJECT_FIELD_TYPE_TESTCASE = OBJECT_FIELD_TEST_ROOT + "type.json";
    private static final String OBJECT_FIELD_VALUE_TESTCASE = OBJECT_FIELD_TEST_ROOT + "value.json";

    private static final String METHOD_ANNOTATION_TESTCASE = METHOD_TEST_ROOT + "annotation.json";
    private static final String METHOD_DOCUMENTATION_TESTCASE = METHOD_TEST_ROOT + "documentation.json";
    private static final String METHOD_BODY_TESTCASE = METHOD_TEST_ROOT + "body.json";
    private static final String METHOD_IDENTIFIER_TESTCASE = METHOD_TEST_ROOT + "identifier.json";
    private static final String METHOD_PARAMETER_TESTCASE = METHOD_TEST_ROOT + "parameter.json";
    private static final String METHOD_QUALIFIER_TESTCASE = METHOD_TEST_ROOT + "qualifier.json";
    private static final String METHOD_RETURN_TESTCASE = METHOD_TEST_ROOT + "returnType.json";

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassAnnotation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassDocumentation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassIdentifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassQualifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testAdvanceClass(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMemberObjectTypeInclusion(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMemberObjectFieldAnnotation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMemberObjectFieldDocumentation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMemberObjectFieldIdentifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMemberObjectFieldQualifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMemberObjectFieldType(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMemberObjectFieldValue(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMethodAnnotation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMethodDocumentation(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMethodBody(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMethodIdentifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMethodParameter(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMethodQualifier(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @Test(dataProvider = "ClassTestDataProvider")
    public void testClassMethodReturn(JsonElement testData) throws Exception {
        executeTestData(testData);
    }

    @DataProvider(name = "ClassTestDataProvider")
    public Object[] ClassTestDataProvider(Method method) throws SemverTestException {
        String filePath;
        switch (method.getName()) {
            case "testClassAnnotation":
                filePath = CLASS_ANNOTATION_TESTCASE;
                break;
            case "testClassDocumentation":
                filePath = CLASS_DOCUMENTATION_TESTCASE;
                break;
            case "testClassIdentifier":
                filePath = CLASS_IDENTIFIER_TESTCASE;
                break;
            case "testClassQualifier":
                filePath = CLASS_QUALIFIER_TESTCASE;
                break;
            case "testAdvanceClass":
                filePath = ADVANCE_CLASS_TESTCASE;
                break;

            case "testClassMemberObjectTypeInclusion":
                filePath = OBJECT_TYPE_INCLUSION_TESTCASE;
                break;

            case "testClassMemberObjectFieldAnnotation":
                filePath = OBJECT_FIELD_ANNOTATION_TESTCASE;
                break;
            case "testClassMemberObjectFieldDocumentation":
                filePath = OBJECT_FIELD_DOCUMENTATION_TESTCASE;
                break;
            case "testClassMemberObjectFieldIdentifier":
                filePath = OBJECT_FIELD_IDENTIFIER_TESTCASE;
                break;
            case "testClassMemberObjectFieldQualifier":
                filePath = OBJECT_FIELD_QUALIFIER_TESTCASE;
                break;
            case "testClassMemberObjectFieldType":
                filePath = OBJECT_FIELD_TYPE_TESTCASE;
                break;
            case "testClassMemberObjectFieldValue":
                filePath = OBJECT_FIELD_VALUE_TESTCASE;
                break;

            case "testClassMethodDocumentation":
                filePath = METHOD_DOCUMENTATION_TESTCASE;
                break;
            case "testClassMethodBody":
                filePath = METHOD_BODY_TESTCASE;
                break;
            case "testClassMethodIdentifier":
                filePath = METHOD_IDENTIFIER_TESTCASE;
                break;
            case "testClassMethodParameter":
                filePath = METHOD_PARAMETER_TESTCASE;
                break;
            case "testClassMethodQualifier":
                filePath = METHOD_QUALIFIER_TESTCASE;
                break;
            case "testClassMethodReturn":
                filePath = METHOD_RETURN_TESTCASE;
                break;
            case "testClassMethodAnnotation":
                filePath = METHOD_ANNOTATION_TESTCASE;
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
