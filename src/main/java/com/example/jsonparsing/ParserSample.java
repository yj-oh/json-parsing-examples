package com.example.jsonparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

public class ParserSample {
	static String readFile(String fileName) throws IOException {
		return IOUtils.resourceToString(fileName, Charset.defaultCharset());
	}

	/* org.json */
	static void parseJSONUsingOrgJson(String jsonString) {
		// JSON
		JSONObject jsonObject = new JSONObject(jsonString);

		System.out.println(jsonObject.get("uuid"));

		// JSON 안의 JSON Object
		JSONObject colorObject = jsonObject.getJSONObject("color");

		System.out.println(colorObject.get("hex"));

		// JSON 안의 Array 안의 JSON Object
		JSONArray jsonArray = jsonObject.getJSONArray("animals");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject animalObject = jsonArray.getJSONObject(i);

			System.out.println(animalObject.get("name"));
		}
	}

	/* google.gson */
	static void parseJSONUsingGoogleGSON(String jsonString) {
		// JSON
		JsonObject jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();

		System.out.println(jsonObject.get("uuid").getAsString());

		// JSON 안의 JSON Object
		JsonObject colorObject = jsonObject.getAsJsonObject("color");

		System.out.println(colorObject.get("hex").getAsString());

		// JSON 안의 Array 안의 JSON Object
		JsonArray jsonArray = jsonObject.getAsJsonArray("animals");
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject animalObject = jsonArray.get(i).getAsJsonObject();

			System.out.println(animalObject.get("name").getAsString());
		}

		// 또다른 방법 : class 사용
		Sample sample = new Gson().fromJson(jsonString, Sample.class);

		System.out.println(sample.getUuid());
		System.out.println(sample.getColor().getHex());
		System.out.println(sample.getAnimals()[0].getName());
	}

	/* jackson */
	static void parseJSONUsingJackson(String jsonString) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Sample sample = mapper.readValue(jsonString, Sample.class);

		System.out.println(sample.getUuid());
		System.out.println(sample.getColor().getHex());
		System.out.println(sample.getAnimals()[0].getName());
	}
}
