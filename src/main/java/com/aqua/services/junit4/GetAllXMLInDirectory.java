package com.aqua.services.junit4;
// GetAllXMLInDirectory

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.File;
import java.util.List;
// ListXMLUnderPath

public class GetAllXMLInDirectory extends SystemTestCase4 {
    public File folder;
    @Test
    @TestProperties(name = "Select Directory Path")

    public void main() throws Exception {
        String[] extensions = new String[] { "xml" };
        System.out.println("Getting all files " + folder.getCanonicalPath() + " including those in subdirectories");
        List<File> files = (List<File>) FileUtils.listFiles(folder, extensions, true);
        for (File file : files) {
            report.report ("" + file.getCanonicalPath());
        }}

    public File getFolder() {
        return folder;
    }
    @ParameterProperties(description = "Select Directory Path")

    public void setFolder(File folder) {
        this.folder = folder;
    }

}