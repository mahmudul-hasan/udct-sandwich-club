package com.udacity.sandwichclub.utils;

/**
 * This is a transformer that transforms a source object S into a resultant object R.
 * @param <S> is the source object.
 * @param <R> is the resultant object.
 *
 * @author Mahmudul Hasan.
 */
public interface ObjectTransformer<S, R> {

	R transform(S s);
}
