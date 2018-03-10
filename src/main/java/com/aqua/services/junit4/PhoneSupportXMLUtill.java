/*
package com.aqua.services.junit4;

*/
/**
 * Created by Maor on 10/02/2018.
 *//*


import jsystem.framework.ParameterProperties;
import junit.framework.SystemTestCase4;
import org.junit.Test;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PhoneSupportXMLUtill extends SystemTestCase4 {
    public File folder;


    @Test
    // New test here
    public void NewTest() throws Exception {

    }

    @Test
    // List all models from xml file
    public void ListAllModelsInXML() throws Exception {
        {
            try

            {

                File inputFile = new File(String.valueOf(folder));
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                UserHandler userhandler = new UserHandler();
                saxParser.parse(inputFile, userhandler);

            }

            catch
                    (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    class UserHandler extends DefaultHandler {

        // Elements to parse: PhoneRegions and Model name
        boolean bPhoneRegions = false;
        boolean bName = false;

        // Method called at the start of the document element
        public void startElement(
                String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("PhoneRegions")) {
                bPhoneRegions = true;
            }
            else if (qName.equalsIgnoreCase("Name")) {
                bName = true;
            }
        }

        // Method called with the text contents in between the start and end tags of an XML document element
        public void characters(char ch[], int start, int length) throws SAXException {

            if (bPhoneRegions) {
                // report.report ("PhoneRegions: " + new String(ch, start, length));
                bPhoneRegions = false;

            } else if (bName) {
                report.report ("Model: " + new String(ch, start, length) + "\n");
                bName = false;

            }
        }
    }

    /////////////////////////////////////////////////////////////////Getters and Setters////////////////////////////////////////////////////////////////////
    public File getFolder () {
        return folder;
    }
    @ParameterProperties(description = "Select Directory Path")
    public void setFolder (File folder){
        this.folder = folder;
    }
}





*/
