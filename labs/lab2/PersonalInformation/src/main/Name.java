package main;

import interfaces.Fillable;

// well aware that I'm assuming people have a first and last name
// but for the sake of this project, it's gonna have to be like that
public class Name implements Fillable {
   /** given name */
   public String first;
   /** family name */
   public String last;

   @Override
   public void fill(Prompt p) {
      this.first = p.question("What is your first or given name?");
      this.last = p.question("What is your last or family name?");
   }
}
