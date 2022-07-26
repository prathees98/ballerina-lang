package org.ballerinalang.semver.checker.utilTest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.ballerina.projects.Package;
import io.ballerina.projects.SemanticVersion;
import io.ballerina.projects.directory.BuildProject;
import io.ballerina.semver.checker.comparator.PackageComparator;
import io.ballerina.semver.checker.diff.PackageDiff;
import io.ballerina.semver.checker.util.DiffUtils;
import io.ballerina.semver.checker.util.SemverUtils;
import org.ballerinalang.semver.checker.exception.SemverTestException;
import org.ballerinalang.semver.checker.util.ProjectUtils;
import org.testng.Assert;

import java.util.Optional;

public class SemverCheckerTest {
    private static final String JSON_ATTR_OLD_CODE = "oldCode";
    private static final String JSON_ATTR_NEW_CODE = "newCode";

    public static void executeData(JsonElement testData)throws SemverTestException {
        try {
            JsonObject testDataObject = (JsonObject) testData;
            String oldCode = testDataObject.get(JSON_ATTR_OLD_CODE).getAsString();
            String newCode = testDataObject.get(JSON_ATTR_NEW_CODE).getAsString();
            BuildProject oldProject = ProjectUtils.createProject(oldCode);
            BuildProject currentProject = ProjectUtils.createProject(newCode);
            Package oldPackage = oldProject.currentPackage();
            Package currentPackage = currentProject.currentPackage();
            PackageComparator packageComparator = new PackageComparator(currentPackage, oldPackage);
            Optional<PackageDiff> packageDiff = packageComparator.computeDiff();
            String packageVersion = String.valueOf(oldPackage.packageVersion());
            SemanticVersion OldVersion = SemanticVersion.from(packageVersion);
            String newPackageVersion = String.valueOf(currentPackage.packageVersion());
            SemanticVersion newVersion = SemanticVersion.from(newPackageVersion);
            String diffType = testDataObject.get("DiffType").getAsString();
            String suggestion = testDataObject.get("VersionSuggestion").getAsString();
            assertDiff(packageDiff, OldVersion, newVersion , diffType);
            assertSuggestion(packageDiff, OldVersion , suggestion);
        } catch (Exception e) {
            throw new SemverTestException("failed to load Ballerina package using test data");
        }
    }

    public static void assertDiff(Optional<PackageDiff> packageDiff, SemanticVersion oldVersion, SemanticVersion newVersion , String diffType) {
          PackageDiff packageDiff1 = packageDiff.get();
          DiffUtils.getDiffSummary(packageDiff1,oldVersion,newVersion);
          Assert.assertEquals(DiffUtils.getDiffTypeName(packageDiff1) , diffType);
    }

    public static void assertSuggestion(Optional<PackageDiff> packageDiff, SemanticVersion oldVersion , String suggestion) {
        PackageDiff packageDiff1 = packageDiff.get();
        Assert.assertEquals(SemverUtils.calculateSuggestedVersion(oldVersion,packageDiff1) , suggestion);
    }

}
