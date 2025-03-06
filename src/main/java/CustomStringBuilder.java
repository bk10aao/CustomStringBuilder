
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomStringBuilder implements StringBuilderInterface {

    private final List<String> stringBuilder = new ArrayList<>();

    private int size = 0;

    public CustomStringBuilder() { }

    public CustomStringBuilder(final CharSequence seq) {
        if(seq == null)
            size = 0;
        else {
            size = seq.length();
            stringBuilder.add(seq.toString());
        }
    }

    public CustomStringBuilder(final String str) {
        if(str == null)
            size = 0;
        else {
            size = str.length();
            stringBuilder.add(str);
        }
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
        if(offset < 0 || len < 0 || offset + len > str.length)
            throw new IndexOutOfBoundsException();
        return append(new String(Arrays.copyOfRange(str, offset, offset + len)));
    }

    public CustomStringBuilder append(final CharSequence charSequence) {
        return append(String.valueOf(charSequence));
    }

    public CustomStringBuilder append(final CharSequence charSequence, final int start, final int end) {
        return append(charSequence.subSequence(start, end + 1));
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
        return delete(index, index + 1);
    }

    public int indexOf(final String str) {
        return indexOf(str, 0);
    }

    public int indexOf(final String str, final int fromIndex) {
        if(fromIndex > size || fromIndex < 0 || size == 0)
            return -1;
        else
            return getIndex(str, fromIndex);
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
        int off = offset;
        if(off < 0 || offset > size)
            throw new StringIndexOutOfBoundsException();
        else {
            int idx = 0;
            while(off > stringBuilder.get(idx).length())
                off -= stringBuilder.get(idx++).length();
            String insertInto = stringBuilder.get(idx);
            stringBuilder.set(idx, insertInto.substring(0, off) + str + insertInto.substring(off));
        }
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

    public CustomStringBuilder replace(final int start, final int end, final String str) {
        if(start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        int s = start;
        int e = end;
        int idx = 0;
        while(s >= stringBuilder.get(idx).length()) {
            s -= stringBuilder.get(++idx).length();
            e -= stringBuilder.get(idx).length();
        }
        List<Integer> matchedRange = getMatchedRange(str, idx);
        String temp = "";
        for(int i : matchedRange)
            temp += stringBuilder.get(i);
        return replace(str, temp, s, e, matchedRange);
    }

    public CustomStringBuilder reverse() {
        CustomStringBuilder sb = new CustomStringBuilder();
        for (int i = stringBuilder.size() - 1; i >= 0; i--) {
            String str = stringBuilder.get(i);
            char[] chars = str.toCharArray();  // Convert string to char array
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
            sb.append(chars);
        }
        return sb;
    }

    public void setCharAt(final int index, final char c) {
        if(index < 0 || index > size)
            throw new StringIndexOutOfBoundsException();
        replace(index, index + 1, String.valueOf(c));
    }

    public CharSequence subSequence(final int start, final int end) {
        return subString(start, end);
    }

    public String subString(final int start) {
        if(start < 0 || start > size)
            throw new StringIndexOutOfBoundsException();
        int s = start;
        int idx = 0;
        while(s > stringBuilder.get(idx).length())
            s -= stringBuilder.get(++idx).length();
        String str = stringBuilder.get(idx++).substring(s);
        for(int i = idx; i < stringBuilder.size(); i++)
            str += stringBuilder.get(i);
        return str;
    }

    public String subString(final int start, final int end) {
        if(start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        if(stringBuilder.size() == 1)
            return stringBuilder.getFirst().substring(start, end);
        int s = start;
        int e = end;
        int idx = 0;
        while(s >= stringBuilder.get(idx).length()) {
            s -= stringBuilder.get(++idx).length();
            e -= stringBuilder.get(idx).length();
        }
        String str = stringBuilder.get(idx++).substring(s);
        for(int i = idx; i < stringBuilder.size() && str.length() < e - s; i++)
            str += stringBuilder.get(i);
        return str.substring(0, e - s);
    }

    @Override
    public String toString() {
        int totalLength = 0;
        for (String str : stringBuilder)
            totalLength += str.length();
        char[] result = new char[totalLength];
        int idx = 0;
        for (String str : stringBuilder) {
            char[] charArray = str.toCharArray();
            System.arraycopy(charArray, 0, result, idx, charArray.length);
            idx += charArray.length;
        }
        return new String(result);
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
            for (int i = idx + 1; i < stringBuilder.size(); i++) {
                s += stringBuilder.get(i);
                if (s.contains(str))
                    return s.indexOf(str) + fromIndex;
            }
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
}