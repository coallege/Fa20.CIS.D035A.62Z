package test;

import main.Person;
import main.Prompt;

public class Main {
   public static void main(String args[]) {
      var person1 = new Person();
      var person2 = new Person();
      var person3 = new Person();

      var prompter = new Prompt();
      System.out.println("\nPerson 1:");
      person1.fill(prompter);
      System.out.println("\nPerson 2:");
      person2.fill(prompter);
      System.out.println("\nPerson 3:");
      person3.fill(prompter);
      prompter.close();
   }
}
