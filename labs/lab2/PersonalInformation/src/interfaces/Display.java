package interfaces;

import java.util.List;

/**
 * When printing an object to the console it is nice for the object to implement
 * some code to say how it should look on the console. toString is not good enough
 * because what if an object contains another object. Returning a List of String
 * is useful because an object could indent the lines and append it to it's own
 * output.
 */
public interface Display {
	List<String> display();
}
