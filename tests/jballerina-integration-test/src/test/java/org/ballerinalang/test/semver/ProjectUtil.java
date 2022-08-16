package org.ballerinalang.test.semver;

import io.ballerina.projects.BuildOptions;
import io.ballerina.projects.directory.BuildProject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringJoiner;

public class ProjectUtil {

    public static final String BAL_TOML_FILE_NAME = "Ballerina.toml";
    public static final String BAL_FILE_EXT = ".bal";
    private  Path tempProjectDir;
    private static final String TEMP_DIR_PREFIX = "semver-enforcing-dir-";
    private static final String MAIN_FILE_PREFIX = "main-";
    private static final String PACKAGE_ORG = "semver_validator";
    private static final String PACKAGE_NAME = "test_package";
    private static final String PACKAGE_VERSION = "1.0.0";
    private  File mainBalFile;
    public  Path getTempProjectDir() {

        return tempProjectDir;
    }
    public  File getMainFilename() {

        return mainBalFile;
    }

    public BuildProject createProject(String mainBalContent) throws Exception {
        // Creates a new directory in the default temporary file directory.
        this.tempProjectDir = Files.createTempDirectory(TEMP_DIR_PREFIX + System.currentTimeMillis());
        this.tempProjectDir.toFile().deleteOnExit();
        // Creates a main file and writes the generated code snippet.
        createMainBalFile(mainBalContent);
        // Creates the Ballerina.toml file and writes the package meta information.
        createBallerinaToml();
        BuildOptions buildOptions = BuildOptions.builder().setOffline(true).build();
        return BuildProject.load(tempProjectDir, buildOptions);
    }

    private void createMainBalFile(String content) throws Exception {
        mainBalFile = File.createTempFile(MAIN_FILE_PREFIX, BAL_FILE_EXT, tempProjectDir.toFile());
        mainBalFile.deleteOnExit();
        FileUtil.writeToFile(mainBalFile, content);
    }

    private  void createBallerinaToml() throws Exception {
        Path ballerinaTomlPath = tempProjectDir.resolve(BAL_TOML_FILE_NAME);
        File balTomlFile = Files.createFile(ballerinaTomlPath).toFile();
        balTomlFile.deleteOnExit();
        StringJoiner balTomlContent = new StringJoiner(System.lineSeparator());
        balTomlContent.add("[package]");
        balTomlContent.add(String.format("org = \"%s\"", PACKAGE_ORG));
        balTomlContent.add(String.format("name = \"%s\"", PACKAGE_NAME));
        balTomlContent.add(String.format("version = \"%s\"", PACKAGE_VERSION));
        FileUtil.writeToFile(balTomlFile, balTomlContent.toString());
    }

    public  Path getTempProjectDir(String mainBalContent) throws Exception {
        // Creates a new directory in the default temporary file directory.
        tempProjectDir = Files.createTempDirectory(TEMP_DIR_PREFIX + System.currentTimeMillis());
        tempProjectDir.toFile().deleteOnExit();
        // Creates a main file and writes the generated code snippet.
        createMainBalFile(mainBalContent);
        // Creates the Ballerina.toml file and writes the package meta information.
        createBallerinaToml();
        return tempProjectDir;
    }
}

