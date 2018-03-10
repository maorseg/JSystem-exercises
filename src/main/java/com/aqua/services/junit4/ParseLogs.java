package com.aqua.services.junit4;

import jsystem.framework.ParameterProperties;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Example java source code on the usage of findInLine(String pattern) method
 * of Scanner class to find a specific pattern on the scanner buffer
 */

public class ParseLogs extends SystemTestCase4 {
    public File folder;

    @Test
    public void GenericParseLogs() throws InterruptedException, IOException {

        File file = new File(String.valueOf(folder));

        // initialize the scanner
        Scanner scan = new Scanner(file);

        // iterate through the file line by line
        while (scan.hasNextLine()) {
            String str = scan.findInLine(".*(error|Error|Exception).*");

            if (str != null) {
                // print the string content that satisfies the pattern
               // String str = scan.findInLine(".*(error|Error|Exception).*");

                report.report(str);
              //  assertThat(str, both(containsString("error")).or(containsString("Error")));
            }
            // advance to the next line
            scan.nextLine();
        }
        // close the scanner object;
        scan.close();

    }

    /////////////////////////////////////////////////////////////////Getters and Setters////////////////////////////////////////////////////////////////////
    public File getFolder() {
        return folder;
    }

    @ParameterProperties(description = "Select Directory Path")
    public void setFolder(File folder) {
        this.folder = folder;

        }

    }

