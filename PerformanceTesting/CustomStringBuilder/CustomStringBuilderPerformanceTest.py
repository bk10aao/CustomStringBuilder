import matplotlib.pyplot as plt
import numpy as np
import csv
from collections import defaultdict

filename = '/Users/drpsychoben/PycharmProjects/StringBuilderCharts/CustomStringBuilder/CustomStringBuilder_performance.csv'

# Maps size -> method name -> list of times
size_to_times = defaultdict(lambda: defaultdict(list))

with open(filename, 'r') as csvfile:
    reader = csv.DictReader(csvfile, delimiter=';')

    # Strip quotes from fieldnames
    raw_headers = [h.strip().strip('"') for h in reader.fieldnames]
    method_names_raw = [h for h in raw_headers if h.lower() != 'size']

    for row in reader:
        size_str = row['Size'].strip().strip('"')
        try:
            size = int(size_str)
        except ValueError:
            continue

        for method in method_names_raw:
            val_str = row.get(f'"{method}"') or row.get(method) or ''
            try:
                val = int(val_str.strip().strip('"'))
            except ValueError:
                val = 0
            size_to_times[size][method].append(val)

# Aggregate: compute average times per method per input size
sizes = sorted(size_to_times.keys())
method_times = {method: [] for method in method_names_raw}

for size in sizes:
    for method in method_names_raw:
        values = size_to_times[size][method]
        avg = sum(values) / len(values) if values else 0
        method_times[method].append(avg)

# Plotting
sizes_np = np.array(sizes)

for method, times in method_times.items():
    times_np = np.array(times)
    if len(times_np) != len(sizes_np):
        print(f"Skipping {method}: mismatched data length ({len(times_np)} vs {len(sizes_np)})")
        continue

    plt.figure(figsize=(10, 6))
    plt.plot(sizes_np, times_np, linestyle='-', label=method, linewidth=1.5)
    plt.xlabel('Input Size')
    plt.ylabel('Time (ns)')
    plt.title(f'{method} Performance')
    plt.grid(True)
    plt.tight_layout()
    plt.savefig(f'{method.replace(" ", "_").replace("(", "").replace(")", "")}_performance.png')
    plt.close()

print("✅ Charts generated for all methods.")
