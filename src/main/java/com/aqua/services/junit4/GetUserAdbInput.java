package com.aqua.services.junit4;
import org.junit.Test;
import javax.swing.*;
import junit.framework.SystemTestCase4;
/**
 * Created by Maor on 22/11/2017.
 */
public class GetUserAdbInput extends SystemTestCase4 {

    String command = null;
    @Test
    public void GetAdbInput() throws Exception {

        try {
            // Get ADB command from the user
            JFrame frame = new JFrame();
            command = JOptionPane.showInputDialog(frame, "Please enter ADB command to execute");
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(command);
            pr.waitFor();

            // Print the entered command
            report.report ("Command entered: " + command);


        } catch (Exception e) {
            report.report("Exception thrown  :" + e);
        }
    }
}