package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;
import org.junit.Test;
import java.io.IOException;

public class  MonkeyMD extends SystemTestCase4 {

    @Test
    public void MDAppStress() throws InterruptedException, IOException {
        String cmd = "adb shell monkey -p com.cellebrite.shindan -v 2000000";
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(cmd);
        pr.waitFor();

    }
}
