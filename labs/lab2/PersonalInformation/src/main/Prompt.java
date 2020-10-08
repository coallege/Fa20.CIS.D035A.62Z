package main;

import java.util.Scanner;

/**
 * Convenient Scanner-like class
 */
public class Prompt {
	private final Scanner sc = new Scanner(System.in);

	public String question(String prompt) {
		System.out.print(prompt + "\n> ");
		return this.sc.nextLine();
	}

	public Long questionLong(String prompt) {
		System.out.print(prompt + "\n> ");
		try {
			return Long.parseLong(this.sc.nextLine());
		} catch (Exception e) {
			System.out.println("\033[1A\033[K> ILLEGAL INPUT");
			return null;
		}
	}

	public Integer questionInt(String prompt) {
		System.out.print(prompt + "\n> ");
		try {
			return Integer.parseInt(this.sc.nextLine());
		} catch (Exception e) {
			System.out.println("\033[1A\033[K> ILLEGAL INPUT");
			return null;
		}
	}

	public void close() {
		this.sc.close();
	}
}
