import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import csv
from collections import defaultdict

def read_csv(filename):
    data = defaultdict(list)
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames if h.lower() != 'size']

        for row in reader:
            size = int(row['Size'].strip('"'))
            if size < 2500:  # Skip sizes less than 2500
                continue
            for header in headers:
                val_str = row.get(f'"{header}"') or row.get(header) or ''
                try:
                    val = int(val_str.strip('"'))
                except ValueError:
                    val = 0
                data[header].append((size, val))
    return data

# Load data from both CSVs
custom_data = read_csv('./CustomStringBuilder_performance.csv')
stringbuilder_data = read_csv('./StringBuilder_performance.csv')

# Get method names, excluding constructor methods
methods = sorted([m for m in custom_data.keys() if m not in ['CustomStringBuilder(CharSequence)', 'StringBuilder(CharSequence)']])
sizes = sorted([size for size, _ in custom_data[methods[0]]])  # Original sizes: [2500, 5000, 7500, 10000, 25000, 50000, 100000, 250000, 500000, 1000000]

# Create a figure with subplots stacked vertically
n_methods = len(methods)
fig, axes = plt.subplots(nrows=n_methods, ncols=1, figsize=(10, 4 * n_methods))
if n_methods == 1:
    axes = [axes]

# Formatter for axes
scalar_formatter = ticker.ScalarFormatter()
scalar_formatter.set_scientific(False)
scalar_formatter.set_useOffset(False)

# Plot each method's performance
for idx, method in enumerate(methods):
    custom_times = [time for _, time in custom_data[method]]
    sb_times = [time for _, time in stringbuilder_data.get(method, [(0, 0)] * len(sizes))]

    ax = axes[idx] if n_methods > 1 else axes
    ax.plot(sizes, custom_times, label='CustomStringBuilder', linestyle='-', linewidth=1.5)
    ax.plot(sizes, sb_times, label='StringBuilder', linestyle='-', linewidth=1.5)
    ax.set_xlabel('Input Size')
    ax.set_ylabel('Time (ns)')
    ax.set_title(f'{method}')
    ax.legend()
    ax.grid(True)

    # Smart axis scaling, x-axis starts at 2500
    x_max = max(sizes)
    y_max = max(max(custom_times, default=0), max(sb_times, default=0))
    ax.set_xlim(2500, 1_000_000)  # Start x-axis at 2500
    ax.set_ylim(0, y_max * 1.1 if y_max > 0 else 1)

    # Set x-axis ticks to start at 2500, followed by 100000 increments
    ax.set_xticks([2500, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000])
    ax.xaxis.set_major_formatter(scalar_formatter)
    ax.yaxis.set_major_formatter(scalar_formatter)

plt.tight_layout()
plt.savefig('All_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print(f"All comparison charts saved in 'All_Performance_Comparisons.png' for methods: {', '.join(methods)}")