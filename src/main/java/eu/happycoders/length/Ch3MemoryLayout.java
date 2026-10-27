package eu.happycoders.length;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * Measures the memory layout and size of the arrays in the article with JOL (Java Object Layout).
 * Without options, JOL prints warnings about attaching to the JVM; these options silence them:
 *
 * <pre>
 * java -Djdk.attach.allowAttachSelf -XX:+EnableDynamicAgentLoading \
 *      -Djol.skipHotspotSAAttach=true --sun-misc-unsafe-memory-access=allow \
 *      -cp target/benchmarks.jar eu.happycoders.length.Ch3MemoryLayout
 * </pre>
 *
 * <p>Add {@code -XX:-UseCompactObjectHeaders} for the layout up to Java 26.
 */
public class Ch3MemoryLayout {

  static void main() {
    int[] intArray = {6, 1, 1, 5, 7};
    System.out.println(ClassLayout.parseInstance(intArray).toPrintable());

    printSize("short[5]", new short[5]);
    printSize("byte[5]", new byte[5]);
    printSize("long[3]", new long[3]);
    printSize("long[5]", new long[5]);
    printSize("String[4]", new String[] {"jujube", "apple", "boysenberry", "cherry"});

    int[][] intMatrix = {{2, 3, 6}, {4, 5, 1}};
    System.out.println(GraphLayout.parseInstance((Object) intMatrix).toFootprint());
  }

  private static void printSize(String name, Object array) {
    System.out.println(name + ": " + ClassLayout.parseInstance(array).instanceSize() + " bytes");
  }
}
