import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import csv
import numpy as np
from collections import defaultdict

def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower() != 'size']

        for row in reader:
            size = int(row['Size'].strip('"'))
            for header in headers:
                val_str = row.get(f'"{header}"') or row.get(header) or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data

# Load data from CustomStringBuilder CSV
data = read_csv('/Users/drpsychoben/PycharmProjects/StringBuilderCharts/StringBuilder/StringBuilder_performance.csv')

# Get method names and sizes
methods = sorted(data.keys())
sizes = sorted([size for size, _ in data[methods[0]]])

# Create a figure with subplots stacked vertically
n_methods = len(methods)
fig, axes = plt.subplots(nrows=n_methods, ncols=1, figsize=(10, 4 * n_methods))
if n_methods == 1:
    axes = [axes]

# Formatters for axes
scalar_formatter = ticker.ScalarFormatter()
scalar_formatter.set_scientific(False)
scalar_formatter.set_useOffset(False)
x_locator = ticker.MultipleLocator(100000)

# Plot each method's performance
for idx, method in enumerate(methods):
    times = [time for _, time in data[method]]

    ax = axes[idx] if n_methods > 1 else axes
    ax.plot(sizes, times, label='StringBuilder', linestyle='-', linewidth=1.5)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.set_title(f'{method}')
    ax.legend()
    ax.grid(True)

    # Smart axis scaling
    x_max = max(sizes)
    y_max = max(times, default=0)
    ax.set_xlim(0, 1_000_000)
    ax.set_ylim(0, y_max * 1.1 if y_max > 0 else 1)

    # Format ticks
    ax.xaxis.set_major_locator(x_locator)
    ax.xaxis.set_major_formatter(scalar_formatter)
    ax.yaxis.set_major_formatter(scalar_formatter)

plt.tight_layout()
plt.savefig('StringBuilder_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print(f"All performance charts saved in 'StringBuilder_Performance_Comparisons.png' for methods: {', '.join(methods)}")