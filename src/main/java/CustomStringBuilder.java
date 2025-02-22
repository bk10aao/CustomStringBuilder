
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
        return index < stringBuilder.getFirst().length() ? removeCharFromStart(index) : removeChar(index);
    }

    public int indexOf(final String str) {
        return indexOf(str, 0);
    }

    public int indexOf(final String str, int fromIndex) {
        if(fromIndex > size || fromIndex < 0 || size == 0)
            return -1;
        else if(stringBuilder.size() == 1) {
            String subString = stringBuilder.getFirst().substring(fromIndex);
            return subString.contains(str) ? subString.indexOf(str) + fromIndex : -1;
        } else
            return getIndexOfInner(str, fromIndex);
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

    public CustomStringBuilder insert(int offset, double d) {
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

    public CustomStringBuilder insert(int offset, final String str) {
        if(offset < 0 || offset > size)
            throw new StringIndexOutOfBoundsException();
        else {
            int idx = 0;
            while(offset > stringBuilder.get(idx).length())
                offset -= stringBuilder.get(idx++).length();
            String insertInto = stringBuilder.get(idx);
            stringBuilder.set(idx, insertInto.substring(0, offset) + str + insertInto.substring(offset));
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

    public CustomStringBuilder replace(int start, int end, String str) {
        if(start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        if(stringBuilder.size() == 1)
            return replaceStart(start, end, str);
        int idx = 0;
        while(start >= stringBuilder.get(idx).length()) {
            start -= stringBuilder.get(++idx).length();
            end -= stringBuilder.get(idx).length();
        }
        List<Integer> matchedIndexes = new ArrayList<>(List.of(idx));
        String update = getStringRange(str, idx, matchedIndexes);
        return end > update.length() ? replaceEnd(start, str, matchedIndexes, update) : replaceInner(start, end, str, matchedIndexes, update);
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

    public void setCharAt(int index, final char c) {
        if(index < 0 || index > size)
            throw new StringIndexOutOfBoundsException();
        if (index < stringBuilder.getFirst().length()) {
            String s1 = stringBuilder.getFirst();
            s1 = s1.substring(0, index) + c + s1.substring(index + 1);
            stringBuilder.set(0, s1);
        } else {
            int idx = 0;
            while (index > stringBuilder.get(idx).length())
                index -= stringBuilder.get(++idx).length();
            String current = stringBuilder.get(idx);
            current = current.substring(0, index) + c + current.substring(index + 1);
            stringBuilder.set(idx, current);
        }
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
        if(stringBuilder.size() == 1)
            return stringBuilder.getFirst().substring(start, end);
        int idx = 0;
        while(start >= stringBuilder.get(idx).length()) {
            start -= stringBuilder.get(++idx).length();
            end -= stringBuilder.get(idx).length();
        }
        String str = stringBuilder.get(idx++).substring(start);
        for(int i = idx; i < stringBuilder.size() && str.length() < end - start; i++)
            str += stringBuilder.get(i);
        return str.substring(0, end - start);
    }

    @Override
    public String toString() {
        int totalLength = 0;
        for (String str : stringBuilder)
            totalLength += str.length();

        char[] result = new char[totalLength];
        int currentIndex = 0;

        for (String str : stringBuilder) {
            char[] charArray = str.toCharArray();
            System.arraycopy(charArray, 0, result, currentIndex, charArray.length);
            currentIndex += charArray.length;
        }
        return new String(result);
    }

    private Integer getIndexOfInner(String str, int fromIndex) {
        int idx = 0;
        int start = fromIndex;
        while (fromIndex > stringBuilder.get(idx).length())
            fromIndex -= stringBuilder.get(idx++).length();
        String s = stringBuilder.get(idx).substring(fromIndex);
        if(s.contains(str))
            return s.indexOf(str) + start;
        else
            for (int i = idx + 1; i < stringBuilder.size(); i++) {
                s += stringBuilder.get(i);
                if (s.contains(str))
                    return s.indexOf(str) + start;
            }
        return -1;
    }

    private String getStringRange(final String str, int idx, final List<Integer> matchedIndexes) {
        String update = stringBuilder.get(idx++);
        for(int i = idx; i < stringBuilder.size(); i++) {
            update += stringBuilder.get(i);
            matchedIndexes.add(i);
            if(update.length() >= str.length())
                break;
        }
        return update;
    }

    private CustomStringBuilder removeChar(int index) {
        int idx = 0;
        while (index >= stringBuilder.get(idx).length())
            index -= stringBuilder.get(idx++).length();
        stringBuilder.set(idx, stringBuilder.get(idx).substring(0, index) + stringBuilder.get(idx).substring(index + 1));
        size--;
        return this;
    }

    private CustomStringBuilder removeCharFromStart(final int index) {
        String s1 = stringBuilder.getFirst();
        s1 = s1.substring(0, index) + s1.substring(index + 1);
        stringBuilder.set(0, s1);
        size--;
        return this;
    }

    private CustomStringBuilder replaceEnd(int start, String str, List<Integer> matchedIndexes, String update) {
        stringBuilder.subList(matchedIndexes.getFirst(), stringBuilder.size()).clear();
        stringBuilder.add(update.substring(0, start) + str);
        size -= start;
        size += update.length();
        return this;
    }

    private CustomStringBuilder replaceInner(int start, int end, String str, List<Integer> matchedIndexes, String update) {
        stringBuilder.subList(matchedIndexes.getFirst(), matchedIndexes.getLast()).clear();
        stringBuilder.set(matchedIndexes.getFirst(), update.substring(0, start) + str + update.substring(end));
        size -= end - start;
        size += update.length();
        return this;
    }

    private CustomStringBuilder replaceStart(final int start, final int end, final String replaceStr) {
        String toMod = stringBuilder.getFirst();
        toMod = end > toMod.length() ? toMod.substring(0, start) + replaceStr : toMod.substring(0, start) + replaceStr + toMod.substring(end);
        stringBuilder.set(0, toMod);
        size -= end - start;
        size += replaceStr.length();
        return this;
    }
}
