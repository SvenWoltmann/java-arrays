# Java Arrays

[![Build](https://github.com/SvenWoltmann/java-arrays/actions/workflows/build.yml/badge.svg)](https://github.com/SvenWoltmann/java-arrays/actions/workflows/build.yml)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=SvenWoltmann_java-arrays&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=SvenWoltmann_java-arrays)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=SvenWoltmann_java-arrays&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=SvenWoltmann_java-arrays)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=SvenWoltmann_java-arrays&metric=security_rating)](https://sonarcloud.io/dashboard?id=SvenWoltmann_java-arrays)

The code of the HappyCoders.eu articles on arrays in Java – one package per article. Every class with a `main()` method is one chapter of its article and prints the outputs shown there.

## Articles

| Article | Package |
|---|---|
| How to Initialize Arrays in Java ([English](https://www.happycoders.eu/java/initialize-array-java/), [German](https://www.happycoders.eu/de/java/arrays-in-java-initialisieren/)) | `eu.happycoders.initialize` |
| Array Length in Java ([English](https://www.happycoders.eu/java/array-length-in-java/), [German](https://www.happycoders.eu/de/java/array-laenge-java/)) | `eu.happycoders.length` |
| 2D Arrays in Java (not yet published; [German](https://www.happycoders.eu/de/java/2d-array-java/), [English](https://www.happycoders.eu/java/2d-array-java/)) | `eu.happycoders.twodimensional` |

## Running the examples

The examples use Java 25 language features and need Java 25 or newer. Build once with `mvn compile`, then run a class from the repository root:

```
java -cp target/classes eu.happycoders.<package>.<ClassName>
```

## How to Initialize Arrays in Java – `eu.happycoders.initialize`

* `Ch1Declare` – declaring arrays, initializing them with values (with `new`, with `var`, without `new`, C-style), separately from the declaration, with a length, and the default values of all element types
* `Ch2Fill` – filling an array element by element, with `Arrays.fill()` (whole array and ranges), `Arrays.setAll()`, and `Arrays.parallelSetAll()`
* `Ch3Copy` – `clone()` for primitive and object arrays, `System.arraycopy()`, `Arrays.copyOf()` (same length, shorter, longer), and `Arrays.copyOfRange()`
* `Ch4Convert` – arrays from a `List` and a `Set` with the four `toArray()` variants, from an object stream, and from primitive streams

The outputs on JDK 27 are in `results/initialize/outputs-jdk27.txt`.

## Array Length in Java – `eu.happycoders.length`

* `Ch1GetLength` – `length`, `Array.getLength()`, height and width of a 2D array, and `IntSummaryStatistics` of the row lengths, printed with an English and a German default locale
* `Ch2SetLength` – the length is set when the array is created, with values or with a size
* `Ch3MemoryLayout` – the layout and size of the article's arrays measured with [JOL](https://github.com/openjdk/jol) (Java Object Layout): `int[5]`, `short[5]`, `byte[5]`, `long[3]`, `long[5]`, `String[4]`, and the footprint of `int[2][3]`
* `Ch4MaxArraySize` – `byte` and `long` arrays with `Integer.MAX_VALUE`, `Integer.MAX_VALUE - 1`, and `Integer.MAX_VALUE - 2` elements; needs a heap of 20 GB

JOL needs the JAR with its dependencies, and without the following options it prints warnings about attaching to the JVM:

```
mvn package
java -Djdk.attach.allowAttachSelf -XX:+EnableDynamicAgentLoading \
     -Djol.skipHotspotSAAttach=true --sun-misc-unsafe-memory-access=allow \
     -cp target/benchmarks.jar eu.happycoders.length.Ch3MemoryLayout
```

Add `-XX:-UseCompactObjectHeaders` for the layout up to Java 26. The maximum array size:

```
java -Xmx20g -cp target/classes eu.happycoders.length.Ch4MaxArraySize
```

The outputs on JDK 27 are in `results/length/outputs-jdk27.txt`.

## 2D Arrays in Java – `eu.happycoders.twodimensional`

* `Ch1Structure` – a 2D array is an array of arrays: each row is an `int[]` of its own
* `Ch2Declare` – the brackets at the type, C-style at the name, or mixed
* `Ch3Initialize` – with values, with default values (`new int[2][3]`), and row by row (`new int[2][]`)
* `Ch4Access` – reading and writing elements, a row as an array, and the `ArrayIndexOutOfBoundsException` for a wrong row or column index
* `Ch5Length` – the number of rows and columns, the empty array, and a row 0 that is `null`
* `Ch6Iterate` – nested `for` loops, for-each loops, and a stream with `flatMapToInt()`
* `Ch7Print` – `println()`, `Arrays.toString()` and `Arrays.deepToString()`, one line per row, and aligned columns with `printf()`
* `Ch8Fill` – `Arrays.setAll()` and `Arrays.fill()` per row, and the pitfall of `Arrays.fill()` with one row object for all rows
* `Ch9Jagged` – rows of different lengths, and Pascal's triangle as a jagged array
* `Ch10Copy` – `clone()` copies only the outer array; a deep copy with a loop and with a stream; `Arrays.equals()` vs. `Arrays.deepEquals()`
* `Ch11Sort` – every row for itself, and the rows by one of their columns with a `Comparator`
* `Ch12Multidimensional` – a 3D array, and `Array.newInstance()` for dimensions known only at runtime
* `Ch13Flat` – a 3 x 4 matrix in a flat 1D array, element `[row][col]` at index `row * columns + col`

The outputs of all chapters on JDK 27 are in `results/twodimensional/outputs-jdk27.txt`.

## Benchmarks

Each article's JMH benchmarks are in the `benchmark` subpackage of its package:

* `TraversalBenchmark` – sums all elements of a square `int` matrix with 64, 1,024 and 4,096 rows and columns, stored as a 2D array and as a flat 1D array, each in row-major order (the inner loop walks along a row) and in column-major order (the inner loop walks down a column)

`mvn package` builds `target/benchmarks.jar` with all of them. Run the benchmarks of one article with its package as filter:

```
mvn package
java -jar target/benchmarks.jar eu.happycoders.twodimensional.benchmark
```

The traversal benchmark takes about four minutes. The results of the articles' runs are in `results/<package>/`, e.g. `results/twodimensional/apple-m5-pro/`. The file `traversal-jdk27-size-4100.log` there is a check run with 4,100 instead of 4,096 columns: at 4,096 columns the elements of one column of the flat array are exactly 16 KB apart and evict each other from the same cache sets, which makes the column-major flat traversal slower than the 2D one; at 4,100 columns it is faster.
