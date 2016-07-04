/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sitedownloader;

import java.io.File;

/**
 *
 * @author javad
 */
public class Test2 {

    public static void main(String[] args) {
        String path = "F:\\Video\\Learn English\\English Daily Pronunciation\\";

        
        String list[] = new File(path).list();
        for (int i = 0; i < list.length; i++) {
            String fileName = path + list[i];
            if (new File(path + list[i]).isFile() &&  fileName.substring(fileName.lastIndexOf(".")).equals(".xhtml")) {
                //System.out.println(path + list[i]);
                File f = new File(path + list[i]);
                f.delete();
            }
            
        }
    }
}
