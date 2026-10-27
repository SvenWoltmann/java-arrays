package eu.happycoders.twodimensional.benchmark;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

/**
 * Sums all elements of a square {@code int} matrix with {@code size} rows and columns, stored as a
 * 2D array ({@code int[size][size]}) and as a flat 1D array ({@code int[size * size]}, element
 * {@code [row][col]} at index {@code row * size + col}) - each in row-major order (the inner loop
 * walks along a row) and in column-major order (the inner loop walks down a column).
 *
 * <p>With 64 rows the matrix has 16 KB and fits into the L1 cache, with 1,024 rows it has 4 MB,
 * with 4,096 rows 64 MB.
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
@State(Scope.Benchmark)
public class TraversalBenchmark {

  @Param({"64", "1024", "4096"})
  private int size;

  private int[][] matrix;
  private int[] flat;

  @Setup
  public void setUp() {
    Random random = new Random(42);
    matrix = new int[size][size];
    flat = new int[size * size];
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        int value = random.nextInt(100);
        matrix[row][col] = value;
        flat[row * size + col] = value;
      }
    }
  }

  @Benchmark
  public long rowMajor2d() {
    long sum = 0;
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        sum += matrix[row][col];
      }
    }
    return sum;
  }

  @Benchmark
  public long columnMajor2d() {
    long sum = 0;
    for (int col = 0; col < size; col++) {
      for (int row = 0; row < size; row++) {
        sum += matrix[row][col];
      }
    }
    return sum;
  }

  @Benchmark
  public long rowMajorFlat() {
    long sum = 0;
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        sum += flat[row * size + col];
      }
    }
    return sum;
  }

  @Benchmark
  public long columnMajorFlat() {
    long sum = 0;
    for (int col = 0; col < size; col++) {
      for (int row = 0; row < size; row++) {
        sum += flat[row * size + col];
      }
    }
    return sum;
  }
}
