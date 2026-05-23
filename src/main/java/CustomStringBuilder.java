
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An implementation of the {@link StringBuilder}, using an {@link ArrayList}s
 * @author Benjamin Kane
 * @see <a href="https://www.linkedin.com/in/benjamin-kane-81149482/">LinkedIn</a>
 * @see <a href="https://github.com/bk10aao">GitHub account bk10aao</a>
 * @see <a href="https://github.com/bk10aao/CustomStringBuilder">Repository</a>
 */
public class CustomStringBuilder implements Appendable, java.io.Serializable, Comparable<CustomStringBuilder>, CharSequence {

    private final List<String> stringBuilder = new ArrayList<>();

    private int size = 0;

    private static final String[] CHAR_CACHE = new String[256];

    static {
        for (int i = 0; i < 256; i++)
            CHAR_CACHE[i] = String.valueOf((char) i);
    }

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a string builder with no characters
     */
    public CustomStringBuilder() { }

    /**
     * Constructs a string builder that contains the same characters as the specified {@code CharSequence}.
     * @param seq the sequence to construct initial CustomStringBuilder String value.
     * @throws NullPointerException
     *         if {@code seq} is {@code null}
     */
    public CustomStringBuilder(final CharSequence seq) {
        Objects.requireNonNull(seq);
        append(seq);
    }

    /**
     * Constructs a string builder initialized to the contents of the specified string. .
     * @param str the initial contents.
     * @throws NullPointerException
     *         if {@code str} is {@code null}
     */
    public CustomStringBuilder(final String str) {
        Objects.requireNonNull(str);
        append(str);
    }

    /**
     * Appends boolean value to CustomStringBuilder
     * @param b - boolean to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *         if {@code b} is {@code null}
     */
    public CustomStringBuilder append(final boolean b) {
        return append(String.valueOf(b));
    }

    /**
     * Appends character value to CustomStringBuilder
     * @param c - character to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code c} is {@code null}
     */
    public CustomStringBuilder append(final char c) {
        if (c < 256)
            stringBuilder.add(CHAR_CACHE[c]);
        else
            stringBuilder.add(String.valueOf(c));
        size++;
        return this;
    }

    /**
     * Appends character value to CustomStringBuilder
     * @param str - character array to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code str} is {@code null}.
     */
    public CustomStringBuilder append(final char[] str) {
        Objects.requireNonNull(str);
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
     * @param str - the characters to be appended.
     * @param offset - the index of the first {@code char} to append.
     * @param len - the number of {@code char}s to append.
     * @return a reference to this object.
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code len < 0}
     *          or {@code offset+len > str.length}
     * @throws NullPointerException
     *          if {@code str} is {@code null}
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
     * @throws NullPointerException
     *         if {@code charSequence} is {@code null}
     */
    public CustomStringBuilder append(final CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        return append(String.valueOf(charSequence));
    }

    /**
     * Appends Character Sequence to CustomStringBuilder
     * @param charSequence - Character Sequence to be appended to CustomStringBuilder.
     * @param start - The start point to append message subset of {@code charSequence}.
     * @param end - The end point to append message subset of {@code charSequence}.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code len < 0}
     *          or {@code offset+len > str.length}
     * @throws NullPointerException
     *          if {@code charSequence} is {@code null}
     */
    public CustomStringBuilder append(final CharSequence charSequence, final int start, final int end) {
        Objects.requireNonNull(charSequence);
        if (start < 0 || end < start || end > charSequence.length())
            throw new StringIndexOutOfBoundsException();
        return append(charSequence.subSequence(start, end));
    }

    /**
     * Appends double value to CustomStringBuilder
     * @param d - double value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code d} is {@code null}
     */
    public CustomStringBuilder append(final double d) {
        return append(String.valueOf(d));
    }

    /**
     * Appends float value to CustomStringBuilder
     * @param f - float value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code f} is {@code null}
     */
    public CustomStringBuilder append(final float f) {
        return append(String.valueOf(f));
    }

    /**
     * Appends integer value to CustomStringBuilder
     * @param i - integer value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code i} is {@code null}
     */
    public CustomStringBuilder append(final int i) {
        return append(String.valueOf(i));
    }

    /**
     * Appends long value to CustomStringBuilder
     * @param lng - long value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code lng} is {@code null}
     */
    public CustomStringBuilder append(final long lng) {
        return append(String.valueOf(lng));
    }

    /**
     * Appends Object to CustomStringBuilder
     * @param o - Object value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code str} is {@code null}
     */
    public CustomStringBuilder append(final Object o) {
        Objects.requireNonNull(o);
        String objectString = o.toString();
        stringBuilder.add(objectString);
        size += objectString.length();
        return this;
    }

    /**
     * Appends String to CustomStringBuilder
     * @param str - String value to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code str} is {@code null}
     */
    public CustomStringBuilder append(final String str) {
        Objects.requireNonNull(str);
        if(!str.isEmpty()) {
            stringBuilder.add(str);
            size += str.length();
        }
        return this;
    }

    /**
     * Returns the char at specified index
     * @param index - the index of the {@code char} value to be returned
     * @throws IndexOutOfBoundsException
     *          if the index is out of range ({@code index < 0 || index > size()})
     * @return char value at index
     */
    public char charAt(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        int trackingIndex = index;
        for (String chunk : stringBuilder) {
            if (trackingIndex < chunk.length())
                return chunk.charAt(trackingIndex);
            trackingIndex -= chunk.length();
        }
        throw new IllegalStateException("Internal state corruption tracking size.");
    }

    /**
     * Compares this {@code CustomStringBuilder} with the specified {@code StringBuilder}
     * for order. The comparison is based on the lexicographical order of the character sequences they represent.
     * @param o - the {@code StringBuilder} to be compared against this{@code CustomStringBuilder}
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object
     * @throws NullPointerException
     *          if {@code o} is {@code null}
     */
    public int compareTo(final StringBuilder o) {
        return this.toString().compareTo(o.toString());
    }

    /**
     * Compares this {@code CustomStringBuilder} with the specified {@code CustomStringBuilder}
     * for order. The comparison is based on the lexicographical order of the character sequences they represent.
     * @param o - the {@code CustomStringBuilder} to be compared against this{@code CustomStringBuilder}
     * @return a negative integer, zero, or a positive integer as this object is
     *         less than, equal to, or greater than the specified object
     * @throws NullPointerException
     *          if {@code o} is {@code null}
     */
    @Override
    public int compareTo(final CustomStringBuilder o) {
        return this.toString().compareTo(o.toString());
    }

    /**
     * Deletes range of characters in StringBuilder
     * @param start - Start index to begin deleting from.
     * @param  end - End index to delete to
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code start < 0} or {@code end < 0}
     *          or {@code start > end} or {@code end > length()}
     */
    public CustomStringBuilder delete(final int start, final int end) {
        return replace(start, end, "");
    }

    /**
     * Deletes character at index
     * @param index - index to remove character from.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code index < 0} or {@code index > length()}
     */
    public CustomStringBuilder deleteCharAt(final int index) {
        if(index < 0 || index >= size)
            throw new StringIndexOutOfBoundsException();
        return replace(index, index + 1, "");
    }

    /**
     * Compares the specified object with this {@code CustomStringBuilder} for equality.
     * Returns {@code true} if and only if the specified object is also a
     * {@code CustomStringBuilder} and both represent the exact same sequence of characters.
     * <p>
     * In other words, two custom string builders are considered equal if they have
     * the same length and contain the same characters in the same sequential order.
     * This implementation relies on comparing the string representations of both objects.
     *
     * @param obj the object to be compared for equality with this custom string builder.
     * @return {@code true} if the specified object is equal to this custom string builder,
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof CustomStringBuilder other))
            return false;
        return Objects.equals(this.toString(), other.toString());
    }

    /**
     * Returns the hash code value for this {@code CustomStringBuilder}.
     * The hash code is computed based on the character sequence represented by this object,
     * ensuring consistency with the {@link String#hashCode()} contract.
     * <p>
     * This ensures that {@code cb1.equals(cb2)} implies that {@code cb1.hashCode() == cb2.hashCode()}
     * for any two {@code CustomStringBuilder} objects, as required by the general contract of
     * {@link Object#hashCode()}.
     *
     * @return the hash code value for this custom string builder.
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(this.toString());
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
        if (fromIndex < 0)
            return -1;
        if (fromIndex > size)
            return -1;
        return getIndex(str, fromIndex);
    }

    /**
     * Inserts boolean into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param b - boolean to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final boolean b) {
        return insert(offset, String.valueOf(b));
    }

    /**
     * Inserts character into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param c - character to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final char c) {
        return insert(offset, String.valueOf(c));
    }

    /**
     * Inserts character[] into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param str - character array to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final char[] str) {
        Objects.requireNonNull(str);
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
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int index, final char[] str, final int offset, final int len) {
        if (offset < 0 || len < 0 || offset + len > str.length)
            throw new StringIndexOutOfBoundsException();
        return insert(index, String.valueOf(str).substring(offset, offset + len));
    }

    /**
     * insert String value 0f Character Sequence into CustomStringBuilder
     * @param dstOffset - index to insert character into.
     * @param s - CharSequence to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code dstOffset < 0} or {@code dstOffset > length()}
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
     *          if {@code dstOffset < 0} or {@code dstOffset > length()}
     * @throws IndexOutOfBoundsException
     *          if {@code start} or {@code end} are negative,
     *          if {@code end} is greater than {@code length()},
     *          or if {@code start} is greater than {@code end}
     */
    public CustomStringBuilder insert(final int dstOffset, final CharSequence s, final int start, final int end) {
        return insert(dstOffset, s.subSequence(start, end));
    }

    /**
     * Inserts double into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param d - double value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final double d) {
        return insert(offset, String.valueOf(d));
    }

    /**
     * Inserts float into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param f - float value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final float f) {
        return insert(offset, String.valueOf(f));
    }

    /**
     * Inserts integer into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param i - integer value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final int i) {
        return insert(offset, String.valueOf(i));
    }

    /**
     * Inserts long into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param l - long value to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final long l) {
        return insert(offset, String.valueOf(l));
    }

    /**
     * Inserts object into CustomStringBuilder at given offset
     * @param offset - index to insert character into.
     * @param obj - Object to insert into CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code offset < 0} or {@code offset > length()}
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
     *          if {@code offset < 0} or {@code offset > length()}
     */
    public CustomStringBuilder insert(final int offset, final String str) {
        Objects.requireNonNull(str);
        if(offset < 0 || offset > size)
            throw new StringIndexOutOfBoundsException();
        return replace(offset, offset, str);
    }

    /**
     * Returns the last index of String in CustomStringBuilder
     * @param str - String to be find last index of.
     * @return last index of String if present, else -1
     */
    public int lastIndexOf(final String str) {
        Objects.requireNonNull(str);
        return toString().lastIndexOf(str);
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
    public CustomStringBuilder replace(final int start, final int end, final String str) {
        Objects.requireNonNull(str);
        if (start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        char[] current = toCharArray();
        int actualEnd = Math.min(end, size);
        int replacementLength = str.length();
        int newSize = size - (actualEnd - start) + replacementLength;
        char[] newBuffer = new char[newSize];
        System.arraycopy(current, 0, newBuffer, 0, start);
        str.getChars(0, replacementLength, newBuffer, start);
        System.arraycopy(current, actualEnd, newBuffer, start + replacementLength, size - actualEnd);
        stringBuilder.clear();
        stringBuilder.add(new String(newBuffer));
        size = newSize;
        return this;
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
        stringBuilder.clear();
        if(size > 0)
            stringBuilder.add(new String(buffer));
        else
            stringBuilder.add("");
        return this;
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
        if(index < 0 || index >= size)
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
        return new CustomStringBuilder(subString(start, end));
    }

    /**
     * Returns CharSequence of subString in CustomStringBuilder
     * @param start - start index to get subString from.
     * @return String of characters in CustomStringBuilder
     * @throws StringIndexOutOfBoundsException
     *          if {@code start < 0}
     *          of {@code start > size}
     */
    public String subString(final int start) {
        return subString(start, size);
    }

    /**
     * Returns subString in CustomStringBuilder
     * @param start - index to get CharSubSequence from.
     * @param end - index to get CharSubSequence to.
     * @return CharSequence of characters in range
     * @throws StringIndexOutOfBoundsException
     *          if {@code start < 0}
     *          or {@code start > size}
     *          or {@code start > end}
     */
    public String subString(int start, int end) {
        if(start < 0 || start > size || start > end || end > size)
            throw new StringIndexOutOfBoundsException();
        if(start == end)
            return "";
        char[] chars = toCharArray();
        return new String(chars, start, end - start);
    }

    /**
     * Get CustomStringBuilder as String
     * @return String value of CustomStringBuilder's String
     */
    @Override
    public String toString() {
        return String.join("", stringBuilder);
    }

    private int getIndex(final String str, final int fromIndex) {
        if (str.isEmpty())
            return fromIndex;
        if (fromIndex > size - str.length())
            return -1;
        char[] currentChars = toCharArray();
        int matchLength = str.length();
        int maxSearchLimit = size - matchLength;
        for (int i = fromIndex; i <= maxSearchLimit; i++) {
            boolean matchFound = true;
            for (int j = 0; j < matchLength; j++)
                if (currentChars[i + j] != str.charAt(j)) {
                    matchFound = false;
                    break;
                }
            if (matchFound)
                return i;
        }
        return -1;
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