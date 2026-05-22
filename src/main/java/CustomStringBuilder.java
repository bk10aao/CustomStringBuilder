
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
public class CustomStringBuilder implements Appendable, java.io.Serializable, Comparable<StringBuilder>, CharSequence {

    private final List<String> stringBuilder = new ArrayList<>();

    private int size = 0;

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a string builder with no characters
     */
    public CustomStringBuilder() { }

    /**
     * Constructs a string builder that contains the same characters as the specified {@code CharSequence}.
     *
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
     *
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
     *
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
        return append(String.valueOf(c));
    }

    /**
     * Appends character value to CustomStringBuilder
     * @param str - character array to be appended to CustomStringBuilder.
     * @return CustomStringBuilder
     * @throws NullPointerException
     *          if {@code str} is {@code null}.
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
        stringBuilder.add(str);
        size += str.length();
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
        char c = 0;
        for (String current : stringBuilder) {
            if (current.length() > index) {
                c = current.charAt(index);
                break;
            }
            index -= current.length();
        }
        return c;
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
        if(offset < 0 || offset > size)
            throw new StringIndexOutOfBoundsException();
        int idx = 0;
        int currentOffset = 0;
        while (idx < stringBuilder.size() && currentOffset + stringBuilder.get(idx).length() <= offset)
            currentOffset += stringBuilder.get(idx++).length();
        if (idx == stringBuilder.size())
            return append(str);
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
    public CustomStringBuilder replace(final int start, final int end, final String str) {
        if (start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        int actualEnd = Math.min(end, size);
        if (start == actualEnd && str.isEmpty())
            return this;
        int[] chunkIndices = locateChunkIndices(start, actualEnd);
        int startIdx = chunkIndices[0];
        int endIdx = chunkIndices[1];
        String prefix = getChunkSubstring(startIdx, 0, start);
        String suffix = getChunkSubstring(endIdx, actualEnd, -1);
        String replacingBlock = prefix + str + suffix;
        updateChunks(startIdx, endIdx, replacingBlock);
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
     * @return String of characters in CustomStringBuilder
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
        for (int i = idx + 1; i < stringBuilder.size(); i++)
            if ((s += stringBuilder.get(i)).contains(str))
                return s.indexOf(str) + fromIndex;
        return -1;
    }

    private String getChunkSubstring(int chunkIdx, int index, int cutTo) {
        if (chunkIdx < 0 || chunkIdx >= stringBuilder.size())
            return "";
        int offset = 0;
        for (int i = 0; i < chunkIdx; i++)
            offset += stringBuilder.get(i).length();
        String chunk = stringBuilder.get(chunkIdx);
        return (cutTo == -1) ? chunk.substring(index - offset) : chunk.substring(0, cutTo - offset);
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

    private int[] locateChunkIndices(int start, int actualEnd) {
        int startChunkIdx = -1;
        int endChunkIdx = -1;
        int currentOffset = 0;
        for (int i = 0; i < stringBuilder.size(); i++) {
            int nextOffset = currentOffset + stringBuilder.get(i).length();
            if (start >= currentOffset && start <= nextOffset && startChunkIdx == -1)
                startChunkIdx = i;
            if (actualEnd >= currentOffset && actualEnd <= nextOffset && endChunkIdx == -1)
                endChunkIdx = i;
            currentOffset = nextOffset;
        }
        return new int[]{ startChunkIdx, endChunkIdx };
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

    private void updateChunks(int startIdx, int endIdx, String replacingBlock) {
        int oldElementsLength = 0;
        int elementsToRemove = endIdx - startIdx + 1;
        for (int i = 0; i < elementsToRemove; i++)
            oldElementsLength += stringBuilder.remove(startIdx).length();
        if (!replacingBlock.isEmpty() || stringBuilder.isEmpty())
            stringBuilder.add(startIdx, replacingBlock);
        size = size - oldElementsLength + replacingBlock.length();
    }
}