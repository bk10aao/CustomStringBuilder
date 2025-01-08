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
    public void givenStringBuilder_withCharSequenceConstructor_of_null_andLengthOf_0() {
        CharSequence charSequence = null;
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        assertEquals(0, customStringBuilder.length());
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructor_of_123abc_returns_lengthOf_6() {
        CharSequence charSequence = "123abc";
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        assertEquals(6, customStringBuilder.length());
    }


    @Test
    public void givenStringBuilder_withStringConstructor_andEmptyString_returns_lengthOf_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("");
        assertEquals(0, customStringBuilder.length());
        assertEquals("", customStringBuilder.toString());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_null_returns_lengthOf_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(null);
        assertEquals(0, customStringBuilder.length());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_andStringOf_123abc_lengthOf_6_andStringValue_123abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertEquals(6, customStringBuilder.length());
    }

    @Test
    public void givenStringBuilder_withStringConstructor_STRING_VALUE_OF_LENGTH_129_retunsLengthOf_129() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(STRING_VALUE_OF_LENGTH_129);
        assertEquals(129, customStringBuilder.length());
    }

    @Test
    public void givenEmptyStringBuilder_on_toString_returns_emptyString() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructor_of_null_on_toString_returns_emptyString() {
        CharSequence charSequence = null;
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
    }

    @Test
    public void givenStringBuilder_withCharSequenceConstructor_of_123abc_on_toString_returns_stringOf_123abc() {
        CharSequence charSequence = "123abc";
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(charSequence);
        String stringValue = customStringBuilder.toString();
        assertEquals("123abc", stringValue);
    }

    @Test
    public void givenStringBuilder_withSizeOf_127_returns_emptyString() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(127);
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
    }

    @Test
    public void givenStringBuilder_withEmptyStringConstructor_returns_emptyString() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("");
        String stringValue = customStringBuilder.toString();
        assertEquals("", stringValue);
    }

    @Test
    public void givenStringBuilder_withStringConstructor_123abc_returns_stringOf_123abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String stringValue = customStringBuilder.toString();
        assertEquals("123abc", stringValue);
    }

    private static final String STRING_VALUE_OF_LENGTH_129 = "uwcwiavzhhigohtwixbrlxserzenalmzmkzwhrtewfzqpcvtsrnxkpdzcqsvpnqsatxjftfkhrdagqqunffpezghcpkuhlwrttdduhwgvpoqsksfojgtkgtkxkyzvbykl";

}