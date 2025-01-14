
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomStringBuilder implements StringBuilderInterface {

    private List<String> stringBuilder = new ArrayList<>();

    private int size = 0;

    private int capacity = 128;

    public CustomStringBuilder() { }

    public CustomStringBuilder(CharSequence seq) {
        if(seq == null)
            size = 0;
        else {
            size = seq.length();
            stringBuilder.add(seq.toString());
        }
    }

    public CustomStringBuilder(int capacity) {
        if(capacity < 0)
            throw new NegativeArraySizeException();
        stringBuilder = new ArrayList<>(capacity);
        this.capacity = Math.max(capacity, 128);
    }

    public CustomStringBuilder(String str) {
        if(str == null)
            size = 0;
        else {
            size = str.length();
            stringBuilder.add(str);
            expandCapacity();
        }
    }

    public CustomStringBuilder append(boolean b) {
        return append(String.valueOf(b));
    }

    public CustomStringBuilder append(char c) {
        return append(String.valueOf(c));
    }

    public CustomStringBuilder append(char[] str) {
        return append(new String(str));
    }

    public CustomStringBuilder append(char[] str, int offset, int len) {
        if(offset < 0 || len < 0 || offset + len > str.length)
            throw new IndexOutOfBoundsException();
        return append(new String(Arrays.copyOfRange(str, offset, offset + len)));
    }

    public CustomStringBuilder append(CharSequence charSequence) {
        return append(String.valueOf(charSequence));
    }

    public CustomStringBuilder append(CharSequence charSequence, int start, int end) {
        if(start < 0 || end < 0 || start > end || end > charSequence.length())
            throw new IndexOutOfBoundsException();
        return append(charSequence.subSequence(start, end + 1));
    }

    public CustomStringBuilder append(double d) {
        return append(String.valueOf(d));

    }

    public CustomStringBuilder append(float f) {
        return append(String.valueOf(f));
    }

    public CustomStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public CustomStringBuilder append(long lng) {
        return append(String.valueOf(lng));
    }

    public CustomStringBuilder append(String str) {
        String appendString = String.valueOf(str);
        stringBuilder.add(String.valueOf(str));
        size += appendString.length();
        expandCapacity();
        return this;
    }

    public CustomStringBuilder delete(int start, int end) {
        if(start < 0 || start > size || start > end)
            throw new StringIndexOutOfBoundsException();
        replace(start, end, "");
        return this;
    }

    public CustomStringBuilder deleteCharAt(int index) {
        if(index < 0 || index >= size)
            throw new StringIndexOutOfBoundsException();
        return index < stringBuilder.getFirst().length() ? removeCharFromStart(index) : removeChar(index);
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    public int indexOf(String str, int fromIndex) {
        int start = fromIndex;
        if(fromIndex > size || fromIndex < 0 || size == 0)
            return -1;
        else if(stringBuilder.size() == 1) {
            String subString = stringBuilder.getFirst().substring(fromIndex);
            return subString.contains(str) ? subString.indexOf(str) + fromIndex : -1;
        } else {
            int idx = 0;
            while (fromIndex > stringBuilder.get(idx).length()) {
                fromIndex -= stringBuilder.get(idx++).length();
            }
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
    }

    public CustomStringBuilder insert(int offset, String str) {
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

    public CustomStringBuilder insert(int offset, boolean b) {
        return insert(offset, String.valueOf(b));
    }

    public CustomStringBuilder insert(int offset, char c) {
        return insert(offset, String.valueOf(c));
    }

    public CustomStringBuilder insert(int offset, char[] str) {
        return insert(offset, String.valueOf(str));
    }

    public CustomStringBuilder insert(int index, char[] str, int offset, int len) {
        if(index < 0 || index > size || offset < 0 || len < 0 ||  offset + len > size)
            throw new StringIndexOutOfBoundsException();
        return insert(offset, String.valueOf(str).substring(offset, len));
    }

    public CustomStringBuilder insert(int dstOffset, CharSequence s) {
        return insert(dstOffset, String.valueOf(s));
    }

    public CustomStringBuilder insert(int dstOffset, CharSequence s, int start, int end) {
        if(dstOffset < 0 || dstOffset > size || start < 0 || end < 0 || start > size || start > end)
            throw new IndexOutOfBoundsException();
        return insert(dstOffset, s.subSequence(start, end));
    }

    public CustomStringBuilder insert(int offset, double d) {
        return insert(offset, String.valueOf(d));
    }

    public CustomStringBuilder insert(int offset, float f) {
        return insert(offset, String.valueOf(f));
    }

    public CustomStringBuilder insert(int offset, int i) {
        return insert(offset, String.valueOf(i));
    }

    public CustomStringBuilder insert(int offset, long l) {
        return insert(offset, String.valueOf(l));
    }

    public CustomStringBuilder insert(int offset, Object obj) {
        return insert(offset, obj.toString());
    }

    public int lastIndexOf(String str) {
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
        String s1 = "";
        int nextIndex = 0;
        List<Integer> matchesIndexes = new ArrayList<>();

        while(s1.length() < end && nextIndex < stringBuilder.size()) {
            matchesIndexes.add(nextIndex);
            s1 += stringBuilder.get(nextIndex++);
        }
        if(matchesIndexes.size() == 1)
            replaceStart(start, end, str);
        else
            replaceInner(start, end, s1, matchesIndexes, str);
        return this;
    }

    public CustomStringBuilder reverse() {
        CustomStringBuilder sb = new CustomStringBuilder();
        for(int i = stringBuilder.size() - 1; i >= 0; i--) {
            char[] chars = stringBuilder.get(i).toCharArray();
            String str = "";
            for(char c : chars)
                str = c + str;
            sb.append(str);
        }
        return sb;
    }

    public void setCharAt(int index, char c) {
        if(index < 0 || index > size)
            throw new StringIndexOutOfBoundsException();
        if (index < stringBuilder.getFirst().length())
            setStringStart(index, String.valueOf(c));
        else {
            int idx = 0;
            while (index > stringBuilder.get(idx).length())
                index -= stringBuilder.get(++idx).length();
            String current = stringBuilder.get(idx);
            current = current.substring(0, index) + c + current.substring(index + 1);
            stringBuilder.set(idx, current);
        }
    }

    public CharSequence subSequence(int start, int end) {
        try {
            return subString(start, end);
        } catch(StringIndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
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
        if(start < 0 || start > size)
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

    private void replaceStart(int start, int end, String replaceStr) {
        String toMod = stringBuilder.getFirst();
        toMod = end > toMod.length() ? toMod.substring(0, start) + replaceStr : toMod.substring(0, start) + replaceStr + toMod.substring(end);
        stringBuilder.set(0, toMod);
    }

    private void replaceInner(int start, int end, String s1, List<Integer> matchesIndexes, String replaceString) {
        s1 = end > s1.length() ? s1.substring(0, start) + replaceString : s1.substring(0, start) + replaceString + s1.substring(end);
        stringBuilder.subList(matchesIndexes.getFirst(), matchesIndexes.getLast() + 1).clear();
        stringBuilder.addFirst(s1);
    }

    private CustomStringBuilder removeChar(int index) {
        int idx = 0;
        while (index >= stringBuilder.get(idx).length())
            index -= stringBuilder.get(idx++).length();
        stringBuilder.set(idx, stringBuilder.get(idx).substring(0, index) + stringBuilder.get(idx).substring(index + 1));
        return this;
    }

    private CustomStringBuilder removeCharFromStart(int index) {
        String s1 = stringBuilder.getFirst();
        s1 = s1.substring(0, index) + s1.substring(index + 1);
        stringBuilder.set(0, s1);
        return this;
    }

    private void setStringStart(int index, String c) {
        String s1 = stringBuilder.getFirst();
        s1 = s1.substring(0, index) + c + s1.substring(index + 1);
        stringBuilder.set(0, s1);
    }

    private void expandCapacity() {
        while (size > capacity)
            capacity *= 2;
    }
}
