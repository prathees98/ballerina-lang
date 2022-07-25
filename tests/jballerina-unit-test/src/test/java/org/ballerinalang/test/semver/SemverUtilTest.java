package org.ballerinalang.test.semver;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.ballerina.projects.Package;
import io.ballerina.projects.directory.BuildProject;
import io.ballerina.projects.util.ProjectUtils;
import org.ballerinalang.test.context.BMainInstance;
import org.ballerinalang.test.context.BalServer;
import org.ballerinalang.test.context.BallerinaTestException;
import org.ballerinalang.test.context.LogLeecher;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


public class SemverUtilTest {
    public static BalServer balServer;
    private static BMainInstance bMainInstance;
    private static final String JSON_ATTR_OLD_CODE = "oldCode";
    private static final String JSON_ATTR_NEW_CODE = "newCode";
    private static final String JSON_ATTR_EXPECTED_RESULTS = "expectedOutput";

    /**
     * Executes test cases using the provided data set.
     *
     * @param testData test data as a JSON element
     */
    public static void executeTestData(JsonElement testData) {

        try {
            JsonObject testDataObject = (JsonObject) testData;
            String oldCode = testDataObject.get(JSON_ATTR_OLD_CODE).getAsString();
            String newCode = testDataObject.get(JSON_ATTR_NEW_CODE).getAsString();
            String d = String.valueOf(testDataObject.get("description"));
            ProjectUtil p = new ProjectUtil();
            BuildProject oldProject = p.createProject(oldCode);
            BuildProject currentProject = p.createProject(newCode);
            Path dir = p.getTempProjectDir(oldCode);
            File file = p.getMainFile(oldCode);
            runSemver(file, dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runSemver(File mainFileName, Path tempProjectDir) throws BallerinaTestException {
        balServer = new BalServer();
        bMainInstance = new BMainInstance(balServer);
        System.out.println("hallo");
        LogLeecher buildLeecher = new LogLeecher(mainFileName.toString());
        LogLeecher pushLeecher = new LogLeecher("Successfully pushed" + mainFileName.toString() +
                "'local' repository.");
        bMainInstance.runMain("pack", new String[]{}, null, null, new LogLeecher[]{buildLeecher},
                String.valueOf(tempProjectDir));
        buildLeecher.waitForText(5000);
        bMainInstance.runMain("push", new String[]{"--repository=local"}, null, null, new LogLeecher[]{pushLeecher},
                String.valueOf(tempProjectDir));
        buildLeecher.waitForText(5000);
        bMainInstance.runMain("semver", new String[]{"--repository=local"}, null, null, new LogLeecher[]{pushLeecher},
                String.valueOf(tempProjectDir));
        pushLeecher.waitForText(5000);
    }
}
