package main;

import interfaces.Fillable;
import static java.lang.System.out;

public class MailingAddress implements Fillable {
   public String street;
   public String city;
   public String postalCode;
   public String country;

   private static void append(final StringBuilder sb, final String what) {
      if (what != null && what != "") {
         sb.append(what).append('\n');
      }
   }

   @Override
   public String toString() {
      var sb = new StringBuilder();
      append(sb, this.street);
      append(sb, this.city);
      append(sb, this.postalCode);
      append(sb, this.country);
      return sb.toString();
   };

   @Override
   public void fill(Prompt p) {
      this.street = p.question("Number and street:");
      this.city = p.question("City:");
      this.postalCode = p.questionInt("Postal Code:");
      this.country = p.question("Country:");
   }
}
