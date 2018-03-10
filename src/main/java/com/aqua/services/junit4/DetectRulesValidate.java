package com.aqua.services.junit4;

// DetectRulesValidate

import org.junit.Test;

import java.io.*;
import java.util.Scanner;




import static java.util.EnumSet.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.internal.matchers.StringContains.containsString;
import static org.junit.matchers.JUnitMatchers.both;


public class DetectRulesValidate {

    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(new File("C:\\Users\\Maor\\Desktop\\Phone Support\\DetectExample.txt"));
        scanner.useDelimiter(":");

        while (scanner.hasNext()) {
            String name = scanner.next();
            name = name.trim();   // trim the line terminator character
            String value = scanner.next();
            System.out.format(""+ name+ value);
        scanner.close();
    }
}}