package com.aqua.services.junit4;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetAllFilesStartWithInDirectory extends SystemTestCase4 {
    public File folder;
    @Test
    @TestProperties(name = "Select Directory Path")

    public void main() throws Exception {
        {
            // Example directory
            Path dir = Paths.get(String.valueOf(folder));

            /**
             *
             * Create a new DirectoryStream for the above path.
             *
             * List all files within this directory that begin
             * with the letters A or B i.e "[AB)]*"
             *
             */
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "[__]*"))
            {
                // Print all the files to output stream
                for(Path p: stream)
                {
                    report.report(String.valueOf(p.getFileName()));
                }
            }
            catch(Exception e)
            {
                report.report("problems locating directory");
            }
        }
    }

    public File getFolder() {
        return folder;
    }
    @ParameterProperties(description = "Select Directory Path")

    public void setFolder(File folder) {
        this.folder = folder;
    }

}
