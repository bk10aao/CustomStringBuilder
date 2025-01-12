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

    //TODO - very inefficient - improve performance
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
            deleteInner(start, end, s1, matchesIndexes);
        }
        return this;
    }

    public CustomStringBuilder deleteCharAt(int index) {
        if(index < 0 || index >= size)
            throw new StringIndexOutOfBoundsException();
        return index < stringBuilder.get(0).length() ? removeCharFromStart(index) : removeChar(index);
    }

    public int indexOf(String str) {
        int index = 0;
        for (String inner : stringBuilder) {
            int temp = inner.indexOf(str);
            if (temp != -1)
                return index + temp;
            else
                index += inner.length();
        }
        return -1;
    }

    public int indexOf(String str, int fromIndex) {
        if(fromIndex > size || fromIndex < 0) 
            return -1;
        else if(stringBuilder.size() == 1) {
            String subString = stringBuilder.get(0).substring(fromIndex);
            if(subString.contains(str)) 
                return subString.indexOf(str) + fromIndex;
        } else {
            return indexOfInner(str, fromIndex);
        }
        return -1;
    }

    private int indexOfInner(String str, int fromIndex) {
        int index = 0;
        String current = stringBuilder.get(index);
        int count = current.length();

        for (int i = 1; i < stringBuilder.size(); i++) {
            count += stringBuilder.get(i).length();
            if(count >= fromIndex) {
                index = i;
                break;
            }
        }
        for(int i = index + 1; i < stringBuilder.size(); i++) {
            String next = stringBuilder.get(i);
            if(next.contains(str))
                return count + next.indexOf(str);
            count += next.length();
        }
        return -1;
    }

    public int length() {
        return size;
    }

    //TODO - very inefficient - improve performance
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
        if (index < stringBuilder.get(0).length())
            setStringStart(index, String.valueOf(c));
        else
            setString(index, String.valueOf(c));
    }

    public CharSequence subSequence(int start, int end) {
        try {
            return subString(start, end);
        } catch(StringIndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    //TODO - very inefficient - improve performance
    public String subString(int start) {
        if(start < 0 || start >= size)
            throw new StringIndexOutOfBoundsException();
        int index = 0;

        String str = stringBuilder.get(index++);
        while(str.length() < start)
            str += stringBuilder.get(index++);
        str = str.substring(start);
        for(int i = index; i < stringBuilder.size(); i++)
            str += stringBuilder.get(i);

        return str;
    }

    //TODO - very inefficient - improve performance
    public String subString(int start, int end) {
        if(start < 0 || start > size || start > end || end >= size)
            throw new StringIndexOutOfBoundsException();
        int index = 0;
        String str = stringBuilder.get(index++);
        while(str.length() <= start)
            str += stringBuilder.get(index++);
        while(str.length() <= end)
            str += stringBuilder.get(index++);

        return str.substring(start, end);
    }

    private void replaceStart(int start, int end, String replaceStr) {
        String toMod = stringBuilder.get(0);
        toMod = end > toMod.length() ? toMod.substring(0, start) + replaceStr : toMod.substring(0, start) + replaceStr + toMod.substring(end);
        stringBuilder.set(0, toMod);
    }

    private void replaceInner(int start, int end, String s1, List<Integer> matchesIndexes, String replaceString) {
        s1 = end > s1.length() ? s1.substring(0, start) + replaceString : s1.substring(0, start) + replaceString + s1.substring(end);
        stringBuilder.subList(matchesIndexes.get(0), matchesIndexes.get(matchesIndexes.size() - 1) + 1).clear();
        stringBuilder.add(0, s1);
    }

    private CustomStringBuilder removeChar(int index) {
        int currentIndex = 0;
        int currentSize = stringBuilder.get(currentIndex).length();
        int rollingIndex = index;
        String currentIndexedString = "";
        while (currentSize <= index) {
            currentIndexedString = stringBuilder.get(++currentIndex);
            rollingIndex -= currentIndexedString.length();
            currentSize += currentIndexedString.length();
        }
        currentIndexedString = currentIndexedString.substring(0, rollingIndex) + currentIndexedString.substring(rollingIndex + 1);
        stringBuilder.set(currentIndex, currentIndexedString);
        return this;
    }

    private CustomStringBuilder removeCharFromStart(int index) {
        String s1 = stringBuilder.get(0);
        s1 = s1.substring(0, index) + s1.substring(index + 1);
        stringBuilder.set(0, s1);
        return this;
    }

    private void setStringStart(int index, String c) {
        String s1 = stringBuilder.get(0);
        s1 = s1.substring(0, index) + c + s1.substring(index + 1);
        stringBuilder.set(0, s1);
    }

    private void setString(int index, String c) {
        int currentIndex = 0;
        int currentSize = stringBuilder.get(currentIndex).length();
        int rollingIndex = index;
        String currentIndexedString = "";
        while (currentSize <= index) {
            currentIndexedString = stringBuilder.get(++currentIndex);
            rollingIndex -= currentIndexedString.length();
            currentSize += currentIndexedString.length();
        }
        currentIndexedString = currentIndexedString.substring(0, rollingIndex) + c + currentIndexedString.substring(rollingIndex + 1);
        stringBuilder.set(currentIndex, currentIndexedString);
    }

    private void deleteInner(int start, int end, String s1, List<Integer> matchesIndexes) {
        s1 = s1.substring(0, start) + s1.substring(end);
        stringBuilder.subList(matchesIndexes.get(0), matchesIndexes.get(matchesIndexes.size() - 1) + 1).clear();
        stringBuilder.add(0, s1);
    }

    private void setStart(int start, int end, List<Integer> matchesIndexes) {
        int removeIndex = matchesIndexes.get(0);
        String toMod = stringBuilder.get(removeIndex);
        if(end > toMod.length())
            stringBuilder.set(0, toMod.substring(0, start));
        else
            stringBuilder.set(0, toMod.substring(0, start) + toMod.substring(end));
    }

    private void expandCapacity() {
        while (size > capacity)
            capacity *= 2;
    }

    @Override
    public String toString() {
        String str = "";
        for(String s : stringBuilder)
            str += s;
        return str;
    }
}
