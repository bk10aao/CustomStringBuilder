package customstringbuild;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class StringBuilderJMHTest {

    @Param({"10000", "20000", "30000", "40000", "50000", "60000", "70000", "80000", "90000", "100000"})
    public int size;

    private String testStr;
    private char[] chars;
    private char[] insertChars;
    private CharSequence charSequence;
    private CharSequence insertSeq;
    private Object obj;
    private int fromIndex;

    @Setup(Level.Trial)
    public void setUp() {
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            sb.append((char) ('a' + (i % 26)));
        }
        testStr = sb.toString();
        chars = testStr.toCharArray();
        insertChars = "INSERTED".toCharArray();
        charSequence = testStr;
        insertSeq = "INSERT".subSequence(0, Math.min(6, "INSERT".length()));
        obj = new Object();
        fromIndex = size > 0 ? size / 2 : 0;
    }

    @Benchmark
    public StringBuilder benchmarkConstructorEmpty() {
        return new StringBuilder();
    }

    @Benchmark
    public StringBuilder benchmarkConstructorCharSequence() {
        return new StringBuilder(testStr);
    }

    @Benchmark
    public StringBuilder benchmarkConstructorString() {
        return new StringBuilder(testStr);
    }

    // --- Appends ---

    @Benchmark
    public StringBuilder benchmarkAppendBoolean() {
        StringBuilder sb = new StringBuilder();
        return sb.append(true);
    }

    @Benchmark
    public StringBuilder benchmarkAppendChar() {
        StringBuilder sb = new StringBuilder();
        return sb.append('a');
    }

    @Benchmark
    public StringBuilder benchmarkAppendCharArray() {
        StringBuilder sb = new StringBuilder();
        return sb.append(chars);
    }

    @Benchmark
    public StringBuilder benchmarkAppendCharArrayRange() {
        StringBuilder sb = new StringBuilder();
        return sb.append(chars, 0, Math.min(10, chars.length));
    }

    @Benchmark
    public StringBuilder benchmarkAppendCharSequence() {
        StringBuilder sb = new StringBuilder();
        return sb.append(testStr);
    }

    @Benchmark
    public StringBuilder benchmarkAppendCharSequenceRange() {
        StringBuilder sb = new StringBuilder();
        return sb.append(testStr, 0, Math.min(10, testStr.length()));
    }

    @Benchmark
    public StringBuilder benchmarkAppendDouble() {
        StringBuilder sb = new StringBuilder();
        return sb.append(123.456);
    }

    @Benchmark
    public StringBuilder benchmarkAppendFloat() {
        StringBuilder sb = new StringBuilder();
        return sb.append(123.45f);
    }

    @Benchmark
    public StringBuilder benchmarkAppendInt() {
        StringBuilder sb = new StringBuilder();
        return sb.append(42);
    }

    @Benchmark
    public StringBuilder benchmarkAppendLong() {
        StringBuilder sb = new StringBuilder();
        return sb.append(123456789L);
    }

    @Benchmark
    public StringBuilder benchmarkAppendObject() {
        StringBuilder sb = new StringBuilder();
        return sb.append((Object) "obj");
    }

    @Benchmark
    public StringBuilder benchmarkAppendString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(testStr);
    }

    // --- Inserts ---

    @Benchmark
    public StringBuilder benchmarkInsertBoolean() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, true);
    }

    @Benchmark
    public StringBuilder benchmarkInsertChar() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, 'x');
    }

    @Benchmark
    public StringBuilder benchmarkInsertCharArray() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, insertChars);
    }

    @Benchmark
    public StringBuilder benchmarkInsertCharArrayRange() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, insertChars, 0, insertChars.length);
    }

    @Benchmark
    public StringBuilder benchmarkInsertCharSequence() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, insertSeq);
    }

    @Benchmark
    public StringBuilder benchmarkInsertCharSequenceRange() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, insertSeq, 0, insertSeq.length());
    }

    @Benchmark
    public StringBuilder benchmarkInsertDouble() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, 123.45);
    }

    @Benchmark
    public StringBuilder benchmarkInsertFloat() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, 123.45f);
    }

    @Benchmark
    public StringBuilder benchmarkInsertInt() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, 42);
    }

    @Benchmark
    public StringBuilder benchmarkInsertLong() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, 123456789L);
    }

    @Benchmark
    public StringBuilder benchmarkInsertObject() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, (Object) "obj");
    }

    @Benchmark
    public StringBuilder benchmarkInsertString() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.insert(fromIndex, "hello");
    }

    // --- Deletions & Replacements ---

    @Benchmark
    public StringBuilder benchmarkDelete() {
        StringBuilder sb = new StringBuilder(testStr);
        int end = Math.min(fromIndex + 10, testStr.length());
        return sb.delete(fromIndex, end);
    }

    @Benchmark
    public StringBuilder benchmarkDeleteCharAt() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.deleteCharAt(fromIndex);
    }

    @Benchmark
    public StringBuilder benchmarkReplace() {
        StringBuilder sb = new StringBuilder(testStr);
        int end = Math.min(fromIndex + 5, testStr.length());
        return sb.replace(fromIndex, end, "REPLACE");
    }

    @Benchmark
    public StringBuilder benchmarkReverse() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.reverse();
    }

    // --- Searching & Indexing ---

    @Benchmark
    public int benchmarkIndexOf() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.indexOf("a");
    }

    @Benchmark
    public int benchmarkIndexOfFromIndex() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.indexOf("a", 0);
    }

    @Benchmark
    public int benchmarkLastIndexOf() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.lastIndexOf("a");
    }

    @Benchmark
    public void benchmarkSetCharAt() {
        StringBuilder sb = new StringBuilder(testStr);
        sb.setCharAt(fromIndex, 'z');
    }

    // --- Subsequences & Substrings ---

    @Benchmark
    public CharSequence benchmarkSubSequence() {
        StringBuilder sb = new StringBuilder(testStr);
        int end = Math.min(fromIndex + 10, testStr.length());
        return sb.subSequence(fromIndex, end);
    }

    @Benchmark
    public String benchmarkSubStringSingle() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.substring(fromIndex);
    }

    @Benchmark
    public String benchmarkSubstringRange() {
        StringBuilder sb = new StringBuilder(testStr);
        int end = Math.min(fromIndex + 10, testStr.length());
        return sb.substring(fromIndex, end);
    }

    // --- Properties & Comparisons ---

    @Benchmark
    public char benchmarkCharAt() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.charAt(fromIndex);
    }

    @Benchmark
    public int benchmarkCompareTo() {
        StringBuilder sb1 = new StringBuilder(testStr);
        StringBuilder sb2 = new StringBuilder(testStr);
        return sb1.compareTo(sb2);
    }

    @Benchmark
    public int benchmarkCompareToStandard() {
        StringBuilder sb1 = new StringBuilder(testStr);
        StringBuilder sb2 = new StringBuilder(testStr);
        return sb1.compareTo(sb2);
    }

    @Benchmark
    public boolean benchmarkEquals() {
        StringBuilder sb1 = new StringBuilder(testStr);
        StringBuilder sb2 = new StringBuilder(testStr);
        return sb1.equals(sb2);
    }

    @Benchmark
    public int benchmarkHashCode() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.hashCode();
    }

    @Benchmark
    public int benchmarkLength() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.length();
    }

    @Benchmark
    public String benchmarkToString() {
        StringBuilder sb = new StringBuilder(testStr);
        return sb.toString();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StringBuilderJMHTest.class.getName())
                .measurementIterations(3)
                .forks(1)
                .result("StringBuilder_performance_results.csv")
                .resultFormat(ResultFormatType.CSV)
                .build();

        Collection<RunResult> results = new Runner(opt).run();
        writeCustomCsv(results);
    }

    private static void writeCustomCsv(Collection<RunResult> results) {
        try (FileWriter writer = new FileWriter("StringBuilder_jmh_performance.csv")) {
            writer.write("Benchmark;Size;Score (ns/op)\n");
            for (RunResult result : results) {
                String benchmarkName = result.getParams().getBenchmark();
                String shortName = benchmarkName.substring(benchmarkName.lastIndexOf('.') + 1);

                double score = result.getPrimaryResult().getScore();
                String sizeVal = result.getParams().getParam("size");

                writer.write("\"" + shortName + "\";" + (sizeVal != null ? sizeVal : "N/A") + ";" + score + "\n");
            }
            System.out.println("JMH Performance report saved: StringBuilderV2_jmh_performance.csv");
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}