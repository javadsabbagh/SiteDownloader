/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sitedownloader;

/**
 *
 * @author Administrator
 */
import java.net.*;
import java.io.*;

public class URLUtils {

    public static void main(String s[]) throws MalformedURLException, IOException {
        //ست پراکسی با رمز و نام کاربری
        URLUtils.dump("http://www.yahoo.com");
        System.out.println("**************");
        //URLUtils.dump("https://www.paypal.com");
        //System.out.println("**************");
        //Proxy instance, proxy ip = 123.0.0.1 with port 8080

        // ست پراکسی بدون نام کاربری و پسورد
//        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8080));
//        URL url = new URL("http://www.yahoo.com");
//        HttpURLConnection uc = (HttpURLConnection) url.openConnection(proxy);
//        uc.connect();
//
//
//        String line;
//        StringBuffer tmp = new StringBuffer();
//        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
//        while ((line = in.readLine()) != null) {
//            System.out.println(line);
//        }

    }

    public static void dump(String URLName) {
        try {
            DataInputStream di = null;
            FileOutputStream fo = null;
            byte[] b = new byte[1];

            // PROXY
            System.setProperty("http.proxyHost", "172.30.1.4");
            System.setProperty("http.proxyPort", "8080");

            URL u = new URL(URLName);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            //
            // it's not the greatest idea to use a sun.misc.* class
            // Sun strongly advises not to use them since they can
            // change or go away in a future release so beware.
            //
            sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
            String encodedUserPwd =
                    encoder.encode("wasco\\j.sabbagh:pinkeye".getBytes());
            con.setRequestProperty("Proxy-Authorization", "Basic " + encodedUserPwd);
            // PROXY ----------

            di = new DataInputStream(con.getInputStream());
            while (-1 != di.read(b, 0, 1)) {
                System.out.print(new String(b));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
