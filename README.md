# Custom String Builder

Implementation of a StringBuilder using a List

# Time Complexity

This table compares the time complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

| **Method**                              | **Java StringBuilder** | **CustomStringBuilder** |     **Winner**      |
|-----------------------------------------|:----------------------:|:-----------------------:|:-------------------:|
| **append(boolean)**                     |         $O(1)$         |         $O(1)$          |         Tie         |
| **append(char)**                        |         $O(1)$         |         $O(1)$          |         Tie         |
| **append(char[])**                      |         $O(k)$         |         $O(k)$          |         Tie         |
| **append(char[], int, int)**            |         $O(k)$         |         $O(k)$          |         Tie         |
| **append(CharSequence)**                |         $O(k)$         |         $O(k)$          |         Tie         |
| **append(CharSequence, int, int)**      |         $O(k)$         |         $O(k)$          |         Tie         |
| **append(double)**                      |         $O(1)$         |         $O(1)$          |         Tie         |
| **append(float)**                       |         $O(1)$         |         $O(1)$          |         Tie         |
| **append(int)**                         |         $O(1)$         |         $O(1)$          |         Tie         |
| **append(long)**                        |         $O(1)$         |         $O(1)$          |         Tie         |
| **append(String)**                      |         $O(k)$         |         $O(k)$          |         Tie         |
| **delete(int, int)**                    |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **deleteCharAt(int)**                   |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **indexOf(String)**                     |         $O(n)$         |       $O(n + m)$        |    StringBuilder    |
| **indexOf(String, int)**                |         $O(n)$         |       $O(n + m)$        |    StringBuilder    |
| **insert(int, boolean)**                |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, char)**                   |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, char[])**                 |       $O(n + k)$       |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, char[], int, int)**       |       $O(n + k)$       |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, CharSequence)**           |       $O(n + k)$       |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, CharSequence, int, int)** |       $O(n + k)$       |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, double)**                 |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, float)**                  |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, int)**                    |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, long)**                   |         $O(n)$         |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, Object)**                 |       $O(n + k)$       |       $O(m + k)$        | CustomStringBuilder |
| **insert(int, String)**                 |       $O(n + k)$       |       $O(m + k)$        | CustomStringBuilder |
| **lastIndexOf(String)**                 |         $O(n)$         |       $O(n + m)$        |    StringBuilder    |
| **length()**                            |         $O(1)$         |         $O(1)$          |         Tie         |
| **replace(int, int, String)**           |       $O(n + k)$       |       $O(m + k)$        | CustomStringBuilder |
| **reverse()**                           |         $O(n)$         |       $O(n + m)$        |    StringBuilder    |
| **setCharAt(int, char)**                |         $O(1)$         |         $O(m)$          |    StringBuilder    |
| **subSequence(int, int)**               |         $O(k)$         |       $O(m + k)$        |    StringBuilder    |
| **substring(int)**                      |         $O(n)$         |       $O(n + m)$        |    StringBuilder    |
| **substring(int, int)**                 |         $O(k)$         |       $O(m + k)$        |    StringBuilder    |
| **toString()**                          |         $O(n)$         |         $O(n)$          |         Tie         |

# Space Complexity

This table compares the space complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

| **Method**                              | **Java StringBuilder** | **CustomStringBuilder** |  **Winner**   |
|-----------------------------------------|:----------------------:|:-----------------------:|:-------------:|
| **append(boolean)**                     |         $O(1)$         |         $O(1)$          |      Tie      |
| **append(char)**                        |         $O(1)$         |         $O(1)$          |      Tie      |
| **append(char[])**                      |         $O(k)$         |         $O(k)$          |      Tie      |
| **append(char[], int, int)**            |         $O(k)$         |         $O(k)$          |      Tie      |
| **append(CharSequence)**                |         $O(k)$         |         $O(k)$          |      Tie      |
| **append(CharSequence, int, int)**      |         $O(k)$         |         $O(k)$          |      Tie      |
| **append(double)**                      |         $O(1)$         |         $O(1)$          |      Tie      |
| **append(float)**                       |         $O(1)$         |         $O(1)$          |      Tie      |
| **append(int)**                         |         $O(1)$         |         $O(1)$          |      Tie      |
| **append(long)**                        |         $O(1)$         |         $O(1)$          |      Tie      |
| **append(String)**                      |         $O(k)$         |         $O(k)$          |      Tie      |
| **delete(int, int)**                    |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **deleteCharAt(int)**                   |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **indexOf(String)**                     |         $O(1)$         |       $O(n + m)$        | StringBuilder |
| **indexOf(String, int)**                |         $O(1)$         |       $O(n + m)$        | StringBuilder |
| **insert(int, boolean)**                |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, char)**                   |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, char[])**                 |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, char[], int, int)**       |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, CharSequence)**           |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, CharSequence, int, int)** |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, double)**                 |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, float)**                  |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, int)**                    |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, long)**                   |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, Object)**                 |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **insert(int, String)**                 |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **lastIndexOf(String)**                 |         $O(1)$         |       $O(n + m)$        | StringBuilder |
| **length()**                            |         $O(1)$         |         $O(1)$          |      Tie      |
| **replace(int, int, String)**           |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **reverse()**                           |         $O(1)$         |       $O(n + m)$        | StringBuilder |
| **setCharAt(int, char)**                |         $O(1)$         |       $O(m + k)$        | StringBuilder |
| **subSequence(int, int)**               |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **substring(int)**                      |         $O(n)$         |       $O(n + m)$        | StringBuilder |
| **substring(int, int)**                 |         $O(k)$         |       $O(m + k)$        | StringBuilder |
| **toString()**                          |         $O(n)$         |         $O(n)$          |      Tie      |

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


































