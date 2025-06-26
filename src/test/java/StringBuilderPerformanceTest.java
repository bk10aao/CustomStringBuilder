import java.io.FileWriter;
import java.io.IOException;

public class StringBuilderPerformanceTest {

    public static void main(String[] args) {
        int[] sizes = {1, 10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000,
                25000, 50000, 100000, 250000, 500000, 1000000};

        long[][] results = new long[sizes.length][];

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            System.out.println("Benchmarking size: " + size);
            String testStr = generateString(size);

            long appendTime = benchmarkAppend(testStr);
            long insertTime = benchmarkInsert(testStr);
            long deleteTime = benchmarkDelete(testStr);
            long replaceTime = benchmarkReplace(testStr);
            long reverseTime = benchmarkReverse(testStr);
            long indexOfTime = benchmarkIndexOf(testStr);
            long lastIndexOfTime = benchmarkLastIndexOf(testStr);
            long toStringTime = benchmarkToString(testStr);
            long substringTime = benchmarkSubstring(testStr);

            results[i] = new long[]{
                    size, appendTime, insertTime, deleteTime,
                    replaceTime, reverseTime, indexOfTime,
                    lastIndexOfTime, toStringTime, substringTime
            };
        }

        try (FileWriter writer = new FileWriter("StringBuilder_performance.csv")) {
            writer.write("Size,Append,Insert,Delete,Replace,Reverse,IndexOf,LastIndexOf,ToString,Substring\n");
            for (long[] row : results) {
                for (int j = 0; j < row.length; j++) {
                    writer.write(String.valueOf(row[j]));
                    if (j < row.length - 1) writer.write(",");
                }
                writer.write("\n");
            }
            System.out.println("Performance data written to StringBuilder_performance.csv");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    private static String generateString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) sb.append((char) ('a' + (i % 26)));
        return sb.toString();
    }

    private static long benchmarkAppend(String input) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsert(String input) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(input);
        sb.insert(0, "INSERTED");
        return System.nanoTime() - start;
    }

    private static long benchmarkDelete(String input) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(input);
        sb.delete(0, Math.min(10, sb.length()));
        return System.nanoTime() - start;
    }

    private static long benchmarkReplace(String input) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(input);
        int mid = Math.min(sb.length() / 2, sb.length() - 1);
        sb.replace(0, mid, "REPLACED");
        return System.nanoTime() - start;
    }

    private static long benchmarkReverse(String input) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return System.nanoTime() - start;
    }

    private static long benchmarkIndexOf(String input) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(input);
        sb.indexOf("z");  // unlikely character
        return System.nanoTime() - start;
    }

    private static long benchmarkLastIndexOf(String input) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(input);
        sb.lastIndexOf("a");
        return System.nanoTime() - start;
    }

    private static long benchmarkToString(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.toString();
        return System.nanoTime() - start;
    }

    private static long benchmarkSubstring(String input) {
        StringBuilder sb = new StringBuilder(input);
        int len = sb.length();
        int startIdx = Math.min(5, len);
        int endIdx = Math.min(15, len);
        long start = System.nanoTime();
        sb.substring(startIdx, endIdx);
        return System.nanoTime() - start;
    }
}
