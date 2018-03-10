package com.aqua.services.junit4;

/**
 * Created by Maor on 07/02/2018.
 */

import java.io.File;
import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import junit.framework.SystemTestCase4;
import java.util.List;

public class Check_CDMA_Region_Exist extends SystemTestCase4 {
    public File folder;

    @Test
    @TestProperties(name = "Select Directory Path")


    public void main() throws Exception {

        String[] extensions = new String[] { "xml" };
        System.out.println("Getting all files " + folder.getCanonicalPath() + " including those in subdirectories");
        List<File> files = (List<File>) FileUtils.listFiles(folder, extensions, true);
        for (File file : files) {
        report.report ("file: " + file.getCanonicalPath());
        }}

    public File getFolder() {
        return folder;
    }
    @ParameterProperties(description = "Select Directory Path")

    public void setFolder(File folder) {
        this.folder = folder;
    }

}
//////////////////////////////////////////////////////////////////////////////////////
/* Scanner scan = new Scanner(folder);

        // iterate through the file line by line
        while (scan.hasNextLine()) {
            // scan for names on the content of the file

            // .* - any character sequence
            String str = scan.findInLine("CDMA");
            // String str = scan.findInLine("[A-Za-z].*[A-Za-z]");
            if (str != null) {

                // print the string content that satisfies the pattern
                // specified on the method argument
                report.report(str);
            }
            // advance to the next line
            scan.nextLine();
        }
        // close the scanner object;
        scan.close();
*/