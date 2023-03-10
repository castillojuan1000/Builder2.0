package com.github.castillojuan1000.Artifact;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArtifact {

  public static void ZipArtifact() throws IOException {
    String artifactDirPath = System.getProperty("BUILDER_ARTIFACT_DIR");

    // Get the directory containing the files to add to the zip archive
    String directoryPath = artifactDirPath;
    Path directory = Paths.get(directoryPath);

    // Create a FileOutputStream to write the zip file
    FileOutputStream fos = new FileOutputStream(directoryPath + File.separator + "artifact.zip");
    // Create a ZipOutputStream to write to the FileOutputStream
    ZipOutputStream zos = new ZipOutputStream(fos);

    // Iterate over the files in the directory
    Files.walk(directory)
        .filter(Files::isRegularFile)
        .forEach(file -> {
          try {
            // Create a ZipEntry for the file and add it to the ZipOutputStream
            ZipEntry zipEntry = new ZipEntry(directory.relativize(file).toString());
            zos.putNextEntry(zipEntry);

            // Read the file and write it to the ZipOutputStream
            byte[] buffer = new byte[1024];
            int length;
            FileInputStream fis = new FileInputStream(file.toFile());
            while ((length = fis.read(buffer)) > 0) {
              zos.write(buffer, 0, length);
            }

            // Close the FileInputStream and the ZipEntry
            fis.close();
            zos.closeEntry();
          } catch (IOException e) {
            e.printStackTrace();
          }
        });

    // Close the ZipOutputStream and FileOutputStream
    zos.close();
    fos.close();
  }


}
