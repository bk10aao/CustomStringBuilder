import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomStringBuilder implements StringBuilderInterface {

    private List<String> stringBuilder = new ArrayList<>();

    private int size = 0;

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
    }

    public CustomStringBuilder(String str) {
        if(str == null) {
            size = 0;
        } else {
            size = str.length();
            stringBuilder.add(str);
        }
    }

    public CustomStringBuilder append(boolean b) {
        String bStr = String.valueOf(b);
        stringBuilder.add(bStr);
        size += bStr.length();
        return this;
    }

    public CustomStringBuilder append(char c) {
        stringBuilder.add(String.valueOf(c));
        size++;
        return this;
    }

    public CustomStringBuilder append(char[] str) {
        if(str == null) {
            stringBuilder.add("null");
            size += 4;
            return this;
        }
        stringBuilder.add(String.valueOf(str));
        size += str.length;
        return this;
    }
    public CustomStringBuilder append(char[] str, int offset, int len) {
        if(offset < 0 || len < 0 || offset + len > str.length)
            throw new IndexOutOfBoundsException();
        String appendString = new String(Arrays.copyOfRange(str, offset, offset + len));
        stringBuilder.add(appendString);
        size += appendString.length();
        return this;
    }

    public CustomStringBuilder append(CharSequence charSequence) {
        String appendString = String.valueOf(charSequence);
        stringBuilder.add(String.valueOf(charSequence));
        size += appendString.length();
        return this;
    }

    public CustomStringBuilder append(CharSequence charSequence, int start, int end) {
        if(start < 0 || end < 0 || start > end || end > charSequence.length())
            throw new IndexOutOfBoundsException();
        stringBuilder.add(String.valueOf(charSequence.subSequence(start, end + 1)));
        size += (end - start) + 1;
        return this;
    }

    public CustomStringBuilder append(int i) {
        String intStr = String.valueOf(i);
        stringBuilder.add(intStr);
        size += intStr.length();
        return this;
    }

    public CustomStringBuilder append(long lng) {
        String lngStr = String.valueOf(lng);
        stringBuilder.add(lngStr);
        size += lngStr.length();
        return this;
    }

    public CustomStringBuilder append(float f) {
        String fltStr = String.valueOf(f);
        stringBuilder.add(fltStr);
        size += fltStr.length();
        return this;
    }

    public CustomStringBuilder append(double d) {
        String dblStr = String.valueOf(d);
        stringBuilder.add(dblStr);
        size += dblStr.length();
        return this;
    }

    //TODO appendCodePoint


    public int length() {
        return size;
    }

    @Override
    public String toString() {
        String str = "";
        for(String s : stringBuilder) {
            str += s;
        }
        return str;
    }

}
