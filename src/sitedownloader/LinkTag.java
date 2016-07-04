/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */
public class LinkTag extends Tag{
    private String href;
    private String type;
    private String rel;
    
    public  LinkTag(/*String site,*/String href){
        this.href= href;
        setName("link");
    }
    public LinkTag(){
        setName("link");
    }
    public String getHref(){
        return href;
    }
    public void  setHref(String href){
        this.href = href;
    }
    public String getType(){
        return type;
    }
    public void  setType(String type){
        this.type = type;
    }
    public String getRel(){
        return rel;
    }
    public void  setRel(String rel){
        this.rel = rel;
    }


    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Link Tag Details - ");
        sb.append("href : "+getHref());
        sb.append(",");
        sb.append("type : "+getType());
        sb.append(",");
        sb.append("rel : "+getRel());
        return sb.toString();
    }

}