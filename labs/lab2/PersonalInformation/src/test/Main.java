package test;

import main.Person;
import main.Prompt;

public class Main {
   public static void main(String args[]) {
      var prompter = new Prompt();
      new Person().fill(prompter);
      prompter.close();
   }
}
