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

# Time Complexity

This table compares the time complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

| **Method**                              | **Java StringBuilder** | **CustomStringBuilder** |     **Winner**      |
|-----------------------------------------|:----------------------:|:-----------------------:|:-------------------:|
| **append(boolean)**                     |          O(1)          |          O(1)           |         Tie         |
| **append(char)**                        |          O(1)          |          O(1)           |         Tie         |
| **append(char[])**                      |          O(k)          |          O(k)           |         Tie         |
| **append(char[], int, int)**            |          O(k)          |          O(k)           |         Tie         |
| **append(CharSequence)**                |          O(k)          |          O(k)           |         Tie         |
| **append(CharSequence, int, int)**      |          O(k)          |          O(k)           |         Tie         |
| **append(double)**                      |          O(1)          |          O(1)           |         Tie         |
| **append(float)**                       |          O(1)          |          O(1)           |         Tie         |
| **append(int)**                         |          O(1)          |          O(1)           |         Tie         |
| **append(long)**                        |          O(1)          |          O(1)           |         Tie         |
| **append(String)**                      |          O(k)          |          O(k)           |         Tie         |
| **delete(int, int)**                    |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **deleteCharAt(int)**                   |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **indexOf(String)**                     |          O(n)          |        O(n + m)         |    StringBuilder    |
| **indexOf(String, int)**                |          O(n)          |        O(n + m)         |    StringBuilder    |
| **insert(int, boolean)**                |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **insert(int, char)**                   |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **insert(int, char[])**                 |        O(n + k)        |        O(m + k)         | CustomStringBuilder |
| **insert(int, char[], int, int)**       |        O(n + k)        |        O(m + k)         | CustomStringBuilder |
| **insert(int, CharSequence)**           |        O(n + k)        |        O(m + k)         | CustomStringBuilder |
| **insert(int, CharSequence, int, int)** |        O(n + k)        |        O(m + k)         | CustomStringBuilder |
| **insert(int, double)**                 |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **insert(int, float)**                  |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **insert(int, int)**                    |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **insert(int, long)**                   |          O(n)          |        O(m + k)         | CustomStringBuilder |
| **insert(int, Object)**                 |        O(n + k)        |        O(m + k)         | CustomStringBuilder |
| **insert(int, String)**                 |        O(n + k)        |        O(m + k)         | CustomStringBuilder |
| **lastIndexOf(String)**                 |          O(n)          |        O(n + m)         |    StringBuilder    |
| **length()**                            |          O(1)          |          O(1)           |         Tie         |
| **replace(int, int, String)**           |        O(n + k)        |        O(m + k)         | CustomStringBuilder |
| **reverse()**                           |          O(n)          |        O(n + m)         |    StringBuilder    |
| **setCharAt(int, char)**                |          O(1)          |          O(m)           |    StringBuilder    |
| **subSequence(int, int)**               |          O(k)          |        O(m + k)         |    StringBuilder    |
| **substring(int)**                      |          O(n)          |        O(n + m)         |    StringBuilder    |
| **substring(int, int)**                 |          O(k)          |        O(m + k)         |    StringBuilder    |
| **toString()**                          |          O(n)          |          O(n)           |         Tie         |

# Space Complexity

This table compares the space complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

| **Method**                              | **Java StringBuilder** | **CustomStringBuilder** |  **Winner**   |
|-----------------------------------------|:----------------------:|:-----------------------:|:-------------:|
| **append(boolean)**                     |          O(1)          |          O(1)           |      Tie      |
| **append(char)**                        |          O(1)          |          O(1)           |      Tie      |
| **append(char[])**                      |          O(k)          |          O(k)           |      Tie      |
| **append(char[], int, int)**            |          O(k)          |          O(k)           |      Tie      |
| **append(CharSequence)**                |          O(k)          |          O(k)           |      Tie      |
| **append(CharSequence, int, int)**      |          O(k)          |          O(k)           |      Tie      |
| **append(double)**                      |          O(1)          |          O(1)           |      Tie      |
| **append(float)**                       |          O(1)          |          O(1)           |      Tie      |
| **append(int)**                         |          O(1)          |          O(1)           |      Tie      |
| **append(long)**                        |          O(1)          |          O(1)           |      Tie      |
| **append(String)**                      |          O(k)          |          O(k)           |      Tie      |
| **delete(int, int)**                    |          O(1)          |        O(m + k)         | StringBuilder |
| **deleteCharAt(int)**                   |          O(1)          |        O(m + k)         | StringBuilder |
| **indexOf(String)**                     |          O(1)          |        O(n + m)         | StringBuilder |
| **indexOf(String, int)**                |          O(1)          |        O(n + m)         | StringBuilder |
| **insert(int, boolean)**                |          O(1)          |        O(m + k)         | StringBuilder |
| **insert(int, char)**                   |          O(1)          |        O(m + k)         | StringBuilder |
| **insert(int, char[])**                 |          O(k)          |        O(m + k)         | StringBuilder |
| **insert(int, char[], int, int)**       |          O(k)          |        O(m + k)         | StringBuilder |
| **insert(int, CharSequence)**           |          O(k)          |        O(m + k)         | StringBuilder |
| **insert(int, CharSequence, int, int)** |          O(k)          |        O(m + k)         | StringBuilder |
| **insert(int, double)**                 |          O(1)          |        O(m + k)         | StringBuilder |
| **insert(int, float)**                  |          O(1)          |        O(m + k)         | StringBuilder |
| **insert(int, int)**                    |          O(1)          |        O(m + k)         | StringBuilder |
| **insert(int, long)**                   |          O(1)          |        O(m + k)         | StringBuilder |
| **insert(int, Object)**                 |          O(k)          |        O(m + k)         | StringBuilder |
| **insert(int, String)**                 |          O(k)          |        O(m + k)         | StringBuilder |
| **lastIndexOf(String)**                 |          O(1)          |        O(n + m)         | StringBuilder |
| **length()**                            |          O(1)          |          O(1)           |      Tie      |
| **replace(int, int, String)**           |          O(k)          |        O(m + k)         | StringBuilder |
| **reverse()**                           |          O(1)          |        O(n + m)         | StringBuilder |
| **setCharAt(int, char)**                |          O(1)          |        O(m + k)         | StringBuilder |
| **subSequence(int, int)**               |          O(k)          |        O(m + k)         | StringBuilder |
| **substring(int)**                      |          O(n)          |        O(n + m)         | StringBuilder |
| **substring(int, int)**                 |          O(k)          |        O(m + k)         | StringBuilder |
| **toString()**                          |          O(n)          |          O(n)           |      Tie      |

## Notes
- **Variables**:
  - **n**: Total length of the string (sum of all characters).
  - **m**: Number of string segments in `CustomStringBuilder`'s `ArrayList`.
  - **k**: Length of the input string or subsequence.

# Performance Charts

## Custom String Builder vs String Builder
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/StringBuilder(CharSequence).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(boolean).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(char).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(char[]).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(char%5B%5D,%20int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(CharSequence).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(CharSequence,%20int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(double).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(float).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(long).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(String).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20char%5B%5D).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20char%5B%5D,%20int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20CharSequence).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20CharSequence,%20int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20double).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20float).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20long).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20Object).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20String).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/delete(int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/deleteCharAt(int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/replace(int,%20int,%20String).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/reverse().png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/indexOf(String).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/indexOf(String,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/lastIndexOf(String).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/setCharAt(int,%20char).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/subSequence(int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/substring(int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/substring(int,%20int).png)
![Combined Performance Charts](PerformanceTesting/CompareCustomStringBuilderToStringBuilder/length().png)


































