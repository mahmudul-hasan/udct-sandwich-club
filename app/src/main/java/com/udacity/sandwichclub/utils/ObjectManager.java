package com.udacity.sandwichclub.utils;

/**
 * This is an API to manages an object of type T.
 * @param <T> a type of object to be managed.
 *
 * @author Mahmudul Hasan.
 */
public interface ObjectManager<T> {

	void manage(T t);
}
