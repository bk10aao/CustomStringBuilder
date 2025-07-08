
import java.util.ArrayList;
import java.util.List;

public class CustomStringBuilder implements StringBuilderInterface {

    private final List<String> stringBuilder = new ArrayList<>();

    private int size = 0;

    public CustomStringBuilder() { }

    public CustomStringBuilder(final CharSequence seq) {
        if(seq != null)
            append(seq);
    }

    public CustomStringBuilder(final String str) {
        if(str != null)
            append(str);
    }

    public CustomStringBuilder append(final boolean b) {
        return append(String.valueOf(b));
    }

    public CustomStringBuilder append(final char c) {
        return append(String.valueOf(c));
    }

    public CustomStringBuilder append(final char[] str) {
        return append(new String(str));
    }

    public CustomStringBuilder append(final char[] str, final int offset, final int len) {
        return append(new String(str, offset, len));
    }

    public CustomStringBuilder append(final CharSequence charSequence) {
        return append(String.valueOf(charSequence));
    }

    public CustomStringBuilder append(final CharSequence charSequence, final int start, final int end) {
        if (charSequence == null)
            throw new NullPointerException();
        if (start < 0 || end < start || end > charSequence.length())
            throw new StringIndexOutOfBoundsException();
        return append(charSequence.subSequence(start, end));
    }

    public CustomStringBuilder append(final double d) {
        return append(String.valueOf(d));
    }

    public CustomStringBuilder append(final float f) {
        return append(String.valueOf(f));
    }

    public CustomStringBuilder append(final int i) {
        return append(String.valueOf(i));
    }

    public CustomStringBuilder append(final long lng) {
        return append(String.valueOf(lng));
    }

    public CustomStringBuilder append(final String str) {
        if (str == null)
            throw new NullPointerException();
        stringBuilder.add(str);
        size += str.length();
        return this;
    }

    public CustomStringBuilder delete(final int start, final int end) {
        return replace(start, end, "");
    }

    public CustomStringBuilder deleteCharAt(final int index) {
        if(index < 0 || index >= size)
            throw new StringIndexOutOfBoundsException();
        return replace(index, index + 1, "");
    }

    public int indexOf(final String str) {
        return indexOf(str, 0);
    }

    public int indexOf(final String str, final int fromIndex) {
        return (fromIndex > size || fromIndex < 0 || size == 0) ? -1 : getIndex(str, fromIndex);
    }

    public CustomStringBuilder insert(final int offset, final boolean b) {
        return insert(offset, String.valueOf(b));
    }

    public CustomStringBuilder insert(final int offset, final char c) {
        return insert(offset, String.valueOf(c));
    }

    public CustomStringBuilder insert(final int offset, final char[] str) {
        return insert(offset, String.valueOf(str));
    }

    public CustomStringBuilder insert(final int index, final char[] str, final int offset, final int len) {
        return insert(index, String.valueOf(str).substring(offset, len));
    }

    public CustomStringBuilder insert(final int dstOffset, final CharSequence s) {
        return insert(dstOffset, String.valueOf(s));
    }

    public CustomStringBuilder insert(final int dstOffset, final CharSequence s, final int start, final int end) {
        return insert(dstOffset, s.subSequence(start, end));
    }

    public CustomStringBuilder insert(final int offset, final double d) {
        return insert(offset, String.valueOf(d));
    }

    public CustomStringBuilder insert(final int offset, final float f) {
        return insert(offset, String.valueOf(f));
    }

    public CustomStringBuilder insert(final int offset, final int i) {
        return insert(offset, String.valueOf(i));
    }

    public CustomStringBuilder insert(final int offset, final long l) {
        return insert(offset, String.valueOf(l));
    }

    public CustomStringBuilder insert(final int offset, final Object obj) {
        return insert(offset, obj.toString());
    }

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

    public int lastIndexOf(final String str) {
        String built = "";
        for(int i = stringBuilder.size() - 1; i >= 0; i--) {
            built = stringBuilder.get(i) + built;
            if(built.lastIndexOf(str) != -1)
                return size - (built.length() - built.lastIndexOf(str));
        }
        return -1;
    }

    public int length() {
        return size;
    }

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

    public void setCharAt(final int index, final char c) {
        if(index < 0 || index > size)
            throw new StringIndexOutOfBoundsException();
        replace(index, index + 1, String.valueOf(c));
    }

    public CharSequence subSequence(final int start, final int end) {
        return subString(start, end);
    }

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