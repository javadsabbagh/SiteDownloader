/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */
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

public class HtmlParserExample extends DefaultHandler{

	List myTags;
        

	private String tempVal;

	//to maintain context
	private ATag tempATag;
        private ImgTag tempImgTag;
        private LinkTag tempLinkTag;
        private ScriptTag tempScriptTag;
	private ObjectTag tempObjectTag;
        private EmbedTag tempEmbedTag;

        public HtmlParserExample(){
		myTags = new ArrayList();
	}

	public void runExample() {
		parseDocument();
		printData();
	}

	private void parseDocument() {

		//get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {

			//get a new instance of parser
			SAXParser sp = spf.newSAXParser();

			//parse the file and also register this class for call backs
			sp.parse("I:\\CSS-Tricks\\Creating.htm", this);

		}catch(SAXException se) {
			se.printStackTrace();
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch (IOException ie) {
			ie.printStackTrace();
		}
	}

	/**
	 * Iterate through the list and print
	 * the contents
	 */
	private void printData(){

		
                String preName;
		Iterator it = myTags.iterator();
		while(it.hasNext()) {
                        //System.out.println("No of "+it.next().+" Tags '" + myTags.size() + "'.");
			System.out.println(it.next().toString());
		}

	}


	//Event Handlers
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//reset
		tempVal = "";
		if(qName.equalsIgnoreCase("a")) {
			//create a new instance of employee
			tempATag = new ATag();
			tempATag.setHref(attributes.getValue("href"));
		}else if (qName.equalsIgnoreCase("img")) {
			//create a new instance of employee
			tempImgTag = new ImgTag();
			tempImgTag.setSrc(attributes.getValue("src"));
		}else if  (qName.equalsIgnoreCase("link")) {
			//create a new instance of employee
			tempLinkTag = new LinkTag();
			tempLinkTag.setHref(attributes.getValue("href"));
                        tempLinkTag.setType(attributes.getValue("type"));
                        tempLinkTag.setRel(attributes.getValue("rel"));
		}else if  (qName.equalsIgnoreCase("script")) {
			//create a new instance of employee
			tempScriptTag = new ScriptTag();
			tempScriptTag.setSrc(attributes.getValue("src"));
                        tempScriptTag.setType(attributes.getValue("type"));
		}else if  (qName.equalsIgnoreCase("embed")) {
			//create a new instance of employee
			tempEmbedTag = new EmbedTag();
			tempEmbedTag.setSrc(attributes.getValue("src"));
		}else if  (qName.equalsIgnoreCase("object")) {
			//create a new instance of employee
			tempObjectTag = new ObjectTag();
			tempObjectTag.setData(attributes.getValue("data"));
                        tempObjectTag.setType(attributes.getValue("type"));
		}
	}


	public void characters(char[] ch, int start, int length) throws SAXException {
		tempVal = new String(ch,start,length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equalsIgnoreCase("a")) {
			//add it to the list
			myTags.add(tempATag);
		}else if(qName.equalsIgnoreCase("img")) {
			//add it to the list
			myTags.add(tempImgTag);
		}else if(qName.equalsIgnoreCase("link")) {
			//add it to the list
			myTags.add(tempLinkTag);
		}else if(qName.equalsIgnoreCase("script")) {
			//add it to the list
			myTags.add(tempScriptTag);
		}else if(qName.equalsIgnoreCase("embed")) {
			//add it to the list
			myTags.add(tempEmbedTag);
		}else if(qName.equalsIgnoreCase("object")) {
			//add it to the list
			myTags.add(tempObjectTag);
		}

	}

	public static void main(String[] args){
		HtmlParserExample spe = new HtmlParserExample();
		spe.runExample();
	}

}