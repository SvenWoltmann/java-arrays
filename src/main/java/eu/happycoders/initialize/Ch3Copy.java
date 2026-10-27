package eu.happycoders.initialize;

import java.util.Arrays;

/**
 * Copying arrays: clone() for primitive and object arrays, System.arraycopy(), Arrays.copyOf(), and
 * Arrays.copyOfRange().
 */
public class Ch3Copy {

  static void main() {
    clonePrimitives();
    cloneObjects();
    arraycopy();
    copyOf();
    copyOfRange();
  }

  private static void clonePrimitives() {
    int[] intArray = {6, 11, 5, 7, 44, 7, 4};
    int[] copy = intArray.clone();

    intArray[1] = 999;
    copy[2] = 88;

    System.out.println("intArray: " + Arrays.toString(intArray));
    System.out.println("copy:     " + Arrays.toString(copy));
  }

  private static void cloneObjects() {
    StringBuilder[] fruits = {
      new StringBuilder("cherry"), new StringBuilder("papaya"), new StringBuilder("huckleberry")
    };

    StringBuilder[] copy = fruits.clone();

    fruits[1].reverse();

    System.out.println("fruits: " + Arrays.toString(fruits));
    System.out.println("copy:   " + Arrays.toString(copy));

    copy[2] = new StringBuilder("tomato");

    System.out.println("fruits: " + Arrays.toString(fruits));
    System.out.println("copy:   " + Arrays.toString(copy));
  }

  private static void arraycopy() {
    int[] winningNumbers = {14, 17, 29, 32, 45, 1, 2};
    int[] middleThree = new int[3];
    System.arraycopy(winningNumbers, 2, middleThree, 0, 3);
    System.out.println("middleThree: " + Arrays.toString(middleThree));
  }

  private static void copyOf() {
    int[] winningNumbers = {14, 17, 29, 32, 45, 1, 2};
    int[] copy = Arrays.copyOf(winningNumbers, winningNumbers.length);
    System.out.println("copy = " + Arrays.toString(copy));

    int[] firstThree = Arrays.copyOf(winningNumbers, 3);
    System.out.println("firstThree = " + Arrays.toString(firstThree));

    int[] longerArray = Arrays.copyOf(winningNumbers, 10);
    System.out.println("longerArray = " + Arrays.toString(longerArray));
  }

  private static void copyOfRange() {
    int[] winningNumbers = {14, 17, 29, 32, 45, 1, 2};
    int[] middleThree = Arrays.copyOfRange(winningNumbers, 2, 5);
    System.out.println("middleThree = " + Arrays.toString(middleThree));
  }
}
