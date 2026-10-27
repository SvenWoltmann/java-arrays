package eu.happycoders.initialize;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/** Creating arrays from lists, sets, object streams, and primitive streams. */
public class Ch4Convert {

  static void main() {
    fromList();
    fromSet();
    fromObjectStream();
    fromPrimitiveStreams();
  }

  private static void fromList() {
    List<String> fruits = List.of("honeydew", "dragonfruit", "boysenberry");
    Object[] array1 = fruits.toArray();
    String[] array2 = fruits.toArray(new String[fruits.size()]);
    String[] array3 = fruits.toArray(new String[0]);
    String[] array4 = fruits.toArray(String[]::new);

    for (Object[] array : List.of(array1, array2, array3, array4)) {
      System.out.println(array.getClass().getSimpleName() + " " + Arrays.toString(array));
    }
  }

  private static void fromSet() {
    // Set.of() has no defined iteration order, so the order of the elements varies between runs
    Set<String> fruits = Set.of("honeydew", "dragonfruit", "boysenberry");
    String[] array4 = fruits.toArray(String[]::new);
    System.out.println(array4.getClass().getSimpleName() + " with " + array4.length + " elements");
  }

  private static void fromObjectStream() {
    Stream<String> stream1 = Stream.of("mango", "tomato", "coconut");
    Object[] objects = stream1.toArray();

    Stream<String> stream2 = Stream.of("cherry", "date", "raspberry");
    String[] strings = stream2.toArray(String[]::new);

    System.out.println(objects.getClass().getSimpleName() + " " + Arrays.toString(objects));
    System.out.println(strings.getClass().getSimpleName() + " " + Arrays.toString(strings));
  }

  private static void fromPrimitiveStreams() {
    int[] intArray = IntStream.rangeClosed(1, 10).toArray();
    long[] longArray = LongStream.iterate(1, x -> x < 2000, x -> x * 2).toArray();
    double[] doubleArray = DoubleStream.iterate(1.0, x -> x / 2.0).limit(8).toArray();

    System.out.println("intArray = " + Arrays.toString(intArray));
    System.out.println("longArray = " + Arrays.toString(longArray));
    System.out.println("doubleArray = " + Arrays.toString(doubleArray));
  }
}
