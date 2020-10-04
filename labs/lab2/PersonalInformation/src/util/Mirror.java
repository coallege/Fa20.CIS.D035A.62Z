package util;

import java.lang.reflect.Modifier;
import java.lang.reflect.Field;

import java.util.Scanner;

public class Mirror {
   public static <T> String getName(Class<T> clazz) {
      var simpleName = clazz.getSimpleName();
      if (simpleName != "") {
         return simpleName;
      }

      var canonicalName = clazz.getCanonicalName();
      if (canonicalName != null) {
         return canonicalName;
      }

      return clazz.getTypeName();
   }

   public static <T> T instance(Class<T> clazz) {
      try {
         return clazz.getConstructor().newInstance();
      } catch (Exception e) {
         return null;
      }
   }

   public static <T> T fill(Class<T> clazz) {
      return Mirror.fill(Mirror.instance(clazz));
   }

   public static <T> T fill(T instance) {
      var clazz = instance.getClass();
      var name = Mirror.getName(clazz);
      var fields = clazz.getDeclaredFields();
      var sc = new Scanner(System.in);

      IOStream.write(name + " {\n");
      IOStream.lf();
      IOStream.indent();
      for (Field f : fields) {
         var modifiers = Modifier.toString(f.getModifiers());
         if (modifiers != "") {
            IOStream.write(modifiers + " ");
         }

         var type = f.getType();
         var typeString = Mirror.getName(type);
         IOStream.write(typeString + " " + f.getName() + " = ");

         if (type.isPrimitive()) {
            sc.nextLine();
            IOStream.lfh();
         } else {
            fill(type);
         }
      }
      IOStream.outdent();

      sc.close();
      IOStream.write("}");
      IOStream.lf();
      return instance;
   }
}
