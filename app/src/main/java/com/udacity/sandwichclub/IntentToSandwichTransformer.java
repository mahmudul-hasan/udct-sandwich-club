package com.udacity.sandwichclub;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;
import com.udacity.sandwichclub.utils.ObjectTransformer;

import static com.udacity.sandwichclub.utils.GlobalConstants.EXTRA_POSITION;

/**
 * This class transforms an Intent into a Sandwich that has been selected.
 *
 * @author Mahmudul Hasan.
 */
public class IntentToSandwichTransformer implements ObjectTransformer<Intent, Sandwich> {

	private static final int DEFAULT_POSITION = -1;
	private final String[] sandwiches;

	public IntentToSandwichTransformer(String[] sandwiches) {
		this.sandwiches = sandwiches;
	}

	@Nullable
	@Override
	public Sandwich transform(@Nullable Intent intent) {
		int position = intent == null ? DEFAULT_POSITION : intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
		return position == DEFAULT_POSITION ? null : JsonUtils.parseSandwichJson(sandwiches[position]);
	}
}
