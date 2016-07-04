/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sitedownloader;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Administrator
 */
public class DownloadQueue {

    public static void main(String[] args) {
        Queue<String> qe = new LinkedList<String>();

        qe.add("b");
        qe.add("a");
        qe.add("c");
        qe.add("e");
        qe.add("d");

        Iterator it = qe.iterator();

        System.out.println("Initial Size of Queue :" + qe.size());
        int i = 0;
        while (it.hasNext()) {
            //String iteratorValue = (String) it.next();
            //System.out.println("Queue Next Value :" + iteratorValue);
            //در این قسمت فرآیند دانلود برای هر آدرس تکرار می شود
            //qe.add("d");
            System.out.println(qe.poll());
            if (i++ < 20) qe.add("a");
        }

        // get value and does not remove element from queue
        System.out.println("Queue peek :" + qe.peek());

        // get first value and remove that object from queue
        System.out.println("Queue poll :" + qe.poll());

        System.out.println("Final Size of Queue :" + qe.size());
    }
}
