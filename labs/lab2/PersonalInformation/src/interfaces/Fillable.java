package interfaces;

import main.Prompt;

public interface Fillable {
	// this would work much better as a static abstract method but
	// Java doesn't have these
	void fill(Prompt p);
}
