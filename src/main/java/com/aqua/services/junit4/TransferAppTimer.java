package com.aqua.services.junit4;

/**
 * Created by Maor on 04/03/2018.
 */
// TransferAppTimer - simple Start and Stop generic cubes to measure Transfer
// sessions duration - for performance matrix

import org.junit.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.SystemTestCase4;

/**
 * Created by Maor on 04/03/2018.
 */

public class TransferAppTimer extends SystemTestCase4 {
    public File folder;
    @Test
    public void StartTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        report.report("Session Start time: " + dateFormat.format(date));
    }

    @Test
    public void EndTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        report.report ("Session End time: " + dateFormat.format(date));
    }

}


