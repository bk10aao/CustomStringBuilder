import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringBuilderTest {

    @Test
    public void givenStringBuilder_withSizeConstructor_negative_1_throws_NegativeArraySizeException() {
        assertThrows(NegativeArraySizeException.class,
                ()-> new CustomStringBuilder(-1));
    }

    @Test
    public void givenStringBuilder_withSizeConstructor_negative_20000_throws_NegativeArraySizeException() {
        assertThrows(NegativeArraySizeException.class,
                ()-> new CustomStringBuilder(-20_000));
    }

    @Test
    public void givenDefaultStringBuilder_returnsDefaultSizeOf_127_endIndexOf_0_andLengthOf_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        assertEquals(127, customStringBuilder.getStringCharactersSize());
        assertEquals(0, customStringBuilder.getEndIndex());
        assertEquals(0, customStringBuilder.getLength());
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructor_of_null_returns_returnsDefaultSizeOf_127_endIndexOf_0_andLengthOf_0() {
        CharSequence charSequence = null;
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        assertEquals(127, customStringBuilder.getStringCharactersSize());
        assertEquals(0, customStringBuilder.getEndIndex());
        assertEquals(0, customStringBuilder.getLength());
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructor_of_123abc_returns_returnsDefaultSizeOf_127_endIndexOf_0_andLengthOf_0() {
        CharSequence charSequence = "123abc";
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        assertEquals(127, customStringBuilder.getStringCharactersSize());
        assertEquals(5, customStringBuilder.getEndIndex());
        assertEquals(6, customStringBuilder.getLength());
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructorLargerThanDefaultSize_returns_returnsDefaultSizeOf_127_endIndexOf_0_andLengthOf_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(CHAR_SEQUENCE_VALUE_OF_LENGTH_129);
        assertEquals(258, customStringBuilder.getStringCharactersSize());
        assertEquals(128, customStringBuilder.getEndIndex());
        assertEquals(129, customStringBuilder.getLength());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_andEmptyString_returnsDefaultSizeOf_127_0_endIndexOf_0_andLengthOf_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("");
        assertEquals(127, customStringBuilder.getStringCharactersSize());
        assertEquals(0, customStringBuilder.getEndIndex());
        assertEquals(0, customStringBuilder.getLength());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_null_returnsDefaultSizeOf_127_0_endIndexOf_0_andLengthOf_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(null);
        assertEquals(127, customStringBuilder.getStringCharactersSize());
        assertEquals(0, customStringBuilder.getEndIndex());
        assertEquals(0, customStringBuilder.getLength());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_andStringOf_123abc_returnsDefaultSizeOf_127_0_endIndexOf_5_andLengthOf_6() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertEquals(127, customStringBuilder.getStringCharactersSize());
        assertEquals(5, customStringBuilder.getEndIndex());
        assertEquals(6, customStringBuilder.getLength());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_STRING_VALUE_OF_LENGTH_129_returnsDefaultSizeOf_258_endIndexOf_128_andLengthOf_129() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(STRING_VALUE_OF_LENGTH_129);
        assertEquals(258, customStringBuilder.getStringCharactersSize());
        assertEquals(128, customStringBuilder.getEndIndex());
        assertEquals(129, customStringBuilder.getLength());
    }

    @Test
    public void givenEmptyStringBuilder_on_toString_returns_emptyString() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
        assertEquals(0, stringValue.length());
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructor_of_null_on_toString_returns_emptyString() {
        CharSequence charSequence = null;
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
        assertEquals(0, stringValue.length());
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructor_of_123abc_on_toString_returns_stringOf_123abc() {
        CharSequence charSequence = "123abc";
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        String stringValue = customStringBuilder.toString();
        assertEquals("123abc", stringValue);
        assertEquals(6, stringValue.length());
    }

    @Test
    public void givenStringBuilder_withSizeOf_127_returns_emptyString() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(127);
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
        assertEquals(0, stringValue.length());
    }

    @Test
    public void givenStringBuilder_withEmptyStringConstructor_returns_emptyString() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("");
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
        assertEquals(0, stringValue.length());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_123abc_returns_stringOf_123abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String stringValue = customStringBuilder.toString();
        assertEquals("123abc", stringValue);
        assertEquals(6, stringValue.length());
    }

    private static final String STRING_VALUE_OF_LENGTH_129 = "uwcwiavzhhigohtwixbrlxserzenalmzmkzwhrtewfzqpcvtsrnxkpdzcqsvpnqsatxjftfkhrdagqqunffpezghcpkuhlwrttdduhwgvpoqsksfojgtkgtkxkyzvbykl";

    private static final CharSequence CHAR_SEQUENCE_VALUE_OF_LENGTH_129 = "uwcwiavzhhigohtwixbrlxserzenalmzmkzwhrtewfzqpcvtsrnxkpdzcqsvpnqsatxjftfkhrdagqqunffpezghcpkuhlwrttdduhwgvpoqsksfojgtkgtkxkyzvbykl";
}