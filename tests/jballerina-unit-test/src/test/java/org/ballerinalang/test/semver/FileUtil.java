package org.ballerinalang.test.semver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileUtil {

    /**
     * @param file    Name of the expected file
     * @param content string data which we want to write into the file
     * @throws IOException for handling the error while handling the file
     */
    public static void writeToFile(File file, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file, Charset.defaultCharset())) {
            fileWriter.write(content);
        }
    }
}
