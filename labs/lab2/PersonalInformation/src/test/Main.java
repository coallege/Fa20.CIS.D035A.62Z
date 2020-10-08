package test;

import static java.lang.System.out;

import interfaces.Display;
import main.Person;
import main.Prompt;

import java.util.Scanner;

public class Main {
	/**
	 * Because of the wonderful Display trait/interface
	 * .display() gives us List<String> which can be printed to stdout
	 */
	private static void display(Display o) {
		o.display().forEach(out::println);
	}

	public static void main(String args[]) {
		out.print(""
			+ "Please choose an option\n"
			+ "[0] Display pre-entered people\n"
			+ "[1] Enter your own people\n"
			+ "[default] Exit\n"
			+ "> "
		);

		var input = new Scanner(System.in).nextLine();
		if (input.equals("0")) {
			display(TestPeople.payne);
			display(TestPeople.vonKarma);
		} else if (input.equals("1")) {
			var person1 = new Person();
			var person2 = new Person();
			var person3 = new Person();

			var prompter = new Prompt();
			out.println("\nPerson 1:");
			person1.fill(prompter);
			out.println("\nPerson 2:");
			person2.fill(prompter);
			out.println("\nPerson 3:");
			person3.fill(prompter);
			prompter.close();

			display(person1);
			display(person2);
			display(person3);
		}
	}
}
