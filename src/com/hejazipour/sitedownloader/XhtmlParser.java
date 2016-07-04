/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hejazipour.sitedownloader;

/**
 *
 * @author javad
 */
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class XhtmlParser extends DefaultHandler {

    List myTags;
    private String tempVal;
    private Tag tempTag;
    private String file;
    private String savePath;
    private String baseSite; // for relative addresses

    public XhtmlParser() {
        myTags = new ArrayList();
    }

    public void run(String file, String savePath, String baseSite) {
        this.file = file;
        this.savePath = savePath;
        this.baseSite = baseSite;
        parseDocument(file);
        downloadResources();
    }

    private void parseDocument(String file) {

        //get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {

            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();
            spf.setValidating(false);
            
            //parse the file and also register this class for call backs
            sp.parse(file, this);

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
    private void downloadResources() {

        Iterator it = myTags.iterator();
        while (it.hasNext()) {
            try {
                Tag tag = (Tag) it.next();
                // System.out.println(tag.getSrc());
                String fileName = tag.getSrc();
                fileName = fileName.substring(fileName.lastIndexOf("/") + 1);
                fileName = savePath + "\\" + fileName;
                //System.out.println(fileName);
                File f = new File(fileName);
                URL url;
                if (tag.getSrc().startsWith("/")) {
                    url = new URL(new URL(baseSite), tag.getSrc().substring(1));
                } else {
                    url = new URL(new URL(baseSite), tag.getSrc());
                }
                System.out.println(url.toExternalForm());
                Download.download(url, f);
                //outputText.append("Downloaded : " + url.toExternalForm() + "\n");
            } catch (MalformedURLException e) { // bad url exception
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        tempVal = "";
//        if (qName.equalsIgnoreCase("a")) {
//            //create a new instance of employee
//            tempATag = new ATag();
//            tempATag.setHref(attributes.getValue("href"));
//        } else if (qName.equalsIgnoreCase("img")) {
//            //create a new instance of employee
//            tempImgTag = new ImgTag();
//            tempImgTag.setSrc(attributes.getValue("src"));
//        } else if (qName.equalsIgnoreCase("link")) {
//            //create a new instance of employee
//            tempLinkTag = new LinkTag();
//            tempLinkTag.setHref(attributes.getValue("href"));
//            tempLinkTag.setType(attributes.getValue("type"));
//            tempLinkTag.setRel(attributes.getValue("rel"));
//        } else if (qName.equalsIgnoreCase("script")) {
//            //create a new instance of employee
//            tempScriptTag = new ScriptTag();
//            tempScriptTag.setSrc(attributes.getValue("src"));
//            tempScriptTag.setType(attributes.getValue("type"));
//        } else if (qName.equalsIgnoreCase("embed")) {
//            //create a new instance of employee
//            tempEmbedTag = new EmbedTag();
//            tempEmbedTag.setSrc(attributes.getValue("src"));
//        } else if (qName.equalsIgnoreCase("object")) {
//            //create a new instance of employee
//            tempObjectTag = new ObjectTag();
//            tempObjectTag.setData(attributes.getValue("data"));
//            tempObjectTag.setType(attributes.getValue("type"));
//        }
        if (qName.equalsIgnoreCase("img") || qName.equalsIgnoreCase("script")) {
            //create a new instance of employee
            tempTag = new Tag();
            tempTag.setSrc(attributes.getValue("src"));
        }else if (qName.equalsIgnoreCase("link")) {
            //create a new instance of employee
            tempTag = new Tag();
            tempTag.setSrc(attributes.getValue("href"));
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
//        if (qName.equalsIgnoreCase("a")) {
//            //add it to the list
//            myTags.add(tempATag);
//        } else if (qName.equalsIgnoreCase("img")) {
//            //add it to the list
//            myTags.add(tempImgTag);
//        } else if (qName.equalsIgnoreCase("link")) {
//            //add it to the list
//            myTags.add(tempLinkTag);
//        } else if (qName.equalsIgnoreCase("script")) {
//            //add it to the list
//            myTags.add(tempScriptTag);
//        } else if (qName.equalsIgnoreCase("embed")) {
//            //add it to the list
//            myTags.add(tempEmbedTag);
//        } else if (qName.equalsIgnoreCase("object")) {
//            //add it to the list
//            myTags.add(tempObjectTag);
//        }
        if (qName.equalsIgnoreCase("img") || qName.equalsIgnoreCase("link") || 
                qName.equalsIgnoreCase("script")) {
            //add it to the list
            myTags.add(tempTag);
        }
    }
}