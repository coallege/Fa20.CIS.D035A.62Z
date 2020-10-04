package test;

import main.*;

public class TestPeople {
   static Person payne = new Person();
   static Person vonKarma = new Person();

   static {
      payne.name = new Name();
      payne.name.first = "Winston";
      payne.name.last = "Payne";

      payne.address = new MailingAddress();
      payne.address.street = "1736 Boulay Boulevard";
      payne.address.city = "Los Angeles";
      payne.address.state = "Washington";
      payne.address.postalCode = 74033;
      payne.address.country = "United States of Russia";

      payne.age = 52;
      payne.number = 5226091186L;

      vonKarma.name = new Name();
      vonKarma.name.first = "Franziska";
      vonKarma.name.last = "Von Karma";

      vonKarma.address = new MailingAddress();
      vonKarma.address.street = "Münchener Str. 56";
      vonKarma.address.city = "Frankfurt";
      vonKarma.address.state = null;
      vonKarma.address.postalCode = 60329;
      vonKarma.address.country = "Germany";

      vonKarma.age = 18;
      vonKarma.number = 19947198094L;
   }
}
