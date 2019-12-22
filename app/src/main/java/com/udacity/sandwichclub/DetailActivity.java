package com.udacity.sandwichclub;

import java.util.List;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;

public class DetailActivity extends AppCompatActivity implements SandwichManagerCallback {

	private void closeOnError() {
		finish();
		Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
	}

	private String getListText(List<String> list) {
		return new ListOfStringToTextTransformer().transform(list);
	}

	@Override
	public void handleError() {
		closeOnError();
	}

	@Override
	public void handleSandwichPopulation(@NonNull Sandwich sandwich) {
		populateUI(sandwich);
	}

	private void manageSandwich(Sandwich sandwich) {
		new ManageSandwich(this).manage(sandwich);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Sandwich sandwich = new IntentToSandwichTransformer(getResources().getStringArray(R.array.sandwich_details)).transform(getIntent());
		manageSandwich(sandwich);
	}

	private void populateUI(Sandwich sandwich) {
		ImageView ingredientsIv = findViewById(R.id.image_iv);
		TextView alsoKnownAsTv = findViewById(R.id.also_known_tv);
		TextView placeOfOriginTv = findViewById(R.id.origin_tv);
		TextView descriptionTv = findViewById(R.id.description_tv);
		TextView ingredientsTv = findViewById(R.id.ingredients_tv);
		Picasso.with(this)
				.load(sandwich.getImage())
				.into(ingredientsIv);
		alsoKnownAsTv.setText(getListText(sandwich.getAlsoKnownAs()));
		placeOfOriginTv.setText(sandwich.getPlaceOfOrigin());
		descriptionTv.setText(sandwich.getDescription());
		ingredientsTv.setText(getListText(sandwich.getIngredients()));
		setTitle(sandwich.getMainName());
	}
}
