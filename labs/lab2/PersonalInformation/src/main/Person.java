package main;

import interfaces.*;
import java.util.*;
import java.util.function.Consumer;

public class Person implements Fillable, Display {
   public Name name;
   public MailingAddress address;
   public Integer age;
   public Long number;

   @Override
   public void fill(Prompt p) {
      this.name = new Name();
      this.name.fill(p);
      this.address = new MailingAddress();
      this.address.fill(p);

      this.age = p.questionInt("What is your age?");
      this.number = p.questionLong("What is your phone number?");
   }

   @Override
   public List<String> display() {
      var lines = new ArrayList<String>();
      lines.add("Person {");

      Consumer<String> add = (line) -> {
         lines.add("   " + line);
      };

      var nameLines = this.name.display();
      nameLines.forEach(add);

      var addressLines = this.address.display();
      addressLines.forEach(add);

      if (this.age != null) {
         add.accept("Age: " + this.age.toString());
      }

      if (this.number != null) {
         add.accept("Phone Number: " + this.number.toString());
      }

      lines.add("}");
      return lines;
   }
}
