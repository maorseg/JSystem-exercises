package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;
import org.junit.Test;
import javax.swing.*;

import java.io.IOException;

public class ComboxBoxShowInputDialogExample extends SystemTestCase4 {

    @Test
    public void MultiSelection() throws InterruptedException, IOException {

        String[] choices = {"Run on Port 0", "Run on Port 1","Run on Port 2", "Run on Port 3","Run on Port 4", "Run on Port 5","Run on Port 6", "Run on Port 7"};
        String input = (String) JOptionPane.showInputDialog(null, "Run on Port numbr: ",
                "Run Flow Manager", JOptionPane.QUESTION_MESSAGE, null,
                choices, // Array of choices

        choices.equals(0));
        report.report("Runing on Port 0");
        choices.equals(1);
        report.report("Runing on Port 1");
        choices.equals(2);
        report.report("Runing on Port 2");
        choices.equals(3);
        report.report("Runing on Port 3");
        choices.equals(4);
        report.report("Runing on Port 4");
        choices.equals(5);
        report.report("Runing on Port 5");
        choices.equals(6);
        report.report("Runing on Port 6");
        choices.equals(7);
        report.report("Runing on Port 7");

    }

}