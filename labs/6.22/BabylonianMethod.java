import java.util.NoSuchElementException;
import java.util.Scanner;

public class BabylonianMethod {
   public static double tolerance = 0.0001;

   /** clears the terminal */
   static void clear() {
      System.out.print("\033[3J\033[H\033[2J");
   }
   public static void main(String[] dummy) {
      clear();
      System.out.println(""
         + "BabylonianMethod.java\n"
         + "Author: Cole Gannon\n"
         + "---------------------"
      );
      var sc = new Scanner(System.in);
      while (true) {
         System.out.print(  "in      : ");

         int in = 0;
         try {
            in = sc.nextInt();
         } catch (NoSuchElementException e) {
            sc.close();
            System.out.println("\nInterrupt. Exiting...");
            System.exit(0);
         }

         System.out.println("builtin : " + Math.sqrt(in));
         System.out.println("sqrt    : " + sqrt(in));
         System.out.printf( "diff    : %.16f\n\n", Math.abs(Math.sqrt(in) - sqrt(in)));
      }
   }

   /**
    * Get the square root of a number using a trampoline'd version of the
    * Babylonian Method.
    */
   public static double sqrt(long n) {
      double old;
      // double next = n / 2; // could be any positive number but this is an okay start
      double next = 1;
      do {
         old = next;
         next = (old + n / old) / 2;
      } while (Math.abs(old - next) > tolerance);

      return next;
   }

   /**
    * Get the square root using the recursive Babylonian Method (the way they did it)
    */
   public static double sqrt_r(long n) {
      return sqrt_r(n, n / 2); // sigh... no default arguments still
   }

   public static double sqrt_r(long n, double initialGuess) {
      double nextGuess = (initialGuess + n / initialGuess) / 2;
      if (Math.abs(nextGuess - initialGuess) > tolerance) {
         return sqrt_r(n, nextGuess);
      } else {
         return nextGuess;
      }
   }
}
