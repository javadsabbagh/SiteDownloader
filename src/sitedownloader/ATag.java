/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */
public class ATag extends Tag{
    private String href;
    private enum LinkType {MailAddress,SiteAddress};
    public  ATag(/*String site,*/String href){
        this.href= href;
        setName("a");
    }
    public ATag(){
        setName("a");
    }
    public String getHref(){
        return href;
    }
    public void  setHref(String href){
        this.href = href;
    }
    public LinkType getType(){
        return LinkType.SiteAddress;
    }
    public boolean isIternal(){
        return true;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("A Tag Details - ");
        sb.append("href : "+getHref());
        //sb.append(",");
        //sb.append("");
        return sb.toString();
    }

}
