/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.File;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 *
 * @author dale
 * http://www.saxproject.org/apidoc/org/xml/sax/helpers/DefaultHandler.html
 * https://docs.oracle.com/javase/8/docs/api/org/xml/sax/SAXException.html#SAXException--
 */
public class XMLLoader {
    
    
    public static Document load(File xmlFile) throws Exception {
        Document doc = new Document();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            
            DefaultHandler handler = new DefaultHandler() {
                
                private Stack<Element> stack = new Stack<>();
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    Element element = new Element();
                    element.setType(qName);
                    if(stack.empty()) {
                        stack.push(element);
                        doc.addElement(element);
                    }
                    else {
                        stack.peek().addChild(element);
                        stack.push(element);
                    }
                    
                }
                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    stack.pop();
                }
                
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    stack.peek().setContent(new String(ch, start, length).trim());
                }
            };
            
            saxParser.parse(xmlFile.getAbsoluteFile(), handler);
            
        } catch (Exception e) {
            throw e;
        }
        
      return doc; 
    }
}
