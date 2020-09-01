package com.syntax.class06;

public class SystemProperties {
public static void main(String[] args) {
	
	String timezone = System.getProperty("user.dir");
	System.out.println(timezone);
}
}
