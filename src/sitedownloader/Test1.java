/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sitedownloader;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author javad
 */
public class Test1 {

    public static void main(String[] args) {
        URL url;
        InputStream is = null;
        DataInputStream dis;
        String line;

        try {
            url = new URL("http://localhost/appmgr_forms.htm");
            is = url.openStream();  // throws an IOException
            dis = new DataInputStream(new BufferedInputStream(is));

            while ((line = dis.readLine()) != null) {
                System.out.println(line);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

    }
}
