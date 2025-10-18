
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the {@link StringBuilder}, using an {@link ArrayList}s
 * @author Benjamin Kane
 * @see <a href="https://www.linkedin.com/in/benjamin-kane-81149482/">LinkedIn</a>
 * @see <a href="https://github.com/bk10aao">GitHub account bk10aao</a>
 * @see <a href="https://github.com/bk10aao/CustomStringBuilder">Repository</a>
 */
public class CustomStringBuilder implements StringBuilderInterface {

    private final List<String> stringBuilder = new ArrayList<>();

    private int size = 0;

    /**
     * Constructs a string builder with no characters
     */
    public CustomStringBuilder() { }

    /**
     * Constructs a string builder that contains the same characters as the specified {@code CharSequence}.
     *
     * @param seq the sequence to copy.
     */
    public CustomStringBuilder(final CharSequence seq) {
        if(seq != null)
            append(seq);
    }

    /**
     * Constructs a string builder initialized to the contents of the specified string. .
     *
     * @param str the initial contents.
     */
    public CustomStringBuilder(final String str) {
        if(str != null)
            append(str);
    }

    /**
     * Appends boolean value to CustomStringBuilder
     *
     * @param b - boolean to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    public CustomStringBuilder append(final boolean b) {
        return append(String.valueOf(b));
    }

    /**
     * Appends character value to CustomStringBuilder
     * @param c - character to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    public CustomStringBuilder append(final char c) {
        return append(String.valueOf(c));
    }

    /**
     * Appends character value to CustomStringBuilder
     * @param str - character array to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     */
    public CustomStringBuilder append(final char[] str) {
        return append(new String(str));
    }

    /**
     * Appends the string representation of a sub array of the
     * {@code char} array argument to this sequence.
     * <p>
     * Characters of the {@code char} array {@code str}, starting at
     * index {@code offset}, are appended, in order, to the contents
     * of this sequence. The length of this sequence increases
     * by the value of {@code len}.
     * <p>
     * The overall effect is exactly as if the arguments were converted
     * to a string by the method {@link String#valueOf(char[],int,int)},
     * and the characters of that string were then
     * {@link #append(String) appended} to this character sequence.
     *
     * @param   str      the characters to be appended.
     * @param   offset   the index of the first {@code char} to append.
     * @param   len      the number of {@code char}s to append.
     * @return  a reference to this object.
     * @throws StringIndexOutOfBoundsException
     *         if {@code offset < 0} or {@code len < 0}
     *         or {@code offset+len > str.length}
     */
    public CustomStringBuilder append(final char[] str, final int offset, final int len) {
        if (offset < 0 || len < 0 || offset + len > str.length)
            throw new StringIndexOutOfBoundsException();
        return append(new String(str, offset, len));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param charSequence - Character Sequence to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException on null input;
     */
    public CustomStringBuilder append(final CharSequence charSequence) {
        return append(String.valueOf(charSequence));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param charSequence - Character Sequence to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *         if {@code offset < 0} or {@code len < 0}
     *         or {@code offset+len > str.length}
     * @throws NullPointerException on null input;
     */
    public CustomStringBuilder append(final CharSequence charSequence, final int start, final int end) {
        if (charSequence == null)
            throw new NullPointerException();
        if (start < 0 || end < start || end > charSequence.length())
            throw new StringIndexOutOfBoundsException();
        return append(charSequence.subSequence(start, end));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param d - double value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException on null input;
     */
    public CustomStringBuilder append(final double d) {
        return append(String.valueOf(d));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param f - float value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException on null input;
     */
    public CustomStringBuilder append(final float f) {
        return append(String.valueOf(f));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param i - integer value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException on null input;
     */
    public CustomStringBuilder append(final int i) {
        return append(String.valueOf(i));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param lng - long value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException on null input;
     */
    public CustomStringBuilder append(final long lng) {
        return append(String.valueOf(lng));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param str - String value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException on null input;
     */
    public CustomStringBuilder append(final String str) {
        if (str == null)
            throw new NullPointerException();
        stringBuilder.add(str);
        size += str.length();
        return this;
    }

    /**
     * Deletes range of characters in StringBuilder
     * @param start - Start index to begin deleting from.
     * @param  end - End index to delete to
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *         if {@code start < 0} or {@code end < 0}
     *         or {@code start > end} or {@code end > length()}
     */
    public CustomStringBuilder delete(final int start, final int end) {
        return replace(start, end, "");
    }

    /**
     * Deletes character at index
     * @param index - index to remove character from.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code index < 0} or {@code index > length()}
     */
    public CustomStringBuilder deleteCharAt(final int index) {
        if(index < 0 || index >= size)
            throw new StringIndexOutOfBoundsException();
        return replace(index, index + 1, "");
    }

    /**
     * Gets index of String in CustomStringBuilder
     * @param str - String to be find index of.
     * @return int index of String if present, else -1
     */
    public int indexOf(final String str) {
        return indexOf(str, 0);
    }

    /**
     * Gets index of String in CustomStringBuilder
     * @param str - String to be find index of.
     * @param fromIndex - index to begin searching for String
     * @return int index of String if present, else -1
     */
    public int indexOf(final String str, final int fromIndex) {
        return (fromIndex > size || fromIndex < 0 || size == 0) ? -1 : getIndex(str, fromIndex);
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param b - boolean to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final boolean b) {
        return insert(offset, String.valueOf(b));
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param c - character to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final char c) {
        return insert(offset, String.valueOf(c));
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param str - character array to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final char[] str) {
        return insert(offset, String.valueOf(str));
    }

    /**
     * Inserts String created from char[] into CustomStringBuilder at given offset
     * @param index - index to insert String into.
     * @param str - character array to insert into CustomStringBuilder.
     * @param offset - offset of char array to build string from.
     * @param len - length of String to be created from char[].
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int index, final char[] str, final int offset, final int len) {
        return insert(index, String.valueOf(str).substring(offset, len));
    }

    /**
     * insert String value 0f Character Sequence into CustomStringBuilder
     * @param dstOffset - index to insert character into.
     * @param s - CharSequence to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code dstOffset < 0} or {@code dstOffset > length()}
     */
    public CustomStringBuilder insert(final int dstOffset, final CharSequence s) {
        return insert(dstOffset, String.valueOf(s));
    }

    /**
     * Inserts String created from CharSequence into CustomStringBuilder at given offset
     * @param dstOffset - index to insert String into.
     * @param s - CharSequence to insert into CustomStringBuilder.
     * @param start - start of String from CharSequence.
     * @param end -  start of String from CharSequence.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code dstOffset < 0} or {@code dstOffset > length()}
     * @throws  IndexOutOfBoundsException
     *          if {@code start} or {@code end} are negative,
     *          if {@code end} is greater than {@code length()},
     *          or if {@code start} is greater than {@code end}
     */
    public CustomStringBuilder insert(final int dstOffset, final CharSequence s, final int start, final int end) {
        return insert(dstOffset, s.subSequence(start, end));
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param d - double value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final double d) {
        return insert(offset, String.valueOf(d));
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param f - float value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final float f) {
        return insert(offset, String.valueOf(f));
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param i - integer value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final int i) {
        return insert(offset, String.valueOf(i));
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param l - long value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final long l) {
        return insert(offset, String.valueOf(l));
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param obj - Object to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final Object obj) {
        return insert(offset, obj.toString());
    }

    /**
     * Inserts String into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param str - string value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *       if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final String str) {
        if(offset < 0 || offset > size)
            throw new StringIndexOutOfBoundsException();
        int idx = 0;
        int currentOffset = 0;
        while (idx < stringBuilder.size() && currentOffset + stringBuilder.get(idx).length() <= offset)
            currentOffset += stringBuilder.get(idx++).length();
        if (idx == stringBuilder.size())
            stringBuilder.add(str);
        else
            insertInner(offset, str, idx, currentOffset);
        size += str.length();
        return this;
    }

    /**
     * Returns the last index of String in CustomStringBuilder
     * @param str - String to be find last index of.
     * @return last index of String if present, else -1
     */
    public int lastIndexOf(final String str) {
        String built = "";
        for(int i = stringBuilder.size() - 1; i >= 0; i--) {
            built = stringBuilder.get(i) + built;
            if(built.lastIndexOf(str) != -1)
                return size - (built.length() - built.lastIndexOf(str));
        }
        return -1;
    }

    /**
     * Returns the length of CustomStringBuilder String
     * @return length of CustomStringBuilder String
     */
    public int length() {
        return size;
    }

    /**
     * Replaces range of characters in Custom String Builder with new String
     * @param start - start index to begin replacement.
     * @param end - end index to end replacement.
     * @param str - string to replace range.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code start} or {@code end} are negative,
     *          if {@code end} is greater than {@code length()},
     *          or if {@code start} is greater than {@code end}
     */
    public CustomStringBuilder replace(int start, int end, final String str) {
        if(start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        int idx = 0;
        while(start >= stringBuilder.get(idx).length()) {
            start -= stringBuilder.get(++idx).length();
            end -= stringBuilder.get(idx).length();
        }
        List<Integer> matchedRange = getMatchedRange(str, idx);
        String temp = "";
        for(int i : matchedRange)
            temp += stringBuilder.get(i);
        return replace(str, temp, start, end, matchedRange);
    }

    /**
     * Returns the reverse of String in CustomString Builder
     * @return CustomStringBuilder
     */
    public CustomStringBuilder reverse() {
        char[] buffer = toCharArray();
        int left = 0, right = size - 1;
        while (left < right) {
            char temp = buffer[left];
            buffer[left++] = buffer[right];
            buffer[right--] = temp;
        }
        return new CustomStringBuilder(new String(buffer));
    }

    /**
     * Sets char at given index with new character value
     * @param index - index of char to set.
     * @param c - character to set index to.
     * @throws StringIndexOutOfBoundsException
     *          if {@code index < 0}
     *          or {@code index > length()},
     */
    public void setCharAt(final int index, final char c) {
        if(index < 0 || index > size)
            throw new StringIndexOutOfBoundsException();
        replace(index, index + 1, String.valueOf(c));
    }

    /**
     * Returns CharSequence of subString in CustomStringBuilder
     * @param start - index to get CharSubSequence from.
     * @param end - - index to get CharSubSequence to.
     * @return CharSequence of characters in range
     * @throws StringIndexOutOfBoundsException
     *          if {@code start < 0}
     *          or {@code start > size}
     *          or {@code start > end}
     */
    public CharSequence subSequence(final int start, final int end) {
        return subString(start, end);
    }

    /**
     * Returns CharSequence of subString in CustomStringBuilder
     * @param start - start index to get subString from.
     * @return String
     * @throws StringIndexOutOfBoundsException
     *          if {@code start < 0}
     *          of {@code start > size}
     */
    public String subString(int start) {
        if(start < 0 || start > size)
            throw new StringIndexOutOfBoundsException();
        int idx = 0;
        while(start > stringBuilder.get(idx).length())
            start -= stringBuilder.get(++idx).length();
        String str = stringBuilder.get(idx++).substring(start);
        for(int i = idx; i < stringBuilder.size(); i++)
            str += stringBuilder.get(i);
        return str;
    }

    /**
     * Returns subString in CustomStringBuilder
     * @param start - index to get CharSubSequence from.
     * @param end - - index to get CharSubSequence to.
     * @return CharSequence of characters in range
     * @throws StringIndexOutOfBoundsException
     *          if {@code start < 0}
     *          or {@code start > size}
     *          or {@code start > end}
     */
    public String subString(int start, int end) {
        if(start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        if(start == end)
            return "";
        int idx = 0;
        while(start >= stringBuilder.get(idx).length()) {
            start -= stringBuilder.get(++idx).length();
            end -= stringBuilder.get(idx).length();
        }
        return getSubString(start, end, idx);
    }

    /**
     * Get CustomStringBuilder as String
     * @return String value of CustomStringBuilder's String
     */
    @Override
    public String toString() {
        return new String(toCharArray());
    }

    private Integer getIndex(final String str, final int fromIndex) {
        int idx = 0;
        int startIndex = fromIndex;
        while (startIndex > stringBuilder.get(idx).length())
            startIndex -= stringBuilder.get(idx++).length();
        String s = stringBuilder.get(idx).substring(startIndex);
        if(s.contains(str))
            return s.indexOf(str) + fromIndex;
        else
            for (int i = idx + 1; i < stringBuilder.size(); i++)
                if ((s += stringBuilder.get(i)).contains(str))
                    return s.indexOf(str) + fromIndex;
        return -1;
    }

    private List<Integer> getMatchedRange(final String str, final int index) {
        int idx = index;
        List<Integer> matchedIndexes = new ArrayList<>();
        matchedIndexes.add(idx);
        String update = stringBuilder.get(idx++);
        for(int i = idx; i < stringBuilder.size(); i++) {
            update += stringBuilder.get(i);
            matchedIndexes.add(i);
            if(update.length() >= str.length())
                break;
        }
        return matchedIndexes;
    }

    private String getSubString(int start, int end, int idx) {
        String str = stringBuilder.get(idx++).substring(start);
        while (idx < stringBuilder.size() && str.length() < end - start)
            str += stringBuilder.get(idx++);
        return str.substring(0, end - start);
    }

    private void insertInner(int offset, String str, int idx, int currentOffset) {
        String target = stringBuilder.get(idx);
        int splitPoint = offset - currentOffset;
        stringBuilder.set(idx, target.substring(0, splitPoint));
        stringBuilder.add(++idx, str);
        stringBuilder.add(++idx, target.substring(splitPoint));
    }

    private CustomStringBuilder replace(String str, String temp, int start, int end, List<Integer> matchedRange) {
        String newStr = temp.substring(0, start) + str;
        if(end <= temp.length())
            newStr += temp.substring(end);
        int insertIndex = matchedRange.getFirst();
        for(int i = 0; i <  matchedRange.size(); i++)
            size -= stringBuilder.remove(insertIndex).length();
        stringBuilder.add(insertIndex, newStr);
        size += newStr.length();
        return this;
    }

    private char[] toCharArray() {
        char[] buffer = new char[size];
        int offset = 0;
        for (String str : stringBuilder) {
            str.getChars(0, str.length(), buffer, offset);
            offset += str.length();
        }
        return buffer;
    }
}