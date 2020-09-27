public class BabylonianMethod {
   public static double tolerance = 0.0001;

   /**
    * Get the square root of a number using a trampoline'd version of the
    * Babylonian Method.
    */
   public static double sqrt(long n) {
      double old;
      double next = n / 2; // could be any positive number but this is an okay start
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
         return apprxSqrt(n, nextGuess);
      } else {
         return nextGuess;
      }
   }
}
