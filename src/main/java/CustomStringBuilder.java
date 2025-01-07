import java.util.Arrays;

public class CustomStringBuilder implements StringBuilderInterface {

    private char[] stringCharacters = new char[127];

    private int capacity = 0;

    private int endIndex = 0;

    public CustomStringBuilder() {
        stringCharacters = new char[127];
    }

    public CustomStringBuilder(CharSequence seq) {
        if(seq != null)
            buildString(seq.toString());
    }

    public CustomStringBuilder(int capacity) {
        if(capacity < 0)
            throw new NegativeArraySizeException();
        stringCharacters = new char[capacity];
        this.capacity = capacity;
    }

    public CustomStringBuilder(String str) {
        if(str != null)
            buildString(str);
    }

    public String toString() {
        if(endIndex == 0)
            return "";
        return new String(Arrays.copyOfRange(stringCharacters, 0, endIndex + 1));
    }

    private void buildString(String str) {
        stringCharacters = str.length() * 2 < 128 ?  new char[127] : new char[str.length() * 2];
        System.arraycopy(str.toCharArray(), 0, stringCharacters, 0, str.length());
        this.capacity = str.length();
        endIndex = str.isEmpty() ? 0 : str.length() - 1;
    }

    //TESTER METHODS
    public int getStringCharactersSize() {
        return stringCharacters.length;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getLength() {
        return capacity;
    }

    //test
}
