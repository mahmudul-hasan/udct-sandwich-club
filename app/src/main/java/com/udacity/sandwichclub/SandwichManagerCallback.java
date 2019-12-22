package com.udacity.sandwichclub;

import android.support.annotation.NonNull;

import com.udacity.sandwichclub.model.Sandwich;

/**
 * This is a sandwich manager callback interface.
 *
 * @author Mahmudul Hasan.
 */
public interface SandwichManagerCallback {

	void handleError();

	void handleSandwichPopulation(@NonNull Sandwich sandwich);
}
