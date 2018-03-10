package com.aqua.services.junit4;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import org.junit.Test;

public class PortsController extends SystemTestCase4 {
    private String[] stringArrayWithOptions;

    @Test
    @TestProperties(paramsInclude = {"stringArrayWithOptions"})
    public void VerifyFolderCreateTime() throws Exception {

        switch (stringArrayWithOptions[0]) {

            case "Port 0":
                report.report("Open Port 0");
            break;
            case "Port 1":
                report.report("Open Port 1");
                break;
            case "Port 2":
                report.report("Open Port 2");
                break;
            case "Port 3":
                report.report("Open Port 3");
                break;
            case "Port 4":
                report.report("Open Port 4");
                break;
            case "Port 5":
                report.report("Open Port 5");
                break;
            case "Port 6":
                report.report("Open Port 6");
                break;
            case "Port 7":
                report.report("Enable All Ports");
                break;
            case "Port 8":
                report.report("Disable All Ports");
                break;
            default:
                throw new IllegalArgumentException("Invalid option");

        }
    }


    public String[] getStringArrayWithOptionsOptions()
    {
        return new String[]{"Port 0", "Port 1", "Port 2", "Port 3", "Port 4", "Port 5", "Port 6", "Enable All Ports", "Disable All Ports"};


    }


    public String[] getStringArrayWithOptions() {
        return stringArrayWithOptions;
    }

    public void setStringArrayWithOptions(String[] stringArrayWithOptions) {
        this.stringArrayWithOptions = stringArrayWithOptions;
    }

}