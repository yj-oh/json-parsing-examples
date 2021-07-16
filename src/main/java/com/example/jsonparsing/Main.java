package com.example.jsonparsing;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		String jsonString = ParserSample.readFile("/sample.json");

		ParserSample.parseJSONUsingOrgJson(jsonString);
		ParserSample.parseJSONUsingGoogleGSON(jsonString);
		ParserSample.parseJSONUsingJackson(jsonString);
	}
}
