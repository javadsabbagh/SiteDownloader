/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sitedownloader;

import java.io.IOException;
import java.net.*;

/**
 *
 * @author Administrator
 */
public class URLTester {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL u = new URL("http://java.sun.com/dfsdfs/dfsd/fsd/fsd/fsdf/index.html#chapter1");
        System.out.println(u.getAuthority());
        System.out.println(u.getQuery());
        System.out.println(u.toExternalForm());
        System.out.println(u.getUserInfo());
        System.out.println(u.getRef());
        System.out.println(u.getHost());
        System.out.println(u.getPort());
        System.out.println(u.getDefaultPort());
        System.out.println(u.getProtocol());
        System.out.println(u.getFile());
        System.out.println(u.getPath());

/*        URL u1 = new  URL("FAQ.html");
        System.out.println(u1.getAuthority());
        System.out.println(u1.getQuery());
        System.out.println(u1.toExternalForm());
        System.out.println(u1.getUserInfo());
        System.out.println(u1.getRef());
        System.out.println(u1.getHost());
        System.out.println(u1.getPort());
        System.out.println(u1.getDefaultPort());
        System.out.println(u1.getProtocol());
        System.out.println(u1.getFile());
        System.out.println(u1.getPath());
*/
        URL u2 = new URL(u,"fgfgdg/frertert/book.htm");  // اسلش را از ابتدای رشته حذف کنید تا درست کار کند

        String s = new String("/sdkfjkskdfjkdjfk");
        if(s.startsWith("/")) System.out.println("yes"); else System.out.println("no");

        StringBuilder sb = new StringBuilder(s);
        sb.delete(0, 1);
        System.out.println(sb);

        System.out.println(u2.getAuthority());
        System.out.println(u2.getQuery());
        System.out.println(u2.toExternalForm());
        System.out.println(u2.getUserInfo());
        System.out.println(u2.getRef());
        System.out.println(u2.getHost());
        System.out.println(u2.getPort());
        System.out.println(u2.getDefaultPort());
        System.out.println(u2.getProtocol());
        System.out.println(u2.getFile());
        System.out.println(u2.getPath());

        //System.out.println(u.getContent());

    }
}
