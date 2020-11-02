package com.wf.training.patterns.builder;

import java.util.ArrayList;

// li : name / "Home" : text
// single HTML Tag
class HtmlElement{
	public String name, text;
	public ArrayList<HtmlElement> children = new ArrayList<HtmlElement>();
	
	public HtmlElement() {
		
	}
	
	public HtmlElement(String name, String text) {
		this.name = name;
		this.text = text;
				
	}
	
	
	// recursive string generation output
	private String myToString() {
		StringBuilder sb = new StringBuilder();
		// init tag
		sb.append(String.format("\n<%s>", this.name));
		// text
		if(this.text!=null) {
			sb.append(this.text);
		}
		// recursively call child component
		for(HtmlElement child : this.children) {
			sb.append(child.myToString());
		}
		//close the tag
		sb.append(String.format("\n</%s>",this.name));
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return this.myToString();
	}
}

class HtmlBuilder{
	// provision to have a root component
	private String rootName;
	private HtmlElement root = new HtmlElement();
	
	public HtmlBuilder(String rootName) {
		this.rootName = rootName;
		this.root.name = rootName;
	}
	
	// must have a provision to add child components
	public void addChild(String childName, String childText) {
		// create a new HtmlElement from it
		HtmlElement child = new HtmlElement(childName, childText);
		// add it to the children list of root component
		this.root.children.add(child);
	}
	
	@Override
	public String toString() {
		
		return this.root.toString();
	}
}

public class MyApp {

	public static void main(String[] args) {
		// java code to generate a HTML on the fly
		String str = "hello";
		System.out.println("<h1>" + str + "</h1>");
		
		// a bit complex (menu-creation)
		String menu[] = {"Home","Contact","Help"};
		StringBuilder sb = new StringBuilder();
		sb.append("\n<ul>");
		for(String menuItem : menu) {
			sb.append(String.format("\n<li>%s</li>", menuItem));
		}
		sb.append("\n</ul>");
		System.out.println(sb);
		
		// HTML Builder
		HtmlBuilder builder = new HtmlBuilder("ul");
		for(String menuItem : menu) {
			builder.addChild("li", menuItem);
		}
		
		System.out.println(builder);
	}

}
