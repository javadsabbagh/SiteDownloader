/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author javad
 */
public class Test {
    public static void main(String[] args) {
        String content = null;
        URLConnection connection = null;
        try {
            connection = new URL("http://localhost/appmgr_forms.htm").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(content);

    }

}
