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

package org.ballerinalang.semver.checker.evaluator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.ballerina.projects.Package;
import io.ballerina.projects.directory.BuildProject;
import io.ballerina.semver.checker.comparator.PackageComparator;
import io.ballerina.semver.checker.diff.PackageDiff;
import org.ballerinalang.semver.checker.ProjectUtils;
import org.testng.Assert;
import java.io.FileReader;
import java.util.Optional;

/**
 * Base class for testing all Service declaration related test cases.
 * @since 2201.2.0
 */
public class BaseServiceDeclarationTest {
    private static final String SERVICE_DECLARATION_TEST_DATA_ROOT  = "src/test/resources/testcases/serviceDeclaration";
    protected static final String SERVICE_DECLARATION_ANNOTATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/annotation.json";
    protected static final String SERVICE_DECLARATION_DOCUMENTATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  +  "/documentation.json";
    protected static final String SERVICE_DECLARATION_ATTACH_POINT_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/attachPoint.json";
    protected static final String SERVICE_DECLARATION_SERVICE_MEMBERS_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/serviceMembers.json";
    protected static final String SERVICE_DECLARATION_ISOLATED_QUALIFIER_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/isolatedQualifier.json";
    protected static final String SERVICE_DECLARATION_LISTENER_EXPRESSION_LIST_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/listenerExpressionList.json";
    protected static final String ADVANCE_SERVICE_DECLARATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/advanceServiceDeclaration.json";

    /**
     * @param testFileName Name of the testcase file name
     */
    protected static void testEvaluate(String testFileName) throws Exception {
        JsonArray fileData;
        try (FileReader reader = new FileReader(testFileName)) {
            Object testCaseObject = JsonParser.parseReader(reader);
            fileData = (JsonArray) testCaseObject;
        }

        for (int i = 0; i < fileData.size(); i++) {
            JsonObject element = (JsonObject) fileData.get(i);
            String oldCode =element.get("oldCode").getAsString();
            String newCode = element.get("newCode").getAsString();
            JsonObject expectedOutput = (JsonObject) element.get("expectedOutput");
            BuildProject oldProject = ProjectUtils.createProject(oldCode);
            BuildProject currentProject = ProjectUtils.createProject(newCode);
            Package oldPackage = oldProject.currentPackage();
            Package currentPackage = currentProject.currentPackage();
            compare(oldPackage , currentPackage , expectedOutput );
        }
    }

    /**
     * @param oldPackage Package instance of previous code
     * @param currentPackage package instance of current code
     * @param expectedOutput Expected json output for the test case
     */
    public static void compare(Package oldPackage , Package currentPackage , JsonObject expectedOutput){
        PackageComparator packageComparator = new PackageComparator(currentPackage,oldPackage);
        Optional<PackageDiff> packageDiff = packageComparator.computeDiff();
        if (expectedOutput.equals(new JsonObject())){
            //For now disabled test cases.
        } else {
            packageDiff.ifPresent(diff -> Assert.assertEquals(diff.getAsJson(), expectedOutput));
        }
    }
}






