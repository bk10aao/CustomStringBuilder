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

    int length();

    String toString();
}
