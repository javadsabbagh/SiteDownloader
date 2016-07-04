/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sitedownloader;

/**
 *
 * @author javad
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class DailyPronounciationParser extends DefaultHandler {

    List myEmpls;
    private String tempVal;
    //to maintain context
    private Employee tempEmp;
    String realName;
    String fileName;
    boolean spanFlag;
    boolean aFlag;

    public DailyPronounciationParser() {
        myEmpls = new ArrayList();
    }

    public void runExample() {
        parseDocument();
        //printData();
    }

    private void parseDocument() {

        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            //parse the file and also register this class for call backs

            //for xhtml files do
            String path = "F:\\Video\\Learn English\\English Daily Pronunciation\\";
            File dir = new File(path);
            String[] list = dir.list();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.length; i++) {
                sb = new StringBuilder(path + list[i]);
                if (new File(path + list[i]).isFile() && sb.substring(sb.lastIndexOf(".")).equals(".xhtml")) {
                    //System.out.println(path + list[i]);
                    sp.parse(path + list[i], this);
                }

            }

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Iterate through the list and print
     * the contents
     */
    private void printData() {
//		System.out.println("No of Employees '" + myEmpls.size() + "'.");
//
//		Iterator it = myEmpls.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next().toString());
//		}
    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        //tempVal = "";
        if (qName.equalsIgnoreCase("div") && attributes.getValue("class") != null && attributes.getValue("class").equals("post")) {
        } else if (qName.equalsIgnoreCase("span") && attributes.getValue("class") != null && attributes.getValue("class").equals("alignleft")) {
            //create a new instance of employee
            spanFlag = true;


        } else if (qName.equalsIgnoreCase("a") && attributes.getValue("target") != null && attributes.getValue("target").equals("new")
                && attributes.getValue("onclick") != null && attributes.getValue("onclick").equals("javascript:pageTracker._trackPageview ('/outbound/media.libsyn.com');")) {
            fileName = attributes.getValue("href");
            aFlag = true;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("span")) {
            //add it to the list
//			myEmpls.add(tempEmp);
            if (spanFlag) {
                System.out.println(tempVal);
                spanFlag = false;
                realName = tempVal;
            }

        } else if (qName.equalsIgnoreCase("a") && aFlag == true) {
            StringBuilder sb = new StringBuilder(fileName);
            System.out.println("F:\\Video\\Learn English\\English Daily Pronunciation\\"
                    + sb.substring(sb.lastIndexOf("/") + 1, sb.lastIndexOf(".")));
            System.out.println("F:\\Video\\Learn English\\English Daily Pronunciation\\"
                    + realName + ".mp4"/*sb.substring(sb.lastIndexOf("."))*/);
            System.out.println(fileName);

            aFlag = false;


            File f = new File("F:\\Video\\Learn English\\English Daily Pronunciation\\"
                    + sb.substring(sb.lastIndexOf("/") + 1, sb.lastIndexOf(".")) + ".mp4");
            f.renameTo(new File("F:\\Video\\Learn English\\English Daily Pronunciation\\"
                    + realName + ".mp4"));

        }

    }

    public static void main(String[] args) {
        DailyPronounciationParser spe = new DailyPronounciationParser();
        spe.runExample();
    }
}
