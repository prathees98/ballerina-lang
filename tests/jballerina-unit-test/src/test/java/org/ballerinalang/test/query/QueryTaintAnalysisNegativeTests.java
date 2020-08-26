/*
 *  Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.test.query;

import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.test.util.BCompileUtil;
import org.ballerinalang.test.util.CompileResult;
import org.ballerinalang.test.utils.SQLDBUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.sql.SQLException;

import static org.ballerinalang.test.util.BAssertUtil.validateError;

/**
 * This contains methods to test order by clause in query expression.
 *
 * @since Swan Lake
 */
@Test(groups = {"disableOnOldParser"})
public class QueryTaintAnalysisNegativeTests {
    private CompileResult negativeResult;
    private static final String DB_NAME = "TEST_QUERY_TAINT_ANALYSIS";
    private static final String JDBC_URL = "jdbc:h2:file:" + SQLDBUtils.DB_DIR + DB_NAME;
    private BValue[] args = {new BString(JDBC_URL), new BString(SQLDBUtils.DB_USER),
            new BString(SQLDBUtils.DB_PASSWORD)};

    @BeforeClass
    public void setup() throws SQLException {
        negativeResult = BCompileUtil.compileOffline(SQLDBUtils.getBalFilesDir("query",
                "query-taint-analysis-negative.bal"));
        SQLDBUtils.deleteFiles(new File(SQLDBUtils.DB_DIR), DB_NAME);
        SQLDBUtils.initH2Database(SQLDBUtils.DB_DIR, DB_NAME,
                SQLDBUtils.getSQLResourceDir("query", "query-taint-analysis-data.sql"));
    }

    @Test(description = "Test negative scenarios for query expr with join clause")
    public void testNegativeScenarios() {
        Assert.assertEquals(negativeResult.getErrorCount(), 6);
        int i = 0;
        validateError(negativeResult, i++, "tainted value passed to untainted parameter 'sqlQueries'", 33, 66);
        validateError(negativeResult, i++, "tainted value passed to untainted parameter 'sqlQueries'", 54, 66);
        validateError(negativeResult, i++, "tainted value passed to untainted parameter 'sqlQueries'", 75, 66);
        validateError(negativeResult, i++, "tainted value passed to untainted parameter 'sqlQueries'", 96, 66);
        validateError(negativeResult, i++, "tainted value passed to untainted parameter 'sqlQueries'", 111, 66);
        validateError(negativeResult, i, "tainted value passed to untainted parameter 'op'", 133, 29);
    }
}
