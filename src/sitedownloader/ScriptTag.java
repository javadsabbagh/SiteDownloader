/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */
public class ScriptTag extends Tag {
    private String src;
    private String type;

    public  ScriptTag(/*String site,*/String src){
        this.src= src;
        setName("script");
    }
    public ScriptTag(){
        setName("script");
    }
    public String getSrc(){
        return src;
    }
    public void  setSrc(String src){
        this.src = src;
    }
    public String getType(){
        return type;
    }
    public void  setType(String type){
        this.type = type;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Script Tag Details - ");
        sb.append("src : "+getSrc());
        sb.append(",");
        sb.append("type : "+getType());
        return sb.toString();
    }

}
