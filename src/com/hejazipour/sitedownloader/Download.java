/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hejazipour.sitedownloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


/**
 *
 * @author javad
 */
public class Download {

  public static void download(URL input, File output)
      throws IOException {
    InputStream in = input.openStream();
    try {
      OutputStream out = new FileOutputStream(output);
      try {
        copy(in, out);
      } finally {
        out.close();
      }
    } finally {
      in.close();
    }
  }

  private static void copy(InputStream in, OutputStream out)
      throws IOException {
    byte[] buffer = new byte[1024];
    while (true) {
      int readCount = in.read(buffer);
      if (readCount == -1) {
        break;
      }
      out.write(buffer, 0, readCount);
    }
  }

}