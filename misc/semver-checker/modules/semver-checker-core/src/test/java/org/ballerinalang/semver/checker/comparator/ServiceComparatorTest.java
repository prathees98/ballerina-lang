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
    private static final String SERVICE_MEMBERS_TEST_DATA_ROOT  = "src/test/resources/testcases/serviceDeclaration/serviceMembers";
    private static final String SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT  = SERVICE_MEMBERS_TEST_DATA_ROOT + "/methodDefinition";
    private static final String SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT  = SERVICE_MEMBERS_TEST_DATA_ROOT + "/remoteMethodDefinition";
    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT  = SERVICE_MEMBERS_TEST_DATA_ROOT + "/resourceMethodDefinition";

    private static final String SERVICE_DECLARATION_ANNOTATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/annotation.json";
    private static final String SERVICE_DECLARATION_DOCUMENTATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  +  "/documentation.json";
    private static final String SERVICE_DECLARATION_ATTACH_POINT_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/attachPoint.json";
    private static final String SERVICE_DECLARATION_ISOLATED_QUALIFIER_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/isolatedQualifier.json";
    private static final String SERVICE_DECLARATION_LISTENER_EXPRESSION_LIST_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/listenerExpressionList.json";
    private static final String ADVANCE_SERVICE_DECLARATION_TESTCASE = SERVICE_DECLARATION_TEST_DATA_ROOT  + "/advanceServiceDeclaration.json";

    private static final String SERVICE_MEMBER_OBJECT_FIELD_TESTCASE = SERVICE_MEMBERS_TEST_DATA_ROOT  + "/objectField.json";
    
    private static final String SERVICE_METHOD_DEFINITION_ANNOTATION_TESTCASE = SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT + "annotation.json";
    private static final String SERVICE_METHOD_DEFINITION_DOCUMENTATION_TESTCASE = SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT + "documentation.json";
    private static final String SERVICE_METHOD_DEFINITION_BODY_TESTCASE = SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT + "body.json";
    private static final String SERVICE_METHOD_DEFINITION_IDENTIFIER_TESTCASE = SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT + "identifier.json";
    private static final String SERVICE_METHOD_DEFINITION_PARAMETER_TESTCASE = SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT + "parameter.json";
    private static final String SERVICE_METHOD_DEFINITION_QUALIFIER_TESTCASE = SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT + "qualifier.json";
    private static final String SERVICE_METHOD_DEFINITION_RETURN_TYPE_TESTCASE = SERVICE_METHOD_DEFINITION_TEST_DATA_ROOT + "returnType.json";

    private static final String SERVICE_REMOTE_METHOD_DEFINITION_ANNOTATION_TESTCASE = SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT + "annotation.json";
    private static final String SERVICE_REMOTE_METHOD_DEFINITION_DOCUMENTATION_TESTCASE = SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT + "documentation.json";
    private static final String SERVICE_REMOTE_METHOD_DEFINITION_BODY_TESTCASE = SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT + "body.json";
    private static final String SERVICE_REMOTE_METHOD_DEFINITION_IDENTIFIER_TESTCASE = SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT + "identifier.json";
    private static final String SERVICE_REMOTE_METHOD_DEFINITION_PARAMETER_TESTCASE = SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT + "parameter.json";
    private static final String SERVICE_REMOTE_METHOD_DEFINITION_QUALIFIER_TESTCASE = SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT + "qualifier.json";
    private static final String SERVICE_REMOTE_METHOD_DEFINITION_RETURN_TYPE_TESTCASE = SERVICE_REMOTE_METHOD_DEFINITION_TEST_DATA_ROOT + "returnType.json";

    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_ANNOTATION_TESTCASE = SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT + "annotation.json";
    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_DOCUMENTATION_TESTCASE = SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT + "documentation.json";
    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_BODY_TESTCASE = SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT + "body.json";
    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_IDENTIFIER_TESTCASE = SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT + "identifier.json";
    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_PARAMETER_TESTCASE = SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT + "parameter.json";
    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_QUALIFIER_TESTCASE = SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT + "qualifier.json";
    private static final String SERVICE_RESOURCE_METHOD_DEFINITION_RETURN_TYPE_TESTCASE = SERVICE_RESOURCE_METHOD_DEFINITION_TEST_DATA_ROOT + "returnType.json";
    
    
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

    @Test
    public void testServiceMemberObjectField() throws Exception {
        executeTestFile(SERVICE_MEMBER_OBJECT_FIELD_TESTCASE);
    }

    @Test
    public void testServiceMethodAnnotation() throws Exception {
        executeTestFile(SERVICE_METHOD_DEFINITION_ANNOTATION_TESTCASE);
    }

    @Test
    public void testServiceMethodDocumentation() throws Exception {
        executeTestFile(SERVICE_METHOD_DEFINITION_DOCUMENTATION_TESTCASE);
    }

    @Test
    public void testServiceMethodBody() throws Exception {
        executeTestFile(SERVICE_METHOD_DEFINITION_BODY_TESTCASE);
    }

    @Test
    public void testServiceMethodIdentifier() throws Exception {
        executeTestFile(SERVICE_METHOD_DEFINITION_IDENTIFIER_TESTCASE);
    }

    @Test
    public void testServiceMethodParameter() throws Exception {
        executeTestFile(SERVICE_METHOD_DEFINITION_PARAMETER_TESTCASE);
    }

    @Test
    public void testServiceMethodQualifier() throws Exception {
        executeTestFile(SERVICE_METHOD_DEFINITION_QUALIFIER_TESTCASE);
    }

    @Test
    public void testServiceMethodReturnType() throws Exception {
        executeTestFile(SERVICE_METHOD_DEFINITION_RETURN_TYPE_TESTCASE);
    }

    @Test
    public void testRemoteServiceMethodAnnotation() throws Exception {
        executeTestFile(SERVICE_REMOTE_METHOD_DEFINITION_ANNOTATION_TESTCASE);
    }

    @Test
    public void testRemoteServiceMethodDocumentation() throws Exception {
        executeTestFile(SERVICE_REMOTE_METHOD_DEFINITION_DOCUMENTATION_TESTCASE);
    }

    @Test
    public void testRemoteServiceMethodBody() throws Exception {
        executeTestFile(SERVICE_REMOTE_METHOD_DEFINITION_BODY_TESTCASE);
    }

    @Test
    public void testRemoteServiceMethodIdentifier() throws Exception {
        executeTestFile(SERVICE_REMOTE_METHOD_DEFINITION_IDENTIFIER_TESTCASE);
    }

    @Test
    public void testRemoteServiceMethodParameter() throws Exception {
        executeTestFile(SERVICE_REMOTE_METHOD_DEFINITION_PARAMETER_TESTCASE);
    }

    @Test
    public void testRemoteServiceMethodQualifier() throws Exception {
        executeTestFile(SERVICE_REMOTE_METHOD_DEFINITION_QUALIFIER_TESTCASE);
    }

    @Test
    public void testRemoteServiceMethodReturnType() throws Exception {
        executeTestFile(SERVICE_REMOTE_METHOD_DEFINITION_RETURN_TYPE_TESTCASE);
    }

    @Test
    public void testResourceServiceMethodAnnotation() throws Exception {
        executeTestFile(SERVICE_RESOURCE_METHOD_DEFINITION_ANNOTATION_TESTCASE);
    }

    @Test
    public void testResourceServiceMethodDocumentation() throws Exception {
        executeTestFile(SERVICE_RESOURCE_METHOD_DEFINITION_DOCUMENTATION_TESTCASE);
    }

    @Test
    public void testResourceServiceMethodBody() throws Exception {
        executeTestFile(SERVICE_RESOURCE_METHOD_DEFINITION_BODY_TESTCASE);
    }

    @Test
    public void testResourceServiceMethodIdentifier() throws Exception {
        executeTestFile(SERVICE_RESOURCE_METHOD_DEFINITION_IDENTIFIER_TESTCASE);
    }

    @Test
    public void testResourceServiceMethodParameter() throws Exception {
        executeTestFile(SERVICE_RESOURCE_METHOD_DEFINITION_PARAMETER_TESTCASE);
    }

    @Test
    public void testResourceServiceMethodQualifier() throws Exception {
        executeTestFile(SERVICE_RESOURCE_METHOD_DEFINITION_QUALIFIER_TESTCASE);
    }

    @Test
    public void testResourceServiceMethodReturnType() throws Exception {
        executeTestFile(SERVICE_RESOURCE_METHOD_DEFINITION_RETURN_TYPE_TESTCASE);
    }
}
