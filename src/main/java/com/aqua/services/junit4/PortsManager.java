package com.aqua.services.junit4;

import junit.framework.SystemTestCase4;
import org.junit.Test;

/**
 * Created by Maor on 06/12/2017.
 */

public class PortsManager extends SystemTestCase4 {

    enum RunFlow {

        Port0, Port1, Port2, Port3, Port4, Port5, Port6
    }

        @Test
        public void Method() throws Exception {

            RunFlow day1, day2, day3, day4, day5, day6, day7;
            day1 = RunFlow.Port0;
            day2 = RunFlow.Port1;
            day3 = RunFlow.Port2;
            day4 = RunFlow.Port3;
            day5 = RunFlow.Port4;
            day6 = RunFlow.Port5;
            day7 = RunFlow.Port6;

            if (day1.compareTo(day2) < 0)
                report.report("comes before " + day3);

            if (day2.compareTo(day3) > 0)
                report.report("comes before " + day3);

            if (day3.compareTo(day3) == 0)
                report.report("comes before " + day3);

            if (day4.compareTo(day2) < 0)
                report.report("comes before " + day3);

            if (day5.compareTo(day3) > 0)
                report.report("comes before " + day3);

            if (day6.compareTo(day3) == 0)
                report.report("comes before " + day3);

            if (day7.compareTo(day3) == 0)
                report.report("comes before " + day3);

        }
    }