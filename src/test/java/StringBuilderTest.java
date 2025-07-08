import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringBuilderTest {

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
        assertEquals("123abc8", stringValue);
        assertEquals(7, appended.length());
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

    @Test
    public void givenStringBuilderWithValueOf_123abc_onDeletingWithStartAndEndIndexOf5_returnsUnchangedStringOf_123abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.delete(5, 5);
        String stringValue = modified.toString();
        assertEquals("123abc", stringValue);
    }

    @Test
    public void givenStringBuilderWithValueOf_123abc_onDeletingWithStartIndexOf_2_AndEndIndexOf_4_returnStringOf_12bc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.delete(2, 4);
        String stringValue = modified.toString();
        assertEquals("12bc", stringValue);
    }

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
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteStartIndexOf_2_andEndIndexOf_6_returns_12bcx12xyz456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.delete(2, 6);
        String value = modified.toString();
        assertEquals("12xyz456", value);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onDeleteCharAt_negative_1_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.deleteCharAt(-1));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onDeleteCharAt_10_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.deleteCharAt(10));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onDeleteCharAt_0_returns_23abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(0);
        String value = modified.toString();
        assertEquals("23abc", value);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onDeleteCharAt_1_returns_13abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(1);
        String value = modified.toString();
        assertEquals("13abc", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteCharAtIndexOf_3_returns_123bcxy456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(3);
        String value = modified.toString();
        assertEquals("123bcxyz456", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteCharAtIndexOf_4_returns_123acxy456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(4);
        String value = modified.toString();
        assertEquals("123acxyz456", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteCharAtIndexOf_5_returns_123abxy456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(5);
        String value = modified.toString();
        assertEquals("123abxyz456", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteCharAtIndexOf_6_returns_123abcyz456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(6);
        String value = modified.toString();
        assertEquals("123abcyz456", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteCharAtIndexOf_10_returns_123abcxyz46() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(10);
        String value = modified.toString();
        assertEquals("123abcxyz46", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onDeleteCharAtIndexOf_11_returns_123abcxyz45() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.deleteCharAt(11);
        String value = modified.toString();
        assertEquals("123abcxyz45", value);
    }

    @Test
    public void givenStringBuilder_withValues_123abcxyz_onReplace_withNegativeStartIndex_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abcxyz");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.replace(-1, 2, ""));
    }

    @Test
    public void givenStringBuilder_withValues_123abcxyz_onReplace_withStartIndexLargerThanEndIndex_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abcxyz");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.replace(5, 1, ""));
    }

    @Test
    public void givenStringBuilder_withValues_123abcxyz_onReplace_withStartIndexLargerLengthOfString_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abcxyz");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.replace(15, 100, ""));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReplaceRange_1_to_2_with_XX_returns_1XXabc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.replace(1, 2, "XX");
        String value = modified.toString();
        assertEquals("1XX3abc", value);
        assertEquals(7, customStringBuilder.length());
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReplaceRange_1_to_2_with_X_returns_13Xabc_andLengthOf_6() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.replace(1, 2, "X");
        String value = modified.toString();
        assertEquals("1X3abc", value);
        assertEquals(6, customStringBuilder.length());
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReplaceRange_1_to_3_with_XX_returns_1XXabc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.replace(1, 3, "XX");
        String value = modified.toString();
        assertEquals("1XXabc", value);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReplaceRange_2_to_4_with_XX_returns_12XXbc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        CustomStringBuilder modified = customStringBuilder.replace(2, 4, "XX");
        String value = modified.toString();
        assertEquals("12XXbc", value);
        assertEquals(6, customStringBuilder.length());
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReplaceRange_1_to_3_with_XX_returns_1XXbc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.replace(1, 4, "XX");
        String value = modified.toString();
        assertEquals("1XXbc", value);
        assertEquals(5, customStringBuilder.length());
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReplaceRange_1_to_6_with_XX_returns_1XX() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.replace(1, 6, "XX");
        String value = modified.toString();
        assertEquals("1XX", value);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReplaceRange_1_to_7_with_XX_returns_1XX() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder modified = customStringBuilder.replace(1, 7, "XX");
        String value = modified.toString();
        assertEquals("1XX", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onReplaceStartIndexOf_2_andEndIndexOf_4_with_XX_returns_12XXbcxyz() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        CustomStringBuilder modified = customStringBuilder.replace(2, 4, "XX");
        String value = modified.toString();
        assertEquals("12XXbcxyz", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onReplaceStartIndexOf_2_andEndIndexOf_6_with_X_returns_112Xxyz456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.replace(2, 6, "X");
        String value = modified.toString();
        assertEquals("12Xxyz456", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onReplaceStartIndexOf_2_andEndIndexOf_7_with_X_returns_12Xyz456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.replace(2, 7, "X");
        String value = modified.toString();
        assertEquals("12Xxyz456", value);
    }

    @Test
    public void givenStringBuilder_withValues_123_abc_xyz_appended_onReplaceStartIndexOf_10_andEndIndexOf_14_with_X_returns_123abcxyz4X() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder modified = customStringBuilder.replace(10, 14, "X");
        String value = modified.toString();
        assertEquals("123abcxyz4X", value);
        assertEquals(11, customStringBuilder.length());
    }


    @Test
    public void givenStringBuilder_withNoValues_onReverse_returns_emptyString() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        CustomStringBuilder reversed = customStringBuilder.reverse();
        assertEquals("", reversed.toString());
    }

    @Test
    public void givenStringBuilder_withValues_123_onReverse_returns_321() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        CustomStringBuilder reversed = customStringBuilder.reverse();
        assertEquals("321", reversed.toString());
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onReverse_returns_cba321() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CustomStringBuilder reversed = customStringBuilder.reverse();
        assertEquals("cba321", reversed.toString());
    }

    @Test
    public void givenStringBuilder_withTwoAppendsOf_123_and_abc_returns_cba321() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append("123");
        customStringBuilder.append("abc");
        CustomStringBuilder reversed = customStringBuilder.reverse();
        assertEquals("cba321", reversed.toString());
    }

    @Test
    public void givenStringBuilder_withValues_withAppendsOf_123_abc_xyz_456_onReverse_returns_654zyxcba321() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        CustomStringBuilder reversed = customStringBuilder.reverse();
        assertEquals("654zyxcba321", reversed.toString());
    }

    @Test
    public void givenStringBuilder_withValues_123abcxyz_onSetCharAt_withNegativeStartIndex_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abcxyz");
        assertThrows(IndexOutOfBoundsException.class, () -> customStringBuilder.setCharAt(-1, 'X'));
    }

    @Test
    public void givenStringBuilder_withValues_123abcxyz_onSetCharAt_withIndexLargerThanStringLength_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abcxyz");
        assertThrows(IndexOutOfBoundsException.class, () -> customStringBuilder.setCharAt(10, 'X'));
    }

    @Test
    public void givenStringBuilder_withValues_123abcxyz_onSetCharAtIndex_2_withX_returns_12Xabcxyz() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abcxyz");
        customStringBuilder.setCharAt(2, 'X');
        String modified = customStringBuilder.toString();
        assertEquals("12Xabcxyz", modified);
    }

    @Test
    public void givenStringBuilder_withValues_withAppendsOf_123_abc_xyz_456_onSetCharAt_5_t0_X_returns_123abXxyz456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("xyz");
        customStringBuilder.append("456");
        customStringBuilder.setCharAt(5, 'X');
        String modified = customStringBuilder.toString();
        assertEquals("123abXxyz456", modified);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndexof_negative_1_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.subString(-1));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndexLargerThanStringLengthOf_10_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.subString(10));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndex_1_returns_23abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String subString = customStringBuilder.subString(1);
        assertEquals("23abc", subString);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndex_2_returns_3abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String subString = customStringBuilder.subString(2);
        assertEquals("3abc", subString);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndex_5_returns_c() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String subString = customStringBuilder.subString(5);
        assertEquals("c", subString);
    }

    @Test
    public void givenStringBuilder_withTwoValuesAppendedOf_123_abc_onSubString_withIndex_3_returns_abc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String subString = customStringBuilder.subString(3);
        assertEquals("abc", subString);
    }

    @Test
    public void givenStringBuilder_withTwoValuesAppendedOf_123_abc_onSubString_withIndex_4_returns_bc() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        String subString = customStringBuilder.subString(4);
        assertEquals("bc", subString);
    }

    @Test
    public void givenStringBuilder_withThreeValuesAppendedOf_123_abc_456_onSubString_withIndex_4_returns_bc456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("456");

        String subString = customStringBuilder.subString(4);
        assertEquals("bc456", subString);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onSubString_withIndex_4_returns_bc4567890() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        String subString = customStringBuilder.subString(4);
        assertEquals("bc4567890", subString);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_45678_90_onSubString_withIndex_4_returns_bc4567890() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123");
        customStringBuilder.append("abc");
        customStringBuilder.append("45678");
        customStringBuilder.append("90");
        String subString = customStringBuilder.subString(4);
        assertEquals("bc4567890", subString);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_45678_90_onSubString_withIndex_4_returns_bc45678890() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123456");
        customStringBuilder.append("abcxyz");
        customStringBuilder.append("45678!2");
        customStringBuilder.append("9088");
        String subString = customStringBuilder.subString(4);
        assertEquals("56abcxyz45678!29088", subString);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_1_2_3_a_b_c_4_5_6_withIndexOf_4_returns_bc456() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("1");
        customStringBuilder.append("2");
        customStringBuilder.append("3");
        customStringBuilder.append("a");
        customStringBuilder.append("b");
        customStringBuilder.append("c");
        customStringBuilder.append("4");
        customStringBuilder.append("5");
        customStringBuilder.append("6");
        String subString = customStringBuilder.subString(4);
        assertEquals("bc456", subString);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndexOf_negative_1_and_2_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.subString(-1, 2));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndexOf_3_and_endIndexOf_2_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.subString(3, 2));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndexof_1_and_endIndexOf_negative_1_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.subString(1, -1));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndexof_1_and_endIndexLargerThanStringSize_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.subString(1, 10));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_withIndexLargerThanStringLengthOf_10_andEndIndexOf_15throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.subString(10, 15));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_startIndexOf_1_onSubString_endIndexOf_3_returns_23() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String subString = customStringBuilder.subString(1, 3);
        assertEquals("23", subString);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubString_startIndexOf_2_onSubString_endIndexOf_3_returns_3() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        String subString = customStringBuilder.subString(2, 3);
        assertEquals("3", subString);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onSubString_startIndexOf_2_endIndexOf_8_returns_3abc45() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        String subString = customStringBuilder.subString(2, 8);
        assertEquals("3abc45", subString);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_1_2_3_a_b_c_4_5_6_onSubString_withStartIndexOf_4_andEndIndexOf_8_returns_bc45() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("1");
        customStringBuilder.append("2");
        customStringBuilder.append("3");
        customStringBuilder.append("a");
        customStringBuilder.append("b");
        customStringBuilder.append("c");
        customStringBuilder.append("4");
        customStringBuilder.append("5");
        customStringBuilder.append("6");
        String subString = customStringBuilder.subString(4, 8);
        assertEquals("bc45", subString);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubSequence_withIndexOf_negative_1_and_2_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(IndexOutOfBoundsException.class, () -> customStringBuilder.subSequence(-1, 2));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubSequence_withIndexOf_3_and_endIndexOf_2_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(IndexOutOfBoundsException.class, () -> customStringBuilder.subSequence(3, 2));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubSequence_withIndexof_1_and_endIndexOf_negative_1_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(IndexOutOfBoundsException.class, () -> customStringBuilder.subSequence(1, -1));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubSequence_withIndexof_1_and_endIndexLargerThanStringSize_throws_IndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(IndexOutOfBoundsException.class, () -> customStringBuilder.subSequence(1, 10));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubSequence_withIndexLargerThanStringLengthOf_10_andEndIndexOf_15throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        assertThrows(IndexOutOfBoundsException.class, () -> customStringBuilder.subSequence(10, 15));
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubSequence_startIndexOf_1_endIndexOf_3_returns_23() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CharSequence subSequence = customStringBuilder.subSequence(1, 3);
        assertEquals("23", subSequence);
    }

    @Test
    public void givenStringBuilder_withValues_123abc_onSubSequence_startIndexOf_2_endIndexOf_3_returns_3() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        CharSequence subSequence = customStringBuilder.subSequence(2, 3);
        assertEquals("3", subSequence);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_subSequence_startIndexOf_2_endIndexOf_8_returns_3abc4() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        CharSequence subString = customStringBuilder.subSequence(2, 8);
        assertEquals("3abc45", subString);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_1_2_3_a_b_c_4_5_6_subSequence_withStartIndexOf_4_andEndIndexOf_8_returns_bc45() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("1");
        customStringBuilder.append("2");
        customStringBuilder.append("3");
        customStringBuilder.append("a");
        customStringBuilder.append("b");
        customStringBuilder.append("c");
        customStringBuilder.append("4");
        customStringBuilder.append("5");
        customStringBuilder.append("6");
        CharSequence subString = customStringBuilder.subSequence(4, 8);
        assertEquals("bc45", subString);
    }

    @Test
    public void givenStringBuilder_withNoValues_onIndexOf_A_returns_negative_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        assertEquals(-1, customStringBuilder.indexOf("A"));
    }

    @Test
    public void givenStringBuilder_withValue_A_onIndexOf_B_returns_negative_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("A");
        assertEquals(-1, customStringBuilder.indexOf("B"));
    }

    @Test
    public void givenStringBuilder_withValue_A_onIndexOf_A_returns_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("A");
        assertEquals(0, customStringBuilder.indexOf("A"));
    }

    @Test
    public void givenStringBuilder_withValues_abc123_onIndexOf_c_returns_2() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("abc123");
        assertEquals(2, customStringBuilder.indexOf("c"));
    }

    @Test
    public void givenStringBuilder_withValues_abc123_onIndexOf_3_returns_4() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("abc123");
        assertEquals(5, customStringBuilder.indexOf("3"));
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_2_returns_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("2");
        assertEquals(1, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_c_returns_5() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("c");
        assertEquals(5, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_5_returns_7() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("5");
        assertEquals(7, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_7_returns_9() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("7");
        assertEquals(9, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_0_returns_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("0");
        assertEquals(12, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_bc4_returns_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("bc4");
        assertEquals(4, strIndex);
    }

    @Test
    public void givenStringBuilder_withValue_A_onIndexOf_B_withStartIndexOf_negative_1_returns_negative_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("A");
        assertEquals(-1, customStringBuilder.indexOf("B", 1));
    }

    @Test
    public void givenStringBuilder_withNoValues_onIndexOf_A_withStartIndexOf_0_returns_negative_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        assertEquals(-1, customStringBuilder.indexOf("A", 1));
    }

    @Test
    public void givenStringBuilder_withValue_A_onIndexOf_B_withStartIndexOf_0_returns_negative_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("A");
        assertEquals(-1, customStringBuilder.indexOf("B", 0));
    }

    @Test
    public void givenStringBuilder_withValue_A_onIndexOf_B_withStartIndexOf_1_returns_negative_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("A");
        assertEquals(-1, customStringBuilder.indexOf("B", 1));
    }

    @Test
    public void givenStringBuilder_withValue_A_onIndexOf_A_fromIndexOf_0_returns_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("A");
        assertEquals(0, customStringBuilder.indexOf("A", 0));
    }

    @Test
    public void givenStringBuilder_withValue_ABB_onIndexOf_A_fromIndexOf_1_returns_2() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABA");
        assertEquals(2, customStringBuilder.indexOf("A", 1));
    }

    @Test
    public void givenStringBuilder_withValue_ABAB_onIndexOf_B_fromIndexOf_2_returns_3() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABAB");
        assertEquals(3, customStringBuilder.indexOf("B", 2));
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_0_fromIndex_0_returns_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("0", 0);
        assertEquals(12, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_456_fromIndex_2_returns_6() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("0", 0);
        assertEquals(12, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onIndexOf_789_fromIndex_2_returns_9() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("789", 2);
        assertEquals(9, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_7890_onIndexOf_890_fromIndex_2_returns_10() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.indexOf("890", 9);
        assertEquals(10, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_7890_abc_onIndexOf_abc_fromIndex_5_returns_13() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        customStringBuilder.append("abc");
        int strIndex = customStringBuilder.indexOf("abc", 5);
        assertEquals(13, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_7890_abc_onIndexOf_0ab_fromIndex_5_returns_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        customStringBuilder.append("abc");
        int strIndex = customStringBuilder.indexOf("0ab", 5);
        assertEquals(12, strIndex);
    }

    @Test
    public void givenStringBuilder_withNo_withLastIndexOf_A_returns_negative_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        int strIndex = customStringBuilder.lastIndexOf("A");
        assertEquals(-1, strIndex);
    }

    @Test
    public void givenStringBuilder_withValueOf_A_withLastIndexOf_A_returns_0() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("A");
        int strIndex = customStringBuilder.lastIndexOf("A");
        assertEquals(0, strIndex);
    }

    @Test
    public void givenStringBuilder_withValueOf_ABA_withLastIndexOf_A_returns_2() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABA");
        int strIndex = customStringBuilder.lastIndexOf("A");
        assertEquals(2, strIndex);
    }

    @Test
    public void givenStringBuilder_withValueOf_ABA_withLastIndexOf_B_returns_1() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABA");
        int strIndex = customStringBuilder.lastIndexOf("A");
        assertEquals(2, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onLastIndexOf_0_returns_12() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.lastIndexOf("0");
        assertEquals(12, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onLastIndexOf_456_returns_7() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.lastIndexOf("456");
        assertEquals(6, strIndex);
    }

    @Test
    public void givenStringBuilder_withFourValuesAppendedOf_123_abc_456_78_90_onLastIndexOf_c45_returns_6() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("123abc");
        customStringBuilder.append("456");
        customStringBuilder.append("7890");
        int strIndex = customStringBuilder.lastIndexOf("c45");
        assertEquals(5, strIndex);
    }

    @Test
    public void givenStringBuilder_withValues_ABCDEFGHI_and_JKLMNOPQ_onDelete_0_1_returns_BCDEFGHIJKLMNOPQ() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABCDEFGHI");
        customStringBuilder.append("JKLMNOPQ");
        CustomStringBuilder result = customStringBuilder.delete(0, 1);
        String str = result.toString();
        assertEquals("BCDEFGHIJKLMNOPQ", str);
    }

    @Test
    public void givenStringBuilder_withValues_ABCDEFGHI_and_JKLMNOPQ_onDelete_0_2_returns_CDEFGHIJKLMNOPQ() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABCDEFGHI");
        customStringBuilder.append("JKLMNOPQ");
        CustomStringBuilder result = customStringBuilder.delete(0, 2);
        String str = result.toString();
        assertEquals("CDEFGHIJKLMNOPQ", str);
    }

    @Test
    public void givenStringBuilder_withValues_ABCDEFGHI_and_JKLMNOPQ_onDelete_0_3_returns_CDEFGHIJKLMNOPQ() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABCDEFGHI");
        customStringBuilder.append("JKLMNOPQ");
        CustomStringBuilder result = customStringBuilder.delete(0, 3);
        String str = result.toString();
        assertEquals("DEFGHIJKLMNOPQ", str);
    }

    @Test
    public void givenStringBuilder_withValues_ABCDEFGHI_and_JKLMNOPQ_onDelete_1_2_returns_ACDEFGHIJKLMNOPQ() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABCDEFGHI");
        customStringBuilder.append("JKLMNOPQ");
        CustomStringBuilder result = customStringBuilder.delete(1, 2);
        String str = result.toString();
        assertEquals("ACDEFGHIJKLMNOPQ", str);
    }

    @Test
    public void givenStringBuilder_withValues_ABCDEFGHI_and_JKLMNOPQ_onDelete_1_3_returns_ADEFGHIJKLMNOPQ() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABCDEFGHI");
        customStringBuilder.append("JKLMNOPQ");
        CustomStringBuilder result = customStringBuilder.delete(1, 3);
        String str = result.toString();
        assertEquals("ADEFGHIJKLMNOPQ", str);
    }

    @Test
    public void givenStringBuilder_withValues_ABCDEFGHI_and_JKLMNOPQ_onDelete_8_9_returns_ABCDEFGHJKLMNOPQ() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABCDEFGHI");
        customStringBuilder.append("JKLMNOPQ");
        CustomStringBuilder result = customStringBuilder.delete(8, 9);
        String str = result.toString();
        assertEquals("ABCDEFGHJKLMNOPQ", str);
    }

    @Test
    public void givenStringBuilder_withValues_ABCDEFGHI_and_JKLMNOPQ_onDelete_8_10_returns_ABCDEFGHKLMNOPQ() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABCDEFGHI");
        customStringBuilder.append("JKLMNOPQ");
        CustomStringBuilder result = customStringBuilder.delete(8, 10);
        String str = result.toString();
        assertEquals("ABCDEFGHKLMNOPQ", str);
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingAStringOf_D_AtIndex_negative_1_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.insert(-1, "D"));
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingAStringOf_D_AtIndex_negative_4_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.insert(4, "D"));
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingAStringOf_D_AtIndex_3_returns_ABCD() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(3, "D");
        String str = result.toString();
        assertEquals("ABCD", str);
        assertEquals(4, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingAStringOf_D_AtIndex_0_returns_DABC() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(0, "D");
        String str = result.toString();
        assertEquals("DABC", str);
        assertEquals(4, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingAStringOf_D_AtIndex_1_returns_ADBC() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(1, "D");
        String str = result.toString();
        assertEquals("ADBC", str);
        assertEquals(4, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingAStringOf_TEST_AtIndex_3_returns_ABCTESTDEFGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(3, "TEST");
        String str = result.toString();
        assertEquals("ABCTESTDEFGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingAStringOf_TEST_AtIndex_4_returns_ABCDTESTEFGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(4, "TEST");
        String str = result.toString();
        assertEquals("ABCDTESTEFGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingAStringOf_TEST_AtIndex_6_returns_ABCDEFTESTGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(6, "TEST");
        String str = result.toString();
        assertEquals("ABCDEFTESTGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingAStringOf_TEST_AtIndex_7_returns_ABCDEFGTESTHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(7, "TEST");
        String str = result.toString();
        assertEquals("ABCDEFGTESTHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingAStringOf_TEST_AtIndex_9_returns_ABCDEFGHITEST() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(9, "TEST");
        String str = result.toString();
        assertEquals("ABCDEFGHITEST", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingABoolean_True_AtIndex_negative_1_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.insert(-1, true));
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingABoolean_True_AtIndex_negative_4_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.insert(4, true));
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingABoolean_True_AtIndex_3_returns_ABCD() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(3, true);
        String str = result.toString();
        assertEquals("ABCtrue", str);
        assertEquals(7, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingABoolean_True_AtIndex_0_returns_trueABC() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(0, true);
        String str = result.toString();
        assertEquals("trueABC", str);
        assertEquals(7, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingABoolean_True_AtIndex_1_returns_AtrueBC() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(1, true);
        String str = result.toString();
        assertEquals("AtrueBC", str);
        assertEquals(7, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingABoolean_True_AtIndex_3_returns_ABCtrueDEFGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(3, true);
        String str = result.toString();
        assertEquals("ABCtrueDEFGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingABoolean_True_AtIndex_4_returns_ABCDtrueEFGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(4, true);
        String str = result.toString();
        assertEquals("ABCDtrueEFGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_oonInsertingABoolean_True_AtIndex_6_returns_ABCDEFtrueGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(6, true);
        String str = result.toString();
        assertEquals("ABCDEFtrueGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingABoolean_True_AtIndex_7_returns_ABCDEFGtrueHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(7, true);
        String str = result.toString();
        assertEquals("ABCDEFGtrueHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingABoolean_True_AtIndex_9_returns_ABCDEFGHItrue() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(9, true);
        String str = result.toString();
        assertEquals("ABCDEFGHItrue", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingACharOf_X_AtIndex_negative_1_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.insert(-1, 'X'));
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingACharOf_X_AtIndex_negative_4_throws_StringIndexOutOfBoundsException() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        assertThrows(StringIndexOutOfBoundsException.class, () -> customStringBuilder.insert(4, 'X'));
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingACharOf_X_AtIndex_3_returns_ABCX() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(3, 'X');
        String str = result.toString();
        assertEquals("ABCX", str);
        assertEquals(4, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingACharOf_X_AtIndex_0_returns_XABC() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(0, 'X');
        String str = result.toString();
        assertEquals("XABC", str);
        assertEquals(4, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_onInsertingACharOf_X_AtIndex_1_returns_AXBC() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        CustomStringBuilder result = customStringBuilder.insert(1, 'X');
        String str = result.toString();
        assertEquals("AXBC", str);
        assertEquals(4, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingABoolean_True_AtIndex_3_returns_ABCXDEFGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(3, 'X');
        String str = result.toString();
        assertEquals("ABCXDEFGHI", str);
        assertEquals(10, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingCharOf_X_AtIndex_4_returns_ABCDXEFGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(4, 'X');
        String str = result.toString();
        assertEquals("ABCDXEFGHI", str);
        assertEquals(10, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingCharOf_X_AtIndex_6_returns_ABCDEFXGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(6, 'X');
        String str = result.toString();
        assertEquals("ABCDEFXGHI", str);
        assertEquals(10, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingCharOf_X_AtIndex_7_returns_ABCDEFGXHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(7, 'X');
        String str = result.toString();
        assertEquals("ABCDEFGXHI", str);
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingCharOf_X_AtIndex_9_returns_ABCDEFGHIX() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(9, 'X');
        String str = result.toString();
        assertEquals("ABCDEFGHIX", str);
        assertEquals(10, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingACharArrayOf_T_E_S_T_AtIndex_6_returns_ABCDEFTESTGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(6, new char[] {'T', 'E', 'S', 'T'});
        String str = result.toString();
        assertEquals("ABCDEFTESTGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingACharArrayOf_T_E_S_T_AtIndex_7_returns_ABCDEFGTESTHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(7, new char[] {'T', 'E', 'S', 'T'});
        String str = result.toString();
        assertEquals("ABCDEFGTESTHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingACharArrayOf_T_E_S_T_AtIndex_9_returns_ABCDEFGHITEST() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(9, new char[] {'T', 'E', 'S', 'T'});
        String str = result.toString();
        assertEquals("ABCDEFGHITEST", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingACharSequenceOfTEST_AtIndex_6_returns_ABCDEFTESTGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CharSequence charSequence = "TEST";
        CustomStringBuilder result = customStringBuilder.insert(6, charSequence);
        String str = result.toString();
        assertEquals("ABCDEFTESTGHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingACharSequenceOfTEST_AtIndex_7_returns_ABCDEFGTESTHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CharSequence charSequence = "TEST";
        CustomStringBuilder result = customStringBuilder.insert(7, charSequence);
        String str = result.toString();
        assertEquals("ABCDEFGTESTHI", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingACharSequenceOfTEST_AtIndex_9_returns_ABCDEFGHITEST() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CharSequence charSequence = "TEST";

        CustomStringBuilder result = customStringBuilder.insert(9, charSequence);
        String str = result.toString();
        assertEquals("ABCDEFGHITEST", str);
        assertEquals(13, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingADoubleValueOF_666_AtIndex_6_returns_ABCDEF666GHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        double d = 666;
        CustomStringBuilder result = customStringBuilder.insert(6, d);
        String str = result.toString();
        assertEquals("ABCDEF666.0GHI", str);
        assertEquals(14, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingADoubleValueOF_666_AtIndex_7_returns_ABCDEFG666HI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        double d = 666;
        CustomStringBuilder result = customStringBuilder.insert(7, d);
        String str = result.toString();
        assertEquals("ABCDEFG666.0HI", str);
        assertEquals(14, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingADoubleValueOF_666_returns_ABCDEFGHI666() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        double d = 666;
        CustomStringBuilder result = customStringBuilder.insert(9, d);
        String str = result.toString();
        assertEquals("ABCDEFGHI666.0", str);
        assertEquals(14, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingFloatValueOF_pi_AtIndex_6_returns_ABCDEF2point14159GHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        float pi = 3.14159f;
        CustomStringBuilder result = customStringBuilder.insert(6, pi);
        String str = result.toString();
        assertEquals("ABCDEF3.14159GHI", str);
        assertEquals(16, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingFloatValueOF_pi_AtIndex_7_returns_ABCDEF2point14159GHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        float pi = 3.14159f;
        CustomStringBuilder result = customStringBuilder.insert(7, pi);
        String str = result.toString();
        assertEquals("ABCDEFG3.14159HI", str);
        assertEquals(16, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingFloatValueOF_pi_returns_ABCDEF2point14159GHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        float pi = 3.14159f;
        CustomStringBuilder result = customStringBuilder.insert(9, pi);
        String str = result.toString();
        assertEquals("ABCDEFGHI3.14159", str);
        assertEquals(16, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingIntValueOF_666_AtIndex_6_returns_ABCDEF2point666GHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        int i = 666;
        CustomStringBuilder result = customStringBuilder.insert(6, i);
        String str = result.toString();
        assertEquals("ABCDEF666GHI", str);
        assertEquals(12, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingIntValueOF_666_AtIndex_7_returns_ABCDEFG666HI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        int i = 666;
        CustomStringBuilder result = customStringBuilder.insert(7, i);
        String str = result.toString();
        assertEquals("ABCDEFG666HI", str);
        assertEquals(12, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingIntValueOF_666_returns_ABCDEFGHI666() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        int i = 666;
        CustomStringBuilder result = customStringBuilder.insert(9, i);
        String str = result.toString();
        assertEquals("ABCDEFGHI666", str);
        assertEquals(12, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingLongValueOF_666_AtIndex_6_returns_ABCDEF2point666GHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        long l = 666;
        CustomStringBuilder result = customStringBuilder.insert(6, l);
        String str = result.toString();
        assertEquals("ABCDEF666GHI", str);
        assertEquals(12, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingLongValueOF_666_AtIndex_7_returns_ABCDEFG666HI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        long l = 666;
        CustomStringBuilder result = customStringBuilder.insert(7, l);
        String str = result.toString();
        assertEquals("ABCDEFG666HI", str);
        assertEquals(12, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInsertingLongValueOF_666_returns_ABCDEFGHI666() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        long l = 666;
        CustomStringBuilder result = customStringBuilder.insert(9, l);
        String str = result.toString();
        assertEquals("ABCDEFGHI666", str);
        assertEquals(12, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInserting_TestObject_AtIndex_6_returns_ABCDEF_TESTOBJECTASSTRING_GHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(6, new TestObject());
        String str = result.toString();
        assertEquals("ABCDEFTestObject{x=0, y=1, z=2}GHI", str);
        assertEquals(34, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInserting_TestObject_AtIndex_7_returns_ABCDEFG_TESTOBJECTASSTRING_HI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(7, new TestObject());
        String str = result.toString();
        assertEquals("ABCDEFGTestObject{x=0, y=1, z=2}HI", str);
        assertEquals(34, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInserting_TestObject_returns_ABCDEFGHI_TESTOBJECTASSTRING_() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CustomStringBuilder result = customStringBuilder.insert(9, new TestObject());
        String str = result.toString();
        assertEquals("ABCDEFGHITestObject{x=0, y=1, z=2}", str);
        assertEquals(34, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInserting_charArrayOf_J_K_L_atIndex_4_returns_ABCDEFKLGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        char[] insertChars = new char[] { 'J', 'K', 'L' };
        CustomStringBuilder result = customStringBuilder.insert(4,  insertChars, 1, 3);
        String str = result.toString();
        assertEquals("ABCDKLEFGHI", str);
        assertEquals(11, result.length());
    }

    @Test
    public void giveStringBuilder_withValues_ABC_DEF_GHI_onInserting_charSequence_OfLength_3_J_K_L_atIndex_4_ofLength_3_returns_ABCDEFKLGHI() {
        CustomStringBuilder customStringBuilder = new CustomStringBuilder("ABC");
        customStringBuilder.append("DEF");
        customStringBuilder.append("GHI");
        CharSequence charSequence = "JKL";
        CustomStringBuilder result = customStringBuilder.insert(4,  charSequence, 1, 3);
        String str = result.toString();
        assertEquals("ABCDKLEFGHI", str);
        assertEquals(11, result.length());
    }

    private static final String STRING_VALUE_OF_LENGTH_129 = "uwcwiavzhhigohtwixbrlxserzenalmzmkzwhrtewfzqpcvtsrnxkpdzcqsvpnqsatxjftfkhrdagqqunffpezghcpkuhlwrttdduhwgvpoqsksfojgtkgtkxkyzvbykl";

    private static class TestObject {
        int x = 0;
        int y = 1;
        int z = 2;

        @Override
        public String toString() {
            return "TestObject{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
        }
    }
}