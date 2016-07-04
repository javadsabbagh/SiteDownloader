/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.w3c.dom.Document;
import org.w3c.tidy.*;

public class CovertToXHTML{
   public static void main(String[] args){
      try{
         FileInputStream FIS=new FileInputStream("F:/Video/Learn English/English Daily Pronunciation/Daily Pronunciations -- A.htm");
         FileOutputStream FOS=new FileOutputStream("F:/Video/Learn English/English Daily Pronunciation/Daily Pronunciations -- A.xhtml");
         Tidy T=new Tidy();
         Document D=T.parseDOM(FIS,FOS);
         }
      catch (java.io.FileNotFoundException e)
         {System.out.println(e.getMessage());}
      }
   }
