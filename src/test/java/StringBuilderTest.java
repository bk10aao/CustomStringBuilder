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
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(null);
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
    public void givenStringBuilder_withStringConstructor_STRING_VALUE_OF_LENGTH_129_returnsLengthOf_129() {
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
        CustomStringBuilder customStringBuilder = new CustomStringBuilder(null);
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

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingBooleanValueOf_true_returns_123abctrue_andLengthOf_10() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append(true);
        String stringValue = appended.toString();
        assertEquals("123abctrue", stringValue);
        assertEquals(10, appended.length());

    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingBooleanValueOf_false_returns_123abcfalse_andLengthOf_11() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append(false);
        String stringValue = appended.toString();
        assertEquals("123abcfalse", stringValue);
        assertEquals(11, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingChar_d_returns_123abcd_andLengthOf_7() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append('d');
        String stringValue = appended.toString();
        assertEquals("123abcd", stringValue);
        assertEquals(7, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharArrayOf_x_y_z_7_8_9_returns_123abcxyz789_andLengthOf_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        char[] append = new char[] {'x', 'y', 'z', '7', '8', '9'};
        CustomStringBuilder appended = customStringBuilder.append(append);
        assertEquals("123abcxyz789", appended.toString());
        assertEquals(12, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharArrayOf_x_y_z_7_8_9_withOffsetOf_negative_1_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        char[] append = new char[] {'x', 'y', 'z', '7', '8', '9'};
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customStringBuilder.append(append,-1, 0));
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharArrayOf_x_y_z_7_8_9_withOffsetOf_1_andLengthOf_negative_1_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        char[] append = new char[] {'x', 'y', 'z', '7', '8', '9'};
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customStringBuilder.append(append,1, -1));
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharArrayOf_x_y_z_7_8_9_withOffsetOf_1_andLengthOf_10_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        char[] append = new char[] {'x', 'y', 'z', '7', '8', '9'};
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customStringBuilder.append(append,1, 10));
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharArrayOf_x_y_z_7_8_9_withOffsetOf_0_andLengthOf_6_returns_123abcxyz789_andLengthOf_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        char[] append = new char[] {'x', 'y', 'z', '7', '8', '9'};
        CustomStringBuilder appended = customStringBuilder.append(append,0, 6);
        assertEquals("123abcxyz789", appended.toString());
        assertEquals(12, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharArrayOf_x_y_z_7_8_9_withOffsetOf_3_andLengthOf_3_returns_123abc789_andLengthOf_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        char[] append = new char[] {'x', 'y', 'z', '7', '8', '9'};
        CustomStringBuilder appended = customStringBuilder.append(append,3, 3);
        assertEquals("123abc789", appended.toString());
        assertEquals(9, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharArrayOf_x_y_z_7_8_9_withOffsetOf_1_andLengthOf_2_returns_123abcZ7_andLengthOf_8() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        char[] append = new char[] {'x', 'y', 'z', '7', '8', '9'};
        CustomStringBuilder appended = customStringBuilder.append(append,1, 2);
        assertEquals("123abcyz", appended.toString());
        assertEquals(8, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharSequenceOf_null_returns_123abcnull_andLengthOf_10() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append((CharSequence) null);
        assertEquals("123abcnull", appended.toString());
        assertEquals(10, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharSequenceOf_789_returns_123abc789_andLengthOf_9() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CharSequence charSequence = "789";
        CustomStringBuilder appended = customStringBuilder.append(charSequence);
        assertEquals("123abc789", appended.toString());
        assertEquals(9, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharSequenceOf_123_at_indexOf_negative_1_andLengthOf_2_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CharSequence charSequence = "123";
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customStringBuilder.append(charSequence, -1, 2));
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharSequenceOf_123_at_indexOf_1_andEndIndexOf_5_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CharSequence charSequence = "123";
        assertThrows(IndexOutOfBoundsException.class,
                ()-> customStringBuilder.append(charSequence, 1, 5));
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingCharSequenceOf_789_at_indexOf_1_andEndIndexOf_2_returns_123abc78_andLengthOf_8() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CharSequence charSequence = "789";
        CustomStringBuilder appended = customStringBuilder.append(charSequence, 1, 2);
        String stringValue = appended.toString();
        assertEquals("123abc89", stringValue);
        assertEquals(8, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingIntegerOf_10_returns_123abc10_andLengthOf_8() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append(10);
        String stringValue = appended.toString();
        assertEquals("123abc10", stringValue);
        assertEquals(8, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingFloatOf_5_point_75f_returns_123abc5_point_75_andLengthOf_10() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append(5.75f);
        String stringValue = appended.toString();
        assertEquals("123abc5.75", stringValue);
        assertEquals(10, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingDoubleOf_19_point_99d_returns_123abc19_point_99_andLengthOf_11() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append(19.99d);
        String stringValue = appended.toString();
        assertEquals("123abc19.99", stringValue);
        assertEquals(11, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onAppendingLongValueOf_10_000L_returns_123abc10000_andLengthOf_11() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder appended = customStringBuilder.append(10_000L);
        String stringValue = appended.toString();
        assertEquals("123abc10000", stringValue);
        assertEquals(11, appended.length());
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onDeletingStartIndexLessThanZero_throw_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.delete(-1, 1));
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onDeletingStartIndexGreaterThanStringLength_10_throw_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.delete(10, 11));
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onDeletingWithStartIndexLargerThanEndIndex_throw_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.delete(5, 3));
    }

//    @Test
//    public void givenStringBuilderWithValueOf_123abc_onDeletingWithStartAndEndIndexOf5_returnsUnchangedStringOf_123abc() {
//        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
//        CustomStringBuilder modified = customStringBuilder.delete(2, 2);
//        String stringValue = modified.toString();
//        assertEquals("123abc", stringValue);
//    }


//    @Test
//    public void givenStringBuilderWithValueOf_123abc_onDeletingWithStartIndexOf_2_AndEndIndexOf_4_returnStringOf_12bc() {
//        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
//        CustomStringBuilder modified = customStringBuilder.delete(2, 4);
//        String stringValue = modified.toString();
//        assertEquals("12bc", stringValue);
//    }
//
    @Test
    public void givenStringBuilderWithValueOf_123abc_onDeletingWithStartIndexOf_2_AndEndIndexOf_10_returnStringOf_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.delete(2, 10);
        String stringValue = modified.toString();
        assertEquals("12", stringValue);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteStartIndexOf_2_andEndIndexOf_4_returns_12bcxyz() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        CustomStringBuilder modified = customStringBuilder.delete(2, 4);
        String value = modified.toString();
        assertEquals("12bcxyz", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteStartIndexOf_2_andEndIndexOf_6_returns_12bcx12312312yz() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.delete(2, 6);
        String value = modified.toString();
        assertEquals("12xyz456", value);
    }

    private static final String STRING_VALUE_OF_LENGTH_129 = "uwcwiavzhhigohtwixbrlxserzenalmzmkzwhrtewfzqpcvtsrnxkpdzcqsvpnqsatxjftfkhrdagqqunffpezghcpkuhlwrttdduhwgvpoqsksfojgtkgtkxkyzvbykl";

}