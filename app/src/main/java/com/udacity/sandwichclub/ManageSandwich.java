package com.udacity.sandwichclub;

import android.support.annotation.Nullable;

import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.ObjectManager;

/**
 * This is a sandwich manager. This class handles the sandwich information population
 * and error when applicable.
 *
 * @author Mahmudul Hasan.
 */
public class ManageSandwich implements ObjectManager<Sandwich> {

	private final SandwichManagerCallback callback;

	public ManageSandwich(SandwichManagerCallback callback) {
		this.callback = callback;
	}

	@Override
	public void manage(@Nullable Sandwich sandwich) {
		if (sandwich == null) {
			callback.handleError();
			return;
		}
		callback.handleSandwichPopulation(sandwich);
	}
}
