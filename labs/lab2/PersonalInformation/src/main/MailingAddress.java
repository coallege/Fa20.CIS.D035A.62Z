package main;

public abstract class MailingAddress {
   public static Builder builder() { return new Builder(); }

   public static class Builder extends MailingAddress {
      public Builder to(final String name) {
         this.name = name;
         return this;
      }

      public Builder toCompany(final String companyName) {
         this.companyName = companyName;
         return this;
      }

      public Builder onStreet(final String street) {
         this.street = street;
         return this;
      }

      public Builder inDistrict(final String district) {
         this.district = district;
         return this;
      }

      public Builder inCity(final String city) {
         this.city = city;
         return this;
      }

      public Builder inCounty(final String county) {
         this.county = county;
         return this;
      }

      public Builder withPostalCode(final String postalCode) {
         this.postalCode = postalCode;
         return this;
      }

      public Builder withPostalCode(final Number postalCode) {
         if (postalCode != null) {
            this.postalCode = postalCode.toString();
         }
         return this;
      }

      public Builder inCountry(final String country) {
         this.country = country;
         return this;
      }

      public MailingAddress build() {
         // fun little trick based on how I've made the builder
         return this;
      }
   }

   public String name;
   public String companyName;
   public String street;
   public String district;
   public String city;
   public String county;
   public String postalCode;
   public String country;

   private static void append(final StringBuilder sb, final String what) {
      if (what != null) {
         sb.append(what).append('\n');
      }
   }

   @Override
   public String toString() {
      var sb = new StringBuilder();
      append(sb, this.name);
      append(sb, this.companyName);
      append(sb, this.street);
      append(sb, this.district);
      append(sb, this.city);
      append(sb, this.county);
      append(sb, this.postalCode);
      append(sb, this.country);
      return sb.toString();
   };
}
