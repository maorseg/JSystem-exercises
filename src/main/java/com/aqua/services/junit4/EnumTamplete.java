package com.aqua.services.junit4;

import jsystem.framework.ParameterProperties;
import junit.framework.SystemTestCase4;
import jsystem.framework.TestProperties;
import org.junit.Test;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import junit.framework.SystemTestCase4;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Created by Maor on 06/12/2017.
 */

public class EnumTamplete extends SystemTestCase4 {

    public Options option;
    enum Options {
        LookForCDMA;

    }

    @Test
    @TestProperties(name = "Select from the drop list to run: ${Session}", paramsInclude = {"Session"})
    public void getTheOption() throws InterruptedException, IOException {

        switch (option) {

            case LookForCDMA:

                // Declare File object:
                // C:\Users\Maor\Desktop\Phone Support\DetectRules.txt
                File file = new File("C:\\Users\\Maor\\Desktop\\Phone Support\\DetectRules.txt");
                // initialize the scanner
                Scanner scan = new Scanner(file);

                // iterate through the file line by line
                while(scan.hasNextLine()){
                    // scan for names on the content of the file

                    // .* - any character sequence
                    String str = scan.findInLine("Apple" );
                    // String str = scan.findInLine("[A-Za-z].*[A-Za-z]");
                    if(str != null){

                        // print the string content that satisfies the pattern
                        // specified on the method argument
                        report.report(str);
                    }
                    // advance to the next line
                    scan.nextLine();
                }
                // close the scanner object;
                scan.close();



                    break;
           /* case Hub1:
                report.report("Hub 1 selected");
                break;
            case Hub2:
                report.report("Hub 2 selected");
                break;
            case Hub3:
                report.report("Hub 3 selected");
                break;*/
                    default:
                       throw new IllegalArgumentException("Invalid option");


        }}

    //---------------------------------------------------Getters and Setters ------------------------------------------------------------------

    public Options getSession()

    {
        return option;
    }
    @ParameterProperties(description = "Select from drop list")
    public void setSession(Options Session)

    {
        this.option = Session;

    }

}


/**
 * Created by Maor on 06/02/2018.
 */


/*
 * findInLine(String pattern) method
 * of Scanner class to find a specific pattern on the scanner buffer
 */



