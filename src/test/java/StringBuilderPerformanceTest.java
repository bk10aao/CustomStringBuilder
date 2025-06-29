import java.io.FileWriter;
import java.io.IOException;

public class StringBuilderPerformanceTest {

    public static void main(String[] args) {
        int[] sizes = {10, 50, 100, 250, 500, 750, 1000, 2500, 5000, 7500, 10000,
                25000, 50000, 100000, 250000, 500000, 1000000};

        long[][] results = new long[sizes.length][];

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
                "\"append(Object)\"",
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
            long appendObjectTime = benchmarkAppendObject();
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
                    appendDoubleTime, appendFloatTime, appendIntTime, appendLongTime, appendObjectTime, appendTime,
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
        long start = System.nanoTime();
        new StringBuilder(input);
        return System.nanoTime() - start;
    }

    // Append benchmarks
    private static long benchmarkAppendBoolean() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append(true);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendChar() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append('a');
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendCharArray(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        long start = System.nanoTime();
        sb.append(chars);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendCharArrayRange(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        int len = Math.min(10, chars.length);
        long start = System.nanoTime();
        sb.append(chars, 0, len);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendCharSequence(CharSequence input) {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append(input);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendCharSequenceRange(CharSequence input) {
        StringBuilder sb = new StringBuilder();
        int len = Math.min(10, input.length());
        long start = System.nanoTime();
        sb.append(input, 0, len);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendDouble() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append(123.45);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendFloat() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append(123.45f);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendInt() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append(123);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendLong() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append(123L);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppendObject() {
        StringBuilder sb = new StringBuilder();
        Object obj = new Object();
        long start = System.nanoTime();
        sb.append(obj);
        return System.nanoTime() - start;
    }

    private static long benchmarkAppend(String input) {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        sb.append(input);
        return System.nanoTime() - start;
    }

    // Insert benchmarks
    private static long benchmarkInsertBoolean(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.insert(0, true);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertChar(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.insert(0, 'a');
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertCharArray(String input) {
        StringBuilder sb = new StringBuilder(input);
        char[] chars = "INSERTED".toCharArray();
        long start = System.nanoTime();
        sb.insert(0, chars);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertCharArrayRange(String input) {
        StringBuilder sb = new StringBuilder(input);
        char[] chars = "INSERTED".toCharArray();
        long start = System.nanoTime();
        sb.insert(0, chars, 0, 4);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertCharSequence(String input) {
        StringBuilder sb = new StringBuilder(input);
        CharSequence seq = "INSERT".subSequence(0, 6);
        long start = System.nanoTime();
        sb.insert(0, seq);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertCharSequenceRange(String input) {
        StringBuilder sb = new StringBuilder(input);
        CharSequence seq = "INSERT".subSequence(0, 6);
        long start = System.nanoTime();
        sb.insert(0, seq, 0, 3);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertDouble(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.insert(0, 123.45);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertFloat(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.insert(0, 123.45f);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertInt(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.insert(0, 123);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertLong(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.insert(0, 123L);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsertObject(String input) {
        StringBuilder sb = new StringBuilder(input);
        Object obj = new Object();
        long start = System.nanoTime();
        sb.insert(0, obj);
        return System.nanoTime() - start;
    }

    private static long benchmarkInsert(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.insert(0, input);
        return System.nanoTime() - start;
    }

    // Delete benchmarks
    private static long benchmarkDelete(String input) {
        StringBuilder sb = new StringBuilder(input);
        int len = input.length();
        long start = System.nanoTime();
        sb.delete(0, len > 10 ? 10 : len);
        return System.nanoTime() - start;
    }

    private static long benchmarkDeleteCharAt(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        if (sb.length() > 0) sb.deleteCharAt(0);
        return System.nanoTime() - start;
    }

    // Replace benchmark
    private static long benchmarkReplace(String input) {
        StringBuilder sb = new StringBuilder(input);
        int len = input.length();
        long start = System.nanoTime();
        sb.replace(0, len > 10 ? 10 : len, "REPLACE");
        return System.nanoTime() - start;
    }

    // Reverse benchmark
    private static long benchmarkReverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.reverse();
        return System.nanoTime() - start;
    }

    // indexOf benchmarks
    private static long benchmarkIndexOf(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.indexOf("a");
        return System.nanoTime() - start;
    }

    private static long benchmarkIndexOfFromIndex(String input) {
        StringBuilder sb = new StringBuilder(input);
        int fromIndex = input.length() / 2;
        long start = System.nanoTime();
        sb.indexOf("a", fromIndex);
        return System.nanoTime() - start;
    }

    private static long benchmarkLastIndexOf(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.lastIndexOf("a");
        return System.nanoTime() - start;
    }

    // setCharAt benchmark
    private static long benchmarkSetCharAt(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        if (sb.length() > 0) sb.setCharAt(0, 'z');
        return System.nanoTime() - start;
    }

    // toString benchmark
    private static long benchmarkToString(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.toString();
        return System.nanoTime() - start;
    }

    // subSequence benchmark
    private static long benchmarkSubSequence(String input) {
        StringBuilder sb = new StringBuilder(input);
        int len = sb.length();
        long start = System.nanoTime();
        sb.subSequence(0, len > 10 ? 10 : len);
        return System.nanoTime() - start;
    }

    // substring benchmarks
    private static long benchmarkSubStringSingle(String input) {
        StringBuilder sb = new StringBuilder(input);
        int len = sb.length();
        long start = System.nanoTime();
        sb.substring(len > 10 ? 10 : 0);
        return System.nanoTime() - start;
    }

    private static long benchmarkSubstring(String input) {
        StringBuilder sb = new StringBuilder(input);
        int len = sb.length();
        long start = System.nanoTime();
        sb.substring(0, len > 10 ? 10 : len);
        return System.nanoTime() - start;
    }

    // length benchmark
    private static long benchmarkLength(String input) {
        StringBuilder sb = new StringBuilder(input);
        long start = System.nanoTime();
        sb.length();
        return System.nanoTime() - start;
    }
}
