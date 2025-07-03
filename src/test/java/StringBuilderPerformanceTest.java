import java.io.FileWriter;
import java.io.IOException;

public class StringBuilderPerformanceTest {

    private static final int RUNS = 100; // Number of runs for averaging

    public static void main(String[] args) {
        int[] sizes = { 1000, 2500, 5000, 7500, 10000,
                25000, 50000, 100000, 250000, 500000, 1000000};

        long[][] results = new long[sizes.length][];

        // Method names updated to reflect StringBuilder and substring
        String[] methodNames = {
                "\"StringBuilder(CharSequence)\"",
                "\"append(boolean)\"",
                "\"append(char)\"",
                "\"append(char[])\"",
                "\"append(char[], int, int)\"",
                "\"append(CharSequence)\"",
                "\"append(CharSequence, int, int)\"",
                "\"append(double)\"",
                "\"append(float)\"",
                "\"append(int)\"",
                "\"append(long)\"",
                "\"append(String)\"",
                "\"insert(int, boolean)\"",
                "\"insert(int, char)\"",
                "\"insert(int, char[])\"",
                "\"insert(int, char[], int, int)\"",
                "\"insert(int, CharSequence)\"",
                "\"insert(int, CharSequence, int, int)\"",
                "\"insert(int, double)\"",
                "\"insert(int, float)\"",
                "\"insert(int, int)\"",
                "\"insert(int, long)\"",
                "\"insert(int, Object)\"",
                "\"insert(int, String)\"",
                "\"delete(int, int)\"",
                "\"deleteCharAt(int)\"",
                "\"replace(int, int, String)\"",
                "\"reverse()\"",
                "\"indexOf(String)\"",
                "\"indexOf(String, int)\"",
                "\"lastIndexOf(String)\"",
                "\"setCharAt(int, char)\"",
                "\"toString()\"",
                "\"subSequence(int, int)\"",
                "\"substring(int)\"",
                "\"substring(int, int)\"",
                "\"length()\""
        };

        for (int i = 0; i < sizes.length; i++) {
            int size = sizes[i];
            System.out.println("Benchmarking size: " + size);
            String testStr = generateString(size);
            CharSequence testSeq = testStr;

            long constructorCharSequenceTime = benchmarkConstructorCharSequence(testSeq);
            long appendBooleanTime = benchmarkAppendBoolean();
            long appendCharTime = benchmarkAppendChar();
            long appendCharArrayTime = benchmarkAppendCharArray(testStr);
            long appendCharArrayRangeTime = benchmarkAppendCharArrayRange(testStr);
            long appendCharSequenceTime = benchmarkAppendCharSequence(testSeq);
            long appendCharSequenceRangeTime = benchmarkAppendCharSequenceRange(testSeq);
            long appendDoubleTime = benchmarkAppendDouble();
            long appendFloatTime = benchmarkAppendFloat();
            long appendIntTime = benchmarkAppendInt();
            long appendLongTime = benchmarkAppendLong();
            long appendTime = benchmarkAppend(testStr);
            long insertBooleanTime = benchmarkInsertBoolean(testStr);
            long insertCharTime = benchmarkInsertChar(testStr);
            long insertCharArrayTime = benchmarkInsertCharArray(testStr);
            long insertCharArrayRangeTime = benchmarkInsertCharArrayRange(testStr);
            long insertCharSequenceTime = benchmarkInsertCharSequence(testStr);
            long insertCharSequenceRangeTime = benchmarkInsertCharSequenceRange(testStr);
            long insertDoubleTime = benchmarkInsertDouble(testStr);
            long insertFloatTime = benchmarkInsertFloat(testStr);
            long insertIntTime = benchmarkInsertInt(testStr);
            long insertLongTime = benchmarkInsertLong(testStr);
            long insertObjectTime = benchmarkInsertObject(testStr);
            long insertTime = benchmarkInsert(testStr);
            long deleteTime = benchmarkDelete(testStr);
            long deleteCharAtTime = benchmarkDeleteCharAt(testStr);
            long replaceTime = benchmarkReplace(testStr);
            long reverseTime = benchmarkReverse(testStr);
            long indexOfTime = benchmarkIndexOf(testStr);
            long indexOfFromIndexTime = benchmarkIndexOfFromIndex(testStr);
            long lastIndexOfTime = benchmarkLastIndexOf(testStr);
            long setCharAtTime = benchmarkSetCharAt(testStr);
            long toStringTime = benchmarkToString(testStr);
            long subSequenceTime = benchmarkSubSequence(testStr);
            long subStringSingleTime = benchmarkSubStringSingle(testStr);
            long subStringTime = benchmarkSubstring(testStr);
            long lengthTime = benchmarkLength(testStr);

            results[i] = new long[]{
                    size, constructorCharSequenceTime, appendBooleanTime, appendCharTime, appendCharArrayTime,
                    appendCharArrayRangeTime, appendCharSequenceTime, appendCharSequenceRangeTime,
                    appendDoubleTime, appendFloatTime, appendIntTime, appendLongTime, appendTime,
                    insertBooleanTime, insertCharTime, insertCharArrayTime, insertCharArrayRangeTime,
                    insertCharSequenceTime, insertCharSequenceRangeTime, insertDoubleTime, insertFloatTime,
                    insertIntTime, insertLongTime, insertObjectTime, insertTime, deleteTime, deleteCharAtTime,
                    replaceTime, reverseTime, indexOfTime, indexOfFromIndexTime, lastIndexOfTime,
                    setCharAtTime, toStringTime, subSequenceTime, subStringSingleTime,
                    subStringTime, lengthTime
            };
        }

        try (FileWriter writer = new FileWriter("StringBuilder_performance.csv")) {
            writer.write("\"Size\";");
            for (int j = 0; j < methodNames.length; j++) {
                writer.write(methodNames[j]);
                if (j < methodNames.length - 1) writer.write(";");
            }
            writer.write("\n");

            for (long[] row : results) {
                for (int j = 0; j < row.length; j++) {
                    writer.write(String.valueOf(row[j]));
                    if (j < row.length - 1) writer.write(";");
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

    // Constructor benchmark
    private static long benchmarkConstructorCharSequence(CharSequence input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            long start = System.nanoTime();
            new StringBuilder(input);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // Append benchmarks
    private static long benchmarkAppendBoolean() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(true);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendChar() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append('a');
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendCharArray(String input) {
        long totalTime = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(chars);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendCharArrayRange(String input) {
        long totalTime = 0;
        char[] chars = input.toCharArray();
        int len = Math.min(10, chars.length);
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(chars, 0, len);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendCharSequence(CharSequence input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(input);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendCharSequenceRange(CharSequence input) {
        long totalTime = 0;
        int len = Math.min(10, input.length());
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(input, 0, len);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendDouble() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(123.45);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendFloat() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(123.45f);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendInt() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(123);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendLong() {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(123L);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppendObject() {
        long totalTime = 0;
        Object obj = new Object();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(obj);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkAppend(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            long start = System.nanoTime();
            sb.append(input);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // Insert benchmarks
    private static long benchmarkInsertBoolean(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, true);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertChar(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, 'a');
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertCharArray(String input) {
        long totalTime = 0;
        char[] chars = "INSERTED".toCharArray();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, chars);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertCharArrayRange(String input) {
        long totalTime = 0;
        char[] chars = "INSERTED".toCharArray();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, chars, 0, 4);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertCharSequence(String input) {
        long totalTime = 0;
        CharSequence seq = "INSERT".subSequence(0, 6);
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, seq);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertCharSequenceRange(String input) {
        long totalTime = 0;
        CharSequence seq = "INSERT".subSequence(0, 6);
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, seq, 0, 3);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertDouble(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, 123.45);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertFloat(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, 123.45f);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertInt(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, 123);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertLong(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, 123L);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsertObject(String input) {
        long totalTime = 0;
        Object obj = new Object();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, obj);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkInsert(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.insert(0, input);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // Delete benchmarks
    private static long benchmarkDelete(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            int len = input.length();
            long start = System.nanoTime();
            if (len > 2) {
                sb.delete(1, len - 1);
            }
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkDeleteCharAt(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            if (sb.length() > 0) sb.deleteCharAt(0);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkReplace(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            if (sb.length() > 3) sb.replace(0, 3, "xyz");
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkReverse(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.reverse();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // IndexOf benchmarks
    private static long benchmarkIndexOf(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.indexOf("a");
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkIndexOfFromIndex(String input) {
        long totalTime = 0;
        int fromIndex = input.length() / 2;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.indexOf("a", fromIndex);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkLastIndexOf(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.lastIndexOf("a");
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    private static long benchmarkSetCharAt(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            if (sb.length() > 0) sb.setCharAt(0, 'z');
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // toString benchmark
    private static long benchmarkToString(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.toString();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // subSequence benchmark
    private static long benchmarkSubSequence(String input) {
        long totalTime = 0;
        int len = input.length();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            if (len > 2) sb.subSequence(0, len / 2);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // substring(int) benchmark
    private static long benchmarkSubStringSingle(String input) {
        long totalTime = 0;
        int len = input.length();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            if (len > 2) sb.substring(len / 2);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // substring(int, int) benchmark
    private static long benchmarkSubstring(String input) {
        long totalTime = 0;
        int len = input.length();
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            if (len > 2) sb.substring(0, len / 2);
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }

    // length benchmark
    private static long benchmarkLength(String input) {
        long totalTime = 0;
        for (int i = 0; i < RUNS; i++) {
            StringBuilder sb = new StringBuilder(input);
            long start = System.nanoTime();
            sb.length();
            totalTime += System.nanoTime() - start;
        }
        return totalTime / RUNS;
    }
}