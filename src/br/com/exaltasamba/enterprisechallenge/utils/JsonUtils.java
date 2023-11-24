package br.com.exaltasamba.enterprisechallenge.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class JsonUtils {

    public static Map<String, String> parse(String jsonString) {
        Gson gson = new Gson();
        TypeToken<Map<String, String>> mapType = new TypeToken<>() {};
        return gson.fromJson(jsonString, mapType);
    }

    public static String serialize(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
