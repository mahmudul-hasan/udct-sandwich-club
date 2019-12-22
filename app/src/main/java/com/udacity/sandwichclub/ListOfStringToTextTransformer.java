package com.udacity.sandwichclub;

import java.util.List;

import com.udacity.sandwichclub.utils.ObjectTransformer;

/**
 * This class transforms a list of strings into a single appended string.
 *
 * @author Mahmudul Hasan.
 */
public class ListOfStringToTextTransformer implements ObjectTransformer<List<String>, String> {

	@Override
	public String transform(List<String> list) {
		String text = "";
		for (String item : list) {
			text += (text.isEmpty() ? "" : ", ") + item;
		}
		return text;
	}
}
