/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

import java.io.File;
import  java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *
 * @author javad
 */
public class RenameFIles {
    public static void main(String[] args) {
       try{
           String filePath = "e:\\";
           DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder        docBuilder = docFactory.newDocumentBuilder();
           Document doc = docBuilder.parse(filePath);

           
       }catch(IOException e){
       }catch(ParserConfigurationException e){
       }catch(SAXException e){
       }
    }

}
