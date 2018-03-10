package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;
import org.junit.Test;
import javax.swing.*;
import java.io.IOException;

public class ConnectivityManager extends SystemTestCase4 {

    @Test
    // Disable Bluetooth to simulate BT HW issue - works on rooted device
    public void SimulateMalfunctionBluetooth() throws InterruptedException, IOException {
        String cmd = "adb shell pm disable com.android.bluetooth";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }

    @Test
    // Disable Reset Bluetooth
    public void ResetToBluetoothDefaults() throws InterruptedException, IOException {
        String cmd = "adb shell pm enable com.android.bluetooth";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

        // create a jframe
        JFrame frame = new JFrame("JOptionPane showMessageDialog example");
        // show a joptionpane dialog using showMessageDialog
        JOptionPane.showMessageDialog(frame,
        "Bluetooth settings were reset back to defaults");
    }

    @Test
    // Disable WIFI to simulate WIFI HW issue - works on rooted device
    public void SimulateMalfunctionWifi() throws InterruptedException, IOException {
        for (int i = 0; i < 50; i++) {
            String cmd = "adb shell svc wifi disable";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
        }
    }

    @Test
    // Simulate WI-FI disconnects i.e. connect and disconnect every 10 seconds
    public void SimulateWifiDisconnections() throws InterruptedException, IOException {

        for(int i=0; i<50; i++) {
            String cmd = "adb shell svc wifi disable";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
            Thread.sleep(10000);

            String cmd1 = "adb shell svc wifi enable";
            Runtime run1 = Runtime.getRuntime();
            Process pr1 = run1.exec(cmd1);
            pr1.waitFor();
            Thread.sleep(10000);

        }
    }

    @Test
    // Simulate network disconnects i.e. connect and disconnect every 10 seconds
    public void SimulateLineDisconnections() throws InterruptedException, IOException {

        for(int i=0; i<50; i++) {
            String cmd = "adb shell settings put global airplane_mode_on 1";
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();
            Thread.sleep(10000);

            String cmd1 = "adb shell settings put global airplane_mode_on 0";
            Runtime run1 = Runtime.getRuntime();
            Process pr1 = run1.exec(cmd1);
            pr1.waitFor();
            Thread.sleep(10000);

            }

         }

         @Test
            public void SimulateRebootLoop() throws InterruptedException, IOException {
                for (int i = 0; i < 10; i++) {
                    String cmd = "adb reboot";
                    Runtime run = Runtime.getRuntime();
                    Process pr = run.exec(cmd);
                    pr.waitFor();
                    Thread.sleep(90000);

                }
            }
        }
