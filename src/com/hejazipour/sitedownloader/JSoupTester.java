/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hejazipour.sitedownloader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 *
 * @author javad
 */
public class JSoupTester {

    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
    }
}
