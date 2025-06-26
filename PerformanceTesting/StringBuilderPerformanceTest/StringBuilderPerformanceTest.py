import matplotlib.pyplot as plt
import numpy as np
import csv

sizes = []
append_times = []
insert_times = []
delete_times = []
replace_times = []
reverse_times = []
index_of_times = []
last_index_of_times = []
to_string_times = []
substring_times = []

with open('/Users/drpsychoben/PycharmProjects/StringBuilderCharts/StringBuilder/StringBuilder_performance.csv', 'r') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        sizes.append(int(row['Size']))
        append_times.append(int(row['Append']))
        insert_times.append(int(row['Insert']))
        delete_times.append(int(row['Delete']))
        replace_times.append(int(row['Replace']))
        reverse_times.append(int(row['Reverse']))
        index_of_times.append(int(row['IndexOf']))
        last_index_of_times.append(int(row['LastIndexOf']))
        to_string_times.append(int(row['ToString']))
        substring_times.append(int(row['Substring']))

# Convert lists to numpy arrays
sizes = np.array(sizes)
append_times = np.array(append_times)
insert_times = np.array(insert_times)
delete_times = np.array(delete_times)
replace_times = np.array(replace_times)
reverse_times = np.array(reverse_times)
index_of_times = np.array(index_of_times)
last_index_of_times = np.array(last_index_of_times)
to_string_times = np.array(to_string_times)
substring_times = np.array(substring_times)

methods = [
    ("append", append_times),
    ("insert", insert_times),
    ("delete", delete_times),
    ("replace", replace_times),
    ("reverse", reverse_times),
    ("indexOf", index_of_times),
    ("lastIndexOf", last_index_of_times),
    ("toString", to_string_times),
    ("substring", substring_times),
]

for method_name, times in methods:
    plt.figure(figsize=(10, 6))
    plt.plot(sizes, times, marker='', linestyle='-', label=method_name, linewidth=1.5)
    plt.xlabel('Input Size')
    plt.ylabel('Time (ns)')
    plt.title(f'StringBuilder.{method_name} Performance')
    plt.grid(True)
    plt.legend()
    plt.savefig(f'{method_name}_performance.png')
    plt.close()

print("Charts generated: " + ", ".join(f"{name}_performance.png" for name, _ in methods))
