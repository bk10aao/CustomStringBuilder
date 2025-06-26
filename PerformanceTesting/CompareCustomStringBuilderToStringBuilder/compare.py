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

methods = custom_data.keys()

# We assume both CSVs have the same sizes for simplicity
sizes = [size for size, _ in custom_data['Append']]

# Plot comparison for each method
for method in methods:
    # Extract times for both implementations
    custom_times = [time for _, time in custom_data[method]]
    sb_times = [time for _, time in stringbuilder_data[method]]

    plt.figure(figsize=(10, 6))
    plt.plot(sizes, custom_times, label='CustomStringBuilder')
    plt.plot(sizes, sb_times, label='StringBuilder')
    plt.xlabel('Input Size')
    plt.ylabel('Time (ns)')
    plt.title(f'Performance Comparison: {method}')
    plt.legend()
    plt.grid(True)
    plt.savefig(f'Comparison_{method}.png')
    plt.close()

print("Comparison charts generated for methods:", ", ".join(methods))
