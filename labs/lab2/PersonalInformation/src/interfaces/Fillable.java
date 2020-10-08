package interfaces;

import main.Prompt;

/**
 * Fillable interface who's implementors say that their class can
 * be filled from input from a Prompt
 */
public interface Fillable {
	// this API might look kinda weird and that's because of Java's restrictions
	// Ideally, this would be an abstract constructor that each implementing class
	// uses or a static abstract method fill but we can't have nice things
	void fill(Prompt p);
}
