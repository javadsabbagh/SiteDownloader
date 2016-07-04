/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */
public class ImgTag extends Tag{
    private String src;

    public  ImgTag(/*String site,*/String src){
        this.src= src;
        setName("img");
    }
    public ImgTag(){
        setName("img");
    }
    public String getSrc(){
        return src;
    }
    public void  setSrc(String src){
        this.src = src;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Img Tag Details - ");
        sb.append("src : "+getSrc());
        //sb.append(",");
        //sb.append("");
        return sb.toString();
    }

}
