package com.aqua.services.junit4;

import jsystem.framework.TestProperties;
import jsystem.framework.report.ReporterHelper;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Maor on 23/11/2017.
 */
public class TakeScreenshot extends SystemTestCase4 {


    @Test
    @TestProperties(name = "Report with screenshot", paramsInclude = { "" })
    public void reporterWithScreenshot() throws Exception {
    ReporterHelper.copyFileToReporterAndAddLink(report, takeScreenshot(), "Screenshot of your desktop");
    }

    private File takeScreenshot() throws Exception {
        Robot robot = new Robot();
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        File screenshotFile = File.createTempFile("screenshot", "jpg");
        ImageIO.write(screenShot, "JPG", screenshotFile);
        return screenshotFile;

    }

}
