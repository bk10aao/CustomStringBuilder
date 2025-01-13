public interface StringBuilderInterface {

    CustomStringBuilder append(boolean b);
    CustomStringBuilder append(char c);
    CustomStringBuilder append(char[] str);
    CustomStringBuilder append(char[] str, int offset, int len);
    CustomStringBuilder append(CharSequence charSequence);
    CustomStringBuilder append(CharSequence charSequence, int start, int end);
    CustomStringBuilder append(int i);
    CustomStringBuilder append(long lng);
    CustomStringBuilder append(float f);
    CustomStringBuilder append(double d);
    CustomStringBuilder delete(int start, int end);
    CustomStringBuilder deleteCharAt(int index);
    int indexOf(String str);
    int lastIndexOf(String str);
    int indexOf(String str, int fromIndex);
    CustomStringBuilder insert(int index, String str);
    int length();
    CustomStringBuilder replace(int start, int end, String str);
    CustomStringBuilder reverse();
    void setCharAt(int index, char c);
    CharSequence subSequence(int start, int end);
    String subString(int start);
    String subString(int start, int end);
    String toString();
}
