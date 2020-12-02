import java.io.*;
import java.util.*;

interface suffering {
	static void main(final String[] args) {
		for (var i = args.length; i --> 0;) {
			System.out.println("but why?");
		}
	}
}

/* Question 1a (5 pts) */
/* Question 1a1
Why should you use Stringbuffer objects instead of String objects in a program
that makes lot of changes to strings?
*/

// Primarily for performance and ease of use (to you, the programmer)
// Strings in Java are immutable which means that once they are made, they can't
// actually be changed. "hello, " + "world" actually has to allocate a new
// String and doesn't mutate either of those two temporary values
// StringBuffers or StringBuilders are much more efficient because they store
// all the temporary values and then concatenate them all at once when you call
// StringBuffer or StringBuilder#toString

/* Question 1a2
Each of the numeric wrapper classes has a static toString method.
What do these methods do?
*/

// What do you think they do, microtransaction?
// They turn a primitive value into a String.

/* Question 1b (5 pts) */
/* Question 1b1
Abstract classes and interfaces can both be used to model common features.
How do you decide whether to use an interface or a class?
*/

// While both can be used for the same thing if you're only using one,
// you can only extend one abstract class.
// With interfaces, you can implement as many as you want.
// Interfaces are for defining, well, interfaces and what functionality a class
// should expose to the outside world.
// Abstract classes can also do that but they're more meant for defining
// behavior that is inherited by sub objects.
// Why not use a class for that?
// Well, sometimes the abstract class isn't meant to be used on it's own.
// Abstract classes can't be instantiated and must be inherited.

/* Question 1b2
What is Garbage Collection?
How can you mark an object for Garbage Collection?
*/

// Garbage collection is another way to deal with memory.
// The garbage collector in Java is built into the JVM and frees memory on the
// virtual heap so that other Objects can use it.

// You can't exactly "mark" an Object for Garbage Collection.
// The whole point of Garbage Collection is that you don't have to manage the
// memory yourself.
// What you can do is make an Object "unreachable", so to speak.
// If you assign the variable that holds the object to null,
// the garbage collector will see that you're not using that object anymore and
// will garbage collect it.
// Pretty much the only way that you can mark an object to be gc'd in Java is
// just to make sure that you can't access it anymore.
// So stuff like letting Objects go out of scope is a good way.

/* Question 2 (10 pts)
Create a class called HasAProfile that maintains name, address and dateofbirth
information in serialized (Hint: Use Interface Serializable) form on disk so
that it can be retrieved whenever a new HasAProfile object is constructed.
If an error occurs when retrieving the information during construction,
the object will prompt the user for name, address and dateofbirth information
and use the information to create a new serialized profile on disk.
*/

// I'm honestly not sure how we're supposed to do this without using an IDE
// or internet.

// Also, this is such a terrible way to design an Object.

@SuppressWarnings("serial")
class HasAProfile implements Serializable {
	String name;
	String address;
	String dateofbirth;

	private static final String filename = "HasAProfile.ser";
	HasAProfile read() {
		try (
			final var fis = new FileInputStream(filename);
			final var ois = new ObjectInputStream(fis);
		) {
			return (HasAProfile) ois.readObject();
		} catch (Throwable t) {
			return null;
		}
	}

	void write() {
		try (
			final var fos = new FileOutputStream(filename);
			final var oos = new ObjectOutputStream(fos)
		) {
			oos.writeObject(this);
		} catch (Throwable e) {}
	}

	final static Scanner sc = new Scanner(System.in);

	HasAProfile() {
		final var maybeProfile = this.read();
		if (maybeProfile == null) {
			System.err.print(""
				+ "File could not be read.\n"
				+ "Please create a new profile\n"
			);
			System.out.print("name\n> ");
			this.name = sc.nextLine();
			System.out.print("address\n> ");
			this.address = sc.nextLine();
			System.out.print("date of birth\n> ");
			this.dateofbirth = sc.nextLine();
		} else {
			this.name = maybeProfile.name;
			this.address = maybeProfile.address;
			this.dateofbirth = maybeProfile.dateofbirth;
			this.write();
		}
	}
}

/* Question 3 (10 pts)
What will the following program print?

public class CompleteConcept {
	public static void main(String[] args) {
		String a = new String("Hello Universe!");
		System.out.println(a.charAt(0));
		System.out.println(a.indexOf('e'));
		System.out.println(a.indexOf("Uni"));
		System.out.println(a.substring(6));
		System.out.println(a.substring(6, 9));
		System.out.println(a.equals("hello universe!"));
		System.out.println(a.equalsIgnoreCase("hello universe!"));
		System.out.println(a.startsWith("Hello"));
		System.out.println(a.startsWith("Uni", 6));
		System.out.println(a.endsWith("e!"));
		System.out.println(a.contains("Uni"));
		System.out.println(a.replace('e', 'u'));
		System.out.println(a.replace("ll", "lll"));
		a = " A B C  \n  ";
		System.out.println(a.trim());
		System.out.println(a.toUpperCase());
		System.out.println(a.toLowerCase());
		System.out.println(a.length());
	}
}
*/

// would make it a lot easier if I could run this but I suppose I better try to
// solve it on my own. Here's my best shot:

class CompleteConcept {
	public static void main(String[] args) {
		String a = new String("Hello Universe!");
		System.out.println(a.charAt(0)); //? 'H'
		System.out.println(a.indexOf('e')); //? 1
		System.out.println(a.indexOf("Uni")); //? -1
		System.out.println(a.substring(6)); //> "Universe"
		System.out.println(a.substring(6, 9)); //> "Uni"
		System.out.println(a.equals("hello universe!")); //> false
		System.out.println(a.equalsIgnoreCase("hello universe!")); //> true
		System.out.println(a.startsWith("Hello")); //> true
		System.out.println(a.startsWith("Uni", 6)); //> true
		System.out.println(a.endsWith("e!")); //> true
		System.out.println(a.contains("Uni")); //> true
		System.out.println(a.replace('e', 'u')); //> "Hullo Univursu"
		System.out.println(a.replace("ll", "lll")); //> "Helllo Universe"
		a = " A B C  \n  ";
		System.out.println(a.trim()); //> "A B C"
		System.out.println(a.toUpperCase()); //> "HELLO UNIVERSE!"
		System.out.println(a.toLowerCase()); //> "hello universe!"
		System.out.println(a.length()); //> 15
	}
}
