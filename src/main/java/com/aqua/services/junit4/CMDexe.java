package com.aqua.services.junit4;

import org.junit.Test;
import javax.swing.*;
import java.io.*;
public class CMDexe {

        @Test
        // Get ADB User Commands and execute
        public void GetUserCommand() throws InterruptedException, IOException {
            String line = "nuimport java.io.InputStreamReader;ll";
            JFrame frame = new JFrame();

            // prompt the user to enter command
            String cmd = JOptionPane.showInputDialog(frame, "Please enter ADB command to execute");
            Runtime run = Runtime.getRuntime();
            Process pr = run.exec(cmd);
            pr.waitFor();

            // Print the result of the adb command
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            while ((line = buf.readLine()) != null) {
            System.out.println(line);

        }
    }
}