public interface StringBuilderInterface {

    /**
     * Add boolean String to CustomStringBuilder.
     * @param b - boolean to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(boolean b);

    /**
     * Add character to CustomStringBuilder.
     * @param c - character to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(char c);

    /**
     * Add String from String[] to CustomStringBuilder.
     * @param str - string[] to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(char[] str);

    /**
     * Add String from String[] to CustomStringBuilder.
     * @param str - string[] to be appended to CustomStringBuilder.
     * @param offset- integer offset of which to cretae substring from to append to CustomStringBuilder.
     * @param len- integer offset of which to cretae substring from to append to CustomStringBuilder.
     * @throws IndexOutOfBoundsException - on offset less than 0.
     * @throws IndexOutOfBoundsException - if length less than 0.
     * @throws IndexOutOfBoundsException - if offset + len bigger than length().
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(char[] str, int offset, int len);

    /**
     * Add String from CharSequence to CustomStringBuilder.
     * @param charSequence - CharSequence to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(CharSequence charSequence);

    /**
     * Add String from CharSeqience to CustomStringBuilder.
     * @param charSequence - CharSequence to be appended to CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if start is negative.
     * @throws IndexOutOfBoundsException - if start is size.
     * @throws IndexOutOfBoundsException - if start is greater than end.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(CharSequence charSequence, int start, int end);

    /**
     * Add integer to CustomStringBuilder.
     * @param i - integer to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(int i);

    /**
     * Add long to CustomStringBuilder.
     * @param lng - long to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(long lng);

    /**
     * Add double to CustomStringBuilder.
     * @param d - double to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(double d);

    /**
     * Add float to CustomStringBuilder.
     * @param f - float to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(float f);

    /**
     * Add String to CustomStringBuilder.
     * @param str - String to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    CustomStringBuilder append(String str);

    /**
     * Delete range of string from CustomStringBuilder.
     * @param start - index to remove from.
     * @param end - index to remove to.
     * @throws StringIndexOutOfBoundsException if start < 0.
     * @throws StringIndexOutOfBoundsException if start > size.
     * @throws StringIndexOutOfBoundsException if start is larger than end.
     * @return CustomStringBuilder
     */
    CustomStringBuilder delete(int start, int end);

    /**
     * Delete character from CustomStringBuilder at index.
     * @param index - index to remove character from.
     * @throws StringIndexOutOfBoundsException if index < 0.
     * @throws StringIndexOutOfBoundsException if index > size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder deleteCharAt(int index);

    /**
     * Get index of string in CustomStringBuilder.
     * @param str - String to be find index of.
     * @return index of string if present else -1
     */
    int indexOf(String str);

    /**
     * Get index of string in CustomStringBuilder from a given Index.
     * @param str - String to be find index of.
     * @param fromIndex - index to search for String from.
     * @return index of string if present else -1
     */
    int indexOf(String str, int fromIndex);

    /**
     * Get last index of string in CustomStringBuilder.
     * @param str - String to be find last index of.
     * @return last index of string if present else -1
     */
    int lastIndexOf(String str);

    /**
     * Insert String from char array into CustomStringBuilder.
     * @param index - int index to insert to substring of char[] str to.
     * @param str - char[] array of String to be inserted.
     * @param offset - index to insert into CustomStringBuilder.
     * @param len - last index of char array to insert.
     * @throws StringIndexOutOfBoundsException - if offset less than 0.
     * @throws StringIndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int index, char[] str, int offset, int len);

    /**
     * Insert character into string at given Index.
     * @param dstOffset - index to insert character into.
     * @param s - CharSequence to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int dstOffset, CharSequence s);

    /**
     * Insert sub CharSequence at given index.
     * @param dstOffset - index to insert character into.
     * @param s - CharSequence to insert into CustomStringBuilder.
     * @param start - start index of CharSequence to insert.
     * @param end - end index of CharSequence to insert.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int dstOffset, CharSequence s, int start, int end);

    /**
     * Insert boolean into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param b - boolean to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, boolean b);

    /**
     * Insert char into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param c - char to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, char c);

    /**
     * Insert double into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param d - boolean to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, double d);

    /**
     * Insert boolean into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param f - float to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, float f);

    /**
     * Insert integer into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param i - integer to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, int i);

    /**
     * Insert long into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param l - long to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, long l);

    /**
     * Insert Object into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param obj - Object to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, Object obj);

    /**
     * Insert String into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param str - String to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, String str);

    /**
     * Insert char[] array into CustomStringBuilder.
     * @param offset - index to insert character into.
     * @param str - char[] array to insert into CustomStringBuilder.
     * @throws IndexOutOfBoundsException - if offset greater than CustomStringBuilder size.
     * @return CustomStringBuilder
     */
    CustomStringBuilder insert(int offset, char[] str);

    /**
     * Get the length of CustomStringBuilder.
     * @return length of CustomerStringBuilder
     */
    int length();

    /**
     * Replace range of String in CustomStringBuilder with new String.
     * @param start - start index to begin replacement.
     * @param end - end index to end replacement.
     * @param str - string to replace range.
     * @throws StringIndexOutOfBoundsException if start < 0.
     * @throws StringIndexOutOfBoundsException if start > size.
     * @throws StringIndexOutOfBoundsException if start > end.
     * @return CustomStringBuilder
     */
    CustomStringBuilder replace(int start, int end, String str);

    /**
     * Get String builder in reverse order.
     * @return CustomStringBuilder
     */
    CustomStringBuilder reverse();

    /**
     * Set char at Index to new char.
     * @param index - index of char to set.
     * @param c - character to set index to.
     * @throws StringIndexOutOfBoundsException if index < 0.
     * @throws StringIndexOutOfBoundsException if index > size.
     */
    void setCharAt(int index, char c);

    /**
     * Get CharSubsequence from CustomStringBuilder.
     * @param start - index to get CharSubSequence from.
     * @param end - - index to get CharSubSequence to.
     * @throws StringIndexOutOfBoundsException if start < 0.
     * @throws StringIndexOutOfBoundsException if start > size.
     * @return CharSubsequence of CustomStringBuilder range
     */
    CharSequence subSequence(int start, int end);

    /**
     * Get substring from CustomStringBuilder.
     * @param start - start index to get subString from.
     * @throws StringIndexOutOfBoundsException if start < 0.
     * @throws StringIndexOutOfBoundsException if start > size.
     * @return String of subString
     */
    String subString(int start);

    /**
     * Get substring from CustomStringBuilder.
     * @param start - start index to get subString from.
     * @param end - end index to get subString from.
     * @throws StringIndexOutOfBoundsException if start < 0.
     * @throws StringIndexOutOfBoundsException if start > size.
     * @throws StringIndexOutOfBoundsException if start > end.
     * @return String of subString
     */
    String subString(int start, int end);

    /**
     * Get String representation of CustomStringBuilder.
     * @return String representation of CustomStringBuilder
     */
    String toString();
}
