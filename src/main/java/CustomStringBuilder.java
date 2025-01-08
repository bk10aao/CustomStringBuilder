import java.util.ArrayList;
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

    @Override
    public String toString() {
        String str = "";
        for(String s : stringBuilder) {
            str += s;
        }
        return str;
    }

    public int length() {
        return size;
    }
}
