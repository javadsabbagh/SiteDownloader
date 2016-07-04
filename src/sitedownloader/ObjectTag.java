/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sitedownloader;

/**
 *
 * @author javad
 */
public class ObjectTag extends Tag{
    private String data;
    private String type;

    public  ObjectTag(/*String site,*/String data){
        this.data= data;
        setName("object");
    }
    public ObjectTag(){
        setName("object");
    }
    public String getData(){
        return data;
    }
    public void  setData(String data){
        this.data = data;
    }
    public String getType(){
        return type;
    }
    public void  setType(String type){
        this.type = type;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Object Tag Details - ");
        sb.append("data : "+getData());
        sb.append(",");
        sb.append("type : "+getType());
        return sb.toString();
    }

}
