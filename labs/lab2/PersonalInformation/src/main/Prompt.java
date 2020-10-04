package main;

import java.text.NumberFormat;
import java.util.Scanner;

public class Prompt {
   private final Scanner sc = new Scanner(System.in);

   public String question(String prompt) {
      System.out.print(prompt + "\n> ");
      return this.sc.nextLine();
   }

   public long questionLong(String prompt, long or) {
      System.out.print(prompt + "\n> ");
      try {
         return Long.parseLong(this.sc.nextLine());
      } catch (Exception e) {
         System.out.println("\033[1A\033[K> ILLEGAL INPUT");
         return or;
      }
   }

   public int questionInt(String prompt, int or) {
      System.out.print(prompt + "\n> ");
      try {
         return Integer.parseInt(this.sc.nextLine());
      } catch (Exception e) {
         System.out.println("\033[1A\033[K> ILLEGAL INPUT");
         return or;
      }
   }

   public void close() {
      this.sc.close();
   }
}
