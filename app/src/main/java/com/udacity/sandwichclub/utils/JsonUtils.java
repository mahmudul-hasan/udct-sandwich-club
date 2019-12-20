package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);
            sandwich.setMainName(jsonObject.getJSONObject(NAME).getString(MAIN_NAME));
            sandwich.setAlsoKnownAs(getStringListFromJsonArray(jsonObject.getJSONObject(NAME).getJSONArray(ALSO_KNOWN_AS)));
            sandwich.setPlaceOfOrigin(jsonObject.getString(PLACE_OF_ORIGIN));
            sandwich.setDescription(jsonObject.getString(DESCRIPTION));
            sandwich.setImage(jsonObject.getString(IMAGE));
            sandwich.setIngredients(getStringListFromJsonArray(jsonObject.getJSONArray(INGREDIENTS)));
        } catch (JSONException exception) {
            exception.printStackTrace();
        }
        return sandwich;
    }

    private static List<String> getStringListFromJsonArray(JSONArray jsonArray) throws JSONException {
        List<String> akaList = new ArrayList<>();
        for (int i=0; i<jsonArray.length(); i++) {
            akaList.add(jsonArray.getString(i));
        }
        return akaList;
    }
}
