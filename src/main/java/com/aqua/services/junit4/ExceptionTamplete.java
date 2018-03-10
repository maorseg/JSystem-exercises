package com.aqua.services.junit4;
import org.junit.Test;
import junit.framework.SystemTestCase4;

/**
 * Created by Maor on 22/11/2017.
 */
public class ExceptionTamplete extends SystemTestCase4 {

    @Test
    public void Method() throws Exception {

        try {

            // Your method here

            }

            // This is a generic Exception handler which means it can handle all the exceptions
            catch(Exception e){
            report.report("Exception thrown  :" + e);

            }
        }
    }