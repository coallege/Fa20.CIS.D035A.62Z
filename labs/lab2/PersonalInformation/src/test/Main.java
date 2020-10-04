package test;

import static java.lang.System.out;

import interfaces.Display;
import main.Person;
import main.Prompt;

public class Main {
   private static void display(Display o) {
      o.display().forEach(out::println);
   }

   // change this
   private static final boolean testingMode = true;
   public static void main(String args[]) {
      if (testingMode) {
         display(TestPeople.payne);
         display(TestPeople.vonKarma);
      } else {
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
