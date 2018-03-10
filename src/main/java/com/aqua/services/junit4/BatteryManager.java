package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;
import org.junit.Test;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatteryManager extends SystemTestCase4 {

    @Test
    // Get Battery Info
    public void BatteryInfo() throws InterruptedException, IOException {
        String line = "nuimport java.io.InputStreamReader;ll";
        String cmd = "adb shell dumpsys battery";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        while ((line = buf.readLine()) != null) {
            System.out.println(line);
            report.report(line);

        }
    }

    @Test
    // change battery level value to 100%
    public void SimulateBatteryFullCharge() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 100";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to 50%
    public void SimulateBatteryHalfCharge() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 50";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to 0%
    public void SimulateBatteryLowCharge() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set level 0";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
    }

    @Test
    // change battery level value to Unknown
    public void SimulateBatteryStatusUnknown() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Discharging
    public void SimulateBatteryCharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 3";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging
    public void SimulateBatteryStatusCharging() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set status 2";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by wireless
    public void SimulateBatteryWifiCharge() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set wireless 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by wireless
    public void SimulateBatteryAcCharge() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set ac 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // change battery level value to Charging by usb
    public void SimulateBatteryUsbCharge() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set usb 1";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // make the system think that charger is disconnected
    public void SimulateBatteryChargerDisconnect() throws InterruptedException, IOException {
        String cmd = "adb shell dumpsys battery set usb 0";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // “reset” command in order to return the battery to it's real values
    public void ResetToBatteryDefaults() throws InterruptedException, IOException {

        String cmd = "adb shell dumpsys battery reset";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();
        // create a jframe
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        // show a joptionpane dialog using showMessageDialog
        JOptionPane.showMessageDialog(frame,
        "Battery settings were reset back to defaults (real values)");

    }
}


