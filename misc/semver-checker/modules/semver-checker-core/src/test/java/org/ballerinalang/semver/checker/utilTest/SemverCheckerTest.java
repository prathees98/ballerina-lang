package org.ballerinalang.semver.checker.utilTest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.ballerina.projects.Package;
import io.ballerina.projects.SemanticVersion;
import io.ballerina.projects.directory.BuildProject;
import io.ballerina.semver.checker.SemverChecker;
import io.ballerina.semver.checker.comparator.PackageComparator;
import io.ballerina.semver.checker.diff.PackageDiff;
import org.ballerinalang.semver.checker.exception.SemverTestException;
import org.ballerinalang.semver.checker.util.ProjectUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
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

            // package util
           /* PackageUtils.loadPackage(ProjectUtils.getTempProjectDir(oldCode));
            Path path = Path.of("hello");
            PackageUtils.loadPackage(path);*/

          /* PrintStream outStream = new PrintStream((OutputStream) ProjectUtils.getTempProjectDir(oldCode));
            PrintStream errStream = new PrintStream(outStream,true);
            CentralClientWrapper centralClientWrapper = new CentralClientWrapper(outStream,errStream);
            String orgName = oldPackage.packageOrg().value();
            String pkgName = oldPackage.packageName().value();
            SemanticVersion version = oldPackage.packageVersion().value();
            System.out.println(centralClientWrapper.getLatestCompatibleVersion(orgName,pkgName,version));*/

            PackageComparator packageComparator = new PackageComparator(currentPackage, oldPackage);
            Optional<PackageDiff> packageDiff = packageComparator.computeDiff();
            String packageVersion = String.valueOf(oldPackage.packageVersion());
            SemanticVersion OldVersion = SemanticVersion.from(packageVersion);
            String newPackageVersion = String.valueOf(currentPackage.packageVersion());
            SemanticVersion newVersion = SemanticVersion.from(newPackageVersion);

            Path projectPath = ProjectUtils.getTempProjectDir(newCode);
           /* BMainInstance bMainInstance = new BMainInstance(balServer);

            compilePackageAndPushToLocal(Paths.get(String.valueOf(projectPath), "http1.1.1").toString(), "waruna-http-any-1.1.1");
*/
            SemverChecker semverChecker = new SemverChecker(projectPath,OldVersion);
            System.out.println(semverChecker.computeDiff());


            assertPackageDiff(packageDiff, OldVersion, newVersion);
        } catch (Exception e) {
            throw new SemverTestException("failed to load Ballerina package using test data");
        }
    }

    public static void assertPackageDiff(Optional<PackageDiff> packageDiff, SemanticVersion oldVersion, SemanticVersion newVersion) {
        //Diffutil
         /*  PackageDiff packageDiff1 = packageDiff.get();
          System.out.println(DiffUtils.getDiffSummary(packageDiff1,oldVersion,newVersion));
          System.out.println(DiffUtils.getVersionSuggestion(packageDiff1,oldVersion,newVersion));
          System.out.println(DiffUtils.stringifyDiff(packageDiff1));
          System.out.println(DiffUtils.getDiffTypeName(packageDiff1));
          //Semver util
          System.out.println(SemverUtils.calculateSuggestedVersion(oldVersion,packageDiff1));*/

    }

   /* private static void compilePackageAndPushToLocal(String packagePath, String balaFileName) {
        LogLeecher buildLeecher = new LogLeecher("target/bala/" + balaFileName + ".bala");
        LogLeecher pushLeecher = new LogLeecher("Successfully pushed target/bala/" + balaFileName + ".bala to " +
                "'local' repository.");
        bMainInstance.runMain("pack", new String[]{}, null, null, new LogLeecher[]{buildLeecher},
                packagePath);
        buildLeecher.waitForText(5000);
        bMainInstance.runMain("push", new String[]{"--repository=local"}, null, null, new LogLeecher[]{pushLeecher},
                packagePath);
        pushLeecher.waitForText(5000);
    }*/
}
