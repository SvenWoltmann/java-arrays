package eu.happycoders.length;

/**
 * Tries to create byte and long arrays with Integer.MAX_VALUE, Integer.MAX_VALUE - 1, and
 * Integer.MAX_VALUE - 2 elements. The largest long array takes 16 GB, so start the class with a
 * heap of at least 20 GB:
 *
 * <pre>
 * java -Xmx20g -cp target/classes eu.happycoders.length.Ch4MaxArraySize
 * </pre>
 */
public class Ch4MaxArraySize {

  static void main() {
    for (int length = Integer.MAX_VALUE; length >= Integer.MAX_VALUE - 2; length--) {
      tryToCreate("byte", length);
    }
    for (int length = Integer.MAX_VALUE; length >= Integer.MAX_VALUE - 2; length--) {
      tryToCreate("long", length);
    }
  }

  private static void tryToCreate(String type, int length) {
    try {
      Object array = type.equals("byte") ? new byte[length] : new long[length];
      System.out.println(
          "new %s[%d] created: %s".formatted(type, length, array.getClass().getSimpleName()));
    } catch (OutOfMemoryError e) {
      System.out.println("new %s[%d]: %s".formatted(type, length, e));
    }
  }
}
