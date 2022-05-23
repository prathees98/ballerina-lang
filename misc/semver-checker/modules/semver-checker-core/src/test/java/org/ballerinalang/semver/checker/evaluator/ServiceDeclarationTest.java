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

import org.testng.annotations.Test;

/**
 * Extended FunctionTest class for test each test case scenarios separately.
 * @since 2201.2.0
 */
public class ServiceDeclarationTest extends BaseServiceDeclarationTest {

    @Test
    public void testServiceAnnotation() throws Exception {
        testEvaluate(SERVICE_DECLARATION_ANNOTATION_TESTCASE);
    }

    @Test
    public void testServiceDocumentation() throws Exception {
        testEvaluate(SERVICE_DECLARATION_DOCUMENTATION_TESTCASE);
    }

    @Test
    public void testServiceAttachPoint() throws Exception {
        testEvaluate(SERVICE_DECLARATION_ATTACH_POINT_TESTCASE);
    }

    @Test
    public void testServiceMembers() throws Exception {
        testEvaluate(SERVICE_DECLARATION_SERVICE_MEMBERS_TESTCASE);
    }

    @Test
    public void testServiceIsolatedQualifier() throws Exception {
        testEvaluate(SERVICE_DECLARATION_ISOLATED_QUALIFIER_TESTCASE);
    }

    @Test
    public void testServiceListenerExpressionList() throws Exception {
        testEvaluate(SERVICE_DECLARATION_LISTENER_EXPRESSION_LIST_TESTCASE);
    }

    @Test
    public void testAdvanceServiceDeclaration() throws Exception {
        testEvaluate(ADVANCE_SERVICE_DECLARATION_TESTCASE);
    }
}
