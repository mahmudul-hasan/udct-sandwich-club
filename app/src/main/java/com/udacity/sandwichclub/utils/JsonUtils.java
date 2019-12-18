package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);
            sandwich.setMainName(jsonObject.getJSONObject("name").getString("mainName"));
            sandwich.setAlsoKnownAs(getStringListFromJsonArray(jsonObject.getJSONObject("name").getJSONArray("alsoKnownAs")));
            sandwich.setPlaceOfOrigin(jsonObject.getString("placeOfOrigin"));
            sandwich.setDescription(jsonObject.getString("description"));
            sandwich.setImage(jsonObject.getString("image"));
            sandwich.setIngredients(getStringListFromJsonArray(jsonObject.getJSONArray("ingredients")));
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
