import matplotlib.pyplot as plt
import matplotlib.ticker as ticker
import csv

def read_csv(filename):
    data = {}
    with open(filename, 'r') as f:
        reader = csv.DictReader(f, delimiter=';')
        headers = [h.strip('"') for h in reader.fieldnames]

        for row in reader:
            clean_row = {h.strip('"'): v for h, v in row.items()}
            size = int(clean_row['Size'])
            for key, value in clean_row.items():
                if key == 'Size':
                    continue
                if key not in data:
                    data[key] = []
                try:
                    val = int(value)
                except ValueError:
                    val = 0
                data[key].append((size, val))
    return data

# Load data from both CSVs
custom_data = read_csv('/Users/drpsychoben/PycharmProjects/StringBuilderCharts/Compare/CustomStringBuilder_performance.csv')
stringbuilder_data = read_csv('/Users/drpsychoben/PycharmProjects/StringBuilderCharts/Compare/StringBuilder_performance.csv')

# Get the method names sorted for consistent plotting
methods = sorted(custom_data.keys())

# Pick sizes from any method (all should have the same sizes)
some_method = methods[0]
sizes = [size for size, _ in custom_data[some_method]]

# Create a figure with subplots stacked vertically
n_methods = len(methods)
fig, axes = plt.subplots(nrows=n_methods, ncols=1, figsize=(10, 4 * n_methods))
if n_methods == 1:
    axes = [axes]

# Configure tick formatter and locator
formatter = ticker.ScalarFormatter()
formatter.set_scientific(False)
locator = ticker.MultipleLocator(100000)  # Tick every 100,000

# Plot each method's comparison
for idx, method in enumerate(methods):
    custom_times = [time for _, time in custom_data[method]]
    sb_times = [time for _, time in stringbuilder_data.get(method, [(0, 0)] * len(sizes))]

    axes[idx].plot(sizes, custom_times, label='CustomStringBuilder')
    axes[idx].plot(sizes, sb_times, label='StringBuilder')
    axes[idx].set_xlabel('Input Size')
    axes[idx].set_ylabel('Time (ns)')
    axes[idx].set_title(f'Performance Comparison: {method}')
    axes[idx].legend()
    axes[idx].grid(True)
    axes[idx].set_xlim(left=0, right=1_000_000)
    axes[idx].set_ylim(bottom=0)
    axes[idx].xaxis.set_major_formatter(formatter)
    axes[idx].xaxis.set_major_locator(locator)

plt.tight_layout()
plt.savefig('All_Performance_Comparisons.png', dpi=300, bbox_inches='tight')
plt.close()

print(f"All comparison charts saved in 'All_Performance_Comparisons.png' for methods: {', '.join(methods)}")
