/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;

/**
 *
 * @author dale
 */
public class Document {
    private ArrayList<Element> elements;
    
    public Document() {
        elements = new ArrayList<>();
    }
    
    public void addElement(Element element) {
        elements.add(element);
    }
    
    public ArrayList<Element> getElements() {
        return elements;
    }
}
