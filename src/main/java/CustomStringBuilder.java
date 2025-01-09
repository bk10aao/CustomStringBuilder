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
        if(str == null) {
            size = 0;
        } else {
            size = str.length();
            stringBuilder.add(str);
            expandCapacity();
        }
    }

    public CustomStringBuilder append(boolean b) {
        String bStr = String.valueOf(b);
        stringBuilder.add(bStr);
        size += bStr.length();
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(char c) {
        stringBuilder.add(String.valueOf(c));
        size++;
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(char[] str) {
        if(str == null) {
            stringBuilder.add("null");
            size += 4;
        } else {
            stringBuilder.add(String.valueOf(str));
            size += str.length;
        }
        expandCapacity();
        return this;
    }
    public CustomStringBuilder append(char[] str, int offset, int len) {
        if(offset < 0 || len < 0 || offset + len > str.length)
            throw new IndexOutOfBoundsException();
        String appendString = new String(Arrays.copyOfRange(str, offset, offset + len));
        stringBuilder.add(appendString);
        size += appendString.length();
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(CharSequence charSequence) {
        String appendString = String.valueOf(charSequence);
        stringBuilder.add(String.valueOf(charSequence));
        size += appendString.length();
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(CharSequence charSequence, int start, int end) {
        if(start < 0 || end < 0 || start > end || end > charSequence.length())
            throw new IndexOutOfBoundsException();
        stringBuilder.add(String.valueOf(charSequence.subSequence(start, end + 1)));
        size += (end - start) + 1;
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(int i) {
        String intStr = String.valueOf(i);
        stringBuilder.add(intStr);
        size += intStr.length();
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(long lng) {
        String lngStr = String.valueOf(lng);
        stringBuilder.add(lngStr);
        size += lngStr.length();
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(float f) {
        String fltStr = String.valueOf(f);
        stringBuilder.add(fltStr);
        size += fltStr.length();
        expandCapacity();
        return this;
    }

    public CustomStringBuilder append(double d) {
        String dblStr = String.valueOf(d);
        stringBuilder.add(dblStr);
        size += dblStr.length();
        expandCapacity();
        return this;
    }

    //TODO appendCodePoint

    public CustomStringBuilder delete(int start, int end) {
        if(start < 0 || start > size || start > end) {
            throw new StringIndexOutOfBoundsException();
        }
        String s1 = "";
        int nextIndex = 0;
        List<Integer> matchesIndexes = new ArrayList<>();
        while(s1.length() < end && nextIndex < stringBuilder.size()) {
            matchesIndexes.add(nextIndex);
            s1 += stringBuilder.get(nextIndex++);
        }
        if(matchesIndexes.size() == 1) {
            setStart(start, end, matchesIndexes);
        } else {
            replaceInner(start, end, s1, matchesIndexes);
        }
        return this;
    }

    private void replaceInner(int start, int end, String s1, List<Integer> matchesIndexes) {
        s1 = s1.substring(0, start) + s1.substring(end);
        stringBuilder.subList(matchesIndexes.get(0), matchesIndexes.get(matchesIndexes.size() - 1) + 1).clear();
        stringBuilder.add(0, s1);
        System.out.println(123);
    }

    private void setStart(int start, int end, List<Integer> matchesIndexes) {
        int removeIndex = matchesIndexes.get(0);
        String toMod = stringBuilder.get(removeIndex);
        if(end > toMod.length()) {
            stringBuilder.set(0, toMod.substring(0, start));
        } else {
            stringBuilder.set(0, toMod.substring(0, start) + toMod.substring(end));
        }
    }

    public int length() {
        return size;
    }

    @Override
    public String toString() {
        String str = "";
        for(String s : stringBuilder)
            str += s;
        return str;
    }

    private void expandCapacity() {
        while (size > capacity)
            capacity *= 2;
    }
}
