# Custom String Builder

Implementation of a StringBuilder using a List

# Methods
1. `CustomStringBuilder()` - constructor.
2. `CustomStringBuilder(final CharSequence seq)` - constructor.
3. `CustomStringBuilder(final String str)` - constructor.
4. `CustomStringBuilder append(boolean b);` - append boolean to CustomStringBuilder. Returns CustomStringBuilder.
5. `CustomStringBuilder append(char c)` - append char to CustomStringBuilder. Returns CustomStringBuilder.
6. `CustomStringBuilder append(char[] str)` - append char[] to CustomStringBuilder. Returns CustomStringBuilder.
7. `CustomStringBuilder append(char[] str, int offset, int len)` - appends substring of str from offset to len. Returns CustomStringBuilder.
8. `CustomStringBuilder append(CharSequence charSequence)` - append char sequence to CustomStringBuilder. Returns CustomStringBuilder.
9. `CustomStringBuilder append(CharSequence charSequence, int start, int end)` - appends substring of charSequence from offset to len. Throws IndexOutOfBoundsException if start < 0, start > size or start > end.
10. `CustomStringBuilder append(int i)` - append integer to CustomStringBuilder. Returns CustomStringBuilder.
11. `CustomStringBuilder append(long lng)` - append long to CustomStringBuilder. Returns CustomStringBuilder.
12. `CustomStringBuilder append(double d)` - append double to CustomStringBuilder. Returns CustomStringBuilder.
13. `CustomStringBuilder append(float f)` - append float to CustomStringBuilder. Returns CustomStringBuilder.
14. `CustomStringBuilder append(String str)` - append String to CustomStringBuilder. Returns CustomStringBuilder.
15. `CustomStringBuilder delete(int start, int end)` = delete range of characters from CustomStringBuilder. Throws StringIndexOutOfBoundsException if start < 0, start >= length() or start > end.
16. `CustomStringBuilder deleteCharAt(int index)` - delete char at index. returns CustomStringBuilder. Throws StringIndexOutOfBoundsException is index < 0 or index >= size.
17. `int indexOf(String str)` - returns index of String in CustomStringBuilder, else -1.
18. `int indexOf(String str, int fromIndex)` - returns index of String from fromIndex if present, else -1.
19. `int lastIndexOf(String str);` - return last index of String if present else -1.
20. `CustomStringBuilder insert(int index, char[] str, int offset, int len)` - Insert String from char array into CustomStringBuilder, returns CustomStringBuilder. Throws StringIndexOutOfBoundsException if offset < 0 or offset > size.
21. `CustomStringBuilder insert(int dstOffset, CharSequence s)` - insert CharSequence into CustomStringBuilder at index, returns CustomStringBuilderThrows IndexOutOfBoundsException - if offset greater than size.
22. `CustomStringBuilder insert(int dstOffset, CharSequence s, int start, int end)` - Insert sub CharSequence at given index, returns CustomStringBuilder.  Throws IndexOutOfBoundsException if offset greater than size.
23. `CustomStringBuilder insert(int offset, boolean b)` - insert boolean into CustomStringBuilder, returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
24. `CustomStringBuilder insert(int offset, char c)` - insert char into CustomStringBuilder, returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
25. `CustomStringBuilder insert(int offset, double d)` - insert double into CustomStringBuilder returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
26. `CustomStringBuilder insert(int offset, float f)` - insert float into CustomStringBuilder returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
27. `CustomStringBuilder insert(int offset, int i)` - insert integer into CustomStringBuilder returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
28. `CustomStringBuilder insert(int offset, long l)` - insert long into CustomStringBuilder returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
29. `CustomStringBuilder insert(int offset, Object o)` - insert Object into CustomStringBuilder returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
30. `CustomStringBuilder insert(int offset, String str)` - insert String into CustomStringBuilder returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
31. `CustomStringBuilder insert(int offset, char[] str)` - insert Char[] as String into CustomStringBuilder returns CustomStringBuilder. Throws IndexOutOfBoundsException if offset greater than CustomStringBuilder size.
32. `int length();` - returns the length of CustomStringBuilder.
33. `CustomStringBuilder replace(int start, int end, String str)` - replace range of String in CustomStringBuilder with new String returns CustomStringBuilder. Throws StringIndexOutOfBoundsException if start < 0, start > size or start > end.
34. `CustomStringBuilder reverse()` - return String of reverse of String from CustomStringBuilder.
35. `void setCharAt(int index, char c)` - set char at Index to new char. Throws StringIndexOutOfBoundsException if index < 0 or index > size.
36. `CharSequence subSequence(int start, int end)` - Get CharSubsequence from CustomStringBuilder. Returns CharSubsequence of CustomStringBuilder range. Throws StringIndexOutOfBoundsException if start < 0 or start > size.
37. `String subString(int start)` - get substring from CustomStringBuilder from start index. Throws StringIndexOutOfBoundsException if start < 0 or start > size.
38. `String subString(int start, int end)` - get substring from CustomStringBuilder from start index to end index. Throws StringIndexOutOfBoundsException if start < 0, start > size or start > end.
39. `String toString()` - return String representation of CustomStringBuilder.

40. ![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/All_Performance_Comparisons.png)