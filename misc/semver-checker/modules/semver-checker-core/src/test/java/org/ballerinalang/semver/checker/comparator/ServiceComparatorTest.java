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

import org.testng.annotations.Test;
import static org.ballerinalang.semver.checker.util.TestUtils.executeTestFile;

public class ServiceComparatorTest {
    private static final String SERVICE_DECLARATION_TEST_DATA_ROOT  = "src/test/resources/testcases/serviceDeclaration";
    protected static final String SERVICE_DECLARATION_ANNOTATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/annotation.json";
    protected static final String SERVICE_DECLARATION_DOCUMENTATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  +  "/documentation.json";
    protected static final String SERVICE_DECLARATION_ATTACH_POINT_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/attachPoint.json";
    protected static final String SERVICE_DECLARATION_SERVICE_MEMBERS_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/serviceMembers.json";
    protected static final String SERVICE_DECLARATION_ISOLATED_QUALIFIER_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/isolatedQualifier.json";
    protected static final String SERVICE_DECLARATION_LISTENER_EXPRESSION_LIST_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/listenerExpressionList.json";
    protected static final String ADVANCE_SERVICE_DECLARATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/advanceServiceDeclaration.json";

    @Test
    public void testServiceAnnotation() throws Exception {
        executeTestFile(SERVICE_DECLARATION_ANNOTATION_TESTCASE);
    }

    @Test
    public void testServiceDocumentation() throws Exception {
        executeTestFile(SERVICE_DECLARATION_DOCUMENTATION_TESTCASE);
    }

    @Test
    public void testServiceAttachPoint() throws Exception {
        executeTestFile(SERVICE_DECLARATION_ATTACH_POINT_TESTCASE);
    }

    @Test
    public void testServiceMembers() throws Exception {
        executeTestFile(SERVICE_DECLARATION_SERVICE_MEMBERS_TESTCASE);
    }

    @Test
    public void testServiceIsolatedQualifier() throws Exception {
        executeTestFile(SERVICE_DECLARATION_ISOLATED_QUALIFIER_TESTCASE);
    }

    @Test
    public void testServiceListenerExpressionList() throws Exception {
        executeTestFile(SERVICE_DECLARATION_LISTENER_EXPRESSION_LIST_TESTCASE);
    }

    @Test
    public void testAdvanceServiceDeclaration() throws Exception {
        executeTestFile(ADVANCE_SERVICE_DECLARATION_TESTCASE);
    }
}
