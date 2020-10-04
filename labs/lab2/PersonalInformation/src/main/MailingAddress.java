package main;

import interfaces.*;
import java.util.*;

public class MailingAddress implements Fillable, Display {
   public String street;
   public String city;
   public String state;
   public Integer postalCode;
   public String country;

   private static void push(final List<String> l, final Object what) {
      if (what != null && what != "") {
         l.add("   " + what.toString());
      }
   }

   @Override
   public List<String> display() {
      var lines = new ArrayList<String>();
      push(lines, this.street);
      push(lines, this.city);
      push(lines, this.state);
      push(lines, this.postalCode);
      push(lines, this.country);
      if (lines.size() > 0) {
         lines.add(0, "Address {");
         lines.add("}");
      }
      return lines;
   };

   @Override
   public void fill(Prompt p) {
      this.street = p.question("Number and street:");
      this.city = p.question("City:");
      this.state = p.question("State: ");
      this.postalCode = p.questionInt("Postal Code:");
      this.country = p.question("Country:");
   }
}
