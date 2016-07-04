/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sitedownloader;

/**
 *
 * @author Administrator
 */
import java.io.File;

public class TraverseDirectory {

    public static void main(String[] args) {
        TraverseDirectory td = new TraverseDirectory();
        String path = "D:\\Javad_Sabbagh\\Archive";
        td.print(path);
    }

    public void print(String path) {
        //int level;
        File dir = new File(path);
        String[] list = dir.list();
        for (int i = 0; i < list.length; i++) {
            if (new File(path +"\\"+ list[i]).isFile())
                System.out.println(path+"\\"+list[i]);
            else
                print(path+"\\"+list[i]);
        }
    }
}
