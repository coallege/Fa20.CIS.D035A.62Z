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
		System.out.println(a.charAt(0));
		//? 'H'
		//> 'H'
		System.out.println(a.indexOf('e'));
		//? 1
		//> 1
		System.out.println(a.indexOf("Uni"));
		//? -1
		//> 6
		System.out.println(a.substring(6));
		//? "Universe"
		//> "Universe!"
		System.out.println(a.substring(6, 9));
		//? "Uni"
		//> "Uni"
		System.out.println(a.equals("hello universe!"));
		//? false
		//> false
		System.out.println(a.equalsIgnoreCase("hello universe!"));
		//? true
		//> true
		System.out.println(a.startsWith("Hello"));
		//? true
		//> true
		System.out.println(a.startsWith("Uni", 6));
		//? true
		//> true
		System.out.println(a.endsWith("e!"));
		//? true
		//> true
		System.out.println(a.contains("Uni"));
		//? true
		//> true
		System.out.println(a.replace('e', 'u'));
		//? "Hullo Univursu"
		//> "Hullo Univursu!"
		System.out.println(a.replace("ll", "lll"));
		//? "Helllo Universe"
		//> "Helllo Universe!"
		a = " A B C  \n  ";
		System.out.println(a.trim());
		//? "A B C"
		//> "A B C"
		System.out.println(a.toUpperCase());
		//? "HELLO UNIVERSE!"
		//> " A B C  \n  "
		System.out.println(a.toLowerCase());
		//? "hello universe!"
		//> " a b c  \n  "
		System.out.println(a.length());
		//? 15
		//> 11
	}
}

// oof, that did not go well. I could do with paying more attention to detail

/* Question 4 (10 pts)
Identify errors in the following program, correct them and write the output.
class test {
	public static void main(String[] args) {
		byte a = 1000;
		short b = a * 5;
		long l = 5000;
		float k = 834.63;
		byte c = k;
		double d = b;
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}
*/

// well, the IDE sure makes this easy

class test {
	public static void main(String[] args) {
		int a = 1000;
		int b = a * 5;
		double k = 834.63;
		double c = k;
		double d = b;
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}

// I tried to keep the spirit of the program, if not the datatypes
// Output:
// 5000
// 834.63
// 5000

/* Question 5 (10 pts)
File Encryption is the science of writing contents of a file in a secret code.
Your encryption program should work like a filter,
reading the content of one file, modifying the data into a code,
and then writing the coded contents out to a second file.
The second file will be a version of the first file, but written in secret code.
Write a program to demonstrate the above working with binary files.
*/

// this is going to be suffering, I don't know how to write binary files

interface EncodeDecode {
	static byte[] xorWithFirst(final byte[] data) {
		final var len = data.length;
		if (data.length > 1) {
			final var firstByte = data[0];
			for (var i = 1; i < len; i++) {
				data[i] ^= firstByte;
			}
		}
		return data;
	}

	static boolean encodeDecode(final String in, final String out) {
		try (
			final var fin = new FileInputStream(in);
			final var fout = new FileOutputStream(out);
		) {
			final var data = fin.readAllBytes();
			fout.write(EncodeDecode.xorWithFirst(data));
		} catch (Throwable e) {
			return false;
		}
		return true;
	}

	static void main(final String[] args) {
		if (args.length < 2) {
			System.err.println("java EncodeDecode infile.txt outfile.txt");
			return;
		}

		encodeDecode(args[0], args[1]);
	}
}

/* Question 6a (5 pts)
Generate the output of the following program:
class Add {
	protected int i;
	Add(int a) {
		i = a;
	}
	protected void addIt(int amount) {
		i += amount;
	}
	protected int getIt() {
		return i;
	}
}
class DAdd extends Add {
	private int i;
	DAdd(int a, int b) {
		super(a);
		i = b;
	}
	protected void addIt(int amount) {
		i = i * super.i + amount;
	}
	protected int getIt() {
		return i + 1;
	}
	protected void doubleIt(int amount) {
		addIt(2 * amount);
	}
}
public class TestAdder {
	public static void main(String args[]) {
		Add A = new Add(3);
		DAdd DA = new DAdd(1, 5);
		A.addIt(2);
		System.out.println(A.getIt());
		A = DA;
		A.addIt(2);
		System.out.println(A.getIt());
		DA.doubleIt(2);
		System.out.println(A.getIt());
	}
}
*/

class Add {
	protected int i;
	Add(int a) {
		i = a;
	}
	protected void addIt(int amount) {
		i += amount;
	}
	protected int getIt() {
		return i;
	}
}
class DAdd extends Add {
	private int i;
	DAdd(int a, int b) {
		super(a);
		i = b;
	}
	protected void addIt(int amount) {
		i = i * super.i + amount;
	}
	protected int getIt() {
		return i + 1;
	}
	protected void doubleIt(int amount) {
		addIt(2 * amount);
	}
}
class TestAdder {
	public static void main(String args[]) {
		Add A = new Add(3);
		DAdd DA = new DAdd(1, 5);
		A.addIt(2);
		System.out.println(A.getIt());
		//? 5
		//> 5
		A = DA;
		A.addIt(2);
		System.out.println(A.getIt());
		//? 8
		//> 8
		DA.doubleIt(2);
		System.out.println(A.getIt());
		//? 12
		//> 12
	}
}

/* Question 6b (5 pts)*/
/* Question 6b1
What is the difference between method overriding and method overloading?
*/

// Method overriding is when you completely replace the super class's method
// Overloading, on the other hand, does not replace a method but just adds
// another one.

class MyClass {
	// this replaces Object#toString
	@Override
	public String toString() { return ""; }

	String sayHi() { return "hi"; }
	// this is overloading
	String sayHi(String name) { return "hi, " + name; }
}

// String sayHi() and String sayHi(String) are actually two different methods
// that can coexist on the same class even though they share the same name.

/* Question 6b2
When working with Interfaces? //Discussed in class.
*/

// With interfaces, you must Override methods.
// The interface defines methods that you must implement and override.
// Method overloading doesn't always have to be used in interfaces unless the
// interface defines overloaded methods.

/* Question 7a (10 pts)- Extra Credit */

/* Question 7a1.
Of the two search algorithms we covered in this course,
which of the two is the fastest? the slowest? and why for each?
*/

// guess it's time to break out that book that I haven't read
// huh, I can't find which ones were "covered in the class"
// some of these slides aren't actually half bad

// found it
// https://docs.google.com/presentation/d/e/
// 2PACX-1vTbQ3MFK080kqR4Y5AnWX5-YaPhOvIU1s_sNqRfkfOCGz_x27-qgPH2_kCXcCTVy78jdiBZGymOJicI
// /pub

// seems like we might've covered this in the C++ class too
// - insertion sort
// - bubble sort
// - selection sort

// In the C++ class, we didn't cover insertion sort.

// alright to answer the question
// bubble sort is the slowest out of all of them for larger arrays
// insertion sort might seem like the fastest but there's a large memory penalty
// for it's swaps.
// selection sort is probably the fastest for most arrays.

interface BubbleSort {
	/** Sorts an array in place */
	static int[] sort(final int[] ary) {
		var swapped = true;
		int max = ary.length;
		while (swapped && max --> 0) {
			swapped = false;
			for (int i = 0; i < max; ++i) {
				int first = ary[i];
				int second = ary[i + 1];
				if (first > second) {
					ary[i] = second;
					ary[i + 1] = first;
					swapped = true;
				}
			}
		}
		return ary;
	}
}
