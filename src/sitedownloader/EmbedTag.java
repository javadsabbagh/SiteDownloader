/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */
public class EmbedTag extends Tag{
    private String src;

    public   EmbedTag(/*String site,*/String src){
        this.src= src;
        setName("embed");
    }
    public  EmbedTag(){
        setName("embed");
    }
    public String getSrc(){
        return src;
    }
    public void  setSrc(String src){
        this.src = src;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Embed Tag Details - ");
        sb.append("src : "+getSrc());
        //sb.append(",");
        //sb.append("");
        return sb.toString();
    }
}
