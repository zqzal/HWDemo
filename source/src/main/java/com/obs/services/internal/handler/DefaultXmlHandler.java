package com.obs.services.internal.handler;

import java.util.LinkedList;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public abstract class DefaultXmlHandler extends DefaultHandler{

	private StringBuilder currText = null;
	private final LinkedList<String> context = new LinkedList<String>();

	public void startDocument() {
	}

	public void endDocument() {
	}

	public void startElement(String uri, String name, String qName, Attributes attrs) {
		this.currText = new StringBuilder();
		this.startElement(name, attrs);
	}

	public void startElement(String name, Attributes attrs) {
		this.startElement(name);
	}

	public void startElement(String name) {
		context.add(name);
	}

	public void endElement(String uri, String name, String qName) {
		String elementText = this.currText.toString();
		this.endElement(name, elementText);
	}

	public void endElement(String name, String content) {
		context.removeLast();
	}

	public void characters(char ch[], int start, int length) {
		this.currText.append(ch, start, length);
	}
}
