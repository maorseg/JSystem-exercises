package com.aqua.services.junit4;

/**
    A simple LogParser:
    1. Provide any string parameter to search
    2. Browse for any txt or log file
    Return result: Print all the matching lines that contain the provided search string
 */

import jsystem.framework.ParameterProperties;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LogParserUtility extends SystemTestCase4 {

    public File folder;
    public String command;

    @Test
    public void LogParser() throws InterruptedException, IOException {

        File file = new File(String.valueOf(folder));
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {

            String str = scan.findInLine(".*(" + command + ").*");

            if (str != null) {
                report.report(String.valueOf(str));;
            }

            scan.nextLine();

        }

        scan.close();
    }

    /////////////////////////////////////////////////////////////////Getters and Setters////////////////////////////////////////////////////////////////////
    public File getFolder() {
        return folder;
    }

    @ParameterProperties(description = "Select File Path")
    public void setFolder(File folder) {
        this.folder = folder;

    }

    public String getCommand() {
        return command;
    }

    @ParameterProperties(description = "Provide String/text to search")
    public void setCommand(String command) {
        this.command = command;

    }

}





