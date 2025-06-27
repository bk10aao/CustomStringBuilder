import matplotlib.pyplot as plt
import numpy as np
import csv

def read_csv(filename):
    data = {}
    with open(filename, 'r') as f:
        reader = csv.DictReader(f)
        for row in reader:
            size = int(row['Size'])
            for key, value in row.items():
                if key == 'Size':
                    continue
                if key not in data:
                    data[key] = []
                data[key].append((size, int(value)))
    return data

# Load data from both CSVs
custom_data = read_csv('/Users/drpsychoben/PycharmProjects/StringBuilderCharts/Compare/CustomStringBuilder_performance.csv')
stringbuilder_data = read_csv('/Users/drpsychoben/PycharmProjects/StringBuilderCharts/Compare/StringBuilder_performance.csv')

methods = sorted(custom_data.keys())  # Sort for consistent order
sizes = [size for size, _ in custom_data['Append']]

# Create a single figure with subplots stacked vertically
n_methods = len(methods)
fig, axes = plt.subplots(nrows=n_methods, ncols=1, figsize=(10, 4 * n_methods))
axes = [axes] if n_methods == 1 else axes  # Handle single method case

# Plot each method's comparison
for idx, method in enumerate(methods):
    custom_times = [time for _, time in custom_data[method]]
    sb_times = [time for _, time in stringbuilder_data[method]]

    axes[idx].plot(sizes, custom_times, label='CustomStringBuilder')
    axes[idx].plot(sizes, sb_times, label='StringBuilder')
    axes[idx].set_xlabel('Input Size')
    axes[idx].set_ylabel('Time (ns)')
    axes[idx].set_title(f'Performance Comparison: {method}')
    axes[idx].legend()
    axes[idx].grid(True)

# Adjust layout and save
plt.tight_layout()
plt.savefig('All_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print(f"All comparison charts saved in 'All_Performance_Comparisons.png' for methods: {', '.join(methods)}")