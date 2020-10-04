package main;

import interfaces.*;
import java.util.*;

// well aware that I'm assuming people have a first and last name
// but for the sake of this project, it's gonna have to be like that
public class Name implements Fillable, Display {
   /** given name */
   public String first;
   /** family name */
   public String last;

   @Override
   public void fill(Prompt p) {
      this.first = p.question("What is your first or given name?");
      this.last = p.question("What is your last or family name?");
   }

   @Override
   public List<String> display() {
      var lines = new ArrayList<String>();
      if (first != null && last != null) {
         lines.add(this.last + ", " + this.first);
      } else if (first == null && last == null) {
         return lines;
      } else {
         // one of them is null
         lines.add(first == null ? last : first);
      }
      return lines;
   }
}
