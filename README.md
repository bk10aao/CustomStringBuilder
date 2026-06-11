# Custom String Builder

Implementation of a StringBuilder using a List

# Time Complexity

This table compares the time complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

### Time Complexity Comparison: `StringBuilder` vs `CustomStringBuilder`

| Method                              | Standard `StringBuilder` | CustomStringBuilder | Winner                  |
|-------------------------------------|--------------------------|---------------------|-------------------------|
| append(boolean)                     | O(1) amortized           | O(1) amortized      | **Tie**                 |
| append(char)                        | O(1) amortized           | O(1) amortized      | **Tie**                 |
| append(char[])                      | O(k)                     | O(k)                | **Tie**                 |
| append(char[], int, int)            | O(k)                     | O(k)                | **Tie**                 |
| append(CharSequence)                | O(k)                     | O(1) amortized      | **CustomStringBuilder** |
| append(CharSequence, int, int)      | O(k)                     | O(k)                | **Tie**                 |
| append(double)                      | O(1) amortized           | O(1) amortized      | **Tie**                 |
| append(float)                       | O(1) amortized           | O(1) amortized      | **Tie**                 |
| append(int)                         | O(1) amortized           | O(1) amortized      | **Tie**                 |
| append(long)                        | O(1) amortized           | O(1) amortized      | **Tie**                 |
| append(String)                      | O(k)                     | O(1) amortized      | **CustomStringBuilder** |
| append(Object)                      | O(1) amortized           | O(1) amortized      | **Tie**                 |
| insert(int, boolean)                | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, char)                   | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, char[])                 | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, char[], int, int)       | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, CharSequence)           | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, CharSequence, int, int) | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, double)                 | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, float)                  | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, int)                    | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, long)                   | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, Object)                 | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| insert(int, String)                 | O(n)                     | O(1) amortized      | **CustomStringBuilder** |
| delete(int, int)                    | O(n)                     | O(m + f)            | **CustomStringBuilder** |
| deleteCharAt(int)                   | O(n)                     | O(m + f)            | **CustomStringBuilder** |
| replace(int, int, String)           | O(n)                     | O(m + f)            | **CustomStringBuilder** |
| reverse()                           | O(n)                     | O(n)                | **Tie**                 |
| charAt(int)                         | O(1)                     | O(f) amortized      | **StringBuilder**       |
| indexOf(String)                     | O(n)                     | O(n × f) worst      | **StringBuilder**       |
| indexOf(String, int)                | O(n)                     | O(n × f) worst      | **StringBuilder**       |
| lastIndexOf(String)                 | O(n)                     | O(n × f) worst      | **StringBuilder**       |
| setCharAt(int, char)                | O(n)                     | O(m + f)            | **CustomStringBuilder** |
| toString()                          | O(n)                     | O(n)                | **Tie**                 |
| subSequence(int, int)               | O(1)                     | O(n)                | **StringBuilder**       |
| substring(int)                      | O(k)                     | O(n)                | **StringBuilder**       |
| substring(int, int)                 | O(k)                     | O(n)                | **StringBuilder**       |
| length()                            | O(1)                     | O(1)                | **Tie**                 |

**Legend:**
- **n** = current length of the builder
- **k** = number of characters involved in the operation
- **m** = number of characters affected (deleted/replaced)
- **f** = number of fragments (capped at 32)

# Space Complexity

This table compares the space complexity of key methods in Java's `StringBuilder` (using a dynamic character array) and `CustomStringBuilder` (using an `ArrayList<String>`).

### Space Complexity Comparison: `StringBuilder` vs `CustomStringBuilder`

| Method                                      | Standard `StringBuilder` Space     | CustomStringBuilder Space                  | Winner                  |
|---------------------------------------------|------------------------------------|--------------------------------------------|-------------------------|
| append(boolean)                             | O(1) amortized                     | O(1)                                       | **Tie**                 |
| append(char)                                | O(1) amortized                     | O(1)                                       | **Tie**                 |
| append(char[])                              | O(k)                               | O(k)                                       | **Tie**                 |
| append(char[], int, int)                    | O(k)                               | O(k)                                       | **Tie**                 |
| append(CharSequence)                        | O(k)                               | O(1)                                       | **CustomStringBuilder** |
| append(CharSequence, int, int)              | O(k)                               | O(k)                                       | **Tie**                 |
| append(double)                              | O(1) amortized                     | O(1)                                       | **Tie**                 |
| append(float)                               | O(1) amortized                     | O(1)                                       | **Tie**                 |
| append(int)                                 | O(1) amortized                     | O(1)                                       | **Tie**                 |
| append(long)                                | O(1) amortized                     | O(1)                                       | **Tie**                 |
| append(String)                              | O(k)                               | O(1)                                       | **CustomStringBuilder** |
| append(Object)                              | O(1) amortized                     | O(1)                                       | **Tie**                 |
| insert(int, boolean)                        | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, char)                           | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, char[])                         | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, char[], int, int)               | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, CharSequence)                   | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, CharSequence, int, int)         | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, double)                         | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, float)                          | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, int)                            | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, long)                           | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, Object)                         | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| insert(int, String)                         | O(n)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| delete(int, int)                            | O(1)                               | O(1)                                       | **Tie**                 |
| deleteCharAt(int)                           | O(1)                               | O(1)                                       | **Tie**                 |
| replace(int, int, String)                   | O(1)                               | O(1) + O(m)                                | **CustomStringBuilder** |
| reverse()                                   | O(n)                               | O(n)                                       | **Tie**                 |
| charAt(int)                                 | O(1)                               | O(1)                                       | **Tie**                 |
| indexOf(String)                             | O(1)                               | O(1)                                       | **Tie**                 |
| indexOf(String, int)                        | O(1)                               | O(1)                                       | **Tie**                 |
| lastIndexOf(String)                         | O(1)                               | O(1)                                       | **Tie**                 |
| setCharAt(int, char)                        | O(1)                               | O(1)                                       | **Tie**                 |
| toString()                                  | O(n)                               | O(n)                                       | **Tie**                 |
| subSequence(int, int)                       | O(1)                               | O(n)                                       | **StringBuilder**       |
| substring(int)                              | O(k)                               | O(n)                                       | **StringBuilder**       |
| substring(int, int)                         | O(k)                               | O(n)                                       | **StringBuilder**       |
| length()                                    | O(1)                               | O(1)                                       | **Tie**                 |

**Legend:**
- **n** = current total length of the builder
- **k** = length of the input string/sequence being added
- **m** = length of the new string being inserted/replaced
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

























## Performance Charts

**Custom String Builder vs String Builder** (optimized for GitHub Dark Mode)

<svg width="100%" height="auto" viewBox="0 0 1200 8500" xmlns="http://www.w3.org/2000/svg" style="max-width:100%; border-radius:12px;">
  <rect width="100%" height="100%" fill="#0d1117" rx="12"/>
  <foreignObject width="100%" height="100%" x="0" y="0">
    <div xmlns="http://www.w3.org/1999/xhtml" style="padding:40px 30px; font-family:-apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,sans-serif; color:#c9d1d9; background:#0d1117; border-radius:12px;">
      
      <h3 style="color:#58a6ff; margin:0 0 25px 0; text-align:center;">Performance Charts</h3>
      <p style="color:#8b949e; text-align:center; margin-bottom:30px;">CustomStringBuilder vs StringBuilder</p>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/StringBuilder(CharSequence).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="Combined Performance Charts"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(boolean).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(boolean)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(char).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(char)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(char[]).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(char[])"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(char%5B%5D,%20int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(char[], int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(CharSequence).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(CharSequence)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(CharSequence,%20int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(CharSequence, int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(double).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(double)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(float).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(float)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(long).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(long)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/append(String).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="append(String)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20char%5B%5D).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, char[])"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20char%5B%5D,%20int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, char[], int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20CharSequence).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, CharSequence)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20CharSequence,%20int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, CharSequence, int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20double).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, double)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20float).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, float)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20long).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, long)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20Object).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, Object)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/insert(int,%20String).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="insert(int, String)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/delete(int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="delete(int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/deleteCharAt(int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="deleteCharAt(int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/replace(int,%20int,%20String).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="replace(int, int, String)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/reverse().png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="reverse()"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/indexOf(String).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="indexOf(String)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/indexOf(String,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="indexOf(String, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/lastIndexOf(String).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="lastIndexOf(String)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/setCharAt(int,%20char).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="setCharAt(int, char)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/subSequence(int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="subSequence(int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/substring(int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="substring(int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/substring(int,%20int).png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="substring(int, int)"/>

      <img src="PerformanceTesting/CompareCustomStringBuilderToStringBuilder/length().png#gh-dark-mode-only" style="max-width:100%; height:auto; margin:15px 0; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.3);" alt="length()"/>

      <p style="margin-top:40px; font-size:0.9em; color:#8b949e; text-align:center;">
        All charts displayed with forced dark background for optimal viewing on GitHub.
      </p>
    </div>
  </foreignObject>
</svg>








