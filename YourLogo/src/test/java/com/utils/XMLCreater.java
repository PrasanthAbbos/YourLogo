package com.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLCreater {
	
	public static final String xmlPath = "G:\\Eclipse\\XMPParser\\Documents\\Test.xml";
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		
		xmlCreator();

	}
	
	public static void xmlCreator() throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory docFact =  DocumentBuilderFactory.newInstance();
		DocumentBuilder docBul = docFact.newDocumentBuilder();
		Document doc = docBul.newDocument();
		
		
		Element root = doc.createElement("RootComapany");
		doc.appendChild(root);
		
		Element child1 = doc.createElement("Employee");
		root.appendChild(child1);
		
		Attr atr = doc.createAttribute("id");
		atr.setNodeValue("343");
		child1.setAttributeNode(atr);
		
		
		Element first = doc.createElement("firstname");
		first.appendChild(doc.createTextNode("prasanth"));
		child1.appendChild(first);
		
		
		Attr at1 =  doc.createAttribute("id");
		at1.setNodeValue("987897");
		first.setAttributeNode(at1);
		
		Element last = doc.createElement("lastname");
		last.appendChild(doc.createTextNode("Kar"));
		child1.appendChild(last);
		
		
		TransformerFactory trFact =  TransformerFactory.newInstance();
		Transformer trF = trFact.newTransformer();
		DOMSource dmsr= new DOMSource(doc);
		StreamResult stres = new StreamResult(new File(xmlPath));
		
		trF.transform(dmsr, stres);
		
	}

}
