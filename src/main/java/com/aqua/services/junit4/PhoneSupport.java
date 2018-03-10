package com.aqua.services.junit4;

import jsystem.framework.report.Reporter;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import org.junit.Assert;
import org.junit.Test;




public class PhoneSupport extends SystemTestCase4  {
    private String fileName ;
    private String[] portList;
    private HubAction hubAction;
    File root = new File("C:\\Users\\Maor\\Desktop\\Phone Support");
    boolean recursive = true;


    public enum HubAction {
        ListAllXml,AutoDetect
    }




    /**
     * Verifies that the specified diagnostics apk exists in the current folder
     */
    @Test
    @TestProperties(name = "Verify that xml  ${fileName} exists", paramsInclude = { "fileName" })
    public void verifyFileExistence() {
        File file = new File(fileName);
        Assert.assertTrue(file.exists());
    }


    @Test
   // @TestProperties(paramsInclude = {"portList", "hubAction"})
    @TestProperties(paramsInclude = {"hubAction"})
    public void VerifyFolderCreateTime() throws IOException {

        switch (hubAction) {
            case ListAllXml:
                // for (int i = 0; i < portList.length; i++) {
                //   String[] temp = portList[i].split(" ");
                //    report.report("Open " + portList[i]);


                // Directory Info
                long size = FileUtils.sizeOfDirectory(new File("C:\\Users\\Maor\\Desktop\\Phone Support"));
                int count = new File("C:\\Users\\Maor\\Desktop\\Phone Support").list().length;
                report.startLevel("Phone Support Directory Info", Reporter.MainFrame);
                report.report("Directory exists? " + root.exists());
                report.report("Directory Name:" + root.getName());
                report.report ("Directory Size: " + size + " bytes");
                report.report("Directory XML files count : " + count);


                //report.addLink("My Link", "");

                ////////////////////
                String[] extensions = {"xml"};
                Collection files = FileUtils.listFiles(root, extensions, recursive);
                for (Iterator iterator = files.iterator(); iterator.hasNext(); ) {
                File file = (File) iterator.next();
                report.report("" + file.getAbsolutePath());

                }

                 ///////////////////

            case AutoDetect:


        }

    }

    //---------------------------------------------------Getters and Setters ------------------------------------------------------------------

    public String[] getPortList() {
        return portList;
    }

    public void setPortList(String[] portList) {
        this.portList = portList;
    }

    public HubAction getHubAction() {
        return hubAction;
    }

    public void setHubAction(HubAction hubAction) {
        this.hubAction = hubAction;
    }

    public String getFileName() {
        return fileName;
    }

    @ParameterProperties(description = "Expected Android apk")
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
