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
public class CustomStringBuilderJMHTest {

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
    public CustomStringBuilder benchmarkConstructorEmpty() {
        return new CustomStringBuilder();
    }

    @Benchmark
    public CustomStringBuilder benchmarkConstructorCharSequence() {
        return new CustomStringBuilder(testStr);
    }

    @Benchmark
    public CustomStringBuilder benchmarkConstructorString() {
        return new CustomStringBuilder(testStr);
    }

    // --- Appends ---

    @Benchmark
    public CustomStringBuilder benchmarkAppendBoolean() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(true);
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendChar() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append('a');
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendCharArray() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(chars);
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendCharArrayRange() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(chars, 0, Math.min(10, chars.length));
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendCharSequence() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(testStr);
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendCharSequenceRange() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(testStr, 0, Math.min(10, testStr.length()));
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendDouble() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(123.456);
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendFloat() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(123.45f);
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendInt() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(42);
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendLong() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(123456789L);
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendObject() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append((Object) "obj");
    }

    @Benchmark
    public CustomStringBuilder benchmarkAppendString() {
        CustomStringBuilder sb = new CustomStringBuilder();
        return sb.append(testStr);
    }

    // --- Inserts ---

    @Benchmark
    public CustomStringBuilder benchmarkInsertBoolean() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, true);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertChar() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, 'x');
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertCharArray() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, insertChars);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertCharArrayRange() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, insertChars, 0, insertChars.length);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertCharSequence() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, insertSeq);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertCharSequenceRange() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, insertSeq, 0, insertSeq.length());
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertDouble() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, 123.45);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertFloat() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, 123.45f);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertInt() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, 42);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertLong() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, 123456789L);
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertObject() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, (Object) "obj");
    }

    @Benchmark
    public CustomStringBuilder benchmarkInsertString() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.insert(fromIndex, "hello");
    }

    // --- Deletions & Replacements ---

    @Benchmark
    public CustomStringBuilder benchmarkDelete() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        int end = Math.min(fromIndex + 10, testStr.length());
        return sb.delete(fromIndex, end);
    }

    @Benchmark
    public CustomStringBuilder benchmarkDeleteCharAt() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.deleteCharAt(fromIndex);
    }

    @Benchmark
    public CustomStringBuilder benchmarkReplace() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        int end = Math.min(fromIndex + 5, testStr.length());
        return sb.replace(fromIndex, end, "REPLACE");
    }

    @Benchmark
    public CustomStringBuilder benchmarkReverse() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.reverse();
    }

    // --- Searching & Indexing ---

    @Benchmark
    public int benchmarkIndexOf() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.indexOf("a");
    }

    @Benchmark
    public int benchmarkIndexOfFromIndex() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.indexOf("a", 0);
    }

    @Benchmark
    public int benchmarkLastIndexOf() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.lastIndexOf("a");
    }

    @Benchmark
    public void benchmarkSetCharAt() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        sb.setCharAt(fromIndex, 'z');
    }

    // --- Subsequences & Substrings ---

    @Benchmark
    public CharSequence benchmarkSubSequence() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        int end = Math.min(fromIndex + 10, testStr.length());
        return sb.subSequence(fromIndex, end);
    }

    @Benchmark
    public String benchmarkSubStringSingle() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.subString(fromIndex);
    }

    @Benchmark
    public String benchmarkSubstringRange() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        int end = Math.min(fromIndex + 10, testStr.length());
        return sb.subString(fromIndex, end);
    }

    // --- Properties & Comparisons ---

    @Benchmark
    public char benchmarkCharAt() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.charAt(fromIndex);
    }

    @Benchmark
    public int benchmarkCompareToCustom() {
        CustomStringBuilder sb1 = new CustomStringBuilder(testStr);
        CustomStringBuilder sb2 = new CustomStringBuilder(testStr);
        return sb1.compareTo(sb2);
    }

    @Benchmark
    public int benchmarkCompareToStandard() {
        CustomStringBuilder sb1 = new CustomStringBuilder(testStr);
        StringBuilder sb2 = new StringBuilder(testStr);
        return sb1.compareTo(sb2);
    }

    @Benchmark
    public boolean benchmarkEquals() {
        CustomStringBuilder sb1 = new CustomStringBuilder(testStr);
        CustomStringBuilder sb2 = new CustomStringBuilder(testStr);
        return sb1.equals(sb2);
    }

    @Benchmark
    public int benchmarkHashCode() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.hashCode();
    }

    @Benchmark
    public int benchmarkLength() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.length();
    }

    @Benchmark
    public String benchmarkToString() {
        CustomStringBuilder sb = new CustomStringBuilder(testStr);
        return sb.toString();
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CustomStringBuilderJMHTest.class.getSimpleName())
                .measurementIterations(3)
                .forks(1)
                .result("CustomStringBuilder_performance_results.csv")
                .resultFormat(ResultFormatType.CSV)
                .build();

        Collection<RunResult> results = new Runner(opt).run();
        writeCustomCsv(results);
    }

    private static void writeCustomCsv(Collection<RunResult> results) {
        try (FileWriter writer = new FileWriter("CustomStringBuilder_jmh_performance.csv")) {
            writer.write("Benchmark;Size;Score (ns/op)\n");
            for (RunResult result : results) {
                String benchmarkName = result.getParams().getBenchmark();
                String shortName = benchmarkName.substring(benchmarkName.lastIndexOf('.') + 1);

                double score = result.getPrimaryResult().getScore();
                String sizeVal = result.getParams().getParam("size");

                writer.write("\"" + shortName + "\";" + (sizeVal != null ? sizeVal : "N/A") + ";" + score + "\n");
            }
            System.out.println("JMH Performance report saved: CustomStringBuilderV2_jmh_performance.csv");
        } catch (IOException e) {
            System.err.println("Failed to write CSV: " + e.getMessage());
        }
    }
}