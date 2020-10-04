package main;

import interfaces.*;
import java.util.*;

public class Person implements Fillable {
   Name name;
   MailingAddress address;
   Integer age;
   Long number;

   @Override
   public void fill(Prompt p) {
      this.name = new Name();
      this.name.fill(p);
      this.address = new MailingAddress();
      this.address.fill(p);

      this.age = p.questionInt("What is your age?");
      this.number = p.questionLong("What is your phone number?");
   }
}
