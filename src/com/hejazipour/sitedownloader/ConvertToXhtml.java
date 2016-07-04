/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hejazipour.sitedownloader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.w3c.dom.Document;
import org.w3c.tidy.*;

/**
 *
 * @author javad
 */
public class ConvertToXhtml {

    public static void convert(String htmlPath, String xhtmlPath) {
        try {
            FileInputStream FIS = new FileInputStream(htmlPath);
            FileOutputStream FOS = new FileOutputStream(xhtmlPath);
            Tidy T = new Tidy();
            Document D = T.parseDOM(FIS, FOS);
        } catch (java.io.FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

