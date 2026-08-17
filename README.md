# Custom String Builder

Implementation of a StringBuilder using a List

# Time Complexity

This table compares the time complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

### Time Complexity

| Method                              |   JDK    |    Custom    |          Winner           |
|:------------------------------------|:--------:|:------------:|:-------------------------:|
| append(boolean)                     |  $O(1)$  |    $O(1)$    |          **Tie**          |
| append(char)                        |  $O(1)$  |    $O(1)$    |          **Tie**          |
| append(char[])                      |  $O(k)$  |    $O(k)$    |          **Tie**          |
| append(char[], int, int)            |  $O(k)$  |    $O(k)$    |          **Tie**          |
| append(CharSequence)                |  $O(k)$  |    $O(1)$    |  **CustomStringBuilder**  |
| append(CharSequence, int, int)      |  $O(k)$  |    $O(k)$    |          **Tie**          |
| append(double)                      |  $O(1)$  |    $O(1)$    |          **Tie**          |
| append(float)                       |  $O(1)$  |    $O(1)$    |          **Tie**          |
| append(int)                         |  $O(1)$  |    $O(1)$    |          **Tie**          |
| append(long)                        |  $O(1)$  |    $O(1)$    |          **Tie**          |
| append(String)                      |  $O(k)$  |    $O(1)$    |  **CustomStringBuilder**  |
| append(Object)                      |  $O(1)$  |    $O(1)$    |          **Tie**          |
| insert(int, boolean)                |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, char)                   |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, char[])                 |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, char[], int, int)       |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, CharSequence)           |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, CharSequence, int, int) |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, double)                 |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, float)                  |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, int)                    |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, long)                   |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, Object)                 |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| insert(int, String)                 |  $O(n)$  |    $O(1)$    |  **CustomStringBuilder**  |
| delete(int, int)                    |  $O(n)$  |  $O(m + f)$  |  **CustomStringBuilder**  |
| deleteCharAt(int)                   |  $O(n)$  |  $O(m + f)$  |  **CustomStringBuilder**  |
| replace(int, int, String)           |  $O(n)$  |  $O(m + f)$  |  **CustomStringBuilder**  |
| reverse()                           |  $O(n)$  |    $O(n)$    |          **Tie**          |
| charAt(int)                         |  $O(1)$  |    $O(f)$    |     **StringBuilder**     |
| indexOf(String)                     |  $O(n)$  |  $O(n × f)$  |     **StringBuilder**     |
| indexOf(String, int)                |  $O(n)$  |  $O(n × f)$  |     **StringBuilder**     |
| lastIndexOf(String)                 |  $O(n)$  |  $O(n × f)$  |     **StringBuilder**     |
| setCharAt(int, char)                |  $O(n)$  |  $O(m + f)$  |  **CustomStringBuilder**  |
| toString()                          |  $O(n)$  |    $O(n)$    |          **Tie**          |
| subSequence(int, int)               |  $O(1)$  |    $O(n)$    |     **StringBuilder**     |
| substring(int)                      |  $O(k)$  |    $O(n)$    |     **StringBuilder**     |
| substring(int, int)                 |  $O(k)$  |    $O(n)$    |     **StringBuilder**     |
| length()                            |  $O(1)$  |    $O(1)$    |          **Tie**          |

- $n$ = current length of the builder
- $k$ = number of characters involved in the operation
- $m$ = number of characters affected (deleted/replaced)
- $f$ = number of fragments (capped at 32)

# Space Complexity

This table compares the space complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

### Space Complexity

| Method                               |  JDK   |    Custom     |         Winner          |
|:-------------------------------------|:------:|:-------------:|:-----------------------:|
| append(boolean)                      | $O(1)$ |    $O(1)$     |         **Tie**         |
| append(char)                         | $O(1)$ |    $O(1)$     |         **Tie**         |
| append(char[])                       | $O(k)$ |    $O(k)$     |         **Tie**         |
| append(char[], int, int)             | $O(k)$ |    $O(k)$     |         **Tie**         |
| append(CharSequence)                 | $O(k)$ |    $O(1)$     | **CustomStringBuilder** |
| append(CharSequence, int, int)       | $O(k)$ |    $O(k)$     |         **Tie**         |
| append(double)                       | $O(1)$ |    $O(1)$     |         **Tie**         |
| append(float)                        | $O(1)$ |    $O(1)$     |         **Tie**         |
| append(int)                          | $O(1)$ |    $O(1)$     |         **Tie**         |
| append(long)                         | $O(1)$ |    $O(1)$     |         **Tie**         |
| append(String)                       | $O(k)$ |    $O(1)$     | **CustomStringBuilder** |
| append(Object)                       | $O(1)$ |    $O(1)$     |         **Tie**         |
| insert(int, boolean)                 | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, char)                    | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, char[])                  | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, char[], int, int)        | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, CharSequence)            | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, CharSequence, int, int)  | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, double)                  | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, float)                   | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, int)                     | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, long)                    | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, Object)                  | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| insert(int, String)                  | $O(n)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| delete(int, int)                     | $O(1)$ |    $O(1)$     |         **Tie**         |
| deleteCharAt(int)                    | $O(1)$ |    $O(1)$     |         **Tie**         |
| replace(int, int, String)            | $O(1)$ | $O(1) + O(m)$ | **CustomStringBuilder** |
| reverse()                            | $O(n)$ |    $O(n)$     |         **Tie**         |
| charAt(int)                          | $O(1)$ |    $O(1)$     |         **Tie**         |
| indexOf(String)                      | $O(1)$ |    $O(1)$     |         **Tie**         |
| indexOf(String, int)                 | $O(1)$ |    $O(1)$     |         **Tie**         |
| lastIndexOf(String)                  | $O(1)$ |    $O(1)$     |         **Tie**         |
| setCharAt(int, char)                 | $O(1)$ |    $O(1)$     |         **Tie**         |
| toString()                           | $O(n)$ |    $O(n)$     |         **Tie**         |
| subSequence(int, int)                | $O(1)$ |    $O(n)$     |    **StringBuilder**    |
| substring(int)                       | $O(k)$ |    $O(n)$     |    **StringBuilder**    |
| substring(int, int)                  | $O(k)$ |    $O(n)$     |    **StringBuilder**    |
| length()                             | $O(1)$ |    $O(1)$     |         **Tie**         |

- $n$ = current total length of the builder
- $k$ = length of the input string/sequence being added
- $m$ = length of the new string being inserted/replaced

# Performance Charts

## Custom String Builder vs String Builder

| Method                                | Custom (ns/op) | JDK (ns/op) |            Winner            |  Margin   |
|:--------------------------------------|:--------------:|:-----------:|:----------------------------:|:---------:|
| `append(boolean)`                     |       11       |     3.1     |           **JDK**            |   3.55x   |
| `append(char)`                        |       13       |     3.0     |           **JDK**            |   4.23x   |
| `append(char[])`                      |     2,061      |   14,078    |          **Custom**          |   6.83x   |
| `append(char[], int, int)`            |       14       |     6.1     |           **JDK**            |   2.23x   |
| `append(CharSequence)`                |       10       |    1,664    |          **Custom**          |  161.57x  |
| `append(CharSequence, int, int)`      |       13       |     5.2     |           **JDK**            |   2.50x   |
| `append(double)`                      |       34       |     55      |          **Custom**          |   1.60x   |
| `append(float)`                       |       32       |     59      |          **Custom**          |   1.83x   |
| `append(int)`                         |       13       |     3.0     |           **JDK**            |   4.40x   |
| `append(long)`                        |       18       |     11      |           **JDK**            |   1.59x   |
| `append(Object)`                      |       11       |     3.0     |           **JDK**            |   3.53x   |
| `append(String)`                      |       10       |    1,634    |          **Custom**          |  160.24x  |
| `charAt(int)`                         |      1.0       |    1,562    |          **Custom**          | 1,562.20x |
| `compareTo(StringBuilder)`            |     6,984      |    5,488    |           **JDK**            |   1.27x   |
| `constructor(CharSequence)`           |       10       |    1,688    |          **Custom**          |  167.09x  |
| `constructor()`                       |      3.0       |     3.0     | **Statistically Equivalent** |   1.00x   |
| `constructor(String)`                 |       10       |    1,681    |          **Custom**          |  168.06x  |
| `delete(int, int)`                    |     1,807      |    2,322    |          **Custom**          |   1.28x   |
| `deleteCharAt(int)`                   |     1,824      |    2,274    |          **Custom**          |   1.25x   |
| `equals(Object)`                      |     5,240      |    3,248    |           **JDK**            |   1.61x   |
| `hashCode()`                          |     51,496     |    1,786    |           **JDK**            |  28.83x   |
| `indexOf(String)`                     |      2.0       |    1,660    |          **Custom**          |  829.95x  |
| `indexOf(String, int)`                |      2.1       |    1,628    |          **Custom**          |  775.19x  |
| `insert(int, boolean)`                |     1,845      |    2,388    |          **Custom**          |   1.29x   |
| `insert(int, char)`                   |     1,814      |    2,383    |          **Custom**          |   1.31x   |
| `insert(int, char[])`                 |     1,797      |    2,463    |          **Custom**          |   1.37x   |
| `insert(int, char[], int, int)`       |     1,822      |    2,404    |          **Custom**          |   1.32x   |
| `insert(int, CharSequence)`           |     1,822      |    2,422    |          **Custom**          |   1.33x   |
| `insert(int, CharSequence, int, int)` |     1,832      |    2,399    |          **Custom**          |   1.31x   |
| `insert(int, double)`                 |     1,818      |    2,465    |          **Custom**          |   1.36x   |
| `insert(int, float)`                  |     1,815      |    2,446    |          **Custom**          |   1.35x   |
| `insert(int, int)`                    |     1,816      |    2,417    |          **Custom**          |   1.33x   |
| `insert(int, long)`                   |     1,824      |    2,445    |          **Custom**          |   1.34x   |
| `insert(int, Object)`                 |     1,823      |    2,402    |          **Custom**          |   1.32x   |
| `insert(int, String)`                 |     1,801      |    2,369    |          **Custom**          |   1.32x   |
| `lastIndexOf(String)`                 |       25       |    1,598    |          **Custom**          |  63.92x   |
| `length()`                            |      1.0       |    1,569    |          **Custom**          | 1,568.90x |
| `replace(int, int, String)`           |     1,906      |    2,359    |          **Custom**          |   1.24x   |
| `reverse()`                           |     16,719     |   11,161    |           **JDK**            |   1.50x   |
| `setCharAt(int, char)`                |     1,877      |    1,625    |           **JDK**            |   1.16x   |
| `subSequence(int, int)`               |     4,348      |    1,635    |           **JDK**            |   2.66x   |
| `substring(int)`                      |     5,676      |    2,856    |           **JDK**            |   1.99x   |
| `substring(int, int)`                 |     4,714      |    1,608    |           **JDK**            |   2.93x   |
| `toString()`                          |     1,538      |     2.0     |           **JDK**            |  769.25x  |

#### Note: The following performance charts are designed to be viewed in dark mode.

![Heatmap](PerformanceTesting/heatmap.png)
![Combined Performance Charts](PerformanceTesting/plot_constructor__.png)
![Combined Performance Charts](PerformanceTesting/plot_constructor_CharSequence_.png)
![Combined Performance Charts](PerformanceTesting/plot_constructor_String_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_CharSequence_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_CharSequence_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_Object_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_String_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_boolean_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_char_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_char[]_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_char[]_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_double_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_float_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_append_long_.png)
![Combined Performance Charts](PerformanceTesting/plot_charAt_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_compareTo_StringBuilder_.png)
![Combined Performance Charts](PerformanceTesting/plot_delete_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_deleteCharAt_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_equals_Object_.png)
![Combined Performance Charts](PerformanceTesting/plot_hashCode__.png)
![Combined Performance Charts](PerformanceTesting/plot_indexOf_String_.png)
![Combined Performance Charts](PerformanceTesting/plot_indexOf_String_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_CharSequence_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_CharSequence_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_Object_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_String_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_boolean_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_char_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_char[]_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_char[]_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_double_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_float_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_insert_int_long_.png)
![Combined Performance Charts](PerformanceTesting/plot_lastIndexOf_String_.png)
![Combined Performance Charts](PerformanceTesting/plot_length__.png)
![Combined Performance Charts](PerformanceTesting/plot_replace_int_int_String_.png)
![Combined Performance Charts](PerformanceTesting/plot_reverse__.png)
![Combined Performance Charts](PerformanceTesting/plot_setCharAt_int_char_.png)
![Combined Performance Charts](PerformanceTesting/plot_subSequence_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_substring_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_substring_int_int_.png)
![Combined Performance Charts](PerformanceTesting/plot_toString__.png)