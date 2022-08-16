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

import io.ballerina.projects.internal.model.Central;
import io.ballerina.projects.util.ProjectConstants;
import org.ballerinalang.test.BaseTest;
import org.ballerinalang.test.context.BMainInstance;
import org.ballerinalang.test.context.BallerinaTestException;
import org.ballerinalang.test.context.LogLeecher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.ballerinalang.util.RepoUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.ballerina.projects.util.ProjectConstants.CENTRAL_REPOSITORY_CACHE_NAME;

/**
 * Tests usage for semver command
 */
public class SemverVersionTest extends BaseTest {

    private static final String testFileLocation = Paths.get("src", "test", "resources", "semver")
            .toAbsolutePath().toString();
    private BMainInstance bMainInstance;
    protected static Path homeCache;

    @BeforeClass
    public void setup() throws BallerinaTestException {
        this.homeCache = Paths.get("build", "userHome");
        /*this.homeCache = Path.of(Paths.get(testFileLocation, "foo1.1.0").toString());*/
        bMainInstance = new BMainInstance(balServer);
        // Build and push down stream packages.
        testPushWithCustomPath();
        /*compilePackageAndPushToLocal(Paths.get(testFileLocation, "foo1.1.0").toString(), "prathees-foo-any-1.1.0");*/
    }

    public static void testPushWithCustomPath()  {
        Path centralRepoPath = homeCache.resolve(ProjectConstants.REPOSITORIES_DIR)
                .resolve(CENTRAL_REPOSITORY_CACHE_NAME).resolve(ProjectConstants.BALA_DIR_NAME);
        Path balaDestPath = centralRepoPath.resolve("prathees").resolve("foo").resolve("1.1.0").resolve("any");
        Path mockRepo = homeCache;
        PowerMockito.mockStatic(RepoUtils.class);
        PowerMockito.when(RepoUtils.createAndGetHomeReposPath()).thenReturn(mockRepo);


    }
    private void compilePackageAndPushToLocal(String packagePath, String balaFileName) throws BallerinaTestException {
        LogLeecher buildLeecher = new LogLeecher("target"+File.separator+ "bala"+File.separator + balaFileName + ".bala");
        LogLeecher pushLeecher = new LogLeecher("Successfully pushed target"+File.separator+"bala"+File.separator + balaFileName + ".bala to " +
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

        Path path = Paths.get(testFileLocation, "foo1.2.0");
        executeBalCommand("foo", path);
    }

    @Test
    public void testUsageOfNewPackageVersion() throws BallerinaTestException {
        Path path = Paths.get(testFileLocation, "myPackage");
        executeBalCommand("myPackage",path);
    }

    private void executeBalCommand(String packageName , Path path) throws BallerinaTestException {
        String testsPassed = "Suggested version";
        LogLeecher logLeecher = new LogLeecher(testsPassed);
        bMainInstance.runMain("semver --1.1.0", new String[0], null, null, new LogLeecher[]{logLeecher},
                path.toString());
        logLeecher.waitForText(5000);
    }
}
