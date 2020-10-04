package util;

/**
 * Indent Out Stream
 */
public class IOStream {
   private static final short indentSize = 3;
   private static StringBuilder current = new StringBuilder();
   private static boolean atBeginningOfLine = true;

   public static void indent() {
      current.append(" ".repeat(IOStream.indentSize));
   }

   public static void outdent() {
      var len = current.length();
      current.delete(len - IOStream.indentSize, len);
   }

   public static void write(String s) {
      if (IOStream.atBeginningOfLine) {
         System.out.print(current.toString() + s);
         atBeginningOfLine = false;
      } else {
         System.out.print(s);
      }
   }

   /**
    * Say that a linefeed happened
    */
   public static void lfh() {
      IOStream.atBeginningOfLine = true;
   }

   public static void lf() {
      try {
         System.out.write(new byte[] { (byte) '\n' });
      } catch (Exception e) {
         throw new RuntimeException("Issues writing to stdout");
      }
      lfh();
   }
}
