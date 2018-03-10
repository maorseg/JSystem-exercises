// PhoneSupportPicturesUtill class

package com.aqua.services.junit4;

/**
 * Created by Maor on 10/02/2018.
 */

import jsystem.framework.ParameterProperties;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import java.io.File;
import java.io.*;

public class PhoneSupportPicturesUtill extends SystemTestCase4 {
    public File folder;


    @Test

    public void NewTest() throws Exception {

    }

    @Test
    // List All jpg files in a Directory
    public void GetAllXMLInDirectory() throws Exception {

        File dir = new File(String.valueOf(folder));
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.endsWith("jpg");
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            report.report("Directory does not exist or is not a directory");
        } else {
            for (int i=0; i< children.length; i++) {
                String filename = children[i];
                report.report(filename);
            }
        }
    }

    // https://www.tutorialspoint.com/javaexamples/dir_search_file.htm
    // List All devices with missing pictures in a Directory

    @Test
    public void GetAllMissingPictures() throws Exception {

        File dir = new File(String.valueOf(folder));
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.contains("NO_PIC");
            }
        };
        String[] children = dir.list(filter);
        if (children == null) {
            report.report("Directory does not exist or is not a directory");
        } else {
            for (int i=0; i< children.length; i++) {
                String filename = children[i];
                report.report(filename);
            }
        }
    }

    /////////////////////////////////////////////////////////////////Getters and Setters////////////////////////////////////////////////////////////////////
    public File getFolder () {
        return folder;
    }
    @ParameterProperties(description = "Select Directory Path")
    public void setFolder (File folder){
        this.folder = folder;
    }
}







