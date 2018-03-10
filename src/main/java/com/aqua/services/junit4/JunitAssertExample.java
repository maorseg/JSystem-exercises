package com.aqua.services.junit4;

import static org.junit.Assert.*;

import junit.framework.SystemTestCase4;
import org.junit.Test;


public class JunitAssertExample extends SystemTestCase4 {

    @Test
    public void testAssert(){

        //Variable declaration
        String string1="Junit";
        String string2="Junit";
        String string3="test";
        String string4="test";
        String string5=null;
        int variable1=1;
        int	variable2=2;
        int[] airethematicArrary1 = { 1, 2, 3 };
        int[] airethematicArrary2 = { 1, 2, 3 };

        //Assert statements
        assertEquals(string1,string2); // will  return true
        assertSame(string3, string4); // will  return true
        assertNotSame(string1, string3); // will  return true
        assertNotNull(string1); // will  return true
        assertNull(string5); // will  return true
        assertTrue(variable1<variable2); // will  return true
        assertArrayEquals(airethematicArrary1, airethematicArrary2); // will  return true
    }
}