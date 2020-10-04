package main;

import interfaces.Fillable;

public class Person implements Fillable {
   Name name;
   MailingAddress address;
   int age;
   long number;

   @Override
   public void fill(Prompt p) {
      this.name = new Name();
      this.name.fill(p);
      this.address = new MailingAddress();
      this.address.fill(p);

      this.age = p.questionInt("What is your age?", 0);
      this.number = p.questionLong("What is your phone number?", 0L);
   }
}
