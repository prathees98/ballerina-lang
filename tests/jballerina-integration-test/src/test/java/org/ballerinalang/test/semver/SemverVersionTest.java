/*
 *  Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.test.semver;

import org.ballerinalang.test.BaseTest;
import org.ballerinalang.test.context.BMainInstance;
import org.ballerinalang.test.context.BallerinaTestException;
import org.ballerinalang.test.context.LogLeecher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Tests usage for semver command
 */
public class SemverVersionTest extends BaseTest {

    private static final String testFileLocation = Paths.get("src", "test", "resources", "semver")
            .toAbsolutePath().toString();
    private BMainInstance bMainInstance;

    @BeforeClass
    public void setup() throws BallerinaTestException {
        bMainInstance = new BMainInstance(balServer);
        // Build and push down stream packages.
        compilePackageAndPushToLocal(Paths.get(testFileLocation, "foo0.1.0").toString(), "prathees-foo-any-0.1.0");
    }

    private void compilePackageAndPushToLocal(String packagePath, String balaFileName) throws BallerinaTestException {
        LogLeecher buildLeecher = new LogLeecher("target/bala/" + balaFileName + ".bala");
        LogLeecher pushLeecher = new LogLeecher("Successfully pushed target/bala/" + balaFileName + ".bala to " +
                "'local' repository.");
        bMainInstance.runMain("pack", new String[]{}, null, null, new LogLeecher[]{buildLeecher},
                packagePath);
        buildLeecher.waitForText(5000);
        bMainInstance.runMain("push", new String[]{"--repository=local"}, null, null, new LogLeecher[]{pushLeecher},
                packagePath);
        pushLeecher.waitForText(5000);
    }

    @Test
    public void testUsageOfPackageVersion() throws BallerinaTestException {

        Path path = Paths.get(testFileLocation, "foo0.2.0");
        executeBalCommand("foo", path);
    }

    @Test
    public void testUsageOfNewPackageVersion() throws BallerinaTestException {
        Path path = Paths.get(testFileLocation, "myPackage");
        executeBalCommand("myPackage",path);
    }

    private void executeBalCommand(String packageName , Path path) throws BallerinaTestException {
        String testsPassed = "Tests passed";
        LogLeecher logLeecher = new LogLeecher(testsPassed);
        bMainInstance.runMain(testFileLocation + "/", packageName, null, new String[]{}, null, null,
                new LogLeecher[]{logLeecher});
        logLeecher.waitForText(5000);
        bMainInstance.runMain("semver", new String[]{"--repository=local"}, null, null, new LogLeecher[]{logLeecher},
                path.toString());
        logLeecher.waitForText(5000);
    }
}
