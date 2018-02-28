/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;
import java.util.HashMap;
import org.xml.sax.Attributes;

/**
 *
 * @author dale
 */
public class Element {
    private ArrayList<Element> children;
    private String type;
    private String content;
    private Attributes attributes;
    
    public Element() {
        children = new ArrayList<>();
    }

    public ArrayList<Element> getChildren()
    {
        return children;
    }

    public String getType()
    {
        return type;
    }

    public String getContent()
    {
        return content;
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setContent(String content)
    {
        this.content = content;
    }
    
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    
    public void addChild(Element child) {
        children.add(child);
    }
    
}
