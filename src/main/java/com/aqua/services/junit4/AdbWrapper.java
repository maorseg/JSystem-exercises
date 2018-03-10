package com.aqua.services.junit4;

import jsystem.framework.ParameterProperties;
import junit.framework.SystemTestCase4;
import jsystem.framework.TestProperties;
import org.junit.Test;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Maor on 04/11/2017.
 */

public class AdbWrapper extends SystemTestCase4 {

    public Option simulate;
    enum Option {

        // Battery
        SetBatteryFullCharge,
        SetBatteryHalfCharge,
        SetBatteryLowCharge,
        SetBatteryStatusUnknown,
        SetBatteryDischarging,
        SetBatteryNotCharging,
        SetBatteryStatusCharging,
        SetBatteryWifiCharge,
        SetBatteryAcCharge,
        SetBatteryUsbCharge,
        SetBatteryChargerDisconnect,
        ResetToBatteryDefaults,
        BatteryInfo,
        // Bluetooth
        SetBluetoothOn,
        SetBluetoothOff,
        DisableBluetooth,
        ResetBluetooth,
        // WI-FI
        SetWifiOn,
        SetWifiOff,
        // Airplane
        SetAirplaneOn,
        SetAirplaneOff,
        // Location
        SetLocationOn,
        SetLocationOff,
        // Other
        AdbDevices,
        MDAppStress,
        RebootDevice,
        ForceCloseMDApp,
        GetUserCommand;
    }

    @Test

    /**<font size="4">
     * ***ADB Wrapper***
     * Allow to change values on Device or AVD (Android Virtual Device) for testing diffrent test cases on MD and Diagnostics clients.
     * <font color="red"> Please make sure device or emulator is connected to your PC with ADB before run!.<font color="red">
     */

    @TestProperties(name = "Select from drop list: ${adbcomm}", paramsInclude = {"adbcomm"})
    public void getTheAdbCommand() throws InterruptedException, IOException {

        String command = null;
        switch (simulate) {
            // sets battery charge value between to 100%
            case SetBatteryFullCharge:
                command = "adb shell dumpsys battery set level 100";
                break;
            // sets battery charge value between to 50%
            case SetBatteryHalfCharge:
                command = "adb shell dumpsys battery set level 50";
                break;
            // sets battery charge value between to 5%
            case SetBatteryLowCharge:
                command = "adb shell dumpsys battery set level 5";
                break;
            // sets battery status as Unknown
            case SetBatteryStatusUnknown:
                command = "adb shell dumpsys battery set status 1";
                break;
            case SetBatteryStatusCharging:
                command = "adb shell dumpsys battery set status 2";
                break;
            // // sets battery status as Discharging
            case SetBatteryDischarging:
                command = "adb shell dumpsys battery set status 3";
                break;
            // sets battery status as Not charging
            case SetBatteryNotCharging:
                command = "adb shell dumpsys battery set status 4";
                break;
            // sets power source as a wireless charger
            case SetBatteryWifiCharge:
                command = "adb shell dumpsys battery set wireless 1";
                break;
            // sets power source as an ac charger
            case SetBatteryAcCharge:
                command = "adb shell dumpsys battery set ac 1";
                break;
            // sets power source as a usb charger
            case SetBatteryUsbCharge:
                command = "adb shell dumpsys battery set usb 1";
                break;
            // sets all ac/usb/wireless to 0 – mocks no charging at all (available only in Android 6 and up)
            case SetBatteryChargerDisconnect:
                command = "adb shell dumpsys battery unplug";
                break;
            case ResetToBatteryDefaults:
                command = "adb shell dumpsys battery reset";
                break;
            case BatteryInfo:
                String line = "nuimport java.io.InputStreamReader;ll";
                command = "adb shell dumpsys battery";
                Runtime run = Runtime.getRuntime();
                Process pr = run.exec(command);
                pr.waitFor();
                BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                while ((line = buf.readLine()) != null) {
                    System.out.println(line);
                    report.report(line);
                }
                break;
            // Disable Bluetooth to simulate HW problem
            // Set Set Bluetooth to ON
            case SetBluetoothOn:
                command = "adb shell service call bluetooth_manager 6";
                break;
            // Set Set Bluetooth to OFF
            case SetBluetoothOff:
                command = "adb shell service call bluetooth_manager 9";
                break;
            case DisableBluetooth:
                command = "adb shell pm disable com.android.bluetooth";
                break;
            // Reset Bluetooth to defaults
            case ResetBluetooth:
                command = "adb shell pm enable com.android.bluetooth";
                break;
            // Set Set Wifi to ON
            case SetWifiOn:
                command = "adb shell svc wifi enable";
                break;
            // Set Set Wifi to OFF
            case SetWifiOff:
                command = "adb shell svc wifi disable";
                break;
            // Set Set Airplane mode (flight mode) to ON
            case SetAirplaneOn:
                command = "adb shell settings put global airplane_mode_on 1";
                break;
            // Set Set Airplane mode (flight mode) to OFF
            case SetAirplaneOff:
                command = "adb shell settings put global airplane_mode_on 0";
                break;
            // Set Location On
            case SetLocationOn:
                command = "adb shell settings put secure location_providers_allowed +gps";
                break;
            // Set Location off
            case SetLocationOff:
                command = "adb shell settings put secure location_providers_allowed -gps";
                break;
            // Monkey Stress test for MD apk
            case MDAppStress:
                command = "adb shell monkey -p com.cellebrite.shindan -v 2000000";
                break;
            // Monkey stress test on MD apk application
            case ForceCloseMDApp:
                command = "adb shell am force-stop com.cellebrite.shindan";
                break;
            // Reboot Device
            case RebootDevice:
                command = "adb reboot";
                break;
            case AdbDevices:
                command = "adb devices";
                Runtime run1 = Runtime.getRuntime();
                Process pr1 = run1.exec(command);
                pr1.waitFor();
                BufferedReader buf1 = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
                while ((line = buf1.readLine()) != null) {
                    System.out.println(line);
                    report.report(line);
                }
                break;
            // Get any ADB command from the user
            case GetUserCommand:

                try {
                    // Get ADB command from the user
                    JFrame frame = new JFrame();
                    command = JOptionPane.showInputDialog(frame, "Please enter ADB command to execute");

                    // Print the entered command
                    report.report ("Command entered: " + command);


                } catch (Exception e) {
                    report.report("Exception thrown  :" + e);
                }




                break;
            default: throw new IllegalArgumentException("Invalid command");
        }

        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(command);
        pr.waitFor();

    }

    //---------------------------------------------------Getters and Setters ------------------------------------------------------------------

    public Option getaAbcomm()

    {
        return simulate;
    }
    @ParameterProperties(description = "Select from drop list")
    public void setAdbcomm(Option adbcomm)

    {
        this.simulate = adbcomm;

    }

}